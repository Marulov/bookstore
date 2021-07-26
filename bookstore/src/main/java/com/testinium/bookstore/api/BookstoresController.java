package com.testinium.bookstore.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testinium.bookstore.domain.Bookstore;
import com.testinium.bookstore.dto.BookstoreDto;
import com.testinium.bookstore.dto.TransactionRecordsDto;
import com.testinium.bookstore.service.BookstoreService;

@RestController
@RequestMapping("/api/bookstores")
public class BookstoresController {

	private final BookstoreService bookstoreService;

	public BookstoresController(BookstoreService bookstoreService) {
		super();
		this.bookstoreService = bookstoreService;
	}

	@PostMapping("/createbookstore")
	public ResponseEntity<BookstoreDto> createBookstore(@RequestBody BookstoreDto bookstoreDto) {

		return ResponseEntity.ok(this.bookstoreService.createBookstore(bookstoreDto));
	}

	@DeleteMapping("/deletebookstore")
	public ResponseEntity<BookstoreDto> deleteBookstore(@RequestBody BookstoreDto bookstoreDto) {

		this.bookstoreService.deleteBookstore(bookstoreDto);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<Bookstore>> getAll() {

		return ResponseEntity.ok(this.bookstoreService.getAll());
	}

	@PostMapping("/addbooktobookstore")
	public ResponseEntity<TransactionRecordsDto> addBookToBookstore(
			@RequestBody TransactionRecordsDto transactionRecordsDto) {

		return ResponseEntity.ok(this.bookstoreService.addBookToBookstore(transactionRecordsDto));
	}

	@DeleteMapping("/deletebooktobookstore")
	public ResponseEntity<TransactionRecordsDto> deleteBookToBookstore(@RequestBody TransactionRecordsDto transactionRecordsDto) {

		this.bookstoreService.deleteBookToBookstore(transactionRecordsDto);
		return ResponseEntity.ok().build();
	}
}
