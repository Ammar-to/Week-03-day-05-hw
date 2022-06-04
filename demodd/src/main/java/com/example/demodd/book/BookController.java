package com.example.demodd.book;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@RestController @RequestMapping("book/")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    Logger logger = LoggerFactory.getLogger(BookController.class);
    @GetMapping("")
    public ResponseEntity getBooks(){
        logger.info("Invoked get all books");
        return ResponseEntity.status(200).body(bookService.getBooks());
    }

    @GetMapping("{id}")
    public ResponseEntity getBook(@PathVariable Integer id){
        logger.info("Invoked get one book");
        return ResponseEntity.status(200).body(bookService.getBook(id));
    }

    @PostMapping("")
    public ResponseEntity addBook(@RequestBody @Valid Book book){
        logger.info("Invoked add a book");
        Optional<Book> book1 = Optional.of(book);
        if(book1.isPresent()){
            bookService.addBook(book);
            return ResponseEntity.status(200).body("Added" + book.getName());
        }
        return ResponseEntity.status(400).body("Invalid Data Entered");
    }
}
