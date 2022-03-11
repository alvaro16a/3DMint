package domain.granja;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.Cliente.value.ClienteID;
import domain.granja.event.GranjaCreada;
import domain.granja.event.ImpresionIncluida;
import domain.granja.event.ImpresoraIncluida;
import domain.granja.value.GranjaID;
import domain.granja.value.Impresora3DID;
import domain.value.Stl;

import java.util.List;

public class Granja extends AggregateEvent<GranjaID> {



    protected List<Impresora3D> impresoras;
    protected List<Stl> stls;
    protected ClienteID clienteID;

    public Granja(GranjaID entityId) {
        super(entityId);
        appendChange(new GranjaCreada()).apply();
        subscribe(new GranjaEventChange(this)); //Para realizar un cambio en el estado debo suscribirla
    }

    public void agregarImpresora3D(Impresora3DID entityId){
        appendChange(new ImpresoraIncluida(entityId)).apply();
    }

    public void agregarImpresion(Stl stl){
        appendChange(new ImpresionIncluida(stl)).apply();
    }
}
