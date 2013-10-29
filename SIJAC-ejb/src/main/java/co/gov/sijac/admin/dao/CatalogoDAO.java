 
	
package co.gov.sijac.admin.dao;

import  co.gov.sijac.admin.model.entidades.Catalogo;
import  co.gov.sijac.common.annotation.GestorEntidad;
import  co.gov.sijac.common.dao.GenericoDAOInterface;
/**
 *
 * @author ENUNEZT
 */
@GestorEntidad(clase="CatalogoDAO",descripcion="Interfaz para gestionar  Catalogo del sistema")
public interface CatalogoDAO extends GenericoDAOInterface<Catalogo>{
    
}