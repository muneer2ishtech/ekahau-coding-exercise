package fi.ishtech.ekahau.codingexcercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fi.ishtech.ekahau.codingexcercise.entity.User;
import fi.ishtech.ekahau.codingexcercise.repo.UserRepo;

/**
 *
 * @author Muneer Ahmed Syed
 */
@RestController
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/api/v1/users")
	public List<User> findAll() {
		return userRepo.findAll();

	}

	@GetMapping("/api/v1/users/{id}")
	User findById(@PathVariable Long id) {
		return userRepo.findById(id).get();
	}

}