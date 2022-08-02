package stock.trading.external;

import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    /**
     * Fallback
     */
    public Asset getAsset(Long id) {
        Asset asset = new Asset();
        return asset;
    }
    // keep

}
