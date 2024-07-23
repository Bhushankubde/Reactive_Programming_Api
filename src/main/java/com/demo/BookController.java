package com.demo;

import com.demo.Repository.BookRepository;
import com.demo.entity.Book;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Mono<Book> create(@RequestBody Book book){
       return bookService.create(book);
    }
    @GetMapping("/all")
    public Flux<Book> getAll(){
        return bookService.getAll() ;
    }

    @GetMapping("/{bid}")
    public Mono<Book> getSingle(@PathVariable("bid") int bookid){
        return bookService.getSingle(bookid);
    }

    @PutMapping("/{bookid}")
    public Mono<Book> update(@RequestBody Book book , @PathVariable int bookid ){
      return bookService.update(book,bookid);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable int id){
        return bookService.delete(id);
    }

}
