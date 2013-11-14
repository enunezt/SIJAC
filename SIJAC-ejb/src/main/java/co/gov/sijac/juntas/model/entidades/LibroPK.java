package co.gov.sijac.juntas.model.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the libros database table.
 * 
 */
@Embeddable
public class LibroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idJunta;
	private Long idPersona;

	public LibroPK() {
	}

	public LibroPK(Integer idJunta,Long idPersona) {
	    this.idJunta   =idJunta;
	    this.idPersona =idPersona;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LibroPK)) {
			return false;
		}
		LibroPK castOther = (LibroPK)other;
		return 
			this.idJunta.equals(castOther.idJunta)
			&& this.idPersona.equals(castOther.idPersona);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idJunta.hashCode();
		hash = hash * prime + this.idPersona.hashCode();
		
		return hash;
	}
}