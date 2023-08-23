package fi.ishtech.ekahau.codingexcercise.service;

import java.util.List;
import java.util.Optional;

import fi.ishtech.ekahau.codingexcercise.entity.Book;

/**
 *
 * @author Muneer Ahmed Syed
 */
public interface BookService {

	List<Book> findAll();

	Optional<Book> findById(Long id);

	Book create(Book book);

	Book update(Book book);

	void deleteById(Long id);

}
