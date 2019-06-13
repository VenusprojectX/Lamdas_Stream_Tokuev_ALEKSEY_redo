package be.intecbrussel.lambdatest.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class BookApp {
    public static void main(String[] args) {

        // Creating an array books of objects Book
        Book[] books = new Book[4];


        // Declaring 5 book objects
        Book book1 = new Book("Hatty Porrer", new Person("JayKay", "RawLing", LocalDate.of(1974, 11, 23)), LocalDate.of(2008, 11, 27), "Satire");
        Book book2 = new Book("Comment Ca Va?", new Person("Dominique", "Strosquan", LocalDate.of(1931, 7, 13)), LocalDate.of(2010, 9, 27), "Autobiographie");
        Book book3 = new Book("Batman vs Joker", new Person("DC", "Universe", LocalDate.of(1936, 4, 13)), LocalDate.of(2008, 6, 6), "Comics");
        Book book4 = new Book("War and more War", new Person("Comradski", "Comrade", LocalDate.of(1922, 7, 7)), LocalDate.of(1958, 11, 13), "History");
        Book book5 = new Book("Criminal and Unpunished", new Person("Vlad", "Put", LocalDate.of(1964, 8, 23)), LocalDate.of(2017, 12, 12), "Tutorial/Educational");

        // Filling the array book with above declared Book objects
        books = new Book[]{book1, book2, book3, book4, book5};


        // Applying the methods
        System.out.println("\n Freshest book is " + getNewestBook(books));
        System.out.printf("\n Youngest writer is ");
        printYoungestWriter(books);
        System.out.printf("\n Books in Alphabetical Order;\n");
        printSortedByTitle(books);
        System.out.printf("\n Amount of books per writer\n");
        cuontBooksPerAuthor(books);
        System.out.printf("\n Books released from 2016 onwards");
        printBooksRealeasedIn2016(books);


    }

    // We create a Stream of array books and sort it accordingly to the objects Book their release date and put in a new array newBook(created with the help of a constructor reference,
    // after the sorting we print out the first element of the array newBook e.g. after the sorting the first element will be the newest book
    public static Book getNewestBook(Book[] books) {
        Book[] newBook = Stream.of(books).sorted(Comparator.comparing(Book::getReleaseDate)).toArray(Book[]::new);
        return newBook[0];
    }

    //We create a stream of array books and sort it on basis of the date of birth of the author of a book
    //After the sorting we print out the authors credentials
    public static void printYoungestWriter(Book[] books) {
        Stream.of(books).sorted((b1, b2) -> b1.author.dateOfBIrth.compareTo(b2.author.dateOfBIrth));
        System.out.println(books[0].author.lastName + " " + books[0].author.fristName + "born " + books[0].author.dateOfBIrth);
    }

    // We create a stream of array books and sort the books alphabetically and print them out via the method reference
    public static void printSortedByTitle(Book[] books) {
        Stream.of(books).sorted(Comparator.comparing(book -> book.title)).forEach(System.out::println);
    }

    // The lazy long way
    public static void cuontBooksPerAuthor(Book[] books) {
        for (int i = 0; i < 5; i++) {
            int count = 0;
            if (books[i].author.lastName.equalsIgnoreCase(books[0].author.lastName) && books[i].author.fristName.equalsIgnoreCase(books[0].author.fristName)) {
                count++;
            }
            if (books[i].author.lastName.equalsIgnoreCase(books[1].author.lastName) && books[i].author.fristName.equalsIgnoreCase(books[1].author.fristName)) {
                count++;
            }
            if (books[i].author.lastName.equalsIgnoreCase(books[2].author.lastName) && books[i].author.fristName.equalsIgnoreCase(books[2].author.fristName)) {
                count++;
            }
            if (books[i].author.lastName.equalsIgnoreCase(books[3].author.lastName) && books[i].author.fristName.equalsIgnoreCase(books[3].author.fristName)) {
                count++;
            }
            if (books[i].author.lastName.equalsIgnoreCase(books[4].author.lastName) && books[i].author.fristName.equalsIgnoreCase(books[4].author.fristName)) {
                count++;
            }
            System.out.println(books[i].author.getLastName() + "" + books[i].author.getFristName() + " has published " + count + " books");
        }
    }

    // We create a LocalDate variable 'd' and initialize the values to 2016-01-01
    // We filter the array books according to all the books released after the moment 'd' and print all the books that are valid for that condition
    public static void printBooksRealeasedIn2016(Book[] books) {
        LocalDate d = LocalDate.of(2016, 1, 1);
        Stream.of(books).filter(book -> book.getReleaseDate().isAfter(d)).forEach(System.out::println);
    }
}
