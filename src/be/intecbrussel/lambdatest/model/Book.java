package be.intecbrussel.lambdatest.model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    public String title;
    public Person author;
    public LocalDate releaseDate;
    public String genre;


    public Book(String title, Person author, LocalDate releaseDate, String genre) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(releaseDate, book.releaseDate) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, releaseDate, genre);
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }
}
