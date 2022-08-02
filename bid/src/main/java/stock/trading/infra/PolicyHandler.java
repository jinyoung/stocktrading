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
    RequestRepository requestRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Traded'"
    )
    public void wheneverTraded_ChangeState(@Payload Traded traded) {
        Traded event = traded;
        System.out.println(
            "\n\n##### listener ChangeState : " + traded + "\n\n"
        );

        // Sample Logic //
        Request.changeState(event);
    }
    // keep

}
