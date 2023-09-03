package fi.ishtech.ekahau.codingexercise.service;

import fi.ishtech.ekahau.codingexercise.entity.User;
import fi.ishtech.ekahau.codingexercise.payload.PasswordUpdateRequest;
import fi.ishtech.ekahau.codingexercise.payload.SignupRequest;

/**
 *
 * @author Muneer Ahmed Syed
 */
public interface UserService {

	User findById(Long id);

	User create(SignupRequest signupRequest);

	User update(User user);

	void updatePassword(Long userId, PasswordUpdateRequest passwordUpdateRequest);

}
