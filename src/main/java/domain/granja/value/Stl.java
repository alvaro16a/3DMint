package domain.granja.value;

import co.com.sofka.domain.generic.ValueObject;
import domain.value.Dificultad;
import domain.value.Material;

public class Stl implements ValueObject<Stl.Props> {

    private final String nombre;
    private final Integer tiempoDeImpresion;
    private final Material material;
    private final Dificultad dificultad;

    public Stl(String nombre, Integer tiempoDeImpresion) {
        this.nombre = nombre;
        this.tiempoDeImpresion = tiempoDeImpresion;
        this.material = new Material();
        this.dificultad = new Dificultad();
    }

    @Override
    public Props value() {

        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public Integer tiempoDeImpresion() {
                return tiempoDeImpresion;
            }

            @Override
            public Material materia() {
                return material;
            }

            @Override
            public Dificultad dificultad() {
                return dificultad;
            }
        };

    }

    public interface Props{
        String nombre();
        Integer tiempoDeImpresion();
        Material materia();
        Dificultad dificultad();
    }
}
