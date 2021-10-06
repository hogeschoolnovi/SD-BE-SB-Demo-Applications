package nl.novi.books_api.model;

import javax.persistence.*;
import java.util.List;

public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @OneToMany
    List<Book> books;

}
