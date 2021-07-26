package com.testinium.bookstore.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.testinium.bookstore.domain.Book;
import com.testinium.bookstore.domain.Category;
import com.testinium.bookstore.dto.BookDto;
import com.testinium.bookstore.repository.BookDao;

@Service
public class BookServiceImp implements BookService {

	private final BookDao bookDao;
	private final ModelMapper modelMapper;

	public BookServiceImp(BookDao bookDao, ModelMapper modelMapper) {
		super();
		this.bookDao = bookDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<BookDto> getAll() {

		List<Book> books = this.bookDao.findAll();
		List<BookDto> bookDtos = books.stream().map(book -> modelMapper.map(book, BookDto.class)).toList();

		return bookDtos;

	}

	@Override
	public List<BookDto> getByCategoryId(int categoryId) {

		List<Book> books = this.bookDao.findByCategoryId(categoryId);
		List<BookDto> bookDtos = books.stream().map(book -> modelMapper.map(book, BookDto.class)).toList();
		return bookDtos;
	}

	@Override
	public List<BookDto> getByName(String name) {

		List<Book> books = this.bookDao.findByName(name);
		List<BookDto> bookDtos = books.stream().map(book -> modelMapper.map(book, BookDto.class)).toList();
		return bookDtos;
	}

	@Override
	public BookDto changeCategory(int id, Category category) {

		Book categoryChange = this.bookDao.findById(id).get();
		categoryChange.setCategory(category);

		return modelMapper.map(this.bookDao.save(categoryChange), BookDto.class);
	}

	@Override
	public BookDto createBook(BookDto bookDto) {

		Book book = modelMapper.map(bookDto, Book.class);

		return modelMapper.map(this.bookDao.save(book), BookDto.class);

	}

	@Override
	public void deleteBook(BookDto bookDto) {

		Book book = modelMapper.map(bookDto, Book.class);
		this.bookDao.delete(book);

	}
}
