package project.test.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import project.test.entity.Book;

import java.util.List;

public interface BookDAO extends JpaRepository<Book, Integer> {

    List<Book> findAllByBookName(String bookName);
}
