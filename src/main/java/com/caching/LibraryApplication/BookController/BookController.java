package com.caching.LibraryApplication.BookController;


import com.caching.LibraryApplication.BookEntity.BookEntity;
import com.caching.LibraryApplication.Dto.BookDto;
import com.caching.LibraryApplication.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto book){

        BookEntity book1 = bookService.addBook(book);
        BookDto b = new BookDto(book1.getId(), book1.getBookName(),book1.getPrice(), book1.getAbout());
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") int id){
        BookEntity book1 = bookService.getBook(id);

        return new ResponseEntity<>(new BookDto(book1.getId(), book1.getBookName(),book1.getPrice(), book1.getAbout()), HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") int id,@RequestBody BookDto book){

        BookEntity bookEntity= bookService.updateBook(id, book);

        return new ResponseEntity<>(new BookDto(bookEntity.getId(), bookEntity.getBookName(), bookEntity.getPrice(), bookEntity.getAbout()), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id){

        String str =bookService.deleteBook(id);
        return new ResponseEntity<>(str,HttpStatus.OK);
    }

}
