package catalog.angularjs.dto;

import com.fasterxml.jackson.annotation.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book", unique = true, nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "short_desc")
    private String shortDescription;

    @Column(name = "date_publ", length = 4)
    private String datePublish;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "id_book", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_author", nullable = false, updatable = false)})
    @JsonBackReference("authors-books")
    private List<Author> authors = new ArrayList<Author>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(String datePublish) {
        this.datePublish = datePublish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return String.format("Book{id=%s, title='%s', shortDescription='%s', datePublish='%s', authors='%s'}",
                id, title, shortDescription, datePublish, authors);
    }
}
