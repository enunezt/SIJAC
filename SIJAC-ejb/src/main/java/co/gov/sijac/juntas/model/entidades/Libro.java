package co.gov.sijac.juntas.model.entidades;

import java.io.Serializable;

import javax.persistence.*;


import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.admin.model.entidades.Usuario;

import java.util.Date;


/**
 * The persistent class for the libros database table.
 * 
 */
@Entity
@Table(name="libros")
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;
	private LibroPK id;
	private String estado;
	private Date fecCambio;
	private Date fecRegistro;
	private String observaciones;
	private CatalogoDetalle comisionTrabajo;
	private Usuario usuario;
	private Junta junta;
	private Persona persona;
	

	public Libro() {
	}
	public Libro(Integer idJunta, Long idPersona,java.util.Date fecInicio,java.util.Date fecFin) {   
	    id=new LibroPK(idJunta,idPersona);           
	}
	
	public Libro(Junta junta, Persona persona,java.util.Date fecInicio,java.util.Date fecFin) {   
	    id=new LibroPK(junta.getIdJunta(),persona.getIdPersona());           
	}


	@EmbeddedId
	public LibroPK getId() {
		return this.id;
	}

	public void setId(LibroPK id) {
		this.id = id;
	}


	@Column(nullable=false, length=1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fec_cambio", nullable=false)
	public Date getFecCambio() {
		return this.fecCambio;
	}

	public void setFecCambio(Date fecCambio) {
		this.fecCambio = fecCambio;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fec_registro", nullable=false)
	public Date getFecRegistro() {
		return this.fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}


	@Column(length=50)
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="comision_trabajo")
	public CatalogoDetalle getComisionTrabajo() {
		return this.comisionTrabajo;
	}

	public void setComisionTrabajo(CatalogoDetalle catalogo) {
		this.comisionTrabajo = catalogo;
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
	
	/**
	     * @return the junta
	     */
	  //bi-directional many-to-one association to Perfil
	  @ManyToOne(fetch=FetchType.EAGER)
	  @JoinColumn(name="id_junta", nullable=false, insertable=false, updatable=false)
	    public Junta getJunta() {
	        return junta;
	    }


	    /**
	     * @param junta the junta to set
	     */
	    public void setJunta(Junta junta) {
	        this.junta = junta;
	    }


	    /**
	     * @return the persona
	     */
	    @ManyToOne(fetch=FetchType.EAGER)
	    @JoinColumn(name="id_persona", nullable=false, insertable=false, updatable=false)		
	    public Persona getPersona() {
	        return persona;
	    }


	    /**
	     * @param persona the persona to set
	     */
	    public void setPersona(Persona persona) {
	        this.persona = persona;
	    }

}