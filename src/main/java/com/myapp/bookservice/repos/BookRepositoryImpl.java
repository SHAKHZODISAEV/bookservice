package com.myapp.bookservice.repos;

import com.myapp.bookservice.model.BookDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class BookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;


    public BookRepositoryImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BookDTO> findAll() {
        return jdbcTemplate.query("SELECT * FROM book ", new BeanPropertyRowMapper<>(BookDTO.class));
    }

    @Override
    public List<BookDTO> findAllByOrderByTitleDesc() {
       return jdbcTemplate.query("SELECT * FROM book order by title desc", new BeanPropertyRowMapper<>(BookDTO.class));
    }

    @Override
    public Long save(BookDTO book) {
        Long id = getNextIdFromSequence();
        jdbcTemplate.update("INSERT INTO book (id,title, author, description) VALUES(?,?,?,?)",
                new Object[] {id,book.getTitle(), book.getAuthor(), book.getDescription() });
        return id;
    }

    private Long getNextIdFromSequence() {
        String query = "SELECT nextval('primary_sequence')";
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
