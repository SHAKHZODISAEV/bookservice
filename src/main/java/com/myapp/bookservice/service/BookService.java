package com.myapp.bookservice.service;

import com.myapp.bookservice.model.BookDTO;

import java.util.List;
import java.util.Map;

/**
 * Service Interface for managing {@link com.myapp.bookservice.domain.Book}.
 */

public interface BookService {

    List<BookDTO> getAllBooksSortedByTitleDescending();

    Map<String, List<BookDTO>> getBooksGroupedByAuthor();

    BookDTO create(final BookDTO bookDTO);

    List<Object[]> getTopAuthorsWithCharacterCount(String character);

}
