
package com.mycompany.peluqueria.canina.persistencia;

import com.mycompany.peluqueria.canina.logica.Dueno;
import com.mycompany.peluqueria.canina.logica.Mascota;
import com.mycompany.peluqueria.canina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
     MascotaJpaController mascotaJpaController = new MascotaJpaController();
     DuenoJpaController duenoJpaController = new DuenoJpaController();
     
     
     public void guardarMascota(Dueno dueno, Mascota mascota){
         //guardamos el dueno en la BD
         //primero hay que guardar al dueno pq la mascota lo requiere, entonces debe existir antes
         duenoJpaController.create(dueno);
         
         mascotaJpaController.create(mascota);
     }
     
     public List<Mascota> obtenerMascotas(){
         //obtenemos las mascotas
         return mascotaJpaController.findMascotaEntities();
     }
     
     public void eliminarMascota(int num_cliente){
         try {
             //al ser un 1 a 1, tambien habria que borrar al dueno, porque sino el dueno sigue quedando en la BD
             //si fueran 1 A N, donde un dueno tiene muchas mascotas, podriamos dejarlo.
             Mascota mascota = mascotaJpaController.findMascota(num_cliente);
             mascotaJpaController.destroy(num_cliente);
             duenoJpaController.destroy(mascota.getDueno().getIdDueno());
         } catch (NonexistentEntityException ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
