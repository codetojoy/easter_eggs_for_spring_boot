package net.codetojoy.dao;

import java.util.List;

import net.codetojoy.model.Book;

public interface BookDao {
    List<Book> getBooks();
}
