package net.codetojoy.service;

import java.util.List;

import net.codetojoy.dao.BookDao;
import net.codetojoy.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    public List<Book> getBooks() {
        return bookDao.getBooks();
    }
}
