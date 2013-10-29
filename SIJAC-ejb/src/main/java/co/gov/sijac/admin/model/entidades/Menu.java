package co.gov.sijac.admin.model.entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name="menu")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idMenu;
	private String descripcion;
	private Date fecCambio;
	private Long idPadre;
	private String nombre;

    public Menu() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_menu",unique=true, nullable=false)
	public Long getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}


	@Column(length=100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fec_cambio")
	public Date getFecCambio() {
		return this.fecCambio;
	}

	public void setFecCambio(Date fecCambio) {
		this.fecCambio = fecCambio;
	}


	@Column(name="id_padre")
	public Long getIdPadre() {
		return this.idPadre;
	}

	public void setIdPadre(Long idPadre) {
		this.idPadre = idPadre;
	}


	@Column(length=50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}