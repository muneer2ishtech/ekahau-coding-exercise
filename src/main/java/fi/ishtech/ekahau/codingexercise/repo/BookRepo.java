package fi.ishtech.ekahau.codingexercise.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.ishtech.ekahau.codingexercise.entity.Book;

/**
 *
 * @author Muneer Ahmed Syed
 */
public interface BookRepo extends JpaRepository<Book, Long> {

}
