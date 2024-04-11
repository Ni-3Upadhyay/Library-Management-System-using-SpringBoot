package com.caching.LibraryApplication.Dto;

import com.caching.LibraryApplication.BookEntity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class BookDto {

    int id;
    String bookName;
    String price;
    String about;

    public BookDto(){

    }

    public BookDto(int id, String bookName, String price, String about){
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.about= about;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPrice() {
        return price;
    }

    public String getAbout() {
        return about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
