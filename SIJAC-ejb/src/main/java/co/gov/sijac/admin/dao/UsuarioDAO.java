package co.gov.sijac.admin.dao;


import co.gov.sijac.admin.model.UsuarioModel;
import co.gov.sijac.admin.model.UsuarioSettingsModel;
import co.gov.sijac.admin.model.entidades.Usuario;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.exception.DAOExcepcion;
/**
 *
 * @author enunezt
 */
@GestorEntidad(clase="UsuarioDAO",descripcion="Interfaz para gestionar los usuarios del sistema")
public interface UsuarioDAO extends GenericoDAOInterface<Usuario>,UsuarioModel<DAOExcepcion>,UsuarioSettingsModel<DAOExcepcion>{
	
	
    
}
