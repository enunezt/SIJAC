package co.gov.sijac.admin.lugares.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the departamentos database table.
 * 
 */
@Entity
@Table(name="departamentos")
@NamedQueries({@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d"),
@NamedQuery(name="Departamento.findByPais", query="SELECT d FROM Departamento d where d.pais=:idPais")})
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idDepartamento;
	private String nombre;
	private Set<Ciudad> ciudades;
	private Pais pais;

	public Departamento() {
	}


	@Column(length=50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="departamento", fetch=FetchType.EAGER)
	public Set<Ciudad> getCiudades() {
		return this.ciudades;
	}

	public void setCiudades(Set<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public Ciudad addCiudade(Ciudad ciudade) {
		getCiudades().add(ciudade);
		ciudade.setDepartamento(this);

		return ciudade;
	}

	public Ciudad removeCiudade(Ciudad ciudade) {
		getCiudades().remove(ciudade);
		ciudade.setDepartamento(null);

		return ciudade;
	}


	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="id_pais", referencedColumnName="id_pais")
	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}


	/**
	 * @return the idDepartamento
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_departamento", nullable=false)
	public Integer getIdDepartamento() {
	    return idDepartamento;
	}


	/**
	 * @param idDepartamento the idDepartamento to set
	 */
	public void setIdDepartamento(Integer idDepartamento) {
	    this.idDepartamento = idDepartamento;
	}

}