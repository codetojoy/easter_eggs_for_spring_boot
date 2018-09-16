package net.codetojoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import net.codetojoy.model.Book;
import net.codetojoy.api.query.BookQueryService;

@Controller
@RequestMapping("/api/books")
public class BookQueryController {
    private BookQueryService queryService;

    @Autowired
    public BookQueryController(BookQueryService queryService) {
        this.queryService = queryService;
    }

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Book> getBooks() throws Exception {
        // TODO consider returning BookDto objects
        return queryService.getBooks();
    }
}
