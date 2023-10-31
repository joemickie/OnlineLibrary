package org.java15;

import org.java15.enums.Gender;
import org.java15.enums.Status;
import org.java15.models.Book;
import org.java15.models.Library;
import org.java15.models.Person;
import org.java15.services.LibrarianServices;
import org.java15.services.LibraryServices;
import org.java15.services_impl.LibrarianServicesImpl;
import org.java15.services_impl.LibraryServicesImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(Arrays.asList(new Book("English", "John Doe", 4),
                new Book("Math", "Jane Doe", 5),
                new Book("Science", "John Doe", 4),
                new Book("History", "Jane Doe", 2),
                new Book("Geography", "John Doe", 1),
                new Book("Computer Science", "Jane Doe", 0)));
        Library library = new Library(books);
        Person teacher = new Person("Ernest", Gender.MALE, 30, Status.TEACHER);
        Person seniorStudent = new Person("Charles", Gender.MALE, 30, Status.SENIOR);
        Person juniorStudent = new Person("Emma", Gender.MALE, 30, Status.JUNIOR);
        Person librarian = new Person("Philip", Gender.MALE, 30, Status.LIBRARIAN);

        LibraryServices libraryServices = new LibraryServicesImpl(library);
        System.out.println(libraryServices.requestBook(books.get(2), juniorStudent));
        System.out.println(libraryServices.requestBook(books.get(3), teacher));
        System.out.println(libraryServices.requestBook(books.get(2), seniorStudent));
        System.out.println(libraryServices.requestBook(books.get(0), juniorStudent));
        System.out.println(libraryServices.requestBook(books.get(0), seniorStudent));
        System.out.println(libraryServices.requestBook(books.get(0), teacher));
        System.out.println("-----------------------");
        LibrarianServices librarianServices = new LibrarianServicesImpl(library);
        System.out.println("First come first serve");
        System.out.println(librarianServices.issueBookOnFirstComeFirstServeBasis(librarian));
        System.out.println("-----------------------");
        System.out.println("Priority queue");
        System.out.println(librarianServices.issueBookOnPriorityBasis(librarian));
    }
}