
package net.codetojoy.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="question_group")
public class QuestionGroup implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne @JoinColumn(name="question_id")
    private Question question;

    @Column(name="prefix")
    private String prefix;

    @Column(name="sequence")
    private int sequence;

    @Column(name="tier")
    private int tier;

    @Column(name="q_activation_threshold")
    private int activationThreshold;

    @Column(name="has_comments")
    private boolean comments;

    @Column(name="is_mandatory")
    private boolean mandatory;

    @Column(name="is_mutex")
    private boolean mutex;

    // -----------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    public String getPrefix() { return prefix; }
    public void setPrefix(String prefix) { this.prefix = prefix; }

    public int getSequence() { return sequence; }
    public void setSequence(int sequence) { this.sequence = sequence; }

    public int getTier() { return tier; }
    public void setTier(int tier) { this.tier = tier; }

    public int getActivationThreshold() { return activationThreshold; }
    public void setActivationThreshold(int activationThreshold) { this.activationThreshold = activationThreshold; }

    public boolean isComments() { return comments; }
    public void setComments(boolean comments) { this.comments = comments; }

    public boolean isMandatory() { return mandatory; }
    public void setMandatory(boolean mandatory) { this.mandatory = mandatory; }

    public boolean isMutex() { return mutex; }
    public void setMutex(boolean mutex) { this.mutex = mutex; }
}
