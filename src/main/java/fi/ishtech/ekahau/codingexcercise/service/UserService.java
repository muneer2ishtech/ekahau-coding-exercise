package fi.ishtech.ekahau.codingexcercise.service;

import fi.ishtech.ekahau.codingexcercise.entity.User;
import fi.ishtech.ekahau.codingexcercise.payload.PasswordUpdateRequest;
import fi.ishtech.ekahau.codingexcercise.payload.SignupRequest;

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
