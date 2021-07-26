package com.testinium.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testinium.bookstore.domain.Bookstore;

public interface BookstoreDao extends JpaRepository<Bookstore, Integer> {

}
