package stock.trading.external;

import java.util.Date;
import lombok.Data;

@Data
public class Trade {

    private Long id;
    private Long bidRequestId;
    private String item;
    private Double price;
    private Double quantity;
    private Long askRequestId;
    // keep

}
