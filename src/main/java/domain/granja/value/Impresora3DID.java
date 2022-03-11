package domain.granja.value;

import co.com.sofka.domain.generic.Identity;

public class Impresora3DID extends Identity {
    private Impresora3DID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public Impresora3DID(){} //Este permite que se cree el elemento
    public static Impresora3DID of(String valor) {
        return new Impresora3DID(valor);
    }
}
