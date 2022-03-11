package domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class Material implements ValueObject<Material.Tipo> {

    private final Tipo value;

    public Material() {
        this.value=Tipo.PLA;
    }

    public Material(Tipo value) {
        this.value = value;
    }

    @Override
    public Tipo value(){
        return value;
    }

    public enum Tipo{
        PLA, ABS, PETG, NYLON
    }
}
