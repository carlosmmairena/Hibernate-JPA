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

import dev.runosoftware.entities.Desarrollador;
import dev.runosoftware.entities.Ocupacion;
import dev.runosoftware.entities.SeguroCCSS;

import java.time.LocalDate;
import java.time.Month;

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
        
        System.out.println("************** Registrando desarrollador...");

        Ocupacion ocupacion1 = new Ocupacion(1L, "Programador nivel 1", 569000);
        
        Desarrollador dev1 = new Desarrollador(3L, 504260647, "Carlos", "Mairena", "Guancaste, Carrillo",
        LocalDate.of(1999, Month.MARCH, 30), "Kubernetes", true);

        Desarrollador dev2 = new Desarrollador(4L, 504260647, "Paula", "Rodríguez", "Guancaste, Carrillo",
        LocalDate.of(1999, Month.MARCH, 30), "Web Developer", true);

        dev1.setOcupacion(ocupacion1);
        dev2.setOcupacion(ocupacion1);

        dev2.setSeguroCaja(new SeguroCCSS(25l, 7852466, LocalDate.now(), 58400));
        dev1.setSeguroCaja(new SeguroCCSS(105L, 585278552, LocalDate.now(), 89300));

        EntityManager manager = MF.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(ocupacion1);
        manager.persist(dev1);
        manager.persist(dev2);
        manager.getTransaction().commit();
        manager.close();

        mostrarDatos();
        System.out.println("**************** Finalización del programa");
    }
    
    
    public static void mostrarDatos() {
        EntityManager manager = MF.createEntityManager();
        
        Desarrollador dev = manager.find(Desarrollador.class, 3L);
        manager.close();
        
        System.out.println("***************** : " + dev);
        
        System.out.println("---------------------");
    }

}
