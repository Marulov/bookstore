package com.testinium.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bookstores")
public class Bookstore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "city")
	private String city;

	@OneToMany(mappedBy = "bookstore", cascade = CascadeType.ALL)
	private List<TransactionRecords> transactionRecords;

	public Bookstore() {

	}

	public Bookstore(int id, String name, String city, List<TransactionRecords> transactionRecords) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.transactionRecords = transactionRecords;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<TransactionRecords> getTransactionRecords() {
		return transactionRecords;
	}

	public void setTransactionRecords(List<TransactionRecords> transactionRecords) {
		this.transactionRecords = transactionRecords;
	}
}
