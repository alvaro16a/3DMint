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

    public void terminarImpresion(int horasImprimidas){
        if(this.estado.value()==Estado.Fase.IMPRIMIENDO) {
            this.estado = new Estado(Estado.Fase.APAGADA);
            if(horasImprimidas > 0){
                this.horasDeImpresion += horasImprimidas;
            }else{
            throw new IllegalArgumentException("El tiempo de impresion de impresion debe ser mayor a cero");
            }

        }else{
            throw new IllegalArgumentException("No se puede terminar una impresion que no se esta realizando");
        }
    }
    public void iniciarImpresion(){
        if(this.estado.value()==Estado.Fase.APAGADA) {
            this.estado = new Estado(Estado.Fase.IMPRIMIENDO);
        }else{
            throw new IllegalArgumentException("No se puede iniciar una impresion si la maquina no esta disponible");
        }
    }
    public void ImpresoraEnMantenimiento(){
        if(this.estado.value()==Estado.Fase.APAGADA) {
            this.estado = new Estado(Estado.Fase.MANTENIMIENTO);
            this.horasDeImpresion=0;
        }else{
            throw new IllegalArgumentException("Solo se puede enviar la impresora a mantenimiento cuando halla terminado el trabajo");
        }
    }
    public void ImpresoraAveriada(){
        if(this.estado.value()!=Estado.Fase.AVERIADO) {
            this.estado = new Estado(Estado.Fase.AVERIADO);
            this.horasDeImpresion=0;
        }else{
            throw new IllegalArgumentException("La impresora ya esta reportada como averiada");
        }
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
