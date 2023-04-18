package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    //atributo
    private BookRepository bookRepository;

    // constructor
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // CRUD sobre la entidad Book

    // Buscar todos los libros (lista de libros)

    /**
     * http://localhost:8081/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

//    public  Book findOneById(Long id){
//
//    }
}
