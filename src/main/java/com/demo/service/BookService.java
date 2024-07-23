package com.demo.service;

import com.demo.entity.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

   public Mono<Book> create(Book book);
   public Flux<Book> getAll();
   public Mono<Book> getSingle(int bookid);
   public Mono<Book> update(Book book, int bookid);
   public Mono<Void> delete(int bookid);
}
