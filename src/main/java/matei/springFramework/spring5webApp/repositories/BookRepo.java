package matei.springFramework.spring5webApp.repositories;

import matei.springFramework.spring5webApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
