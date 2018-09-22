
package net.codetojoy.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String title;

    public Book() {}

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    // -----------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
