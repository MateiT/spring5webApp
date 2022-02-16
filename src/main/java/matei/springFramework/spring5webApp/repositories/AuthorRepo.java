package matei.springFramework.spring5webApp.repositories;

import matei.springFramework.spring5webApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
