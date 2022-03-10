package domain.granja.value;

import co.com.sofka.domain.generic.ValueObject;

public class Estado implements ValueObject<Estado.Fase> {

    private final Fase value;

    public Estado(Fase value){
        this.value =value;
    }
    public Estado(){
        this.value =Fase.APAGADA;
    }

    @Override
    public Fase value(){
        return value;
    }

    public enum Fase{
        IMPRIMIENDO, APAGADA, MANTENIMIENTO, AVERIADO
    }
}
