package stock.trading.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "trade", url = "${api.url.trade}")
public interface TradeService {
    @RequestMapping(method = RequestMethod.GET, path = "/trades/{id}")
    public Trade getTrade(@PathVariable("id") Long id);
    // keep

}
