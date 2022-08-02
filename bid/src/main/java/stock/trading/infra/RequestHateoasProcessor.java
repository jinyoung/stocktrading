package stock.trading.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stock.trading.domain.*;

@Component
public class RequestHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Request>> {

    @Override
    public EntityModel<Request> process(EntityModel<Request> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/sell")
                .withRel("sell")
        );

        return model;
    }
}
