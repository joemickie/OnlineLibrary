package org.java15.services;

import org.java15.models.Book;
import org.java15.models.Person;

public interface LibraryServices {
    String requestBook(Book book, Person person);
}
