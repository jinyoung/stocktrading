package stock.trading.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stock.trading.domain.*;

@RepositoryRestResource(collectionResourceRel = "requests", path = "requests")
public interface RequestRepository
    extends PagingAndSortingRepository<Request, Long> {}
