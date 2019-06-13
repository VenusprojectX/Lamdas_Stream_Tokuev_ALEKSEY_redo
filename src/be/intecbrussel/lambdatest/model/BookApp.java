package be.intecbrussel.lambdatest.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class BookApp {
    public static void main(String[] args) {


        Book book1 = new Book("Hatty Porrer", new Person("JayKay", "RawLing", LocalDate.of(1974, 11, 23)), LocalDate.of(2008, 11, 27), "Satire");
        Book book2 = new Book("Comment Ca Va?", new Person("Dominique", "Strosquan", LocalDate.of(1931, 7, 13)), LocalDate.of(2010, 9, 27), "Autobiographie");
        Book book3 = new Book("Batman vs Joker", new Person("DC", "Universe", LocalDate.of(1936, 4, 13)), LocalDate.of(2008, 6, 6), "Comics");
        Book book4 = new Book("War and more War", new Person("Comradski", "Comrade", LocalDate.of(1922, 7, 7)), LocalDate.of(1958, 11, 13), "History");
        Book book5 = new Book("Criminal and Unpunished", new Person("Vlad", "Put", LocalDate.of(1964, 8, 23)), LocalDate.of(2012, 12, 12), "Tutorial/Educational");

        Book[] books = {book1, book2, book3, book4, book5};


    }

    public Optional<Book> getNewestBook(Book[] books) {
        return Stream.of(books).sorted(Comparator.comparing(Book::getReleaseDate)).findFirst();
    }

    public void printYoungestWriter(Book[] books) {
        Stream.of(books).sorted(Comparator.comparing(b -> b.author.dateOfBIrth));
    }

    public void printSortedByTitle(Book[] books) {
        System.out.println(Stream.of(books).sorted(Comparator.comparing(book -> book.title)));
    }

    public void contBooksPerAuthor(Book[] books){
        for (int i = 0; i < 5;i++){
            int count = 0;
//            if ( books[i].author.lastName.equalsIgnoreCase(books[0].author.lastName)){
//                count++;
//            }else if ( books[i].author.lastName.equalsIgnoreCase(books[1].author.lastName)){
//                 count++;
//            }else if ( books[i].author.lastName.equalsIgnoreCase(books[2].author.lastName)){
//                 count++;
//            }else if (books[i].author.lastName.equalsIgnoreCase(books[3].author.lastName)){
//                 count++;
//            }else if (books[i].author.lastName.equalsIgnoreCase(books[4].author.lastName)){
//                 count++;
//            }
            System.out.println(books[i].author.getLastName() + " has published " + count + "books");



        }
    }

    public void printBooksRealeasedIn2016 ( Book [] books){
        
    }
}
