package org.java15.services;

import org.java15.models.Person;

public interface LibrarianServices {
    String issueBookOnFirstComeFirstServeBasis(Person person);
    String issueBookOnPriorityBasis(Person person);
}
