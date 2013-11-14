package co.gov.sijac.juntas.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import co.gov.sijac.admin.model.entidades.Usuario;

import java.util.Date;


/**
 * The persistent class for the pagos_afiliado database table.
 * 
 */
@Entity
@Table(name="pagos_afiliado")
@NamedQuery(name="PagosAfiliado.findAll", query="SELECT p FROM PagosAfiliado p")
public class PagosAfiliado implements Serializable {
	private static final long serialVersionUID = 1L;
	private PagosAfiliadoPK id;
	private Date fecCambio;
	private Boolean pagMes1;
	private Boolean pagMes10;
	private Boolean pagMes11;
	private Boolean pagMes12;
	private Boolean pagMes2;
	private Boolean pagMes3;
	private Boolean pagMes4;
	private Boolean pagMes5;
	private Boolean pagMes6;
	private Boolean pagMes7;
	private Boolean pagMes8;
	private Boolean pagMes9;
	private Usuario usuario;
	
	private Junta junta;
	private Persona persona;

	public PagosAfiliado() {
	}
	public PagosAfiliado(Integer idJunta, Long idPersona,Integer anio) {   
	    id=new PagosAfiliadoPK(idJunta,idPersona,anio);           
	}
	
	public PagosAfiliado(Junta junta, Persona persona,Integer anio) {   
	    id=new PagosAfiliadoPK(junta.getIdJunta(),persona.getIdPersona(),anio);           
	}


	@EmbeddedId
	public PagosAfiliadoPK getId() {
		return this.id;
	}

	public void setId(PagosAfiliadoPK id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fec_cambio", nullable=false)
	public Date getFecCambio() {
		return this.fecCambio;
	}

	public void setFecCambio(Date fecCambio) {
		this.fecCambio = fecCambio;
	}


	@Column(name="pag_mes_1", nullable=false)
	public Boolean getPagMes1() {
		return this.pagMes1;
	}

	public void setPagMes1(Boolean pagMes1) {
		this.pagMes1 = pagMes1;
	}


	@Column(name="pag_mes_10", nullable=false)
	public Boolean getPagMes10() {
		return this.pagMes10;
	}

	public void setPagMes10(Boolean pagMes10) {
		this.pagMes10 = pagMes10;
	}


	@Column(name="pag_mes_11", nullable=false)
	public Boolean getPagMes11() {
		return this.pagMes11;
	}

	public void setPagMes11(Boolean pagMes11) {
		this.pagMes11 = pagMes11;
	}


	@Column(name="pag_mes_12", nullable=false)
	public Boolean getPagMes12() {
		return this.pagMes12;
	}

	public void setPagMes12(Boolean pagMes12) {
		this.pagMes12 = pagMes12;
	}


	@Column(name="pag_mes_2", nullable=false)
	public Boolean getPagMes2() {
		return this.pagMes2;
	}

	public void setPagMes2(Boolean pagMes2) {
		this.pagMes2 = pagMes2;
	}


	@Column(name="pag_mes_3", nullable=false)
	public Boolean getPagMes3() {
		return this.pagMes3;
	}

	public void setPagMes3(Boolean pagMes3) {
		this.pagMes3 = pagMes3;
	}


	@Column(name="pag_mes_4", nullable=false)
	public Boolean getPagMes4() {
		return this.pagMes4;
	}

	public void setPagMes4(Boolean pagMes4) {
		this.pagMes4 = pagMes4;
	}


	@Column(name="pag_mes_5", nullable=false)
	public Boolean getPagMes5() {
		return this.pagMes5;
	}

	public void setPagMes5(Boolean pagMes5) {
		this.pagMes5 = pagMes5;
	}


	@Column(name="pag_mes_6", nullable=false)
	public Boolean getPagMes6() {
		return this.pagMes6;
	}

	public void setPagMes6(Boolean pagMes6) {
		this.pagMes6 = pagMes6;
	}


	@Column(name="pag_mes_7", nullable=false)
	public Boolean getPagMes7() {
		return this.pagMes7;
	}

	public void setPagMes7(Boolean pagMes7) {
		this.pagMes7 = pagMes7;
	}


	@Column(name="pag_mes_8", nullable=false)
	public Boolean getPagMes8() {
		return this.pagMes8;
	}

	public void setPagMes8(Boolean pagMes8) {
		this.pagMes8 = pagMes8;
	}


	@Column(name="pag_mes_9", nullable=false)
	public Boolean getPagMes9() {
		return this.pagMes9;
	}

	public void setPagMes9(Boolean pagMes9) {
		this.pagMes9 = pagMes9;
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