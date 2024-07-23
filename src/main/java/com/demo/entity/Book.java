package com.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_details")
public class Book {
    @Id
    private int bookid;
    private String bookname;
    private String description;

    public Book() {

    }

    public Book(int bookid, String bookname, String description) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.description = description;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
