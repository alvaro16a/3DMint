package domain.granja;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.granja.event.*;
import domain.granja.value.GranjaID;
import domain.granja.value.Impresora3DID;
import domain.value.Stl;

import java.util.List;
import java.util.Map;

public class Granja extends AggregateEvent<GranjaID> {


    protected Map<String,Impresora3D> impresoras;
    protected List<Stl> stls;


    public Granja(GranjaID entityId) {
        super(entityId);
        appendChange(new GranjaCreada(entityId)).apply();
        subscribe(new GranjaEventChange(this)); //Para realizar un cambio en el estado debo suscribirla
    }

    private Granja(GranjaID granjaID,String nombre) {
        super(granjaID);
        subscribe(new GranjaEventChange(this));

    }

    public static Granja from(GranjaID id, List<DomainEvent> events){ //reconstruccion de la granja teniendo id y eventos
        var granja = new Granja(id,"nada");
        events.forEach(granja::applyEvent);
        return granja;
    }

    public void agregarImpresora3D(Impresora3DID entityId){
        appendChange(new ImpresoraIncluida(entityId)).apply();
    }

    public void agregarImpresion(Stl stl){
        appendChange(new ImpresionIncluida(stl)).apply();
    }

    public void terminarImpresion(Impresora3DID entityId){
        appendChange(new ImpresionTerminada(entityId)).apply();
    }


    public void iniciarImpresion(Impresora3DID entityId){
        appendChange(new ImpresionIniciada(entityId)).apply();

    }

}
