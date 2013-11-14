package co.gov.sijac.admin.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the catalogo database table.
 * 
 */
@Entity
@Table(name="catalogo")

@NamedQueries(
{@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c"),
@NamedQuery( name = "Catalogo.findById", query = "SELECT c FROM Catalogo c WHERE c.idCatalogo = :idCatalogo" ),
@NamedQuery( name = "Catalogo.findIdByName", query = "SELECT c FROM Catalogo c WHERE c.nombre = :nombre"),
} )
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idCatalogo;
	private String descripcion;
	private Date fecRegistro;
	private String nombre;
	private Set<CatalogoDetalle> catalogoDetalles;

	public Catalogo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_catalogo", unique=true, nullable=false)
	public Integer getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}


	@Column(nullable=false, length=100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fec_registro", nullable=false)
	public Date getFecRegistro() {
		return this.fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}


	@Column(unique=true,nullable=false, length=100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to CatalogoDetalle
	@OneToMany(mappedBy="catalogo", fetch=FetchType.LAZY)
	public Set<CatalogoDetalle> getCatalogoDetalles() {
		return this.catalogoDetalles;
	}

	public void setCatalogoDetalles(Set<CatalogoDetalle> catalogoDetalles) {
		this.catalogoDetalles = catalogoDetalles;
	}

	public CatalogoDetalle addCatalogoDetalle(CatalogoDetalle catalogoDetalle) {
		getCatalogoDetalles().add(catalogoDetalle);
		catalogoDetalle.setCatalogo(this);

		return catalogoDetalle;
	}

	public CatalogoDetalle removeCatalogoDetalle(CatalogoDetalle catalogoDetalle) {
		getCatalogoDetalles().remove(catalogoDetalle);
		catalogoDetalle.setCatalogo(null);

		return catalogoDetalle;
	}
	
	@Override
	    public boolean equals(Object o) {
		if ((o instanceof Catalogo)
			&& (((Catalogo) o).getIdCatalogo() == this.idCatalogo)) {
		    return true;
		} else {
		    return false;
		}
	    }

	    @Override
	    public int hashCode() {
		int hash = 11;
		hash = 17 * hash + this.idCatalogo;
		return hash;
	    }

}