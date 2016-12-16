package net.codetojoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        System.out.println("TRACER HELLO");
        List<Book> books = bookRepository.findAll();

/*
        books = new ArrayList<Book>();
        Book book = new Book();
        book.setId(999L);
        book.setAuthor("Hunter S Thompson");
        book.setTitle("Fear and Loathing in Las Vegas");
        books.add(book);
*/
        System.out.println("TRACER CP2: " + books.size());
        
        return books; // new ObjectMapper().writeValueAsString(books);
    }
}
