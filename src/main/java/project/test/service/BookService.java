package project.test.service;

import project.test.entity.Book;

import java.util.List;

public interface BookService {
    void save(String bookName , String aName, String aSurname);

    void delete(String bookName);

    List<Book> findAll();

    List<Book> findAllByName(String bookName);

    public void editBook(String oldBookName, String bookName);


}
