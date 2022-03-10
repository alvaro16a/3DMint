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


    public Impresora3D(Impresora3DID entityId,Estado estado, VolumenDeImoresion volumenDeImoresion,String modelo) {
        super(entityId);
        this.horasDeImpresion = 0;
        this.estado = estado;
        this.volumenDeImoresion=volumenDeImoresion;
        this.modelo=modelo;
    }

    public Impresora3D(Impresora3DID entityId) {
        super(entityId);
        this.horasDeImpresion = 0;
        this.estado = new Estado();
        this.volumenDeImoresion= new VolumenDeImoresion();
        this.modelo="Ender 3 V2"; //impresora 3d con excelente relacion precio beneficio
    }

    public Integer HorasDeImpresion() {
        return horasDeImpresion;
    }

    public Estado Estado() {
        return estado;
    }

    public VolumenDeImoresion VolumenDeImoresion() {
        return volumenDeImoresion;
    }

    public String Modelo() {
        return modelo;
    }
}
