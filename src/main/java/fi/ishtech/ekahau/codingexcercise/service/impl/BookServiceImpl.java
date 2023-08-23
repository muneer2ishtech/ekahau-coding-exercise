package fi.ishtech.ekahau.codingexcercise.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import fi.ishtech.ekahau.codingexcercise.entity.Book;
import fi.ishtech.ekahau.codingexcercise.repo.BookRepo;
import fi.ishtech.ekahau.codingexcercise.service.BookService;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Muneer Ahmed Syed
 */
@Service
@Slf4j
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	@Override
	public Optional<Book> findById(Long id) {
		return bookRepo.findById(id);
	}

	@Override
	public Book create(Book book) {
		Assert.isNull(book.getId(), "Cannot set id for new Book");
		Assert.hasText(book.getTitle(), "Title is mandatory");

		book = bookRepo.save(book);
		log.info("New Book({}) created for title: {}", book.getId(), book.getTitle());

		return book;
	}

	@Override
	public Book update(Book book) {
		Assert.notNull(book.getId(), "Book id is mandatory to find and update details");

		book = bookRepo.save(book);
		entityManager.refresh(book);
		log.info("Updated Book({})", book.getId());

		return book;
	}

	@Override
	public void deleteById(Long id) {
		bookRepo.deleteById(id);
		log.info("Deleted Book({})", id);
	}

}
