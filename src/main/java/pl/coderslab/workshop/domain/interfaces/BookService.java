package pl.coderslab.workshop.domain.interfaces;

import pl.coderslab.workshop.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    void edit(Book book);
    void delete(Long id);
    Optional<Book> get(Long id);
    Book add(Book book);
}
