package ru.job4j.pojo;

public class Book {
    private String nameBook;
    private int countPages;

    public Book(String nameBook, int countPages) {
        this.nameBook = nameBook;
        this.countPages = countPages;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }
}
