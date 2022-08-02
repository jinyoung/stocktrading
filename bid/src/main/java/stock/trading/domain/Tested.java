package stock.trading.domain;

import java.util.*;
import lombok.*;
import stock.trading.domain.*;
import stock.trading.infra.AbstractEvent;

@Data
@ToString
public class Tested extends AbstractEvent {

    private Long id;
    private Float price;
    private String item;
    private String accountId;
    private String status;
    private Boolean bid;
    private Double quantity;

    public Tested(Request aggregate) {
        super(aggregate);
    }

    public Tested() {
        super();
    }
    // keep

}
