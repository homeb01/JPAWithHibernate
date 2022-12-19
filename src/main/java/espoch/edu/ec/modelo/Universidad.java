package espoch.edu.ec.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UNIVERSIDAD")
public class Universidad {
	
	@Id
	@Column(name = "ID_UNIVERSIDAD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;
	
	@OneToMany(mappedBy = "universidad")
	private List<Estudiante> estudiantes = new ArrayList<>();
	
	public Universidad() {
		
	}

	public Universidad(String nombre, Date fecha_creacion) {
		this.nombre = nombre;
		this.fecha_creacion = fecha_creacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public long getId() {
		return id;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	public void agregarEstudiante(Estudiante estudiante) {
		this.estudiantes.add(estudiante);
		estudiante.setUniversidad(this);
	}
}
