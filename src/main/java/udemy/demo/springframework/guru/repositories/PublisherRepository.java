package udemy.demo.springframework.guru.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.demo.springframework.guru.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
