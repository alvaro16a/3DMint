package domain.granja;

import co.com.sofka.domain.generic.EventChange;
import domain.granja.event.GranjaCreada;

import java.util.ArrayList;

public class GranjaEventChange extends EventChange {
    public GranjaEventChange(Granja granja) {

        apply((GranjaCreada event) -> {
            granja.impresoras = new ArrayList<>();
            granja.stls = new ArrayList<>();
        });
    }
}
