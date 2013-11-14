package co.gov.sijac.juntas.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.admin.model.entidades.Usuario;

import java.util.Date;


/**
 * The persistent class for the dignatarios database table.
 * 
 */
@Entity
@Table(name="dignatarios")
@NamedQuery(name="Dignatario.findAll", query="SELECT d FROM Dignatario d")
public class Dignatario implements Serializable {
	private static final long serialVersionUID = 1L;
	private DignatarioPK id;
	private String estado;
	private Date fecCambio;
	private Date fecRegistro;
	private CatalogoDetalle tipoDignatario;
	private Usuario usuario;
	private Junta junta;
	private Persona persona;

	public Dignatario() {
	}
	public Dignatario(Integer idJunta, Long idPersona,java.util.Date fecInicio,java.util.Date fecFin) {   
	    id=new DignatarioPK(idJunta,idPersona,fecInicio,fecFin);           
	}
	
	public Dignatario(Junta junta, Persona persona,java.util.Date fecInicio,java.util.Date fecFin) {   
	    id=new DignatarioPK(junta.getIdJunta(),persona.getIdPersona(),fecInicio,fecFin);           
	}


	@EmbeddedId
	public DignatarioPK getId() {
		return this.id;
	}

	public void setId(DignatarioPK id) {
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


	//bi-directional many-to-one association to CatalogoDetalle
	@ManyToOne
	@JoinColumn(name="tipo_dignatario", nullable=false)
	public CatalogoDetalle getTipoDignatario() {
		return this.tipoDignatario; 
	}

	public void setTipoDignatario(CatalogoDetalle tipoDignatario) {
		this.tipoDignatario = tipoDignatario;
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