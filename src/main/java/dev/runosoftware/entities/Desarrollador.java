
package dev.runosoftware.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "DESARROLLADOR")
@PrimaryKeyJoinColumn(name = "idEmpleado")
public class Desarrollador extends Empleado {

    private static final long serialVersionUID = -3596596706181972467L;

    @Column(name = "HABILIDAD", length = 25)
    private String habilidad;
    @Column(name = "ACTIVO")
    private boolean activo;

    public Desarrollador() {
        super();
    }

    public Desarrollador(int cedula, String nombre, String apellido, String direccion,
            LocalDate fechaNacimiento, String habilidad, boolean activo) {

        super(cedula, nombre, apellido, direccion, fechaNacimiento);
        this.habilidad = habilidad;
        this.activo = activo;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Desarrollador [Cédula=" + getCedula() + "activo=" + activo + ", habilidad=" + habilidad + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (activo ? 1231 : 1237);
        result = prime * result + getCedula();
        result = prime * result + ((habilidad == null) ? 0 : habilidad.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Desarrollador other = (Desarrollador) obj;
        if(this.getCedula() != other.getCedula())
            return false;
        if (activo != other.activo)
            return false;
        if (habilidad == null) {
            if (other.habilidad != null)
                return false;
        } else if (!habilidad.equals(other.habilidad))
            return false;
        return true;
    }
    
}
