package stock.trading.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stock.trading.domain.*;

@RepositoryRestResource(collectionResourceRel = "bids", path = "bids")
public interface BidRepository extends PagingAndSortingRepository<Bid, Long> {}
