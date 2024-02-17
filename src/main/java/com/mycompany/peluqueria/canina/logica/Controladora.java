
package com.mycompany.peluqueria.canina.logica;

import com.mycompany.peluqueria.canina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
    
    public void guardarMascota(String duenoName, String phone, String address, String nombre_mascota, String color, String raza, String observations, boolean isAlergico, boolean hasSpecialAtention){
        
        //creamos el dueno
        Dueno dueno = new Dueno();
        dueno.setDuenoName(duenoName);
        dueno.setAddress(address);
        dueno.setPhone(phone);
        
        //creamos mascota 
        Mascota mascota = new Mascota();
        mascota.setColor(color);
        mascota.setDueno(dueno);
        mascota.setHasSpecialAtention(hasSpecialAtention);
        mascota.setIsAlergico(isAlergico);
        mascota.setNombre_mascota(nombre_mascota);
        mascota.setObservations(observations);
        mascota.setRaza(raza);
        
        controladoraPersistencia.guardarMascota(dueno, mascota);
    }
    
    
    public List<Mascota> obtenerMascotas(){
        return controladoraPersistencia.obtenerMascotas();
    }
    
    public Mascota obtenerMascota(int num_cliente){
        return controladoraPersistencia.obtenerMascota(num_cliente);
    }
    
    public void eliminarMascota(int num_cliente){
        controladoraPersistencia.eliminarMascota(num_cliente);
    }
    
    public void editarMascota( 
            Mascota mascota,
            String petName, 
            String petColor,
            String petRaza,
            String observations,
            boolean petIsAlergico,
            boolean petHasSpecialAtention,
            String duenoName,
            String duenoPhone,
            String duenoAddress
    ){
        mascota.setNombre_mascota(petName);
        mascota.setColor(petColor);
        mascota.setRaza(petRaza);
        mascota.setObservations(observations);
        mascota.setIsAlergico(petIsAlergico);
        mascota.setHasSpecialAtention(petHasSpecialAtention);
        
        
        
        //llamamos a la funcion de JPA?
        controladoraPersistencia.editarMascota(mascota);
        
       
      //este es el dueno de la DB
      Dueno dueno =  buscarDueno(mascota.getDueno().getIdDueno());
      editarDueno(dueno, duenoName, duenoPhone, duenoAddress);


        
    }
    
    
    public Dueno buscarDueno(int dueno_id){
        return controladoraPersistencia.obtenerDueno(dueno_id);
    }
    
    public void editarDueno(Dueno dueno, String duenoName, String duenoPhone, String duenoAddress){
        dueno.setDuenoName(duenoName);
        dueno.setPhone(duenoPhone);
        dueno.setAddress(duenoAddress);
        
        //llamamos a la funcion de JPA?
        controladoraPersistencia.editarDueno(dueno);
    }
    
}
