package com.myapp.bookservice.controller;

import com.myapp.bookservice.model.BookDTO;
import com.myapp.bookservice.service.impl.BookServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(final BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/sortedByTitleDescending")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooksSortedByTitleDescending());
    }

    @GetMapping("/groupedByAuthor")
    public ResponseEntity<Map<String, List<BookDTO>>> getBooksGroupedByAuthor() {
        Map<String, List<BookDTO>> booksGroupedByAuthor = bookService.getBooksGroupedByAuthor();
        return ResponseEntity.ok(booksGroupedByAuthor);
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid final BookDTO bookDTO) {
        BookDTO createdBook = bookService.create(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping("/topAuthorsWithCharacterCount")
    public ResponseEntity<List<Object[]>> getTopAuthorsWithCharacterCount(@RequestParam String character) {
        List<Object[]> topAuthorsWithCharacterCount = bookService.getTopAuthorsWithCharacterCount(character);
        return ResponseEntity.ok(topAuthorsWithCharacterCount);
    }



}
