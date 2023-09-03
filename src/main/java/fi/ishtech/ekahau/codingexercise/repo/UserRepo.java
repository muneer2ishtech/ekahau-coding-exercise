package fi.ishtech.ekahau.codingexercise.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fi.ishtech.ekahau.codingexercise.entity.User;

/**
 *
 * @author Muneer Ahmed Syed
 */
public interface UserRepo extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	Optional<User> findOneByEmail(String email);

	@Query("SELECT u.passwordHash FROM User u WHERE u.id = :userId")
	String findPasswordHashById(Long userId);

	@Modifying
	@Query("UPDATE User u SET u.passwordHash = :newPassword WHERE u.id = :userId")
	void updatePassword(Long userId, String newPassword);

}
