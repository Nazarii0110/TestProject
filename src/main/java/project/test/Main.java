package project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import project.test.config.DataConfig;
import project.test.service.BookService;

import java.awt.print.Book;
import java.util.Scanner;

@Component
public class Main {

    public static void main(String[] args) {


        Scanner scanner  =  new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
        BookService bookService = context.getBean(BookService.class);


        System.out.println("Please choose what you want:  1-add book;" +
                "2-delet book;"+
                "3-edit book;" +
                "4-show all books;" +
                "5-Show sorted books by name;" +
                "or if You want quit enter anothe number");
        String a = "Thank you for using program";;
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Enter name of book then name author and his/her surname:");
                bookService.save(scanner.next(), scanner.next(), scanner.next());
                System.out.println("Book was added");

                break;
            case 2:
                System.out.println("Enter name of book wich you want to delete:");
                bookService.delete(scanner.next());
                System.out.println("Book was deleted");
                break;
            case 3:
                System.out.println("Enter name of book wich you want to edit:");
                bookService.editBook(scanner.next(), scanner.next());
                System.out.println("Book was edited");
                break;
            case 4:
                System.out.println("All books");
                System.out.println(bookService.findAll());
                break;
            case 5:
                System.out.println("Sorted books by name");
                System.out.println(bookService.findAllByName(scanner.next()));
            default:
                System.out.println(a);
                break;
        }


        }

    }





