package com.senai.integrador.book.repositories;

import com.senai.integrador.book.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
