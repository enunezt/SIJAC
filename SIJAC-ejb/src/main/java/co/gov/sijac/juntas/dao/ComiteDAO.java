 
	
package co.gov.sijac.juntas.dao;

import  co.gov.sijac.juntas.model.entidades.Comite;
import  co.gov.sijac.common.annotation.GestorEntidad;
import  co.gov.sijac.common.dao.GenericoDAOInterface;
/**
 *
 * @author ENUNEZT
 */
@GestorEntidad(clase="ComiteDAO",descripcion="Interfaz para gestionar  Comite del sistema")
public interface ComiteDAO extends GenericoDAOInterface<Comite>{
    
}