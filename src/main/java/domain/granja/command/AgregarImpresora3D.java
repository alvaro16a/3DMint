package domain.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.granja.value.Impresora3DID;

public class AgregarImpresora3D extends Command {

    private final Impresora3DID entityId;

    public AgregarImpresora3D(Impresora3DID entityId) {
        this.entityId = entityId;
    }

    public Impresora3DID getEntityId() {
        return entityId;
    }
}
