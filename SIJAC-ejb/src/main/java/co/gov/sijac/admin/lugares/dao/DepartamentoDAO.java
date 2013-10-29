 
	
package co.gov.sijac.admin.lugares.dao;

import  co.gov.sijac.admin.lugares.model.entidades.Departamento;
import  co.gov.sijac.common.annotation.GestorEntidad;
import  co.gov.sijac.common.dao.GenericoDAOInterface;
/**
 *
 * @author ENUNEZT
 */
@GestorEntidad(clase="DepartamentoDAO",descripcion="Interfaz para gestionar  Departamento del sistema")
public interface DepartamentoDAO extends GenericoDAOInterface<Departamento>{
    
}