package domain.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.granja.value.Impresora3DID;

public class TerminarImpresion extends Command {

    private final Impresora3DID impresora3DID;

    public TerminarImpresion(Impresora3DID impresora3DID) {
        this.impresora3DID = impresora3DID;
    }

    public Impresora3DID getImpresora3DID() {
        return impresora3DID;
    }
}
