package fi.ishtech.ekahau.codingexcercise.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.ishtech.ekahau.codingexcercise.entity.Book;

/**
 *
 * @author Muneer Ahmed Syed
 */
public interface BookRepo extends JpaRepository<Book, Long> {

}
