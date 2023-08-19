package fi.ishtech.ekahau.codingexcercise.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.ishtech.ekahau.codingexcercise.entity.User;

/**
 *
 * @author Muneer Ahmed Syed
 */
public interface UserRepo extends JpaRepository<User, Long> {

}
