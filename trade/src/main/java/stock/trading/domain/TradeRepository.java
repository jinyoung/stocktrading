package stock.trading.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stock.trading.domain.*;

@RepositoryRestResource(collectionResourceRel = "trades", path = "trades")
public interface TradeRepository
    extends PagingAndSortingRepository<Trade, Long> {}
