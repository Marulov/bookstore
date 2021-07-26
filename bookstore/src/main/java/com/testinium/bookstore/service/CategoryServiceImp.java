package com.testinium.bookstore.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.testinium.bookstore.domain.Category;
import com.testinium.bookstore.dto.CategoryDto;
import com.testinium.bookstore.repository.CategoryDao;

@Service
public class CategoryServiceImp implements CategoryService {

	private final CategoryDao categoryDao;
	private final ModelMapper modelMapper;

	public CategoryServiceImp(CategoryDao categoryDao, ModelMapper modelMapper) {
		super();
		this.categoryDao = categoryDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<CategoryDto> getAll() {

		List<Category> categories = this.categoryDao.findAll();

		List<CategoryDto> categoryDtos = categories.stream()
				.map(category -> modelMapper.map(category, CategoryDto.class)).toList();

		return categoryDtos;
	}

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = modelMapper.map(categoryDto, Category.class);

		return modelMapper.map(this.categoryDao.save(category), CategoryDto.class);

	}

	@Override
	public void deleteCategory(CategoryDto categoryDto) {

		Category category = this.categoryDao.findById(categoryDto.getId()).get();
		this.categoryDao.delete(category);

	}
}
