package com.myapp.bookservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookDTOTest {

    @Test
    public void testGetterAndSetter() {
        // Arrange
        BookDTO bookDTO = new BookDTO();
        Long id = 1L;
        String title = "Test Title";
        String author = "Test Author";
        String description = "Test Description";

        // Act
        bookDTO.setId(id);
        bookDTO.setTitle(title);
        bookDTO.setAuthor(author);
        bookDTO.setDescription(description);

        // Assert
        assertEquals(id, bookDTO.getId());
        assertEquals(title, bookDTO.getTitle());
        assertEquals(author, bookDTO.getAuthor());
        assertEquals(description, bookDTO.getDescription());
    }

    @Test
    public void testConstructor() {
        // Arrange
        Long id = 1L;
        String title = "Test Title";
        String author = "Test Author";
        String description = "Test Description";

        // Act
        BookDTO bookDTO = new BookDTO(id, title, author, description);

        // Assert
        assertEquals(id, bookDTO.getId());
        assertEquals(title, bookDTO.getTitle());
        assertEquals(author, bookDTO.getAuthor());
        assertEquals(description, bookDTO.getDescription());
    }
}
