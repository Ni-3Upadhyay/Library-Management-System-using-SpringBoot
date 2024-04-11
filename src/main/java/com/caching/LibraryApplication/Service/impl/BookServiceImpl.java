package com.caching.LibraryApplication.Service.impl;

import com.caching.LibraryApplication.BookEntity.BookEntity;
import com.caching.LibraryApplication.BookRepository.BookRepository;
import com.caching.LibraryApplication.Dto.BookDto;
import com.caching.LibraryApplication.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Override
    public BookEntity addBook(BookDto book) {

        BookEntity bookEntity = new BookEntity(book.getId(), book.getBookName(), book.getPrice(), book.getAbout());
        BookEntity book1 = bookRepository.save(bookEntity);
        return book1;
    }

    @Override
    @CachePut(cacheNames = "books", key="#id")          // the difference b/w cachePut and cacheable is to update we use cachePut
    public BookEntity updateBook(int id , BookDto book) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow();

        bookEntity.setBookName(book.getBookName());
        bookEntity.setAbout(book.getAbout());
        bookEntity.setPrice(book.getPrice());
        return bookRepository.save(bookEntity);
    }

    @Override
    @Cacheable(cacheNames = "books", key = "#id")           // to store the data in the cache so whatever output we want we will get it in cache
    public BookEntity getBook(int id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")           // CacheEvict to delete from cache memory.
    public String deleteBook(int id) {

        bookRepository.deleteById(id);
        return "book deleted";
    }
}
