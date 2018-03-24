package com.romanklause.spring5webapp.bootstrap;

import com.romanklause.spring5webapp.model.Author;
import com.romanklause.spring5webapp.model.Book;
import com.romanklause.spring5webapp.model.Publisher;
import com.romanklause.spring5webapp.repositories.AuthorRepository;
import com.romanklause.spring5webapp.repositories.BookRespository;
import com.romanklause.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRespository bookRespository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,
                        BookRespository bookRespository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRespository = bookRespository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author author = new Author("Georg", "Orwell");
        Publisher publisher = new Publisher("Ullstein Taschenbuch", "HH");
        Book book = new Book("1984", "1234",  publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);

        publisherRepository.save(publisher);
        authorRepository.save(author);
        bookRespository.save(book);
    }

}
