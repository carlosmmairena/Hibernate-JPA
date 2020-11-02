package dev.runosoftware.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author DreadsLock
 */
@Entity
@Table(name = "Ocupacion")
public class Ocupacion implements Serializable {

    private static final long serialVersionUID = 2L; // Requerido para Serializar

    @Id
    @Column(name = "COD_OCUPACION")
    private Long   id;

    @Column(name = "PUESTO")
    private String puesto;

    @Column(name = "SALARIO")
    private float salario;

    // Relacion de Uno a Muchos
    @OneToMany(mappedBy = "ocupacion", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Empleado> empleados = new ArrayList<Empleado>();

    public Ocupacion() {
    }

    public Ocupacion(Long id, String puesto, float salario) {
        this.id = id;
        this.puesto = puesto;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Ocupacion{" + "id=" + id + ", puesto=" + puesto + ", salario=" + salario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.puesto);
        hash = 79 * hash + Float.floatToIntBits(this.salario);
        hash = 79 * hash + Objects.hashCode(this.empleados);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ocupacion other = (Ocupacion) obj;
        if (Float.floatToIntBits(this.salario) != Float.floatToIntBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.puesto, other.puesto)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.empleados, other.empleados)) {
            return false;
        }
        return true;
    }

}
