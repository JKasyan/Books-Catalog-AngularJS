package catalog.angularjs.dto;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.annotation.Id;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Author implements Serializable {

    @Id
    private int id;
    private String name;
    private String secondName;
    @JsonBackReference("authors-books")
    private List<Book> books = new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Author{id=%s, name='%s', secondName='%s'}",
                id, name, secondName);
    }
}
