package com.testinium.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testinium.bookstore.domain.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
