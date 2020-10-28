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

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DreadsLock
 */

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {
    
    private static final long serialVersionUID = 1L; // Requerido para Serializar
    
    @Id
    @Column(name = "COD_EMPLEADO")
    private Long   id;
    
    @Column(name = "CEDULA")
    private int    cedula;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "APELLIDO")
    private String apellido;
    
    @Column(name = "DIRECCION_EXACTA")
    private String direccion;
    
    @Column(name = "FECHA_NACIMIENTO")   
    private LocalDate   fechaNacimiento;
    
    public Empleado(){
        // Bean requerido por Hibernate
    }

    public Empleado(Long id ,int cedula, String nombre, String apellido, String direccion, LocalDate fechaNacimiento) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "EmpleadoM{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
}
