package net.codetojoy.service;

import net.codetojoy.model.Book;
import net.codetojoy.api.query.BookQueryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookQueryServiceImpl implements BookQueryService {
    private BookRepository bookRepository;

    @Autowired
    public BookQueryServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = bookRepository.findAll();

        return books;
    }
}
