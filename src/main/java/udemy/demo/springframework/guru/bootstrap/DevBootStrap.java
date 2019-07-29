package udemy.demo.springframework.guru.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import udemy.demo.springframework.guru.model.Author;
import udemy.demo.springframework.guru.model.Book;
import udemy.demo.springframework.guru.model.Publisher;
import udemy.demo.springframework.guru.repositories.AuthorRepository;
import udemy.demo.springframework.guru.repositories.BookRepository;
import udemy.demo.springframework.guru.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Eric
        Author eric =  new Author("Eric", "Evans");
        Publisher publisherA = new Publisher("A Pub", "A Street");
        publisherA.setName("foo");
        Book ddd = new Book("Domain Driven Design", "1234", publisherA);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(publisherA);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //rod
        Author rod =  new Author("Rod", "Johnson");
        Publisher publisherB = new Publisher("B Pub", "B Street");
        publisherB.setName("bar");
        Book noEJB = new Book("J2EE Development without EJB ", "234444", publisherB);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(publisherB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
