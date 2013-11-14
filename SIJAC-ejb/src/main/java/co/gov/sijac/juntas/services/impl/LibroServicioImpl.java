 
	
package co.gov.sijac.juntas.services.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import co.gov.sijac.juntas.model.entidades.Libro;
import co.gov.sijac.juntas.services.LibroServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.exception.ServicioExcepcion;

@Stateless
@Local(LibroServicio.class)
@Servicio(clase="LibroServicioImpl",descripcion="Implementacion Logica de negocio de Libros")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class LibroServicioImpl implements LibroServicio{ 
	
//TODO: Implementar LibroServicio
}
