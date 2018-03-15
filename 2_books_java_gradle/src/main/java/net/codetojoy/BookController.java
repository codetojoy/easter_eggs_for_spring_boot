
package net.codetojoy;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private int id;
    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(11, "The Undoing Project", "Michael Lewis"));
        books.add(new Book(22, "Blink", "Malcolm Gladwell"));
        books.add(new Book(33, "Freakonomics", "Levitt,Dubner"));
        id = 34;
    }

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Books getBooks() {    
        return new Books(books);
    }

    @RequestMapping(method=RequestMethod.POST, produces="application/json")
    public @ResponseBody Book createBook(@RequestBody Book book) {
        book.setId(id);
        id++;
        books.add(book);

        return book;
    }
}
