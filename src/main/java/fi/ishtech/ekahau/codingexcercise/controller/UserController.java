package fi.ishtech.ekahau.codingexcercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.ishtech.ekahau.codingexcercise.entity.User;
import fi.ishtech.ekahau.codingexcercise.repo.UserRepo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Muneer Ahmed Syed
 */
@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/api/v1/users")
	public List<User> findAll() {
		return userRepo.findAll();

	}

	@PreAuthorize(value = "hasAuthority('ROLE_USER')" + " and authentication.principal.id.equals(#id) ")
	@GetMapping("/api/v1/users/{id}")
	public User findById(@PathVariable Long id) {
		return userRepo.findById(id).get();
	}

	@PreAuthorize(value = "hasAuthority('ROLE_USER')" + " and authentication.principal.id.equals(#id) ")
	@PutMapping("/api/v1/users/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody User user) {
		log.debug("Updating User({})", user.getId());

		Assert.notNull(user.getId(), "User id is mandatory to find and update details");
		Assert.isTrue(id.equals(user.getId()), "Cannot update details of another User");
		Assert.isTrue(! StringUtils.hasText(user.getPasswordHash()), "Cannot update password using this API");

		user = userRepo.save(user);
		log.info("Updated User({})", user.getId());

		return ResponseEntity.ok(user);
	}

}
