package matei.springFramework.spring5webApp.repositories;

import matei.springFramework.spring5webApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
