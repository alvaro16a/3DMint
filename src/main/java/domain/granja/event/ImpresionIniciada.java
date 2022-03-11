package domain.granja.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.granja.value.Impresora3DID;


public class ImpresionIniciada extends DomainEvent {

    private final Impresora3DID impresora3DID;


    public ImpresionIniciada(Impresora3DID impresora3DID) {
        super("granja.impresioniniciada");
        this.impresora3DID = impresora3DID;

    }

    public Impresora3DID getImpresora3DID() {
        return impresora3DID;
    }

}
