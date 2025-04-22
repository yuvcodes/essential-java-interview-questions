package q02_associationCompositionAggregation;
import java.util.*;

    class Book {
        String title;

        Book(String title) {
            this.title = title;
        }

        void display() {
            System.out.println("Book: " + title);
        }
    }

    // Library contains Books, but books can exist without the library.
    class Library {
        List<Book> books;

        Library(List<Book> books) {
            this.books = books;
        }

        void displayBooks() {
            System.out.println("Library contains:");
            for (Book b : books) {
                b.display();
            }
        }
    }

    public class AggregationDemo {
        public static void main(String[] args) {
            Book b1 = new Book("Java Fundamentals");
            Book b2 = new Book("Spring Boot Basics");

            List<Book> bookList = new ArrayList<>();
            bookList.add(b1);
            bookList.add(b2);

            Library lib = new Library(bookList);
            lib.displayBooks();
        }
    }

    /*
    output:
        Library contains:
        Book: Java Fundamentals
        Book: Spring Boot Basics
     */
