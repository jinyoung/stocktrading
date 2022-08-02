package stock.trading.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stock.trading.TradeApplication;

@Entity
@Table(name = "Bid_table")
@Data
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String item;

    private Double price;

    private String accountId;

    private Double quantity;

    public static BidRepository repository() {
        BidRepository bidRepository = TradeApplication.applicationContext.getBean(
            BidRepository.class
        );
        return bidRepository;
    }

    public static void acceptBid(BidRequested bidRequested) {
        /** Example 1:  new item 
        Bid bid = new Bid();
        repository().save(bid);

        */

        /** Example 2:  finding and process
        
        repository().findById(bidRequested.get???()).ifPresent(bid->{
            
            bid // do something
            repository().save(bid);


         });
        */

    }
}
