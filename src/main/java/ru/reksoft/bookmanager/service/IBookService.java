package ru.reksoft.bookmanager.service;

import ru.reksoft.bookmanager.model.Book;

import java.util.List;

/**
 * Created by agubanov on 07.06.2017.
 */
public interface IBookService {

    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(int id);

    Book getBookById(int id);

    List<Book> listBooks();
}
