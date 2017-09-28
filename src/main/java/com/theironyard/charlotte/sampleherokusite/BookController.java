package com.theironyard.charlotte.sampleherokusite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController {

    List<Book> books = new ArrayList<>();

    @CrossOrigin
    @RequestMapping(path = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {

        return books;
    }

    //@CrossOrigin(origins = {"http://thegoogs.com", "yahoo.com", "idk.com"})
    @CrossOrigin
    @RequestMapping(path = "/books", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {
        //Book greenEggsAndHam = new Book("1234","Green Eggs And Ham",
        //                        "Dr. Seuss!", true, "Awesome", true, 67 );
        //books.add(greenEggsAndHam);
        books.add(book);

    }

    @CrossOrigin
    @RequestMapping(path = "/checkin", method = RequestMethod.PATCH)
    public void checkInBook(@RequestBody Book book) {
        book.setCheckedOut(false);
    }

    @CrossOrigin
    @RequestMapping(path = "/checkout", method = RequestMethod.PATCH)
    public void checkOutBook(@RequestBody Book book) {
        book.setCheckedOut(true);
    }
}
