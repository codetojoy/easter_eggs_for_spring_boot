
package net.codetojoy.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="value")
public class Value implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="desc")
    private String desc;

    // @ManyToOne  @JoinColumn(name = "code_id")    
    // private Code code;

    public Value() {}

    // -----------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    // public Code getCode() { return code; }
    // public void setCode(Code code) { this.code = code; }
}
