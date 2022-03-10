package domain.Cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.Cliente.value.ClienteID;

public class Cliente extends AggregateEvent<ClienteID> {

    public Cliente(ClienteID entityId) {
        super(entityId);
    }
}
