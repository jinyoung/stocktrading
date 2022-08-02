package stock.trading.external;

import java.util.Date;
import lombok.Data;

@Data
public class Asset {

    private String item;
    private Double amount;
    private String accountId;
    // keep

}
