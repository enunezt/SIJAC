package co.gov.sijac.admin.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import co.gov.sijac.image.model.entidades.Imagen;

import java.util.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idUsuario;	
	private String clave;
	private Date fecCambio;
	private Date fecRegistro;
	private String usuario;
	private List<Perfil> perfiles;
	private Imagen fotoPerfil;
	//private SettingsContext contexto;


	public Usuario() {
    	//contexto=new SettingsContext();
    }

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario",unique=true, nullable=false)
	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	@Column(nullable=false, length=255)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fec_cambio")
	public Date getFecCambio() {
		return this.fecCambio;
	}

	public void setFecCambio(Date fecCambio) {
		this.fecCambio = fecCambio;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fec_registro", nullable=false)
	public Date getFecRegistro() {
		return this.fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}


	

	@Column(nullable=false, length=10)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	//uni-directional many-to-many association to Perfil
	@ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(
		name="perfil_usuario"
		, joinColumns={
			@JoinColumn(name="id_usuario", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_perfil", nullable=false)
			}
		)
	public List<Perfil> getPerfiles() {
		return this.perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
/*	public SettingsContext contexto(){
		return this.contexto;
	}
	public SettingsContext adicionarContexto(SettingsContext contexto){
		return this.contexto;
	}
	*/
	

	@JoinColumn(name = "id_imagen")
	@OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	public Imagen getFotoPerfil() {
		return fotoPerfil;
	}


	public void setFotoPerfil(Imagen fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	


	

}