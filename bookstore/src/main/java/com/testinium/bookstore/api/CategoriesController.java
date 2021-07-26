package com.testinium.bookstore.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testinium.bookstore.dto.CategoryDto;
import com.testinium.bookstore.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	private final CategoryService categoryService;

	public CategoriesController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAll() {

		return ResponseEntity.ok(this.categoryService.getAll());
	}

	@PostMapping
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {

		return ResponseEntity.ok(this.categoryService.createCategory(categoryDto));
	}

	@DeleteMapping
	public ResponseEntity<CategoryDto> deleteCategory(@RequestBody CategoryDto categoryDto) {

		this.categoryService.deleteCategory(categoryDto);
		return ResponseEntity.ok().build();
	}
}
