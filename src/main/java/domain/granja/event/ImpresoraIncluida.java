package domain.granja.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.granja.value.Impresora3DID;

public class ImpresoraIncluida extends DomainEvent {

    private final Impresora3DID impresora3DID;

    public ImpresoraIncluida(Impresora3DID impresora3DID) {
        super("granja.impresoraincluida");
        this.impresora3DID = impresora3DID;
    }

    public Impresora3DID Impresora3DID() {
        return impresora3DID;
    }
}
