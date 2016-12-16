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
        List<Book> books = bookRepository.findAll();

        return books; 
    }
}
