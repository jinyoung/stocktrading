package stock.trading.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stock.trading.domain.*;

@Component
public class AskHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Ask>> {

    @Override
    public EntityModel<Ask> process(EntityModel<Ask> model) {
        return model;
    }
}
