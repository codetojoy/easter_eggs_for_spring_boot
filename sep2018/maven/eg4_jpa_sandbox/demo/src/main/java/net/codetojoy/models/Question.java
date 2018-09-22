
package net.codetojoy.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne @JoinColumn(name="code_id")
    private Code code;

    @Column(name="desc")
    private String desc;

    // -----------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    public Code getCode() { return code; }
    public void setCode(Code code) { this.code = code; }
}
