package com.myapp.bookservice.service.impl;

import com.myapp.bookservice.model.BookDTO;
import com.myapp.bookservice.repos.BookRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.myapp.bookservice.service.BookService;
import com.myapp.bookservice.util.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepositoryImpl bookRepository;

    public BookServiceImpl(final BookRepositoryImpl bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<BookDTO> getAllBooksSortedByTitleDescending(){
        return bookRepository.findAllByOrderByTitleDesc();
    }

    public Map<String, List<BookDTO>> getBooksGroupedByAuthor() {
        List<BookDTO> allBooks = bookRepository.findAll();
        return allBooks.stream().collect(Collectors.groupingBy(BookDTO::getAuthor));
    }

    public BookDTO create(final BookDTO bookDTO) {
        Long id = bookRepository.save(bookDTO);
        bookDTO.setId(id);
        return bookDTO;
    }

    public List<Object[]> getTopAuthorsWithCharacterCount(String character) {
        List<BookDTO> allBooks = bookRepository.findAll();

        return allBooks.stream()
                .collect(Collectors.groupingBy(BookDTO::getAuthor,
                        Collectors.summingInt(book -> StringUtils.countOccurrencesIgnoreCase(book.getTitle(), character))))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .map(entry -> new Object[]{entry.getKey(), entry.getValue()})
                .collect(Collectors.toList());
    }



}
