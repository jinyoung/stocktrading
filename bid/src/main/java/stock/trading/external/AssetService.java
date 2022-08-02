package stock.trading.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
    name = "assets",
    url = "${api.url.assets}",
    fallback = AssetServiceImpl.class
)
public interface AssetService {
    @RequestMapping(method = RequestMethod.GET, path = "/assets/{item}")
    public Asset getAsset(@PathVariable("item") String item);
    // keep

}
