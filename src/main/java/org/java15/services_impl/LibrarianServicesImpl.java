package org.java15.services_impl;

import org.java15.enums.Status;
import org.java15.models.Book;
import org.java15.models.BookRequest;
import org.java15.models.Library;
import org.java15.models.Person;
import org.java15.services.LibrarianServices;

import java.util.List;

public class LibrarianServicesImpl implements LibrarianServices {
    private final Library library;

    public LibrarianServicesImpl(Library library) {
        this.library = library;
    }

    @Override
    public String issueBookOnFirstComeFirstServeBasis(Person person) {
        if (person.getStatus().equals(Status.LIBRARIAN)) {
            while (!library.getFirstComeFirstServeQueue().isEmpty()) {
                BookRequest bookRequest = library.getFirstComeFirstServeQueue().remove();
                issueBook(bookRequest);
            }
            return "Issued all books on first come first serve basis";
        } else {
            return "Only librarian can issue book on first come first serve basis";
        }
    }

    @Override
    public String issueBookOnPriorityBasis(Person person) {
        if (person.getStatus().equals(Status.LIBRARIAN)) {
            while (!library.getPriorityQueue().isEmpty()) {
                BookRequest bookRequest = library.getPriorityQueue().remove();
                issueBook(bookRequest);
            }
            return "Issued all books on noInQueue basis";
        } else {
            return "Only librarian can issue book on noInQueue basis";
        }
    }

    private void issueBook(BookRequest bookRequest) {
        List<Book> books = library.getBooks();
        for (Book book : books) {
            if (book.equals(bookRequest.book())) {
                if (book.getQuantity() > 0) {
                    book.setQuantity(book.getQuantity() - 1);
                    System.out.println("Issued book " + bookRequest.book().getName() + " to " + bookRequest.person().getName());
                } else {
                    System.out.println("Book " + bookRequest.book().getName() + " is no longer available");
                }
                break;
            }
        }
    }
}
