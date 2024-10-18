package com.estsoft.springproject.library.service;

import com.estsoft.springproject.library.entity.Book;
import com.estsoft.springproject.library.entity.BookDTO;
import com.estsoft.springproject.library.repository.BookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;


    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    // 책 전체 조회
    public List<Book> findAll() {
        return repository.findAll(Sort.by("id")); // 오름차순
    }

    // 특정 책 조회
    public Book findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 ID 값 입니다"));
    }
    
    // 책 생성
    public Book createBook(Book book) {
        return repository.save(book);
    }
}
