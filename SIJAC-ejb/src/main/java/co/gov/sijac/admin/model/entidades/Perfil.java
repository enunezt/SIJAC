package co.gov.sijac.admin.model.entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.*;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name="perfil")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idPerfil;
	private String descripcion;
	private Date fecCambio;
	private String nombre;
	private Set<PerfilOpcion> perfilOpciones;

    public Perfil() {
    //	perfilOpciones=new ArrayList<PerfilOpcion>();	
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil",unique=true, nullable=false)
	public Long getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Long id) {
		this.idPerfil = id;
	}


	@Column(length=100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fec_cambio")
	public Date getFecCambio() {
		return this.fecCambio;
	}

	public void setFecCambio(Date fecCambio) {
		this.fecCambio = fecCambio;
	}


	@Column(nullable=false, length=20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to PerfilOpcion
	@OneToMany(mappedBy="perfil",cascade =CascadeType.ALL,fetch=FetchType.EAGER)	
	public Set<PerfilOpcion> getPerfilOpciones() {
		return this.perfilOpciones;
	}

	public void setPerfilOpciones(Set<PerfilOpcion> perfilOpciones) {
		this.perfilOpciones = perfilOpciones;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPerfil == null) ? 0 : idPerfil.hashCode());
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
		Perfil other = (Perfil) obj;
		if (idPerfil == null) {
			if (other.idPerfil != null)
				return false;
		} else if (!idPerfil.equals(other.idPerfil))
			return false;
		return true;
	}
	
}