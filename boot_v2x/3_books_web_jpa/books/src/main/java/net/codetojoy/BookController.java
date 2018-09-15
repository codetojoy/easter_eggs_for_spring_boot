package net.codetojoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Book> getBooks() throws Exception {
        List<Book> books = bookRepository.findAll();

        return books;
    }

    @RequestMapping(method=RequestMethod.POST, produces="application/json")
    public @ResponseBody Book createBook(@RequestBody Book book) {
        List<Book> entities = new ArrayList<Book>();
        entities.add(book);
        List<Book> results = bookRepository.saveAll(entities);
        Book savedBook = results.get(0);

        return savedBook;
    }
}
