package stock.trading.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stock.trading.domain.*;

@Component
public class BidHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Bid>> {

    @Override
    public EntityModel<Bid> process(EntityModel<Bid> model) {
        return model;
    }
}
