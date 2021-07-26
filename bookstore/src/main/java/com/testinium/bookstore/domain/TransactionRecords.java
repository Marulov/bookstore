package com.testinium.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transaction_records")
public class TransactionRecords {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "price_by_city")
	private double priceByCity;

	@ManyToOne
	@JoinColumn(name = "book")
	private Book book;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "bookstore")
	private Bookstore bookstore;

	public TransactionRecords() {

	}

	public TransactionRecords(int id, double priceByCity, Book book, Bookstore bookstore) {
		super();
		this.id = id;
		this.priceByCity = priceByCity;
		this.book = book;
		this.bookstore = bookstore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPriceByCity() {
		return priceByCity;
	}

	public void setPriceByCity(double priceByCity) {
		this.priceByCity = priceByCity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Bookstore getBookstore() {
		return bookstore;
	}

	public void setBookstore(Bookstore bookstore) {
		this.bookstore = bookstore;
	}
}
