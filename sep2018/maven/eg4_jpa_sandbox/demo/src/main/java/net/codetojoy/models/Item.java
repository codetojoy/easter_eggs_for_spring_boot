package net.codetojoy.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany  @JoinColumn(name = "item_id")
    private List<Answer> answers;

    @Column(name="score")
    private int score;

    // -----------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Answer> getAnswers() { return answers; }
    public void setAnswers(List<Answer> answers) { this.answers = answers; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
