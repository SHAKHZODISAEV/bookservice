package com.myapp.bookservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;



public class BookDTO {

    public BookDTO(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public BookDTO() {
    }

    public BookDTO(Long id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    @Schema(hidden = true)
    private Long id;

    @Size(max = 150)
    private String title;

    @Size(max = 150)
    private String author;

    @Size(max = 150)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
