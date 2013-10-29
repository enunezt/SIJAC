package co.gov.sijac.image.model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Imagen
 *
 */
@Entity
@Table(name="imagenes")
@NamedQueries(
{@NamedQuery( name = "Imagen.findAllEntidad", query = "SELECT i FROM Imagen i WHERE i.idEntidad=:idEntidad" ),
@NamedQuery( name = "Imagen.findById", query = "SELECT i FROM Imagen i WHERE i.idImagen = :idImagen" ),
@NamedQuery( name = "Imagen.findIdByEnte", query = "SELECT i.idImagen FROM Imagen i WHERE i.idEntidad=:idEntidad AND i.tipo=:tipo"),
@NamedQuery( name = "Imagen.findByEnte", query = "SELECT i FROM Imagen i WHERE i.idEntidad=:idEntidad AND i.tipo=:tipo" )
} )
public class Imagen implements Serializable {
	private static final long serialVersionUID = 7102771536127786524L;
	private Long idImagen;	
	private String nombre;
	private EImagen tipo;
	private Long idEntidad;
	private Date fechaRegistro;
	private byte[] content; 
	private ETipoImagen extension;

	public Imagen() {
		super();
	}
   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Imagen",unique=true, nullable=false)
	public Long getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Long idImagen) {
		this.idImagen = idImagen;
	}
	
	@Column(length=20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Enumerated(EnumType.ORDINAL) 
	public EImagen getTipo() {
		return tipo;
	}


	public void setTipo(EImagen tipo) {
		this.tipo = tipo;
	}


	@Column(nullable=false)
	public Long getIdEntidad() {
		return idEntidad;
	}


	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="fec_registro")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Lob
	@Column( name = "content",length = 20000)
	@Basic(fetch = FetchType.LAZY)
	public byte[] getContent() {
		return content;
	}


	public void setContent(byte[] content) {
		this.content = content;
	}


	@Column(nullable=false)
	@Enumerated(EnumType.STRING) 
	public ETipoImagen getExtension() {
		return extension;
	}


	public void setExtension(ETipoImagen extension) {
		this.extension = extension;
	}

	
}
