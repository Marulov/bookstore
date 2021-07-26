package com.testinium.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testinium.bookstore.domain.Book;

public interface BookDao extends JpaRepository<Book, Integer> {

	List<Book> findByCategoryId(int categoryId);

	List<Book> findByName(String name);
}
