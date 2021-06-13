package pl.coderslab.workshop.domain.service;

import org.springframework.stereotype.Service;
import pl.coderslab.workshop.domain.model.Book;
import pl.coderslab.workshop.domain.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService  implements pl.coderslab.workshop.domain.interfaces.BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void edit(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> get(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book add(Book book) {
        bookRepository.save(book);
        return book;
    }
}
