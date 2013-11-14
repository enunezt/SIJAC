package co.gov.sijac.juntas.model.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the comites database table.
 * 
 */
@Embeddable
public class ComitePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idJunta;
	private Long idPersona;
	private java.util.Date fecInicio;
	private java.util.Date fecFin;

	public ComitePK() {
	}
	
	public ComitePK(Integer idJunta,Long idPersona,java.util.Date fecInicio,java.util.Date fecFin) {
	    this.idJunta   =idJunta;
	    this.idPersona =idPersona;
	    this.fecInicio =fecInicio;
	    this.fecFin    =fecFin;
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

	@Temporal(TemporalType.DATE)
	@Column(name="fec_inicio", unique=true, nullable=false)
	public java.util.Date getFecInicio() {
		return this.fecInicio;
	}
	public void setFecInicio(java.util.Date fecInicio) {
		this.fecInicio = fecInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="fec_fin", unique=true, nullable=false)
	public java.util.Date getFecFin() {
		return this.fecFin;
	}
	public void setFecFin(java.util.Date fecFin) {
		this.fecFin = fecFin;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ComitePK)) {
			return false;
		}
		ComitePK castOther = (ComitePK)other;
		return 
			this.idJunta.equals(castOther.idJunta)
			&& this.idPersona.equals(castOther.idPersona)
			&& this.fecInicio.equals(castOther.fecInicio)
			&& this.fecFin.equals(castOther.fecFin);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idJunta.hashCode();
		hash = hash * prime + this.idPersona.hashCode();
		hash = hash * prime + this.fecInicio.hashCode();
		hash = hash * prime + this.fecFin.hashCode();
		
		return hash;
	}
}