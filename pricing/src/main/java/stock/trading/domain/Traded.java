package stock.trading.domain;

import java.util.Date;
import lombok.Data;
import stock.trading.infra.AbstractEvent;

@Data
public class Traded extends AbstractEvent {

    private Long id;
    private String item;
    private Double price;
    private Long bidRequestId;
    private Double quantity;
    private Long askRequestId;
}
