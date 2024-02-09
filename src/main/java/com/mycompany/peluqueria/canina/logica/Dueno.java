
package com.mycompany.peluqueria.canina.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dueno implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idDueno;
    
    @Basic
    private String duenoName;
    private String phone;
    private String address;
    
    
    
    public Dueno(){
        
    }

    public Dueno(int idDueno, String duenoName, String phone, String address) {
        this.idDueno = idDueno;
        this.duenoName = duenoName;
        this.phone = phone;
        this.address = address;
    }

    public int getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(int idDueno) {
        this.idDueno = idDueno;
    }

    public String getDuenoName() {
        return duenoName;
    }

    public void setDuenoName(String duenoName) {
        this.duenoName = duenoName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
