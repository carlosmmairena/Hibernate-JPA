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

    private static final EntityManagerFactory MF = Persistence.createEntityManagerFactory("PersistenciaConfig");

    @SuppressWarnings("unchecked")
    public static void main(String a[]) {
        
        Ocupacion ocupacion1 = new Ocupacion(1L, "Contador Público", 693410);
        Ocupacion ocupacion2 = new Ocupacion(2L, "Cocinera", 589000);
        Ocupacion ocupacion3 = new Ocupacion(3L, "Operario de Maquinaria", 625000);
        Ocupacion ocupacion4 = new Ocupacion(4L, "Electricista", 693012);
        Ocupacion ocupacion5 = new Ocupacion(5L, "Peón Agrícola", 485900);
        
        System.out.println("Ocupaciones creadas.");
        
        EntityManager manager = MF.createEntityManager();
        manager.getTransaction().begin();
        
        manager.persist(ocupacion1);
        manager.persist(ocupacion2);
        manager.persist(ocupacion3);
        manager.persist(ocupacion4);
        manager.persist(ocupacion5);
        System.out.println("Puestos de trabajo creados.");
        
        manager.getTransaction().commit();
        manager.close();
        
        
        EntityManager manager2 = MF.createEntityManager();
        manager2.getTransaction().begin();
        
        System.out.println("Se crean los empleados.");
        Empleado empleado1 = new Empleado(
                1L, 504260647, "Carlos", "Mairena",
                "Costa Rica, Guanacaste, Liberia",
                LocalDate.of(1999, Month.MARCH, 30));
        
        Empleado empleado2 = new Empleado(
                2L, 48522, "Rodrigo", "Vidal",
                "Costa Rica, Guanacaste, Liberia",
                LocalDate.of(1998, Month.JANUARY, 11));
        
        System.out.println("Se le asigna el puesto de trabajo al empleado1");
        empleado1.setOcupacion(ocupacion3);

        System.out.println("Se le asigna el puesto de trabajo al empleado2");
        empleado2.setOcupacion(ocupacion3);
        
        System.out.println("Se le asigna el seguro de trabajador al empleado1");
        empleado1.setSeguroCaja(
                new SeguroCCSS(1L, 1252478, LocalDate.now(), 42000));
       
        System.out.println("Se le asigna el seguro de trabajador al empleado2");
        empleado2.setSeguroCaja(
                new SeguroCCSS(4L, 478525, LocalDate.now(), 42400));
        
        System.out.println("Se persisten los empleados con sus datos completos.");
        manager2.persist(empleado1);
        manager2.persist(empleado2);
        
        manager2.getTransaction().commit();
        manager2.close();
        
        mostrarDatos();
        
        System.out.println("Finalización del programa");
    }
    
    
    public static void mostrarDatos() {
        EntityManager manager = MF.createEntityManager();
        manager.getTransaction().begin();
        
        Ocupacion ocupacion = manager.find(Ocupacion.class, 3L);
        List<Empleado> empleados = ocupacion.getEmpleados();
        manager.close();
        
        System.out.println("---------------------");
        
        for(Empleado emplea: empleados){
            System.out.println(emplea);
        }
        
        System.out.println("---------------------");
    }

}
