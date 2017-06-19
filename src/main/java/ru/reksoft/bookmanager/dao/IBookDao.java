package ru.reksoft.bookmanager.dao;

import ru.reksoft.bookmanager.model.Book;

import java.util.List;

/**
 * Created by agubanov on 07.06.2017.
 */
public interface IBookDao {

    public void addBook(Book book);

    public void updateBook(Book book);

    public  void  removeBook(int id);

    public Book getBookById(int id);

    public List<Book> listBooks();

}
