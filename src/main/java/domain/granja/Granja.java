package domain.granja;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Identity;

public class Granja extends AggregateEvent {

    public Granja(Identity entityId) {
        super(entityId);
    }
}
