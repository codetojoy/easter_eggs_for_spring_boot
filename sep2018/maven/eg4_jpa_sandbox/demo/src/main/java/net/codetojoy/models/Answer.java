
package net.codetojoy.models;

import javax.persistence.*;
import java.io.Serializable;

public class Answer {}

/*
@Entity
@Table(name="answer")
public class Answer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String answerText;

    private Long itemId;
    private Long questionId;

    public Answer() {}

    // -----------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }

    public Long getItemQuestionId() { return questionId; }
    public void setItemQuestionId(Long questionId) { this.questionId = questionId; }

    public String getAnswerText() { return answerText; }
    public void setAnswerText(String answerText) { this.answerText = answerText; }
}
*/
