package com.caching.LibraryApplication.BookEntity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book_entity")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "book_name")
    String bookName;

    @Column()
    String price;

    @Column()
    String about;

    public BookEntity(){

    }

    public BookEntity(int id, String bookName, String price, String about){
        this.id = id;
        this.about = about;
        this.price = price;
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public String getBookName() {
        return bookName;
    }

    public String getPrice() {
        return price;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
