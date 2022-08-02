package stock.trading.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stock.trading.TradeApplication;

@Entity
@Table(name = "Ask_table")
@Data
public class Ask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String item;

    private Double price;

    private String accountId;

    private Double quantity;

    public static AskRepository repository() {
        AskRepository askRepository = TradeApplication.applicationContext.getBean(
            AskRepository.class
        );
        return askRepository;
    }

    public static void acceptAsk(AskRequested askRequested) {
        /** Example 1:  new item 
        Ask ask = new Ask();
        repository().save(ask);

        */

        /** Example 2:  finding and process   */
        
        repository().findById(askRequested.get???()).ifPresent(ask->{
            
            ask // do something
            repository().save(ask);


         });
     

    }
}
