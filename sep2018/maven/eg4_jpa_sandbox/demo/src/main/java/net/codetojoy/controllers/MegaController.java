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
    private AnswerRepository answerRepository;

    @Autowired
    public MegaController(BookRepository bookRepository, ItemRepository itemRepository,
                          QuestionRepository questionRepository, CodeRepository codeRepository,
                          AnswerRepository answerRepository) {
        this.bookRepository = bookRepository;
        this.itemRepository = itemRepository;
        this.questionRepository = questionRepository;
        this.codeRepository = codeRepository;
        this.answerRepository = answerRepository;
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

    @RequestMapping(path="/answers",method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Answer> getAnswers() throws Exception {
        List<Answer> results = answerRepository.findAll();
        return results;
    }
}
