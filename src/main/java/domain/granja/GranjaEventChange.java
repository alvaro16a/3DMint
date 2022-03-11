package domain.granja;

import co.com.sofka.domain.generic.EventChange;
import domain.granja.event.GranjaCreada;
import domain.granja.event.ImpresionIncluida;
import domain.granja.event.ImpresionTerminada;
import domain.granja.event.ImpresoraIncluida;
import domain.granja.value.Impresora3DID;

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

        apply((ImpresionTerminada event) ->{

            Impresora3DID impresora3DID=event.Impresora3DID(); //obtiene el id de la impresora 3D que termino con el trabajo
            int indexImpresora3D= granja.impresoras.indexOf(impresora3DID); //Obtiene el indece de esta impresora en la granja
            Impresora3D impresora3D= granja.impresoras.get(indexImpresora3D); //obtiene la im
            impresora3D.terminarImpresion(); //termina la impresion deacuerdo a lo establecido en la entidad Impresora
            int indexSTL = granja.stls.indexOf(impresora3D.Stl());
            granja.stls.remove(indexSTL); //Elimina el STL de la lista de pendientes
        });
    }
}
