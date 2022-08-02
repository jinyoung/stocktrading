package stock.trading.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stock.trading.TradeApplication;
import stock.trading.domain.Traded;

@Entity
@Table(name = "Trade_table")
@Data
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long bidRequestId;

    private String item;

    private Double price;

    private Double quantity;

    private Long askRequestId;

    @PostPersist
    public void onPostPersist() {
        Traded traded = new Traded(this);
        traded.publishAfterCommit();
    }

    public static TradeRepository repository() {
        TradeRepository tradeRepository = TradeApplication.applicationContext.getBean(
            TradeRepository.class
        );
        return tradeRepository;
    }
}
