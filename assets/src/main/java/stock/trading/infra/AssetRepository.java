package stock.trading.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stock.trading.domain.*;

@RepositoryRestResource(collectionResourceRel = "assets", path = "assets")
public interface AssetRepository
    extends PagingAndSortingRepository<Asset, Long> {
    List<Asset> findByAccountId(String accountId);
    // keep

}
