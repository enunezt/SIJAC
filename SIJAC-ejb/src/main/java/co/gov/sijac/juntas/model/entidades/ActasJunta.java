package co.gov.sijac.juntas.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.admin.model.entidades.Usuario;


/**
 * The persistent class for the actas_juntas database table.
 * 
 */
@Entity
@Table(name="actas_juntas")
@NamedQuery(name="ActasJunta.findAll", query="SELECT a FROM ActasJunta a")
public class ActasJunta implements Serializable {
	private static final long serialVersionUID = 1L;
	private ActasJuntaPK id;
	private String archivo;
	private String estado;
	private String nombreArchivo;
	private CatalogoDetalle tipoActa;
	private Junta junta;
	private Usuario usuario;

	public ActasJunta() {
	}


	@EmbeddedId
	public ActasJuntaPK getId() {
		return this.id;
	}

	public void setId(ActasJuntaPK id) {
		this.id = id;
	}


	@Column(nullable=false, length=30)
	public String getArchivo() {
		return this.archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}


	@Column(nullable=false, length=1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Column(name="nombre_archivo", nullable=false, length=30)
	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}


	//bi-directional many-to-one association to CatalogoDetalle
	@ManyToOne
	@JoinColumn(name="tipo_acta", nullable=false, insertable=false, updatable=false)
	public CatalogoDetalle getTipoActa() {
		return this. tipoActa;
	}

	public void setTipoActa(CatalogoDetalle  tipoActa) {
		this. tipoActa =  tipoActa;
	}


	//bi-directional many-to-one association to Junta
	@ManyToOne
	@JoinColumn(name="id_junta", nullable=false, insertable=false, updatable=false)
	public Junta getJunta() {
		return this.junta;
	}

	public void setJunta(Junta junta) {
		this.junta = junta;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable=false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}