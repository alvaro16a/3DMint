package domain.granja.value;

import co.com.sofka.domain.generic.ValueObject;

public class VolumenDeImoresion implements ValueObject<VolumenDeImoresion.Props> {

    private final Integer alto;
    private final Integer largo;
    private final Integer  ancho;


    public VolumenDeImoresion(Integer alto, Integer largo, Integer ancho) {
        if(alto <= 0 || largo <=0 || ancho <= 0){
            throw new RuntimeException("el volumen de impresion debe ser positivo");
        }else{
            this.alto = alto;
            this.largo = largo;
            this.ancho = ancho;
        }
    }

    @Override
    public Props value() {

        return new Props() {
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
