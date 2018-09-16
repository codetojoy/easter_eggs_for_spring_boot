package net.codetojoy.service;

import net.codetojoy.model.Book;
import net.codetojoy.api.command.BookCommandService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookCommandServiceImpl implements BookCommandService {
    private BookRepository bookRepository;

    @Autowired
    public BookCommandServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void createBook(String author, String title) {
        List<Book> entities = new ArrayList<Book>();
        Book book = new Book(author, title);
        entities.add(book);
        List<Book> results = bookRepository.saveAll(entities);
    }
}
