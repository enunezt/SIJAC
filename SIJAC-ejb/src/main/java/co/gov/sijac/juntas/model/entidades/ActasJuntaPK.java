package co.gov.sijac.juntas.model.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the actas_juntas database table.
 * 
 */
@Embeddable
public class ActasJuntaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idJunta;
	private java.util.Date fecCargue;
	private Integer tipoActa;

	public ActasJuntaPK() {
	}

	@Column(name="id_junta", insertable=false, updatable=false, unique=true, nullable=false)
	public Integer getIdJunta() {
		return this.idJunta;
	}
	public void setIdJunta(Integer idJunta) {
		this.idJunta = idJunta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="fec_cargue", unique=true, nullable=false)
	public java.util.Date getFecCargue() {
		return this.fecCargue;
	}
	public void setFecCargue(java.util.Date fecCargue) {
		this.fecCargue = fecCargue;
	}

	@Column(name="tipo_acta", insertable=false, updatable=false, unique=true, nullable=false)
	public Integer getTipoActa() {
		return this.tipoActa;
	}
	public void setTipoActa(Integer tipoActa) {
		this.tipoActa = tipoActa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActasJuntaPK)) {
			return false;
		}
		ActasJuntaPK castOther = (ActasJuntaPK)other;
		return 
			this.idJunta.equals(castOther.idJunta)
			&& this.fecCargue.equals(castOther.fecCargue)
			&& this.tipoActa.equals(castOther.tipoActa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idJunta.hashCode();
		hash = hash * prime + this.fecCargue.hashCode();
		hash = hash * prime + this.tipoActa.hashCode();
		
		return hash;
	}
}