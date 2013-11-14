 
	
package co.gov.sijac.juntas.services.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import co.gov.sijac.juntas.model.entidades.Dignatario;
import co.gov.sijac.juntas.services.DignatarioServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.exception.ServicioExcepcion;

@Stateless
@Local(DignatarioServicio.class)
@Servicio(clase="DignatarioServicioImpl",descripcion="Implementacion Logica de negocio de Dignatarios")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DignatarioServicioImpl implements DignatarioServicio{ 
	
//TODO: Implementar DignatarioServicio
}
