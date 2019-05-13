package udemy.demo.springframework.guru.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.demo.springframework.guru.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
