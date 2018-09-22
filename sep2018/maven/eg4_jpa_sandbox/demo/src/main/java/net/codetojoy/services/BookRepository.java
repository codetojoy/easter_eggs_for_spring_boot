package net.codetojoy.services;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codetojoy.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
