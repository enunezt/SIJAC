package co.gov.sijac.admin.facade.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.dao.OpcionDAO;
import co.gov.sijac.admin.facade.OpcionFacade;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;

/**
 * Session Bean implementation class OpcionFacade
 */
@Stateless
@Local(OpcionFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="OpcionFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Opcion")
public class OpcionFacadeImpl extends GenericoDAOFacade<Opcion> implements OpcionFacade{

@Inject
	private OpcionDAO serviceOpcion;	
	
  	/**
     * Default constructor. 
     */
    public OpcionFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Opcion> getServiceDAO() {
		return serviceOpcion;
	}
	
	
}
