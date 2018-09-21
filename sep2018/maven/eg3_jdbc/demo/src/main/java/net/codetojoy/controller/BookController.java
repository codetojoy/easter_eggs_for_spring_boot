package net.codetojoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import net.codetojoy.model.Book;
import net.codetojoy.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Book> getBooks() throws Exception {
        List<Book> books = bookService.getBooks();

        return books;
    }

/*
    @RequestMapping(method=RequestMethod.POST, produces="application/json")
    public @ResponseBody Book createBook(@RequestBody Book book) {
        List<Book> entities = new ArrayList<Book>();
        entities.add(book);
        List<Book> results = bookRepository.saveAll(entities);
        Book savedBook = results.get(0);

        return savedBook;
    }
*/
}
