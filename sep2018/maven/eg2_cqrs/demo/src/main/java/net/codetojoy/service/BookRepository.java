package net.codetojoy.service;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codetojoy.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
