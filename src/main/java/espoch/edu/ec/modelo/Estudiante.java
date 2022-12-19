package espoch.edu.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ESTUDIANTE")
public class Estudiante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_ESTUDIANTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NOMBRE_APELLIDO")
	private String nombre;
	
	@Column(name = "EDAD")
	private int edad;
	
	@Column(name = "PROMEDIO")
	private float promedio;
	
	@ManyToOne
	@JoinColumn(name = "ID_UNIVERSIDAD")
	private Universidad universidad;
	
	public Estudiante() {
		
	}

	public Estudiante(String nombre, int edad, float promedio) {
		this.nombre = nombre;
		this.edad = edad;
		this.promedio = promedio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
}
