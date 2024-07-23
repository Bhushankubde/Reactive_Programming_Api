package com.demo.service.impl;

import com.demo.Repository.BookRepository;
import com.demo.entity.Book;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceimpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Mono<Book> create(Book book) {
        Mono<Book> savedbook = bookRepository.save(book);
        return savedbook;
    }

    @Override
    public Flux<Book> getAll() {
        Flux<Book> allbooks = bookRepository.findAll();
        return allbooks;
    }

    @Override
    public Mono<Book> getSingle(int bookid) {
        Mono<Book> singlebook = bookRepository.findById(bookid);
        return singlebook;
    }

    @Override
    public Mono<Book> update(Book book, int bookid) {
         Mono<Book> oldbook = bookRepository.findById(bookid);
        return oldbook.flatMap(book1 -> {
             book1.setBookid(book.getBookid());
             book1.setBookname(book.getBookname());
             book1.setDescription(book.getDescription());
             return bookRepository.save(book1);
         });
    }

    @Override
    public Mono<Void> delete(int bookid) {
        return bookRepository.findById(bookid)
                .flatMap(book -> bookRepository.delete(book));
    }

}
