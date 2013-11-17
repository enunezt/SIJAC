package co.gov.sijac.juntas.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import co.gov.sijac.admin.lugares.model.entidades.Ciudad;
import co.gov.sijac.admin.lugares.model.entidades.Departamento;
import co.gov.sijac.admin.lugares.model.entidades.Pais;
import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.admin.model.entidades.Usuario;

import java.sql.Array;
import java.util.Date;


/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name="personas")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idPersona;
	private String apellido1;
	private String apellido2;
	private String barrio;
	private String estado;
	private String direccion;
	private String email;
	private Date fecCambio;
	private Date fecNacimiento;
	private Date fecRegistro;
	private String nombres;
	private Long numDocumento;
	private String telefonos;
	private CatalogoDetalle  profesion;
	private CatalogoDetalle tipoDocumento;
	private Ciudad dirCiudad;
	private Ciudad nacCiudad;
	private Ciudad expedCiudad;
	private Usuario usuario;
	private Usuario usuarioCambio;

	public Persona() {
	}
	
	public Persona(boolean init) {
	    dirCiudad=new Ciudad();
	    Departamento dpto=new Departamento();
	    Pais pais=new Pais(52, 170, "CO", "COL", "COLOMBIA");	    
	    dpto.setPais(pais);
	    dirCiudad.setDepartamento(dpto); 
	    
	    nacCiudad=new Ciudad();
	    Departamento dpto1=new Departamento();
	    Pais pais1=new Pais(52, 170, "CO", "COL", "COLOMBIA");	    
	    dpto1.setPais(pais1);
	    nacCiudad.setDepartamento(dpto1); 
	    
	    expedCiudad=new Ciudad();
	    Departamento dpto2=new Departamento();
	    Pais pais2=new Pais(52, 170, "CO", "COL", "COLOMBIA");	    
	    dpto2.setPais(pais2);
	    expedCiudad.setDepartamento(dpto2); 
	    
	    setEstado("A");
	    
	    usuario=new Usuario();
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona", unique=true, nullable=false)
	public Long getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}


	@Column(nullable=false, length=30)
	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	@Column(length=30)
	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	@Column(nullable=false, length=50)
	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}


	@Column(nullable=false, length=1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Column(nullable=false, length=100)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Column(length=60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	@Column(name="fec_nacimiento", nullable=false)
	public Date getFecNacimiento() {
		return this.fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fec_registro", nullable=false)
	public Date getFecRegistro() {
		return this.fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}


	@Column(nullable=false, length=100)
	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	@Column(name="num_documento", nullable=false)
	public Long getNumDocumento() {
		return this.numDocumento;
	}

	public void setNumDocumento(Long numDocumento) {
		this.numDocumento = numDocumento;
	}


	@Column(length=40)
	public String getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}


	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="profesion")
	public CatalogoDetalle getProfesion() {
		return this.profesion;
	}

	public void setProfesion(CatalogoDetalle catalogo) {
		this.profesion = catalogo;
	}


	//bi-directional many-to-one association to CatalogoDetalle
	@ManyToOne
	@JoinColumn(name="tipo_documento", nullable=false)
	public CatalogoDetalle getTipoDocumento() {
		return this.tipoDocumento; 
	}

	public void setTipoDocumento(CatalogoDetalle catalogoDetalle) {
		this.tipoDocumento = catalogoDetalle;
	}


	//bi-directional many-to-one association to Ciudade
	@ManyToOne
	@JoinColumn(name="dir_ciudad", nullable=false)
	public Ciudad getDirCiudad() {
		return this.dirCiudad;
	}

	public void setDirCiudad(Ciudad ciudad) {
		this.dirCiudad = ciudad;
	}


	//bi-directional many-to-one association to Ciudade
	@ManyToOne
	@JoinColumn(name="nac_ciudad", nullable=false)
	public Ciudad getNacCiudad() {
		return this.nacCiudad;
	}

	public void setNacCiudad(Ciudad ciudad) {
		this.nacCiudad = ciudad;
	}


	//bi-directional many-to-one association to Ciudade
	@ManyToOne
	@JoinColumn(name="exped_ciudad")
	public Ciudad getExpedCiudad() {
		return this.expedCiudad; 
	}

	public void setExpedCiudad(Ciudad ciudad) {
		this.expedCiudad = ciudad;
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
	     * @return the usuarioCambio
	     */
	//bi-directional many-to-one association to Usuario
		@ManyToOne
		@JoinColumn(name="id_usuario_cambio", nullable=false)
	    public Usuario getUsuarioCambio() {
	        return usuarioCambio;
	    }


	    /**
	     * @param usuarioCambio the usuarioCambio to set
	     */
	    public void setUsuarioCambio(Usuario usuarioCambio) {
	        this.usuarioCambio = usuarioCambio;
	    }

}