package domain.granja.command;

import domain.granja.value.Impresora3DID;

public class TerminarImpresion {

    private final Impresora3DID impresora3DID;

    public TerminarImpresion(Impresora3DID impresora3DID) {
        this.impresora3DID = impresora3DID;
    }

    public Impresora3DID getImpresora3DID() {
        return impresora3DID;
    }
}
