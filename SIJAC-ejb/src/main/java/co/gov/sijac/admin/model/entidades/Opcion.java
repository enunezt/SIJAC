package co.gov.sijac.admin.model.entidades;



import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the opcion database table.
 * 
 */
@Entity
@Table(name="opcion")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idOpcion;	
	private Date fecCambio;	
	private Integer tipo;
	private String url;
	private Menu menu;

    public Opcion() {
    //	menu= new Menu(); 	
    	
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_opcion",unique=true, nullable=false)
	public Long getIdOpcion() {
		return this.idOpcion;
	}

	public void setIdOpcion(Long idOpcion) {
		this.idOpcion = idOpcion;
	}




    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fec_cambio")
	public Date getFecCambio() {
		return this.fecCambio;
	}

	public void setFecCambio(Date fecCambio) {
		this.fecCambio = fecCambio;
	}




	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	@Column(length=100)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	//uni-directional many-to-one association to Menu
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_menu")
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOpcion == null) ? 0 : idOpcion.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opcion other = (Opcion) obj;
		if (idOpcion == null) {
			if (other.idOpcion != null)
				return false;
		} else if (!idOpcion.equals(other.idOpcion))
			return false;
		return true;
	}
	
}