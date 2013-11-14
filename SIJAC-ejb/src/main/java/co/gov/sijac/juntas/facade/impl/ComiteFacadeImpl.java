 
	
package co.gov.sijac.juntas.facade.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.juntas.dao.ComiteDAO;
import co.gov.sijac.juntas.facade.ComiteFacade;
import co.gov.sijac.juntas.model.entidades.Comite;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;

/**
 * Session Bean implementation class ComiteFacade
 */
@Stateless
@Local(ComiteFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="ComiteFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Comite")
public class ComiteFacadeImpl extends GenericoDAOFacade<Comite> implements ComiteFacade{

	@Inject
	private ComiteDAO serviceDAOComite;	
	
  	/**
     * Default constructor. 
     */
    public ComiteFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Comite> getServiceDAO() {
		return serviceDAOComite;
	}

	

	
	
}