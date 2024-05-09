package com.myapp.bookservice.repos;

import com.myapp.bookservice.model.BookDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class BookRepositoryImplTest {

    @Test
    public void testFindAll() {
        // Arrange
        JdbcTemplate jdbcTemplate = Mockito.mock(JdbcTemplate.class);
        BookRepositoryImpl bookRepository = new BookRepositoryImpl(jdbcTemplate);
        List<BookDTO> expectedBooks = new ArrayList<>();
        // Add some dummy data to expectedBooks

        expectedBooks.add(new BookDTO(1L, "Book A", "Author A", "Description A"));
        expectedBooks.add(new BookDTO(2L, "Book B", "Author B", "Description B"));
        // Mocking jdbcTemplate behavior
        when(jdbcTemplate.query(anyString(), Mockito.any(BeanPropertyRowMapper.class)))
                .thenReturn(expectedBooks);

        // Act
        List<BookDTO> actualBooks = bookRepository.findAll();

        // Assert
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    public void testFindAllByOrderByTitleDesc() {
        // Arrange
        JdbcTemplate jdbcTemplate = Mockito.mock(JdbcTemplate.class);
        BookRepositoryImpl bookRepository = new BookRepositoryImpl(jdbcTemplate);
        List<BookDTO> expectedBooks = new ArrayList<>();
        // Add some dummy data to expectedBooks

        expectedBooks.add(new BookDTO(1L, "Book A", "Author A", "Description A"));
        expectedBooks.add(new BookDTO(2L, "Book B", "Author B", "Description B"));

        // Mocking jdbcTemplate behavior for the query with ordering by title descending
        when(jdbcTemplate.query(anyString(), Mockito.any(BeanPropertyRowMapper.class)))
                .thenReturn(expectedBooks);

        // Act
        List<BookDTO> actualBooks = bookRepository.findAllByOrderByTitleDesc();

        // Assert
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    public void testSave() {
        // Arrange
        JdbcTemplate jdbcTemplate = Mockito.mock(JdbcTemplate.class);
        BookRepositoryImpl bookRepository = new BookRepositoryImpl(jdbcTemplate);
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Test Title");
        bookDTO.setAuthor("Test Author");
        bookDTO.setDescription("Test Description");

        Long expectedId = 1L;
        // Mocking behavior of getNextIdFromSequence
        when(jdbcTemplate.queryForObject(anyString(), Mockito.eq(Long.class)))
                .thenReturn(expectedId);

        // Act
        Long actualId = bookRepository.save(bookDTO);

        // Assert
        assertEquals(expectedId, actualId);
        // Additional assertions can be made to verify that jdbcTemplate.update was called with correct parameters
    }
}
