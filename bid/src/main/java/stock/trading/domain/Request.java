package stock.trading.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stock.trading.BidApplication;
import stock.trading.domain.AskRequested;
import stock.trading.domain.BidRequested;
import stock.trading.domain.Tested;

@Entity
@Table(name = "Request_table")
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Float price;

    private String item;

    private String accountId;

    private String status;

    private Boolean bid;

    private Double quantity;

    @PostPersist
    public void onPostPersist() {
        BidRequested bidRequested = new BidRequested(this);
        bidRequested.publishAfterCommit();

        AskRequested askRequested = new AskRequested(this);
        askRequested.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        Tested tested = new Tested(this);
        tested.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {
        // Get request from Asset
        //stock.trading.external.Asset asset =
        //    Application.applicationContext.getBean(stock.trading.external.AssetService.class)
        //    .getAsset(/** mapping value needed */);

    }

    @PreUpdate
    public void onPreUpdate() {
        // Get request from Asset
        //stock.trading.external.Asset asset =
        //    Application.applicationContext.getBean(stock.trading.external.AssetService.class)
        //    .getAsset(/** mapping value needed */);

    }

    public static RequestRepository repository() {
        RequestRepository requestRepository = BidApplication.applicationContext.getBean(
            RequestRepository.class
        );
        return requestRepository;
    }

    public void buy() {

        if(true) return;

        Bought bought = new Bought(this);
        bought.publishAfterCommit();
    }

    public void sell() {
        Sold sold = new Sold(this);
        sold.publishAfterCommit();
    }

    public void test() {

        System.out.println("test");
    }

    public void option2() {

        //I have implemented option2
    }

    public void option3() {}

    public static void changeState(Traded traded) {
        /** Example 1:  new item 
        Request request = new Request();
        repository().save(request);

        */

        /** Example 2:  finding and process*/
        
        repository().findById(traded.get???()).ifPresent(request->{
            
            request // do something
            repository().save(request);


         });
        

    }
}
