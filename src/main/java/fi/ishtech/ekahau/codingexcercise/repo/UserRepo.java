package fi.ishtech.ekahau.codingexcercise.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fi.ishtech.ekahau.codingexcercise.entity.User;

/**
 *
 * @author Muneer Ahmed Syed
 */
public interface UserRepo extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	Optional<User> findOneByEmail(String email);

	@Modifying
	@Query("UPDATE User u SET u.passwordHash = :newPassword WHERE u.id = :userId")
	void updatePassword(Long userId, String newPassword);

}
