package pl.coderslab.workshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.domain.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
