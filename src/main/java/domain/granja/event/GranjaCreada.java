package domain.granja.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.granja.value.GranjaID;

public class GranjaCreada extends DomainEvent {

    private final GranjaID granjaID;

    public GranjaCreada(GranjaID entityId) {
        super("granja.granjacreada");
        this.granjaID=entityId;
    }

    public GranjaID getGranjaID() {
        return granjaID;
    }
}
