package domain.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.cliente.value.ClienteID;

public class Cliente extends AggregateEvent<ClienteID> {

    public Cliente(ClienteID entityId) {
        super(entityId);
    }
}
