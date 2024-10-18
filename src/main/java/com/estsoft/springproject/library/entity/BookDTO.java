package com.estsoft.springproject.library.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@AllArgsConstructor
public class BookDTO {
    private String id;
    private String name;
    private String author;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
    }

}
