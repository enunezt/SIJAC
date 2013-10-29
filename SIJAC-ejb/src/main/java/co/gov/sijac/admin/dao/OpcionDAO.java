package co.gov.sijac.admin.dao;

import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.GenericoDAOInterface;

@GestorEntidad(clase="OpcionDAO",descripcion="Interfaz de Opciones del sistema")
public interface OpcionDAO extends GenericoDAOInterface<Opcion> {

	
	
}
