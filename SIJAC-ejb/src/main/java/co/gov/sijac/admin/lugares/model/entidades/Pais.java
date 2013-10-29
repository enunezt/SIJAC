package co.gov.sijac.admin.lugares.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the paises database table.
 * 
 */
@Entity
@Table(name="paises")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idPais;
	private Integer isoNum;
	private String iso2;
	private String iso3;
	private String nombre;
	private Set<Departamento> departamentos;

	public Pais() {
	}


	@Column(name="iso_num")
	public Integer getIsoNum() {
		return this.isoNum;
	}

	public void setIsoNum(Integer isoNum) {
		this.isoNum = isoNum;
	}


	@Column(length=2)
	public String getIso2() {
		return this.iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}


	@Column(length=3)
	public String getIso3() {
		return this.iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}


	@Column(length=50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to Departamento
	@OneToMany(mappedBy="pais", fetch=FetchType.EAGER)
	public Set<Departamento> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Departamento addDepartamento(Departamento departamento) {
		getDepartamentos().add(departamento);
		departamento.setPais(this);

		return departamento;
	}

	public Departamento removeDepartamento(Departamento departamento) {
		getDepartamentos().remove(departamento);
		departamento.setPais(null);

		return departamento;
	}


	/**
	 * @return the idPais
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pais", nullable=false)
	public Integer getIdPais() {
	    return idPais;
	}


	/**
	 * @param idPais the idPais to set
	 */
	public void setIdPais(Integer idPais) {
	    this.idPais = idPais;
	}

}