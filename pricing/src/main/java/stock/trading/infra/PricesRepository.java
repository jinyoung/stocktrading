package stock.trading.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stock.trading.domain.*;

@RepositoryRestResource(collectionResourceRel = "prices", path = "prices")
public interface PricesRepository
    extends PagingAndSortingRepository<Prices, Long> {
    // keep

}
