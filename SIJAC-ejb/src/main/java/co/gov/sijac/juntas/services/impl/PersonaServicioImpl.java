 
	
package co.gov.sijac.juntas.services.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import co.gov.sijac.juntas.model.entidades.Persona;
import co.gov.sijac.juntas.services.PersonaServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.exception.ServicioExcepcion;

@Stateless
@Local(PersonaServicio.class)
@Servicio(clase="PersonaServicioImpl",descripcion="Implementacion Logica de negocio de Personas")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PersonaServicioImpl implements PersonaServicio{ 
	
//TODO: Implementar PersonaServicio
}
