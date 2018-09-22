package net.codetojoy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import net.codetojoy.models.*;
import net.codetojoy.services.*;

@Controller
@RequestMapping("/api/mega")
public class MegaController {
    private BookRepository bookRepository;
    private ItemRepository itemRepository;
    private QuestionRepository questionRepository;
    private CodeRepository codeRepository;

    @Autowired
    public MegaController(BookRepository bookRepository, ItemRepository itemRepository,
                          QuestionRepository questionRepository, CodeRepository codeRepository) {
        this.bookRepository = bookRepository;
        this.itemRepository = itemRepository;
        this.questionRepository = questionRepository;
        this.codeRepository = codeRepository;
    }

    @RequestMapping(path="/books",method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Book> getBooks() throws Exception {
        List<Book> results = bookRepository.findAll();
        return results;
    }

    @RequestMapping(path="/items",method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Item> getItems() throws Exception {
        List<Item> results = itemRepository.findAll();
        return results;
    }

    @RequestMapping(path="/questions",method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Question> getQuestions() throws Exception {
        List<Question> results = questionRepository.findAll();
        return results;
    }

    @RequestMapping(path="/codes",method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Code> getCodes() throws Exception {
        List<Code> results = codeRepository.findAll();
        return results;
    }
}
