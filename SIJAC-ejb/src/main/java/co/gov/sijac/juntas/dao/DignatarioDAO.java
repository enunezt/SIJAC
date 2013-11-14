 
	
package co.gov.sijac.juntas.dao;

import  co.gov.sijac.juntas.model.entidades.Dignatario;
import  co.gov.sijac.common.annotation.GestorEntidad;
import  co.gov.sijac.common.dao.GenericoDAOInterface;
/**
 *
 * @author ENUNEZT
 */
@GestorEntidad(clase="DignatarioDAO",descripcion="Interfaz para gestionar  Dignatario del sistema")
public interface DignatarioDAO extends GenericoDAOInterface<Dignatario>{
    
}