package com.testinium.bookstore.service;

import java.util.List;

import com.testinium.bookstore.dto.CategoryDto;

public interface CategoryService {

	List<CategoryDto> getAll();

	CategoryDto createCategory(CategoryDto categoryDto);

	void deleteCategory(CategoryDto categoryDto);

}
