package domain.granja;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.Cliente.value.ClienteID;
import domain.granja.event.GranjaCreada;
import domain.granja.value.GranjaID;
import domain.value.Stl;

import java.util.List;

public class Granja extends AggregateEvent<GranjaID> {



    protected List<Impresora3D> impresoras;
    protected List<Stl> stls;
    protected ClienteID clienteID;

    public Granja(GranjaID entityId) {
        super(entityId);
        appendChange(new GranjaCreada()).apply();
        //Solo podra cambiar a cliente si esta suscrito
        subscribe(new GranjaEventChange(this));
    }

}
