
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
    
}
