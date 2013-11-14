package co.gov.sijac.admin.lugares.model.entidades;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the ciudades database table.
 * 
 */
@Entity
@Table(name="ciudades")
@NamedQueries({
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c"),
@NamedQuery(name="Ciudad.findByDepartamento", query="SELECT c FROM Ciudad c where c.departamento=:idDepartamento")})
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idCiudad;
	private String nombre;
	private Departamento departamento;

	public Ciudad() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_ciudad", nullable=false)
	public Integer getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}


	@Column(length=80)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_departamento", referencedColumnName="id_departamento")
	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	 @Override
	    public boolean equals(Object o) {
		if ((o instanceof Ciudad) && (((Ciudad) o).getIdCiudad() == this.idCiudad))
		{
		    return true;
		} else {
		    return false;
		}
	    }
	    
	    @Override
	    public int hashCode() {
		int id=this.idCiudad==null?0:this.idCiudad;
		int hash = 11;
		hash = 97 * hash + id;
		return hash;
	}

}