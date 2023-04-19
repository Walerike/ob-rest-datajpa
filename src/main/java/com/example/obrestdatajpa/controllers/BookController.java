package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repositories.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
     *
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id) {
        Optional<Book> bookopt = bookRepository.findById(id);
        // opcion 1 devuelve book si existe, en caso contrario devuelve nullo
        if (bookopt.isPresent())
            return ResponseEntity.ok(bookopt.get());
        else
            return ResponseEntity.notFound().build();
        //  return bookopt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    //guardar el libro recibido por parametro en la base de datos
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return bookRepository.save(book);
    }


}
