package stock.trading.domain;

import java.util.Date;
import lombok.Data;
import stock.trading.infra.AbstractEvent;

@Data
public class Bought extends AbstractEvent {

    private Long id;
    private Float price;
    private String item;
    private String accountId;
    private Double quantity;
}
