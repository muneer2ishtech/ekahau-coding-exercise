package fi.ishtech.ekahau.codingexcercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fi.ishtech.ekahau.codingexcercise.entity.Book;
import fi.ishtech.ekahau.codingexcercise.repo.BookRepo;

/**
 *
 * @author Muneer Ahmed Syed
 */
@RestController
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

}
