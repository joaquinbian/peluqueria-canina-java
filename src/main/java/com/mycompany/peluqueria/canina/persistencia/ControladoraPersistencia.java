
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
             mascotaJpaController.destroy(num_cliente);
         } catch (NonexistentEntityException ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
