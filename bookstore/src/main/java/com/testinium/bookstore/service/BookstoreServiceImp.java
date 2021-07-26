package com.testinium.bookstore.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.testinium.bookstore.domain.Bookstore;
import com.testinium.bookstore.domain.TransactionRecords;
import com.testinium.bookstore.dto.BookstoreDto;
import com.testinium.bookstore.dto.TransactionRecordsDto;
import com.testinium.bookstore.repository.BookstoreDao;
import com.testinium.bookstore.repository.TransactionRecordsDao;

@Service
public class BookstoreServiceImp implements BookstoreService {

	private final BookstoreDao bookstoreDao;
	private final TransactionRecordsDao transactionRecordsDao;
	private final ModelMapper modelMapper;

	public BookstoreServiceImp(BookstoreDao bookstoreDao, TransactionRecordsDao transactionRecordsDao,
			ModelMapper modelMapper) {
		super();
		this.bookstoreDao = bookstoreDao;
		this.transactionRecordsDao = transactionRecordsDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public BookstoreDto createBookstore(BookstoreDto bookstoreDto) {

		Bookstore bookstore = modelMapper.map(bookstoreDto, Bookstore.class);
		return modelMapper.map(this.bookstoreDao.save(bookstore), BookstoreDto.class);

	}

	@Override
	public List<Bookstore> getAll() {

		return this.bookstoreDao.findAll();
	}

	@Override
	public TransactionRecordsDto addBookToBookstore(TransactionRecordsDto transactionRecordsDto) {

		TransactionRecords transactionRecords = modelMapper.map(transactionRecordsDto, TransactionRecords.class);
		return modelMapper.map(this.transactionRecordsDao.save(transactionRecords), TransactionRecordsDto.class);

	}

	@Override
	public void deleteBookstore(BookstoreDto bookstoreDto) {

		Bookstore bookstore = this.bookstoreDao.findById(bookstoreDto.getId()).get();
		this.bookstoreDao.delete(bookstore);

	}

	@Override
	public void deleteBookToBookstore(TransactionRecordsDto transactionRecordsDto) {

		TransactionRecords transactionRecords = this.transactionRecordsDao.findById(transactionRecordsDto.getId()).get();
		this.transactionRecordsDao.delete(transactionRecords);

	}
}
