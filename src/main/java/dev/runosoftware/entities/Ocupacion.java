
package dev.runosoftware.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    @Override
    public String toString() {
        return "Ocupacion{" + "id=" + id + ", puesto=" + puesto + ", salario=" + salario + '}';
    }
}
