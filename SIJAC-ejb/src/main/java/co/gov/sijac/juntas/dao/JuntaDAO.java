 
	
package co.gov.sijac.juntas.dao;

import  co.gov.sijac.juntas.model.entidades.Junta;
import  co.gov.sijac.common.annotation.GestorEntidad;
import  co.gov.sijac.common.dao.GenericoDAOInterface;
/**
 *
 * @author ENUNEZT
 */
@GestorEntidad(clase="JuntaDAO",descripcion="Interfaz para gestionar  Junta del sistema")
public interface JuntaDAO extends GenericoDAOInterface<Junta>{
    
}