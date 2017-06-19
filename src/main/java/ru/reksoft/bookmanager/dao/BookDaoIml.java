package ru.reksoft.bookmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.reksoft.bookmanager.model.Book;

import java.util.List;

/**
 * Created by agubanov on 07.06.2017.
 */
@Repository
public class BookDaoIml implements IBookDao {

    private static final Logger LOG
            = LoggerFactory.getLogger(BookDaoIml.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        LOG.info("Book succesful saved. Book details: " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        LOG.info("Book succesful update. Book details: " + book);
    }

    @Override
    public void removeBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, id);
        if (book != null) {
            session.delete(book);
            LOG.info("Book succesful removed. Book details: " + book);
        }
        LOG.info("Unsuccessful remove book! Book details: " + book);
    }

    @Override
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, id);
        LOG.info("Book succesful loaded. Book details: " + book);
        return book;
    }

    @Override
    public List<Book> listBooks() {
        final Session session = sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();
        LOG.info("Book list: " + bookList);
        return bookList;
    }

}
