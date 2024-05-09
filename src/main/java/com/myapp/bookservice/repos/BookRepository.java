package com.myapp.bookservice.repos;

import com.myapp.bookservice.model.BookDTO;

import java.util.List;

public interface BookRepository {

    List<BookDTO> findAll();

    List<BookDTO> findAllByOrderByTitleDesc();

    Long save(BookDTO book);

}
