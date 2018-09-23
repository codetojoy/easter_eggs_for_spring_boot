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

    private QuestionGroupRepository questionGroupRepository;
    private ScoreRepository scoreRepository;

    @Autowired
    public MegaController(BookRepository bookRepository, ItemRepository itemRepository,
                          QuestionRepository questionRepository, CodeRepository codeRepository,
                          AnswerRepository answerRepository,
                          QuestionGroupRepository questionGroupRepository,
                          ScoreRepository scoreRepository) {
        this.bookRepository = bookRepository;
        this.itemRepository = itemRepository;
        this.questionRepository = questionRepository;
        this.codeRepository = codeRepository;
        this.answerRepository = answerRepository;

        this.questionGroupRepository = questionGroupRepository;
        this.scoreRepository = scoreRepository;
    }

    // ---- PUT

    @RequestMapping(value="/answers/{id}",method=RequestMethod.PUT)
    public @ResponseBody Answer updateAnswer(@PathVariable("id") long id,
                                             @RequestParam String answerText,
                                             @RequestParam Integer score) throws Exception {
        // TODO: this should go in a service
        Optional<Answer> answerOpt = answerRepository.findById(id);
        Answer answer = answerOpt.get();

        answer.setAnswerText(answerText);
        answer.setScore(score);

        answerRepository.saveAndFlush(answer);
        // System.out.println("TRACER PUT answer: " + answer.getId() + " text: " + answerText);

        System.out.println("TRACER PUT answer OK");

        return answer;
    }

    // ---- non-trivial GET

    @RequestMapping(value="/scores",method=RequestMethod.GET)
    public @ResponseBody Score getScoreForQuestionAndValue(@RequestParam Long questionId,
                                                           @RequestParam Long valueId) throws Exception {

        /*
        // this is really bad ...
        // need a service and more importantly a JPA query
        List<Score> scores = scoreRepository.findAll();
        Score score = null;

        System.out.println("TRACER debug TARGET: score " + questionId + " " + valueId);

        for (Score thisScore : scores) {
            Long thisQuestionId = thisScore.getQuestion().getId();
            Long thisValueId = thisScore.getValue().getId();
            if (thisQuestionId.equals(questionId) && thisValueId.equals(valueId)) {
                score = thisScore;
                break;
            }
        }
        */

        Score score = scoreRepository.findByQuestionIdAndValueId(questionId, valueId);

        if (score != null) {
            System.out.println("TRACER score: " + score.getId());
        } else {
            System.out.println("TRACER NULL score");
        }

        return score;
    }

    // ---- simple GET

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

    @RequestMapping(path="/question_group",method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<QuestionGroup> getQuestionGroup() throws Exception {
        List<QuestionGroup> results = questionGroupRepository.findAllWithOrder();
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

    @RequestMapping(path="/scores",method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Score> getScores() throws Exception {
        List<Score> results = scoreRepository.findAll();
        return results;
    }
}
