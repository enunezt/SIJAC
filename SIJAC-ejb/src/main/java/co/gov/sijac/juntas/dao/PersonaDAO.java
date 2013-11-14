 
	
package co.gov.sijac.juntas.dao;

import  co.gov.sijac.juntas.model.entidades.Persona;
import  co.gov.sijac.common.annotation.GestorEntidad;
import  co.gov.sijac.common.dao.GenericoDAOInterface;
/**
 *
 * @author ENUNEZT
 */
@GestorEntidad(clase="PersonaDAO",descripcion="Interfaz para gestionar  Persona del sistema")
public interface PersonaDAO extends GenericoDAOInterface<Persona>{
    
}