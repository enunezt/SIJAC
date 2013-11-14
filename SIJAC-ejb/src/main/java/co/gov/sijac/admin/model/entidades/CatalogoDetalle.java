package co.gov.sijac.admin.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the catalogo_detalle database table.
 * 
 */
@Entity
@Table(name="catalogo_detalle")

@NamedQueries(
{@NamedQuery(name="CatalogoDetalle.findAll", query="SELECT c FROM CatalogoDetalle c"),
@NamedQuery( name = "CatalogoDetalle.findById", query = "SELECT c FROM CatalogoDetalle c WHERE c.idCatalogoDetalle = :idCatalogoDetalle" ),
@NamedQuery( name = "CatalogoDetalle.findByCatalogo", query = "SELECT c FROM CatalogoDetalle c WHERE c.catalogo = :idCatalogo and c.estado=:estado order by c.idCatalogoDetalle"),
} )
public class CatalogoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idCatalogoDetalle;
	private String codigo;
	private String descripcion;
	private String estado;
	private Date fechaCambio;
	private String valor;
	private Catalogo catalogo;

	public CatalogoDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_catalogo_detalle", unique=true, nullable=false)
	public Integer getIdCatalogoDetalle() {
		return this.idCatalogoDetalle;
	}

	public void setIdCatalogoDetalle(Integer idCatalogoDetalle) {
		this.idCatalogoDetalle = idCatalogoDetalle;
	}


	@Column(nullable=false, length=20)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Column(length=100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(nullable=false, length=1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cambio", nullable=false)
	public Date getFechaCambio() {
		return this.fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}


	@Column(nullable=false, length=100)
	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}


	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="id_catalogo", referencedColumnName="id_catalogo",nullable=false)
	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}
	
    @Override
    public boolean equals(Object o) {
	if ((o instanceof CatalogoDetalle)
		&& (((CatalogoDetalle) o).getIdCatalogoDetalle() == this.idCatalogoDetalle)) {
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    public int hashCode() {
	int hash = 11;
	hash = 17 * hash + this.idCatalogoDetalle;
	return hash;
    }

}