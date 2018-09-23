package net.codetojoy.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="answer")
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="answer_text")
    private String answerText;

    @OneToOne @JoinColumn(name="question_id")
    private Question question;

    @Column(name="comments")
    private String comments;

    @Column(name="score")
    private int score;

    // -----------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    public String getAnswerText() { return answerText; }
    public void setAnswerText(String answerText) { this.answerText = answerText; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
