package com.example.demodd.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(Integer bookId){
        return bookRepository.findById(bookId).get();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }
}
