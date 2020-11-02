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
        
        EntityManager manager = MF.createEntityManager();
        manager.getTransaction().begin();
        
        Ocupacion ocupacion = manager.find(Ocupacion.class, 1L);
        ocupacion.addEmpleado(new Empleado(10L, 89558, "Paula",
                "Martínez", "Costa Rica, Guancaste, Santa Cruz",
                LocalDate.of(15, Month.NOVEMBER, 10)));
        
        manager.getTransaction().commit();
        manager.close();
        
        mostrarDatos();
        
        System.out.println("Finalización del programa");
    }
    
    
    public static void mostrarDatos() {
        EntityManager manager = MF.createEntityManager();
        manager.getTransaction().begin();
        
        Ocupacion ocupacion = manager.find(Ocupacion.class, 1L);
        List<Empleado> empleados = ocupacion.getEmpleados();
        manager.close();
        
        System.out.println("---------------------");
        
        for(Empleado emplea: empleados){
            System.out.println(emplea);
        }
        
        System.out.println("---------------------");
    }

}
