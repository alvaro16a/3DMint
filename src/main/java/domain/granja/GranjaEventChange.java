package domain.granja;

import co.com.sofka.domain.generic.EventChange;
import domain.granja.event.GranjaCreada;
import domain.granja.event.ImpresionIncluida;
import domain.granja.event.ImpresionTerminada;
import domain.granja.event.ImpresoraIncluida;
import domain.granja.value.Impresora3DID;

import java.util.ArrayList;
import java.util.HashMap;

public class GranjaEventChange extends EventChange {
    public GranjaEventChange(Granja granja) {

        apply((GranjaCreada event) -> {
            granja.impresoras = new HashMap<>();
            granja.stls = new ArrayList<>();
        });

        apply((ImpresoraIncluida event) ->{
            granja.impresoras.put(event.Impresora3DID().value(),//convierto el Id en la llave
                                new Impresora3D(event.Impresora3DID()));

        });

        apply((ImpresionIncluida event) ->{
            granja.stls.add(event.getStl());
        });

        apply((ImpresionTerminada event) ->{
            Impresora3D impresora3D=granja.impresoras.get(event.getImpresora3DID());//uso el id como llave para obtener la impresora
            impresora3D.terminarImpresion(); //uso la impresora para terminar la impresion
        });
    }
}
