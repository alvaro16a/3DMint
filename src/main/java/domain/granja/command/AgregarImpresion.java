package domain.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.value.Stl;

public class AgregarImpresion extends Command {

    private final Stl stl;

    public AgregarImpresion(Stl stl) {
        this.stl = stl;
    }

    public Stl getStl() {
        return stl;
    }
}
