package co.gov.sijac.admin.model.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perfil_opcion database table.
 * 
 */
@Entity
@Table(name="perfil_opcion")
public class PerfilOpcion implements Serializable {
	private static final long serialVersionUID = 1L;
	private PerfilOpcionPK idPerfilOpcion;
	private short nivel;
	private Opcion opcion;
	private Perfil perfil;

    public PerfilOpcion() {
    	/*opcion=new Opcion();
    	perfil=new Perfil();*/
    	
    }


	public PerfilOpcion(short nivel, Opcion opcion, Perfil perfil) {
		super();
		this.nivel = nivel;
		this.opcion = opcion;
		this.perfil = perfil;
		idPerfilOpcion=new PerfilOpcionPK(perfil.getIdPerfil().intValue(),opcion.getIdOpcion().intValue());
		
	}
	public PerfilOpcion( Opcion opcion, Perfil perfil) {
		super();
	
		this.opcion = opcion;
		this.perfil = perfil;
		idPerfilOpcion=new PerfilOpcionPK(perfil.getIdPerfil().intValue(),opcion.getIdOpcion().intValue());
	}



	@EmbeddedId
	public PerfilOpcionPK getIdPerfilOpcion() {
		return this.idPerfilOpcion;
	}

	public void setIdPerfilOpcion(PerfilOpcionPK id) {
		this.idPerfilOpcion = id;
	}
	

	public short getNivel() {
		return this.nivel;
	}

	public void setNivel(short nivel) {
		this.nivel = nivel;
	}


	//uni-directional many-to-one association to Opcion
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_opcion", nullable=false, insertable=false, updatable=false)
	public Opcion getOpcion() {
		return this.opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}
	

	//bi-directional many-to-one association to Perfil
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_perfil", nullable=false, insertable=false, updatable=false)
	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
}