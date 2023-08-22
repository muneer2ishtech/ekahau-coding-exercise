package fi.ishtech.ekahau.codingexcercise.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fi.ishtech.ekahau.codingexcercise.entity.User;
import fi.ishtech.ekahau.codingexcercise.exception.UsernameAlreadyExistsException;
import fi.ishtech.ekahau.codingexcercise.payload.SigninRequest;
import fi.ishtech.ekahau.codingexcercise.payload.SignupRequest;
import fi.ishtech.ekahau.codingexcercise.repo.UserRepo;
import fi.ishtech.ekahau.codingexcercise.security.JwtUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Muneer Ahmed Syed
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepo userRepo;

	@PostMapping("/signin")
	public ResponseEntity<?> signin(@Valid @RequestBody SigninRequest signinRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signinRequest.getUsername(), signinRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return ResponseEntity.ok(jwtUtil.getJwtResponse(authentication));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signupRequest) {
		log.debug("Signigup: {}", signupRequest.getUsername());

		if (userRepo.existsByEmail(signupRequest.getUsername())) {
			log.warn("Username: {} already exists", signupRequest.getUsername());
			throw new UsernameAlreadyExistsException();
		}

		User user = new User();
		user.setEmail(signupRequest.getUsername());
		user.setPasswordHash(passwordEncoder.encode(signupRequest.getPassword()));
		user.setFirstName(signupRequest.getFirstName());
		user.setLastName(signupRequest.getLastName());

		user = userRepo.save(user);
		log.info("New User({} created for email: {}", user.getId(), user.getEmail());

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/users/{userId}")
				.buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).body(user.getId());

	}

}
