package com.myapp.bookservice.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testGetterAndSetter() {
        // Arrange
        Book book = new Book();
        Long id = 1L;
        String title = "Test Title";
        String author = "Test Author";
        String description = "Test Description";

        // Act
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);

        // Assert
        assertEquals(id, book.getId());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(description, book.getDescription());
    }

    @Test
    public void testConstructor() {
        // Arrange
        Long id = 1L;
        String title = "Test Title";
        String author = "Test Author";
        String description = "Test Description";

        // Act
        Book book = new Book(id, title, author, description);

        // Assert
        assertEquals(id, book.getId());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(description, book.getDescription());
    }
}
