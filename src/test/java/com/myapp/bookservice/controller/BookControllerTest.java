package com.myapp.bookservice.controller;

import com.myapp.bookservice.model.BookDTO;
import com.myapp.bookservice.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    @Test
    public void testGetAllBooks() {
        // Arrange
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookController bookController = new BookController(bookService);
        List<BookDTO> expectedBooks = new ArrayList<>();
        // Add some dummy data to expectedBooks

        // Mocking bookService behavior for the method call
        when(bookService.getAllBooksSortedByTitleDescending()).thenReturn(expectedBooks);

        // Act
        ResponseEntity<List<BookDTO>> responseEntity = bookController.getAllBooks();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedBooks, responseEntity.getBody());
    }

    @Test
    public void testGetBooksGroupedByAuthor() {
        // Arrange
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookController bookController = new BookController(bookService);
        Map<String, List<BookDTO>> expectedBooksGroupedByAuthor = new HashMap<>();
        // Add some dummy data to expectedBooksGroupedByAuthor

        List<BookDTO> booksByAuthorA = new ArrayList<>();
        booksByAuthorA.add(new BookDTO(1L, "Book 1 by Author A", "Author A", "Description 1"));
        booksByAuthorA.add(new BookDTO(2L, "Book 2 by Author A", "Author A", "Description 2"));
        expectedBooksGroupedByAuthor.put("Author A", booksByAuthorA);

        List<BookDTO> booksByAuthorB = new ArrayList<>();
        booksByAuthorB.add(new BookDTO(3L, "Book 1 by Author B", "Author B", "Description 1"));
        expectedBooksGroupedByAuthor.put("Author B", booksByAuthorB);

        // Mocking bookService behavior for the method call
        when(bookService.getBooksGroupedByAuthor()).thenReturn(expectedBooksGroupedByAuthor);

        // Act
        ResponseEntity<Map<String, List<BookDTO>>> responseEntity = bookController.getBooksGroupedByAuthor();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedBooksGroupedByAuthor, responseEntity.getBody());
    }

    @Test
    public void testCreateBook() {
        // Arrange
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookController bookController = new BookController(bookService);
        BookDTO bookDTO = new BookDTO();
        // Set bookDTO properties

        // Mocking bookService behavior for the method call
        when(bookService.create(bookDTO)).thenReturn(bookDTO);

        // Act
        ResponseEntity<BookDTO> responseEntity = bookController.createBook(bookDTO);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(bookDTO, responseEntity.getBody());
    }

    @Test
    public void testGetTopAuthorsWithCharacterCount() {
        // Arrange
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookController bookController = new BookController(bookService);
        List<Object[]> expectedTopAuthors = new ArrayList<>();
        // Add some dummy data to expectedTopAuthors
        expectedTopAuthors.add(new Object[]{"Author A", 10});
        expectedTopAuthors.add(new Object[]{"Author B", 8});
        expectedTopAuthors.add(new Object[]{"Author C", 6});

        // Mocking bookService behavior for the method call
        when(bookService.getTopAuthorsWithCharacterCount(anyString())).thenReturn(expectedTopAuthors);

        // Act
        ResponseEntity<List<Object[]>> responseEntity = bookController.getTopAuthorsWithCharacterCount("a");

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedTopAuthors, responseEntity.getBody());
    }
}
