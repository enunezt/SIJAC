 
	
package co.gov.sijac.juntas.dao;

import  co.gov.sijac.juntas.model.entidades.Libro;
import  co.gov.sijac.common.annotation.GestorEntidad;
import  co.gov.sijac.common.dao.GenericoDAOInterface;
/**
 *
 * @author ENUNEZT
 */
@GestorEntidad(clase="LibroDAO",descripcion="Interfaz para gestionar  Libro del sistema")
public interface LibroDAO extends GenericoDAOInterface<Libro>{
    
}