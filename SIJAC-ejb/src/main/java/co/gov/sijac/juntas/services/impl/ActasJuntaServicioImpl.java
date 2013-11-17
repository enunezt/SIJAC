 
	
package co.gov.sijac.juntas.services.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import co.gov.sijac.juntas.model.entidades.ActasJunta;
import co.gov.sijac.juntas.services.ActasJuntaServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.exception.ServicioExcepcion;

@Stateless
@Local(ActasJuntaServicio.class)
@Servicio(clase="ActasJuntaServicioImpl",descripcion="Implementacion Logica de negocio de ActasJuntas")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ActasJuntaServicioImpl implements ActasJuntaServicio{ 
	
//TODO: Implementar ActasJuntaServicio
}
