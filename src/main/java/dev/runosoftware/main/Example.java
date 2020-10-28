/*
 * Copyright (C) 2020 DreadsLock
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dev.runosoftware.main;

import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DreadsLock
 */
public class Example {
    
    private static EntityManager manager; // Contiene los métodos del contexto de persistencia
    private static EntityManagerFactory managerFactory;
    
    @SuppressWarnings("unchecked")
    public static void main(String a[]){
        // Se crea el gestor de persistencia a partir de nuestro contexto
        managerFactory = Persistence.createEntityManagerFactory("PersistenciaConfig");
        manager = managerFactory.createEntityManager();
        
        
        // Creamos un empleado y lo registraremos a la BDs
       Empleado empleado1 =  new Empleado(10L, 504260647,
               "Carlos", "Mairena", "Guanacaste, Carrillo, Palmira",
               new GregorianCalendar(1999, 3, 30).getTime());
       
       manager.getTransaction().begin();
       // Persistimos este objeto y podremos realizar cambios y estos se reflejen en la BD
       manager.persist(empleado1);
       manager.getTransaction().commit();
       
       mostrarDatos();
    }
    
    public static void mostrarDatos(){
        // Hacemos una consulta con JPQL
        System.out.println("---------------------");
        List<Empleado> empleados = (List<Empleado>)manager.createQuery("FROM Empleado").getResultList();
        System.out.println("Cantidad de empleados: " + empleados.size());
        
        for(Empleado emp: empleados){
            System.out.println(emp.toString());
        }
        System.out.println("---------------------");
    }

}
