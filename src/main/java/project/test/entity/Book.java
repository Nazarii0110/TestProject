package project.test.entity;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;
    private String bookName;
    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    private Author author;

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, String authorName, String authorSurname) {
        this.bookName = bookName;
        this.author = new Author(authorName, authorSurname);
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
