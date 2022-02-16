package matei.springFramework.spring5webApp.bootstrap;

import matei.springFramework.spring5webApp.domain.Author;
import matei.springFramework.spring5webApp.domain.Book;
import matei.springFramework.spring5webApp.domain.Publisher;
import matei.springFramework.spring5webApp.repositories.AuthorRepo;
import matei.springFramework.spring5webApp.repositories.BookRepo;
import matei.springFramework.spring5webApp.repositories.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepo.save(publisher);

        System.out.println("Publisher Count: " + publisherRepo.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepo.save(eric);
        bookRepo.save(ddd);
        publisherRepo.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
        publisherRepo.save(publisher);

        System.out.println("Number of Books: " + bookRepo.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
