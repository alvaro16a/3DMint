package domain.granja.value;

import co.com.sofka.domain.generic.ValueObject;

public class Stl implements ValueObject<Stl.Props> {

    private final String nombre;
    private final Integer tiempoDeImpresion;
    private final String  Material;
    private final Integer  ancho;


    public Stl(Integer alto, Integer largo, Integer ancho) {
        if(alto <= 0 || largo <=0 || ancho <= 0){
            throw new RuntimeException("el volumen de impresion debe ser positivo");
        }else{
            this.alto = alto;
            this.largo = largo;
            this.ancho = ancho;
        }
    }

    public Stl() {
        this.alto = 25;
        this.largo = 25;
        this.ancho = 20;  //El volumen de impresion estandar es 25x25x20

    }

    @Override
    public Stl.Props value() {

        return new VolumenDeImoresion.Props() {
            @Override
            public int alto() {
                return alto;
            }

            @Override
            public int largo() {
                return largo;
            }

            @Override
            public int ancho() {
                return ancho;
            }

        };
    }

    public interface Props{

        int alto();
        int largo();
        int ancho();


    }
}
