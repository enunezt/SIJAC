package co.gov.sijac.juntas.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import co.gov.sijac.admin.lugares.model.entidades.Ciudad;
import co.gov.sijac.admin.lugares.model.entidades.Departamento;
import co.gov.sijac.admin.lugares.model.entidades.Pais;
import co.gov.sijac.admin.model.entidades.Usuario;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the juntas database table.
 * 
 */
@Entity
@Table(name="juntas")
@NamedQuery(name="Junta.findAll", query="SELECT j FROM Junta j")
public class Junta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idJunta;
	private String barrio;
	private String codigo;
	private String direccion;
	private String estado;
	private Date fecCambio;
	private Date fecRegistro;
	private Date fecResolucion;
	private String numResolucion;
	private String telefonos;
	private Ciudad ciudad;
	private Usuario usuario;
	private Set<ActasJunta> actasJuntas;

	public Junta() {
	}
	
	public Junta(boolean init) {
	    ciudad=new Ciudad();
	    Departamento dpto=new Departamento();
	    Pais pais=new Pais(52, 170, "CO", "COL", "COLOMBIA");	    
	    dpto.setPais(pais);
	    ciudad.setDepartamento(dpto); 
	    
	}


	@Id
	@Column(name="id_junta", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdJunta() {
		return this.idJunta;
	}

	public void setIdJunta(Integer idJunta) {
		this.idJunta = idJunta;
	}


	@Column(nullable=false, length=50)
	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}


	@Column(length=12)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Column(nullable=false, length=80)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Column(length=1)
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


	@Temporal(TemporalType.DATE)
	@Column(name="fec_resolucion", nullable=false)
	public Date getFecResolucion() {
		return this.fecResolucion;
	}

	public void setFecResolucion(Date fecResolucion) {
		this.fecResolucion = fecResolucion;
	}


	@Column(name="num_resolucion", nullable=false, length=10)
	public String getNumResolucion() {
		return this.numResolucion;
	}

	public void setNumResolucion(String numResolucion) {
		this.numResolucion = numResolucion;
	}


	@Column(length=30)
	public String getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}


	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="id_ciudad", nullable=false)
	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
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
	
	//bi-directional many-to-one association to ActasJunta
		@OneToMany(mappedBy="junta", fetch=FetchType.LAZY)
		public Set<ActasJunta> getActasJuntas() {
			return this.actasJuntas;
		}

		public void setActasJuntas(Set<ActasJunta> actasJuntas) {
			this.actasJuntas = actasJuntas;
		}

		public ActasJunta addActasJunta(ActasJunta actasJunta) {
			getActasJuntas().add(actasJunta);
			actasJunta.setJunta(this);

			return actasJunta;
		}

		public ActasJunta removeActasJunta(ActasJunta actasJunta) {
			getActasJuntas().remove(actasJunta);
			actasJunta.setJunta(null);

			return actasJunta;
		}

}