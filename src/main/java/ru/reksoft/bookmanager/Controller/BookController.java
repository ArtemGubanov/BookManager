package ru.reksoft.bookmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.reksoft.bookmanager.model.Book;
import ru.reksoft.bookmanager.service.IBookService;
import ru.reksoft.bookmanager.service.IPublicationHouseService;

/**
 * Контроллер книг
 * Created by agubanov on 07.06.2017.
 */
@Controller
public class BookController {

    private IBookService bookService;

    @Autowired
    private IPublicationHouseService publicationHouseService;

    @Autowired
    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        System.out.println();
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", bookService.listBooks());
        model.addAttribute("publicationHouseMap",publicationHouseService.publicationHouseMap());
        return "books";
    }

    @RequestMapping(value = "books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            bookService.addBook(book);
        } else {
            bookService.updateBook(book);
        }
        return "redirect:/books";
    }

    @RequestMapping(value = "remove/{id}")
    public String remmoveBook(@PathVariable("id") int id) {
        bookService.removeBook(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("listBooks", bookService.listBooks());
        model.addAttribute("publicationHouseMap",publicationHouseService.publicationHouseMap());
        return "books";
    }

    @RequestMapping(value = "bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }

}
