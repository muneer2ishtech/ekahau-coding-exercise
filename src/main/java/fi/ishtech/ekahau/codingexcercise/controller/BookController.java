package fi.ishtech.ekahau.codingexcercise.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fi.ishtech.ekahau.codingexcercise.entity.Book;
import fi.ishtech.ekahau.codingexcercise.repo.BookRepo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Muneer Ahmed Syed
 */
@RestController
@Slf4j
public class BookController {

	@Autowired
	private BookRepo bookRepo;

	@GetMapping("/api/v1/books")
	public List<Book> findAll() {
		return bookRepo.findAll();

	}

	@GetMapping("/api/v1/books/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {
		return ResponseEntity.of(bookRepo.findById(id));
	}

	@PostMapping("/api/v1/books")
	public ResponseEntity<?> createNew(@Valid @RequestBody Book book) {
		Assert.isNull(book.getId(), "Cannot set id for new Book");

		log.debug("Creating new Book {}", book.getTitle());

		book = bookRepo.save(book);
		log.info("New Book({}) created for title: {}", book.getId(), book.getTitle());

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/books/{bookId}")
				.buildAndExpand(book.getId()).toUri();

		return ResponseEntity.created(uri).body(book.getId());
	}

	@DeleteMapping("/api/v1/books/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		log.debug("Deleting Book({})", id);
		
		bookRepo.deleteById(id);
		log.info("Deleting Book({})", id);
		
		return new ResponseEntity<Void>(HttpStatus.GONE);
	}

	@PutMapping("/api/v1/books")
	public ResponseEntity<?> update(@Valid @RequestBody Book book) {
		log.debug("Updating Book({})", book.getId());

		Assert.notNull(book.getId(), "Book id is mandatory to find and update details");

		book = bookRepo.save(book);
		log.info("Updated Book({})", book.getId());

		return ResponseEntity.ok(book);
	}

}
