package org.java15.models;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Library {
    private final List<Book> books;
    private final Queue<BookRequest> firstComeFirstServeQueue;
    private final PriorityQueue<BookRequest> priorityQueue;

    public Library(List<Book> books) {
        this.books = books;
        this.firstComeFirstServeQueue = new LinkedList<>();
        this.priorityQueue = new PriorityQueue<>((a, b) -> {
            if(a.book().equals(b.book())) {
                return Integer.compare(a.person().getStatus().getValue(), b.person().getStatus().getValue());
            } else {
                return Integer.compare(a.noInQueue(), b.noInQueue());
            }
        });
    }

    public List<Book> getBooks() {
        return books;
    }

    public Queue<BookRequest> getFirstComeFirstServeQueue() {
        return firstComeFirstServeQueue;
    }

    public PriorityQueue<BookRequest> getPriorityQueue() {
        return priorityQueue;
    }
}
