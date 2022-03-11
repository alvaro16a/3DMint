package domain.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.granja.value.GranjaID;

public class CrearGranja extends Command {

    private final GranjaID granjaID;


    public CrearGranja(GranjaID granjaID) {
        this.granjaID = granjaID;

    }

    public GranjaID getGranjaID() {
        return granjaID;
    }
}
