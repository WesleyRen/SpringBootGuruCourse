package udemy.demo.springframework.guru.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.demo.springframework.guru.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
