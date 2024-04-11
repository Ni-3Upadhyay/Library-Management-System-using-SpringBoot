package com.caching.LibraryApplication.BookRepository;

import com.caching.LibraryApplication.BookEntity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

//    @Modifying
//    @Query("update book_entity b set b.")
//    int updateAddress(long id, String name);
}
