package com.testinium.bookstore.service;

import java.util.List;

import com.testinium.bookstore.domain.Category;
import com.testinium.bookstore.dto.BookDto;

public interface BookService {

	List<BookDto> getAll();

	List<BookDto> getByCategoryId(int categoryId);

	List<BookDto> getByName(String name);

	BookDto changeCategory(int id, Category category);

	BookDto createBook(BookDto bookDto);

	void deleteBook(BookDto bookDto);
}
