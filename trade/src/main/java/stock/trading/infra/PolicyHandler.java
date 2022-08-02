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

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    BidRepository bidRepository;

    @Autowired
    AskRepository askRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BidRequested'"
    )
    public void wheneverBidRequested_AcceptBid(
        @Payload BidRequested bidRequested
    ) {
        BidRequested event = bidRequested;
        System.out.println(
            "\n\n##### listener AcceptBid : " + bidRequested + "\n\n"
        );

        // Sample Logic //
        Bid.acceptBid(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AskRequested'"
    )
    public void wheneverAskRequested_AcceptAsk(
        @Payload AskRequested askRequested
    ) {
        AskRequested event = askRequested;
        System.out.println(
            "\n\n##### listener AcceptAsk : " + askRequested + "\n\n"
        );

        // Sample Logic //
        Ask.acceptAsk(event);
    }
    // keep

}
