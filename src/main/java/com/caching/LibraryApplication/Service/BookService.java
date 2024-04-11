package com.caching.LibraryApplication.Service;

import com.caching.LibraryApplication.BookEntity.BookEntity;
import com.caching.LibraryApplication.Dto.BookDto;

public interface BookService {

    public BookEntity addBook(BookDto book);

    public BookEntity updateBook(int id, BookDto book);

    public BookEntity getBook(int id);

    public String deleteBook(int id);

}
