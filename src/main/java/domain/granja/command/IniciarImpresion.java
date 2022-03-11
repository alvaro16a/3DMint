package domain.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.granja.value.GranjaID;
import domain.granja.value.Impresora3DID;

public class IniciarImpresion extends Command {
    private final GranjaID granjaID;
    private final Impresora3DID impresora3DID;

    public IniciarImpresion(GranjaID granjaID, Impresora3DID impresora3DID) {
        this.granjaID = granjaID;
        this.impresora3DID = impresora3DID;
    }

    public GranjaID getGranjaID() {
        return granjaID;
    }

    public Impresora3DID getImpresora3DID() {
        return impresora3DID;
    }
}
