package org.java15.services_impl;

import org.java15.models.Book;
import org.java15.models.BookRequest;
import org.java15.models.Library;
import org.java15.models.Person;
import org.java15.services.LibraryServices;

public class LibraryServicesImpl implements LibraryServices {
    private final Library library;

    public LibraryServicesImpl(Library library) {
        this.library = library;
    }

    @Override
    public String requestBook(Book book, Person person) {
        if (library.getBooks().contains(book)) {
            if (book.getQuantity() > 0) {
                library.getFirstComeFirstServeQueue().add(new BookRequest(book, person, library.getPriorityQueue().size()+1));
                library.getPriorityQueue().add(new BookRequest(book, person, library.getPriorityQueue().size()+1));
                return "Book " + book.getName() + " requested by " + person.getName();
            } else {
                return "Book " + book.getName() + " is not available";
            }
        } else {
            return "Book " + book.getName() + " is not available";
        }
    }
}
