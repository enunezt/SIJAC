 
	
package co.gov.sijac.admin.lugares.dao;

import  co.gov.sijac.admin.lugares.model.entidades.Pais;
import  co.gov.sijac.common.annotation.GestorEntidad;
import  co.gov.sijac.common.dao.GenericoDAOInterface;
/**
 *
 * @author ENUNEZT
 */
@GestorEntidad(clase="PaisDAO",descripcion="Interfaz para gestionar  Pais del sistema")
public interface PaisDAO extends GenericoDAOInterface<Pais>{
    
}