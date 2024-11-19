package com.estsoft.springproject.library.controller;

import com.estsoft.springproject.library.entity.Book;
import com.estsoft.springproject.library.entity.BookDTO;
import com.estsoft.springproject.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService service;
    private final BookService bookService;

    public BookController(BookService service, BookService bookService) {
        this.service = service;
        this.bookService = bookService;
    }

    // 책 전체 조회
    @GetMapping
    public String showAll(Model model) {
        List< BookDTO> list = service.findAll()
                .stream()
                .map(BookDTO::new)
                .toList();
        model.addAttribute("bookList", list);
        return "bookManagement";
    }

    // 책 전체 조회 api
    @GetMapping("/api")
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.findAll();
    }


    // 책 단건 조회
    @GetMapping("/{id}")
    public String showDetail(@PathVariable String id, Model model) {
        Book book = service.findById(id);

        model.addAttribute("book", new BookDTO(book));

        return "bookDetail";
    }

    // 책 생성
    @PostMapping
    public String addBook(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String author
    ) {
        service.createBook(new Book(id, name, author));
        return "redirect:/books";
    }
}
