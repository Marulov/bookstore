package com.testinium.bookstore.dto;

public class CategoryDto {

	private int id;

	private String name;

	public CategoryDto() {
		super();
	}

	public CategoryDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
