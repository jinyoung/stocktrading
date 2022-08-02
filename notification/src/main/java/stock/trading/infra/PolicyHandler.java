package stock.trading.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stock.trading.config.kafka.KafkaProcessor;
import stock.trading.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @Autowired
    stock.trading.external.TradeService tradeService;

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Sold'"
    )
    public void wheneverSold_SendNotification(@Payload Sold sold) {
        Sold event = sold;
        System.out.println(
            "\n\n##### listener SendNotification : " + sold + "\n\n"
        );
        // REST Request Sample

        // tradeService.getTrade(/** mapping value needed */);

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Bought'"
    )
    public void wheneverBought_SendNotification(@Payload Bought bought) {
        Bought event = bought;
        System.out.println(
            "\n\n##### listener SendNotification : " + bought + "\n\n"
        );
        // REST Request Sample

        // tradeService.getTrade(/** mapping value needed */);

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AskRequested'"
    )
    public void wheneverAskRequested_SendNotification(
        @Payload AskRequested askRequested
    ) {
        AskRequested event = askRequested;
        System.out.println(
            "\n\n##### listener SendNotification : " + askRequested + "\n\n"
        );
        // REST Request Sample

        // tradeService.getTrade(/** mapping value needed */);

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BidRequested'"
    )
    public void wheneverBidRequested_SendNotification(
        @Payload BidRequested bidRequested
    ) {
        BidRequested event = bidRequested;
        System.out.println(
            "\n\n##### listener SendNotification : " + bidRequested + "\n\n"
        );
        // REST Request Sample

        // tradeService.getTrade(/** mapping value needed */);

        // Sample Logic //

    }
    // keep

}
