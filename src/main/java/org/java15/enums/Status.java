package org.java15.enums;

public enum Status {
    TEACHER(1),
    SENIOR(2),
    JUNIOR(3),
    LIBRARIAN(4);

    private int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
