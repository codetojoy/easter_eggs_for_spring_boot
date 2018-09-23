
package net.codetojoy.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne @JoinColumn(name="question_id")
    private Question question;

    @OneToOne @JoinColumn(name="value_id")
    private Value value;

    @Column(name="score_value")
    private int scoreValue;

    // -----------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    public Value getValue() { return value; }
    public void setValue(Value value) { this.value = value; }

    public int getScoreValue() { return scoreValue; }
    public void setScoreValue(int scoreValue) { this.scoreValue = scoreValue; }
}
