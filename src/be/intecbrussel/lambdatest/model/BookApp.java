package be.intecbrussel.lambdatest.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class BookApp {
    public static void main(String[] args) {


        Book[] books = new Book[4];

        Book book1 = new Book("Hatty Porrer", new Person("JayKay", "RawLing", LocalDate.of(1974, 11, 23)), LocalDate.of(2008, 11, 27), "Satire");
        Book book2 = new Book("Comment Ca Va?", new Person("Dominique", "Strosquan", LocalDate.of(1931, 7, 13)), LocalDate.of(2010, 9, 27), "Autobiographie");
        Book book3 = new Book("Batman vs Joker", new Person("DC", "Universe", LocalDate.of(1936, 4, 13)), LocalDate.of(2008, 6, 6), "Comics");
        Book book4 = new Book("War and more War", new Person("Comradski", "Comrade", LocalDate.of(1922, 7, 7)), LocalDate.of(1958, 11, 13), "History");
        Book book5 = new Book("Criminal and Unpunished", new Person("Vlad", "Put", LocalDate.of(1964, 8, 23)), LocalDate.of(2017, 12, 12), "Tutorial/Educational");

        books = new Book[]{book1, book2, book3, book4, book5};

        System.out.println("\n Freshest book is " + getNewestBook(books).title);
        System.out.printf("\n Youngest writer is "); printYoungestWriter(books);
        System.out.printf("\n Books in Alphabetical Order;\n");printSortedByTitle(books);
        System.out.printf("\n Amount of books per writer\n");cuontBooksPerAuthor(books);
        System.out.printf("\n Books released from 2016 onwards");printBooksRealeasedIn2016(books);


    }

    public static Book getNewestBook(Book[] books) {
        Stream.of(books).sorted(Comparator.comparing(Book::getReleaseDate));
        return books[0];

//        return Stream.of(books).sorted(Comparator.comparing(Book::getReleaseDate)).limit(1).map(Book);
    }

    public static void printYoungestWriter(Book[] books) {
//        System.out.println(Stream.of(books).sorted(Comparator.comparing(b -> b.author.dateOfBIrth)).toString());
        Stream.of(books).sorted((b1,b2)-> b1.author.dateOfBIrth.compareTo(b2.author.dateOfBIrth));
        System.out.println(books[0].author.lastName + books[0].author.fristName);
    }

    public static void printSortedByTitle(Book[] books) {
        Stream.of(books).sorted(Comparator.comparing(book -> book.title)).forEach(book -> book.title.toString());

    }

    public static void cuontBooksPerAuthor(Book[] books) {
        for (int i = 0; i < 5; i++) {
            int count = 0;
            if (books[i].author.lastName.equalsIgnoreCase(books[0].author.lastName)) {
                count++;
            }
            if (books[i].author.lastName.equalsIgnoreCase(books[1].author.lastName)) {
                count++;
            }
            if (books[i].author.lastName.equalsIgnoreCase(books[2].author.lastName)) {
                count++;
            }
            if (books[i].author.lastName.equalsIgnoreCase(books[3].author.lastName)) {
                count++;
            }
            if (books[i].author.lastName.equalsIgnoreCase(books[4].author.lastName)) {
                count++;
            }
            System.out.println(books[i].author.getLastName() + " has published " + count + "books");
        }
    }

    public static void printBooksRealeasedIn2016(Book[] books) {
        LocalDate d = LocalDate.of(2016, 1, 1);
        System.out.println(Stream.of(books).filter(book -> book.getReleaseDate().isAfter(d)));
    }
}
