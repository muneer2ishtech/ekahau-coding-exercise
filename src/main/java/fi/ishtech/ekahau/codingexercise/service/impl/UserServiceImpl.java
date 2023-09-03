package fi.ishtech.ekahau.codingexercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import fi.ishtech.ekahau.codingexercise.entity.User;
import fi.ishtech.ekahau.codingexercise.payload.PasswordUpdateRequest;
import fi.ishtech.ekahau.codingexercise.payload.SignupRequest;
import fi.ishtech.ekahau.codingexercise.repo.UserRepo;
import fi.ishtech.ekahau.codingexercise.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Muneer Ahmed Syed
 */
@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public User create(SignupRequest signupRequest) {
		User user = new User();
		user.setEmail(signupRequest.getUsername());
		user.setPasswordHash(passwordEncoder.encode(signupRequest.getPassword()));
		user.setFirstName(signupRequest.getFirstName());
		user.setLastName(signupRequest.getLastName());

		user = userRepo.saveAndFlush(user);
		log.info("New User({} created for email: {}", user.getId(), user.getEmail());

		return user;
	}

	@Override
	public User update(User user) {
		user = userRepo.saveAndFlush(user);
		entityManager.refresh(user);

		log.info("Updated User({})", user.getId());

		return user;
	}

	@Override
	public void updatePassword(Long userId, PasswordUpdateRequest passwordUpdateRequest) {
		String exPasswordHash = userRepo.findPasswordHashById(userId);
		Assert.isTrue(passwordEncoder.matches(passwordUpdateRequest.getOldPassword(), exPasswordHash),
				"Invalid old password");

		String newPasswordHash = passwordEncoder.encode(passwordUpdateRequest.getNewPassword());

		userRepo.updatePassword(userId, newPasswordHash);
		log.info("Updated password for User({})", userId);
	}

}
