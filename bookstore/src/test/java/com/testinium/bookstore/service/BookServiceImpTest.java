package com.testinium.bookstore.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import com.testinium.bookstore.domain.Book;
import com.testinium.bookstore.dto.BookDto;
import com.testinium.bookstore.dto.CategoryDto;
import com.testinium.bookstore.repository.BookDao;

public class BookServiceImpTest {

	@InjectMocks
	private BookServiceImp bookServiceImp;

	@Mock
	private BookDao bookDao;

	@Mock
	private ModelMapper modelMapper;

	@Before
	public void setUp() throws Exception {

		bookDao = Mockito.mock(BookDao.class);
		modelMapper = Mockito.mock(ModelMapper.class);

		bookServiceImp = new BookServiceImp(bookDao, modelMapper);

	}

	@Test
	public void whenCreateBookCalledWhitValidRequest_itShouldReturnValidBookDto() {

		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(1);
		categoryDto.setName("Otobiyografi");

		BookDto bookDto = new BookDto();
		bookDto.setId(1);
		bookDto.setName("Sol Ayağım");
		bookDto.setPrice(15.0);
		bookDto.setCategoryId(categoryDto.getId());

		Book book = modelMapper.map(bookDto, Book.class);

		Mockito.when(modelMapper.map(this.bookDao.save(book), BookDto.class)).thenReturn(bookDto);

		BookDto result = this.bookServiceImp.createBook(bookDto);

		Assert.assertEquals(result, bookDto);

		Mockito.verify(bookDao).save(book);

	}
}
