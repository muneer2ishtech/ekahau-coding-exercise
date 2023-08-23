package fi.ishtech.ekahau.codingexcercise.service;

import fi.ishtech.ekahau.codingexcercise.entity.User;

/**
 *
 * @author Muneer Ahmed Syed
 */
public interface UserService {

	User findById(Long id);

	User update(User user);

}
