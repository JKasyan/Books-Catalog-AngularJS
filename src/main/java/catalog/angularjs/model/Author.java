package catalog.angularjs.model;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Author")
public class Author implements Serializable {

    @Id
    private ObjectId id;
    @Length(min = 2, max = 20)
    private String firstName;
    @Length(min = 2, max = 20)
    private String secondName;

    @DBRef
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Author{id=%s, firstName='%s', secondName='%s'}",
                id, firstName, secondName);
    }
}
