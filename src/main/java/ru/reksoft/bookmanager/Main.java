package ru.reksoft.bookmanager;

import java.util.Arrays;
import java.util.List;


/**
 * Created by agubanov on 07.06.2017.
 */
public class Main {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"src/main/webapp/WEB-INF/springConfig.xml"});
//        IBookService bookService = (IBookService) context.getBean("bookServiceImpl");
//        System.out.println(bookService.listBooks());
        List<String> mList = Arrays.asList("aa1","cc2", "cc1", "aa2", "bb1");

        mList.stream().forEach(System.out::println);
    }
}
