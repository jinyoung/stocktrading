package stock.trading.domain;

import java.util.*;
import lombok.*;
import stock.trading.domain.*;
import stock.trading.infra.AbstractEvent;

@Data
@ToString
public class Bought extends AbstractEvent {

    private Long id;
    private Float price;
    private String item;
    private String accountId;
    private Double quantity;

    public Bought(Request aggregate) {
        super(aggregate);
    }

    public Bought() {
        super();
    }
    // keep

}
