package nl.novi.books_api.controller;

import nl.novi.books_api.model.Book;
import nl.novi.books_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<Object> searchBooks(@RequestParam(name="title", defaultValue="") String title,
                                              @RequestParam(name="writer", defaultValue="") String writer) {
        return ResponseEntity.ok().body(bookService.getBooks(title, writer));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getBook(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(bookService.getBookById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createBook(@RequestBody Book book) {
        long newId = bookService.createBook(book);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateBookPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        bookService.partialUpdateBook(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
