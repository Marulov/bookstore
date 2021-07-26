package com.testinium.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testinium.bookstore.domain.TransactionRecords;

public interface TransactionRecordsDao extends JpaRepository<TransactionRecords, Integer> {

}
