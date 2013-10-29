package co.gov.sijac.admin.model.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the perfil_opcion database table.
 * 
 */
@Embeddable
public class PerfilOpcionPK implements Serializable {
	

	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idPerfil;
	private int idOpcion;

    public PerfilOpcionPK() {
    }
    public PerfilOpcionPK(int idPerfil, int idOpcion) {
		super();
		this.idPerfil = idPerfil;
		this.idOpcion = idOpcion;
	}

	@Column(name="id_perfil",  nullable=false)
	public int getIdPerfil() {
		return this.idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	@Column(name="id_opcion",  nullable=false)
	public int getIdOpcion() {
		return this.idOpcion;
	}
	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PerfilOpcionPK)) {
			return false;
		}
		PerfilOpcionPK castOther = (PerfilOpcionPK)other;
		return 
			(this.idPerfil == castOther.idPerfil)
			&& (this.idOpcion == castOther.idOpcion);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPerfil;
		hash = hash * prime + this.idOpcion;
		
		return hash;
    }
}