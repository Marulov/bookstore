package com.testinium.bookstore.service;

import java.util.List;

import com.testinium.bookstore.domain.Bookstore;
import com.testinium.bookstore.dto.BookstoreDto;
import com.testinium.bookstore.dto.TransactionRecordsDto;

public interface BookstoreService {

	BookstoreDto createBookstore(BookstoreDto bookstoreDto);

	void deleteBookstore(BookstoreDto bookstoreDto);

	List<Bookstore> getAll();

	TransactionRecordsDto addBookToBookstore(TransactionRecordsDto transactionRecordsDto);

	void deleteBookToBookstore(TransactionRecordsDto transactionRecordsDto);
}
