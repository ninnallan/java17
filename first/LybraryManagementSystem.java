import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private int publicationYear;

    public Book(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", PublicationYear: " + publicationYear;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book getBookByISBN(String ISBN) {
        Iterator<Book> iterator = new BookIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        Iterator<Book> iterator = new BookIterator();
        while (iterator.hasNext()) {
            allBooks.add(iterator.next());
        }
        return allBooks;
    }

    public void sortBooksByYear() {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return Integer.compare(b1.getPublicationYear(), b2.getPublicationYear());
            }
        });
    }

    // BookIterator
    private class BookIterator implements Iterator<Book> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < books.size();
        }

        @Override
        public Book next() {
            return books.get(currentIndex++);
        }
    }
}

// Library Management System
// 1. შექმენით Book კლასი:
// ○ ველები: title (String), author (String), ISBN (String), and publicationYear
// (int).
// ○ მეთოდები:
// ■ Კონსტრუქტორი რომელიც ინიციალიზაციას გაუკეთებს ველებს.
// ■ toString() მეთოდი რომელიც გამოიტანს წიგნის დეტალებს.

// 2. შექმენით Library კლასი:
// ○ ველები: A collection (მაგალითად, ArrayList) Book-ის ობიექტების შესანახად.
// ○ მეთოდები:
// ■ მეთოდი რომელიც დაამატებს Book-ის ობიექტს კოლექციაში.
// ■ მეთოდი რომელიც ამოიღებს Book-ის ობიექტს ISBN-ით იტერატორის
// გამოყენებით BookIterator.
// ■ მეთოდი რომელიც გამოიტანს ყველა წიგნს იტერატორის გამოყენებით
// BookIterator.
// ■ Მეთოდი რომელიც დაასორტირებს წიგნებს publicationYear-ით და
// გამოიყენებს ანონიმურ კლასს comparator-ისას.

// 3. Inner Class - BookIterator:
// ○ შექმენით BookIterator inner კლასი რომელიც დააიმპლემენტირებს Iterator
// ინტერფეისს , გადაყვება წიგნებს ბიბლიოთეკაში.