package domain.granja;

import co.com.sofka.domain.generic.Entity;
import domain.granja.value.Estado;
import domain.granja.value.Impresora3DID;
import domain.granja.value.VolumenDeImoresion;

public class Impresora3D extends Entity<Impresora3DID> {

    private Integer horasDeImpresion;
    private Estado estado;
    private VolumenDeImoresion volumenDeImoresion;
    private String modelo;


    public Impresora3D(Impresora3DID entityId) {
        super(entityId);
    }
}
