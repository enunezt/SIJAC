package co.gov.sijac.juntas.model.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pagos_afiliado database table.
 * 
 */
@Embeddable
public class PagosAfiliadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idJunta;
	private Long idPersona;
	private Integer anio;

	public PagosAfiliadoPK() {
	}
	
	public PagosAfiliadoPK(Integer idJunta,Long idPersona,Integer anio) {
	    this.idJunta   =idJunta;
	    this.idPersona =idPersona;
	    this.anio=anio;
	}

	@Column(name="id_junta", unique=true, nullable=false)
	public Integer getIdJunta() {
		return this.idJunta;
	}
	public void setIdJunta(Integer idJunta) {
		this.idJunta = idJunta;
	}

	@Column(name="id_persona", unique=true, nullable=false)
	public Long getIdPersona() {
		return this.idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	@Column(unique=true, nullable=false)
	public Integer getAnio() {
		return this.anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PagosAfiliadoPK)) {
			return false;
		}
		PagosAfiliadoPK castOther = (PagosAfiliadoPK)other;
		return 
			this.idJunta.equals(castOther.idJunta)
			&& this.idPersona.equals(castOther.idPersona)
			&& this.anio.equals(castOther.anio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idJunta.hashCode();
		hash = hash * prime + this.idPersona.hashCode();
		hash = hash * prime + this.anio.hashCode();
		
		return hash;
	}
}