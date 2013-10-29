package co.gov.sijac.admin.dao;



import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.GenericoDAOInterface;
/**
 *
 * @author enunezt
 */
@GestorEntidad(clase="MenuDAO",descripcion="Interfaz para gestionar los menu del sistema")
public interface MenuDAO extends GenericoDAOInterface<Menu>{
    
}
