
package net.codetojoy.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="code")
public class Code implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    // @OneToMany(mappedBy="code")
    @OneToMany  @JoinColumn(name = "code_id")
    private List<Value> values;

    public Code() {}

    // -----------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Value> getValues() { return values; }
    public void setValues(List<Value> values) { this.values = values; }
}
