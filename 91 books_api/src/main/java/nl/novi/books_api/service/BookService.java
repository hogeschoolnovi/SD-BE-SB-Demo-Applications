package nl.novi.books_api.service;

import nl.novi.books_api.exceptions.RecordNotFoundException;
import nl.novi.books_api.model.Book;
import nl.novi.books_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public long createBook(Book book) {
        Book newBook = bookRepository.save(book);
        //=> INSERT INTO books (title, writer, isbn) VALUES ({book.title},{book.writer},{book.isbn})
        return newBook.getId();
    }

    public void updateBook(long id, Book book) {
        if (!bookRepository.existsById(id)) throw new RecordNotFoundException();
        Book existingBook = bookRepository.findById(id).get();
        existingBook.setTitle(book.getTitle());
        existingBook.setWriter(book.getWriter());
        existingBook.setIsbn(book.getIsbn());
        bookRepository.save(existingBook);
    }

    public void partialUpdateBook(long id, Map<String, String> fields) {
        if (!bookRepository.existsById(id)) throw new RecordNotFoundException();
        Book book = bookRepository.findById(id).get();
        for (String field : fields.keySet()) {
            switch (field.toLowerCase()) {
                case "title":
                    book.setTitle((String) fields.get(field));
                    break;
                case "writer":
                    book.setWriter((String) fields.get(field));
                    break;
                case "isbn":
                    book.setIsbn((String) fields.get(field));
                    break;
            }
        }
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        if (!bookRepository.existsById(id)) throw new RecordNotFoundException();
        bookRepository.deleteById(id);
    }

    public Collection<Book> getBooks(String title, String writer) {
        if (!title.isEmpty()) {
            if (!writer.isEmpty()) {
                return bookRepository.findAllByTitleAndWriter(title, writer);
            }
            else {
                return bookRepository.findAllByTitle(title);
            }
        }
        else {
            if (!writer.isEmpty()) {
                return bookRepository.findAllByWriter(writer);
            }
            else {
                return bookRepository.findAll();
            }
        }
    }

    public Optional<Book> getBookById(long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        if (!bookRepository.existsById(id)) throw new RecordNotFoundException();
        return bookRepository.findById(id);
    }

    public boolean bookExistsById(long id) {
        return bookRepository.existsById(id);
    }

}
