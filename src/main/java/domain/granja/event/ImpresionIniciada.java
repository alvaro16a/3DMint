package domain.granja.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.granja.value.Impresora3DID;
import domain.value.Stl;

public class ImpresionIniciada extends DomainEvent {

    private final Impresora3DID impresora3DID;
    private final Stl stl;

    public ImpresionIniciada(Impresora3DID impresora3DID, Stl stl) {
        super("granja.impresioniniciada");
        this.impresora3DID=impresora3DID;
        this.stl=stl;
    }

    public Impresora3DID getImpresora3DID() {
        return impresora3DID;
    }

    public Stl getStl() {
        return stl;
    }
}
