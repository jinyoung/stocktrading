package stock.trading.domain;

import java.util.*;
import lombok.*;
import stock.trading.domain.*;
import stock.trading.infra.AbstractEvent;

@Data
@ToString
public class Traded extends AbstractEvent {

    private Long id;
    private String item;
    private Double price;
    private Long bidRequestId;
    private Double quantity;
    private Long askRequestId;

    public Traded(Trade aggregate) {
        super(aggregate);
    }

    public Traded() {
        super();
    }
    // keep

}
