package project.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.test.dao.BookDAO;
import project.test.entity.Book;
import project.test.service.BookService;

import java.util.List;
import java.util.Scanner;

@Service
@Transactional
public class BookServImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;


    public void save(String bookName, String aName, String aSurname) {

        if (!bookName.isEmpty() && bookName != null) {
            bookDAO.save(new Book(bookName, aName, aSurname));
            if((aName.isEmpty() || aName == null) && (aSurname.isEmpty() || aSurname == null)){
                bookDAO.save(new Book(bookName));
            }
        }
    }

    public void editBook(String oldBookName,String bookName){
        List<Book> allByName = findAllByName(oldBookName);
        if (allByName.size() > 1) {
            Book book = allByName.get(changeBookHelper(allByName));
            book.setBookName(bookName);

        }


    }

    public void delete(String bookName) {
        List<Book> allByName = findAllByName(bookName);
        if (allByName.size() > 1) {
            Book book = allByName.get(changeBookHelper(allByName));
            bookDAO.delete(book.getIdBook());

        }

    }

    public List<Book> findAll() {
        return bookDAO.findAll(new Sort(Sort.Direction.ASC, "bookName"));
    }

    public List<Book> findAllByName(String bookName) {
        return bookDAO.findAllByBookName(bookName);
    }

    public int scanInt() {
        return new Scanner(System.in).nextInt();
    }

    public int changeBookHelper(List<Book> allByName) {

        System.out.println("we have few books with such name!");
        int innerBookNumber = 1;

        for (Book book : allByName) {
            System.out.println(innerBookNumber + " "
                    + book.getBookName() + " "
                    + book.getAuthor().getAuthorName() + " "
                    + book.getAuthor().getAuthorSurname());
            innerBookNumber++;
        }
        System.out.println(" Please choose one by typing a number of book : ");
        int choosedBookNumber = scanInt();
        return choosedBookNumber;
    }

}
