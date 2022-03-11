package domain.granja;

import co.com.sofka.domain.generic.Entity;
import domain.granja.value.Estado;
import domain.granja.value.Impresora3DID;
import domain.granja.value.VolumenDeImoresion;
import domain.value.Material;
import domain.value.Pieza;
import domain.value.Stl;

import java.util.Objects;

public class Impresora3D extends Entity<Impresora3DID> {

    private Integer horasDeImpresion;
    private Estado estado;
    private VolumenDeImoresion volumenDeImoresion;
    private String modelo;
    private Pieza pieza;
    private Stl stl;



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

    public void terminarImpresion(){
        if(this.estado.value()==Estado.Fase.IMPRIMIENDO) {
            this.estado = new Estado(Estado.Fase.APAGADA);
            this.horasDeImpresion += stl.value().tiempoDeImpresion();
            this.pieza=new Pieza(stl.value().nombre(),new Material());
        }else{
            throw new IllegalArgumentException("No se puede terminar una impresion que no se esta realizando");
        }
    }
    public void iniciarImpresion(Stl stl){
        if(this.estado.value()==Estado.Fase.APAGADA) {
            this.estado = new Estado(Estado.Fase.IMPRIMIENDO);
            this.stl= Objects.requireNonNull(stl);
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

    public Pieza Pieza() {
        return pieza;
    }

    public Stl Stl() {
        return stl;
    }
}
