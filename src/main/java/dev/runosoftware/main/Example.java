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

import dev.runosoftware.entities.Empleado;
import dev.runosoftware.entities.Ocupacion;
import dev.runosoftware.entities.SeguroCCSS;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DreadsLock
 */
public class Example {

    private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("PersistenciaConfig");

    @SuppressWarnings("unchecked")
    public static void main(String a[]) {
        // Creamos un empleado y lo registraremos a la BDs
        Empleado empleado1 = new Empleado(10L, 504260647,
                "Carlos", "Mairena", "Guanacaste, Carrillo, Palmira",
               LocalDate.of(1999, Month.MARCH, 30));
        
        Empleado empleado2 = new Empleado(20L, 504260647,
                "Nelson", "Mairena", "Palmira",
               LocalDate.of(2003, Month.MAY, 30));
        
        registrarEmpleado(empleado1);
        registrarEmpleado(empleado2);
        mostrarDatos();
        
        EntityManager manager1 = managerFactory.createEntityManager();
        EntityManager manager2 = managerFactory.createEntityManager();
        
        manager1.getTransaction().begin();
        manager2.getTransaction().begin();
        
        empleado1 = manager1.merge(empleado1);
        empleado2 = manager2.merge(empleado2);
        
        empleado1.setSeguroCaja(new SeguroCCSS(30L, 9685, LocalDate.now(), 47900));
        empleado2.setSeguroCaja(new SeguroCCSS(35L, 9685, LocalDate.now(), 47900));
        
        manager1.getTransaction().commit();
        manager2.getTransaction().commit();

        manager1.close();
        manager2.close();
        
        mostrarDatos();

    }

    public static void registrarEmpleado(Empleado em) {
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        // Persistimos este objeto y podremos realizar cambios y estos se reflejen en la BD
        manager.persist(em);
        manager.getTransaction().commit();
        System.out.println("Empleado registrado...");
        manager.close();
    }

    public static void mostrarDatos() {
        EntityManager manager = managerFactory.createEntityManager();
        // Hacemos una consulta con JPQL
        System.out.println("---------------------");
        List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        System.out.println("Cantidad de empleados: " + empleados.size());

        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
        }
        System.out.println("---------------------");
        manager.close();
    }

}
