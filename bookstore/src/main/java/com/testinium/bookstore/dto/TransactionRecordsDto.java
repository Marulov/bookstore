package com.testinium.bookstore.dto;

public class TransactionRecordsDto {

	private int id;

	private int bookId;

	private int bookstoreId;

	private BookDto bookDto;

	private BookstoreDto bookstoreDto;

	private double priceByCity;

	public TransactionRecordsDto() {
		super();
	}

	public TransactionRecordsDto(int id, int bookId, int bookstoreId, BookDto bookDto, BookstoreDto bookstoreDto,
			double priceByCity) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.bookstoreId = bookstoreId;
		this.bookDto = bookDto;
		this.bookstoreDto = bookstoreDto;
		this.priceByCity = priceByCity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookDto getBookDto() {
		return bookDto;
	}

	public void setBookDto(BookDto bookDto) {
		this.bookDto = bookDto;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookstoreId() {
		return bookstoreId;
	}

	public void setBookstoreId(int bookstoreId) {
		this.bookstoreId = bookstoreId;
	}

	public BookstoreDto getBookstoreDto() {
		return bookstoreDto;
	}

	public void setBookstoreDto(BookstoreDto bookstoreDto) {
		this.bookstoreDto = bookstoreDto;
	}

	public double getPriceByCity() {
		return priceByCity;
	}

	public void setPriceByCity(double priceByCity) {
		this.priceByCity = priceByCity;
	}
}
