 
	
package co.gov.sijac.juntas.services.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import co.gov.sijac.juntas.model.entidades.PagosAfiliado;
import co.gov.sijac.juntas.services.PagosAfiliadoServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.exception.ServicioExcepcion;

@Stateless
@Local(PagosAfiliadoServicio.class)
@Servicio(clase="PagosAfiliadoServicioImpl",descripcion="Implementacion Logica de negocio de PagosAfiliados")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PagosAfiliadoServicioImpl implements PagosAfiliadoServicio{ 
	
//TODO: Implementar PagosAfiliadoServicio
}
