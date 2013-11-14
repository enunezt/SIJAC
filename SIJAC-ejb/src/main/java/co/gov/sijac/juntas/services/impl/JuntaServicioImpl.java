 
	
package co.gov.sijac.juntas.services.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import co.gov.sijac.juntas.model.entidades.Junta;
import co.gov.sijac.juntas.services.JuntaServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.exception.ServicioExcepcion;

@Stateless
@Local(JuntaServicio.class)
@Servicio(clase="JuntaServicioImpl",descripcion="Implementacion Logica de negocio de Juntas")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class JuntaServicioImpl implements JuntaServicio{ 
	
//TODO: Implementar JuntaServicio
}
