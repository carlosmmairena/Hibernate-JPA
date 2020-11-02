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
package dev.runosoftware.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author DreadsLock
 */
@Entity
@Table(name = "SeguroCCSS")
public class SeguroCCSS implements Serializable {
    
    private static final long serialVersionUID = 3L; // Requerido para Serializar
    
    @Id
    @Column(name = "COD_SEGURO")
    private Long   id;
    
    @Column(name = "NUM_SEGURO")
    private int    numSeguro;
    
    @Column(name = "FECHA_INGRESO")
    private LocalDate fechaIngreso;

    @Column(name = "MONTO_SEGURO")
    private float    montoSeguro;
    
    /* 
        Ahora necesitamos hacer de forma bidireccional la relacion de 1 a 1,
        esto para que si obtenemos los datos del seguro, podamos tener los datos del
        empleado que tiene el actual seguro que estamos visualizando.
    */
    @OneToOne(mappedBy = "seguroCaja", fetch = FetchType.LAZY, orphanRemoval = true)
    private Empleado empleado;

    public SeguroCCSS() {
    }

    public SeguroCCSS(Long id, int numSeguro, LocalDate fechaIngreso, float montoSeguro) {
        this.id = id;
        this.numSeguro = numSeguro;
        this.fechaIngreso = fechaIngreso;
        this.montoSeguro = montoSeguro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumSeguro() {
        return numSeguro;
    }

    public void setNumSeguro(int numSeguro) {
        this.numSeguro = numSeguro;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public float getMontoSeguro() {
        return montoSeguro;
    }

    public void setMontoSeguro(float montoSeguro) {
        this.montoSeguro = montoSeguro;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
        this.empleado.setSeguroCaja(this);
    }

    @Override
    public String toString() {
        return "SeguroCCSS{" + "id=" + id +
                ", numSeguro=" + numSeguro + 
                ", fechaIngreso=" + fechaIngreso + 
                ", montoSeguro=" + montoSeguro + 
                ", Empleado=" + empleado.getCedula() + '}';
    }
    
}
