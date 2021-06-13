package pl.coderslab.workshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.workshop.domain.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
