package stock.trading.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stock.trading.domain.*;

@RepositoryRestResource(collectionResourceRel = "asks", path = "asks")
public interface AskRepository extends PagingAndSortingRepository<Ask, Long> {}
