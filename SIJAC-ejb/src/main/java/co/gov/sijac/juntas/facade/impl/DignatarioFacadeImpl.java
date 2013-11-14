 
	
package co.gov.sijac.juntas.facade.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.juntas.dao.DignatarioDAO;
import co.gov.sijac.juntas.facade.DignatarioFacade;
import co.gov.sijac.juntas.model.entidades.Dignatario;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;

/**
 * Session Bean implementation class DignatarioFacade
 */
@Stateless
@Local(DignatarioFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="DignatarioFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Dignatario")
public class DignatarioFacadeImpl extends GenericoDAOFacade<Dignatario> implements DignatarioFacade{

	@Inject
	private DignatarioDAO serviceDAODignatario;	
	
  	/**
     * Default constructor. 
     */
    public DignatarioFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Dignatario> getServiceDAO() {
		return serviceDAODignatario;
	}

	

	
	
}