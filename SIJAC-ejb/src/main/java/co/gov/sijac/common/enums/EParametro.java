/**
 * 
 */
package co.gov.sijac.common.enums;

import java.util.Collection;


/**
 * @author enunezt
 *
 */
public enum EParametro implements IParametro {
	
	/**
	 * Entidad base para la parte génrica
	 */
	EntLocal ("EntidadLocal"),
	IdEntidadLocal("IdEntidadLocal"),
	NamedQueryLocal("namedQueryLocal"),
	Nombre("nombre"),
	/**
	 * Entidad paginadora
	 */
	Paginable ("EntidadPaginadora"),
	SettContex("ContextoCliente"),	
	NamedQuery("namedQuery"),
	ResultList("ResultList"),
	ParemtrosQuery("ParemtrosQuery"),
	Map("MapaObjetos"),
	Set("SetObjetos"),
	User("EntidadUsuario"),
	CatalogoDet("EntidadCatalogoDet"),
	Catalogo("EntidadCatalogo"),
	Imagen("EntidadImagen"),
	IdEntidad("IdEntidad"),
	ImagenTipo("ImagenTipo");//, OTRO(),....;

    private final String name; // in meters
    EParametro(String name) {
   
        this.name = name;
    }

	@Override
	public String getName() {
		return this.name;
	}

}
