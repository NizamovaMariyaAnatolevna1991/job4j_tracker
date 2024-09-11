package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 500);
        Book book2 = new Book("Java", 900);
        Book book3 = new Book("PL+", 720);
        Book book4 = new Book("Три медведя", 10);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getNameBook() + " - " + book.getCountPages());
        }
        System.out.println("Replace books 0 and 3");
        Book buffer = books[0];
        books[0] = books[3];
        books[3] = buffer;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getNameBook() + " - " + book.getCountPages());
        }
        System.out.println("Books-\"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getNameBook().equals("Clean code")) {
                System.out.println(book.getNameBook() + " - " + book.getCountPages());
            }
        }
    }
}
