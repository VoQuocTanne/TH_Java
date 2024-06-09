package com.example.TH_buoi3.repository;

import com.example.TH_buoi3.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

}