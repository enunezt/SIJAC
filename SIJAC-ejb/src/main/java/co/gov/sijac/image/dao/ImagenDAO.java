package co.gov.sijac.image.dao;


import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.image.model.entidades.Imagen;
/**
 *
 * @author enunezt
 */
@GestorEntidad(clase="ImagenDAO",descripcion="Interfaz para gestionar las Imagenes del sistema")
public interface ImagenDAO extends GenericoDAOInterface<Imagen>{
	
	
    
}
