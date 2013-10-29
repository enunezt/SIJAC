 
	
package co.gov.sijac.admin.lugares.dao;

import  co.gov.sijac.admin.lugares.model.entidades.Ciudad;
import  co.gov.sijac.common.annotation.GestorEntidad;
import  co.gov.sijac.common.dao.GenericoDAOInterface;
/**
 *
 * @author ENUNEZT
 */
@GestorEntidad(clase="CiudadDAO",descripcion="Interfaz para gestionar  Ciudad del sistema")
public interface CiudadDAO extends GenericoDAOInterface<Ciudad>{
    
}