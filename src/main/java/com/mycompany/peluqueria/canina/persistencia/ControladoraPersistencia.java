
package com.mycompany.peluqueria.canina.persistencia;

import com.mycompany.peluqueria.canina.logica.Dueno;
import com.mycompany.peluqueria.canina.logica.Mascota;


public class ControladoraPersistencia {
     MascotaJpaController mascotaJpaController = new MascotaJpaController();
     DuenoJpaController duenoJpaController = new DuenoJpaController();
     
     
     public void guardarMascota(Dueno dueno, Mascota mascota){
         //guardamos el dueno en la BD
         //primero hay que guardar al dueno pq la mascota lo requiere, entonces debe existir antes
         duenoJpaController.create(dueno);
         
         mascotaJpaController.create(mascota);
     }
}
