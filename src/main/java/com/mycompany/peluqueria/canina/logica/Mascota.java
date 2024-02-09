
package com.mycompany.peluqueria.canina.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Mascota implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_cliente;
    
    @Basic
    private String nombre_mascota;
    private String color;
    private String raza;
    private String observations;
    private boolean isAlergico;
    private boolean hasSpecialAtention;

    
    @OneToOne
    private Dueno dueno;
    
    
    public Mascota(){
        
    }
    
    
    public Mascota(int num_cliente, String nombre_mascota, String color, String raza, String observations, boolean isAlergico, boolean hasSpecialAtention, Dueno dueno) {
        this.num_cliente = num_cliente;
        this.nombre_mascota = nombre_mascota;
        this.color = color;
        this.raza = raza;
        this.observations = observations;
        this.isAlergico = isAlergico;
        this.hasSpecialAtention = hasSpecialAtention;
        
        this.dueno = dueno;
    }

    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public boolean isIsAlergico() {
        return isAlergico;
    }

    public void setIsAlergico(boolean isAlergico) {
        this.isAlergico = isAlergico;
    }

    public boolean isHasSpecialAtention() {
        return hasSpecialAtention;
    }

    public void setHasSpecialAtention(boolean hasSpecialAtention) {
        this.hasSpecialAtention = hasSpecialAtention;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
    
    
    
    
    
    
}
