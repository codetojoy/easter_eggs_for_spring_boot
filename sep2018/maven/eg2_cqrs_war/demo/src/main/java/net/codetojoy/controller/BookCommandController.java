package net.codetojoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import net.codetojoy.dto.BookDto;
import net.codetojoy.api.command.BookCommandService;

@Controller
@RequestMapping("/api/books")
public class BookCommandController {
    private BookCommandService commandService;

    @Autowired
    public BookCommandController(BookCommandService commandService) {
        this.commandService = commandService;
    }

    @RequestMapping(method=RequestMethod.POST, produces="application/json")
    public @ResponseBody void createBook(@RequestBody BookDto bookDto) {
        String author = bookDto.getAuthor();
        String title = bookDto.getTitle();
        commandService.createBook(author, title);
        // TODO: return HTTP error if there is a problem
    }
}
