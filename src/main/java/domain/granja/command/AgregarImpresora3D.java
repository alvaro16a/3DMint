package domain.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.granja.value.GranjaID;
import domain.granja.value.Impresora3DID;

public class AgregarImpresora3D extends Command {

    private final GranjaID granjaID;
    private final Impresora3DID impresora3DID;

    public AgregarImpresora3D(GranjaID granjaID, Impresora3DID entityId) {
        this.granjaID = granjaID;
        this.impresora3DID = entityId;
    }

    public GranjaID getGranjaID() {
        return granjaID;
    }

    public Impresora3DID getImpresora3DID() {
        return impresora3DID;
    }
}
