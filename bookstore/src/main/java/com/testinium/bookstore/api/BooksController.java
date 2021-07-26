package com.testinium.bookstore.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.testinium.bookstore.domain.Category;
import com.testinium.bookstore.dto.BookDto;
import com.testinium.bookstore.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BooksController {

	private final BookService bookService;

	public BooksController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping("/")
	public ResponseEntity<List<BookDto>> getAll() {

		return ResponseEntity.ok(this.bookService.getAll());
	}

	@GetMapping("/getbycategoryid/{categoryId}")
	@ResponseBody
	public ResponseEntity<List<BookDto>> getByCategoryId(@PathVariable("categoryId") int categoryId) {

		return ResponseEntity.ok(this.bookService.getByCategoryId(categoryId));
	}

	@GetMapping("/getbyname/{name}")
	@ResponseBody
	public ResponseEntity<List<BookDto>> getByName(@PathVariable("name") String name) {

		return ResponseEntity.ok(this.bookService.getByName(name));
	}

	@PostMapping
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {

		return ResponseEntity.ok(this.bookService.createBook(bookDto));
	}

	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<BookDto> changeCategory(@PathVariable("id") int id, @RequestBody Category category) {

		return ResponseEntity.ok(this.bookService.changeCategory(id, category));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BookDto> deleteBook(@RequestBody BookDto bookDto) {

		this.bookService.deleteBook(bookDto);
		return ResponseEntity.ok().build();
	}
}
