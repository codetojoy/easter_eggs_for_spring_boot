
package net.codetojoy.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="desc")
    private String desc;

    public Question() {}

    // -----------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }
}
