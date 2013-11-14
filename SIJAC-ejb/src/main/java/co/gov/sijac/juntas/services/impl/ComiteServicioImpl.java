 
	
package co.gov.sijac.juntas.services.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import co.gov.sijac.juntas.model.entidades.Comite;
import co.gov.sijac.juntas.services.ComiteServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.exception.ServicioExcepcion;

@Stateless
@Local(ComiteServicio.class)
@Servicio(clase="ComiteServicioImpl",descripcion="Implementacion Logica de negocio de Comites")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ComiteServicioImpl implements ComiteServicio{ 
	
//TODO: Implementar ComiteServicio
}
