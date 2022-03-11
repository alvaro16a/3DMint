package domain.granja;

import co.com.sofka.domain.generic.EventChange;
import domain.granja.event.GranjaCreada;
import domain.granja.event.ImpresionIncluida;
import domain.granja.event.ImpresoraIncluida;

import java.util.ArrayList;

public class GranjaEventChange extends EventChange {
    public GranjaEventChange(Granja granja) {

        apply((GranjaCreada event) -> {
            granja.impresoras = new ArrayList<>();
            granja.stls = new ArrayList<>();
        });

        apply((ImpresoraIncluida event) ->{
            granja.impresoras.add(new Impresora3D(event.Impresora3DID()));

        });

        apply((ImpresionIncluida event) ->{
            granja.stls.add(event.getStl());
        });
    }
}
