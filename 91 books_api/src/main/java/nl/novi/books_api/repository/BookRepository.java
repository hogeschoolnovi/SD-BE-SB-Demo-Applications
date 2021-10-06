package nl.novi.books_api.repository;

import nl.novi.books_api.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookRepository extends JpaRepository<Book, Long> {

    Collection<Book> findAllByTitle(String title);
    Collection<Book> findAllByWriter(String name);
    Collection<Book> findAllByTitleAndWriter(String title, String writer);

//    @Query("SELECT * FROM books WHERE title=?1 AND writer=?2 AND isbn=?3 ORDER BY isbn;")
//    Collection<Book> findAllByTitleAndWriterAndIsbn(String title, String writer, String isbn);

}
