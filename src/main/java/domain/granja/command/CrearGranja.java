package domain.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.granja.value.GranjaID;

public class CrearGranja extends Command {
    private final GranjaID entityId;

    public CrearGranja(GranjaID entityId) {
        this.entityId = entityId;
    }

    public GranjaID getEntityId() {
        return entityId;
    }
}
