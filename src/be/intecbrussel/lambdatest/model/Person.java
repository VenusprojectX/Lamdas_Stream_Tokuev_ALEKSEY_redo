package be.intecbrussel.lambdatest.model;

import java.time.LocalDate;

public class Person {

    public String fristName;
    public String lastName;
    public LocalDate dateOfBIrth;

    public Person(String fristName, String lastName, LocalDate dateOfBIrth) {
        this.fristName = fristName;
        this.lastName = lastName;
        this.dateOfBIrth = dateOfBIrth;
    }

    public String getFristName() {
        return fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBIrth() {
        return dateOfBIrth;
    }
}
