 
	
package co.gov.sijac.juntas.facade.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.juntas.dao.ActasJuntaDAO;
import co.gov.sijac.juntas.facade.ActasJuntaFacade;
import co.gov.sijac.juntas.model.entidades.ActasJunta;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;

/**
 * Session Bean implementation class ActasJuntaFacade
 */
@Stateless
@Local(ActasJuntaFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="ActasJuntaFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad ActasJunta")
public class ActasJuntaFacadeImpl extends GenericoDAOFacade<ActasJunta> implements ActasJuntaFacade{

	@Inject
	private ActasJuntaDAO serviceDAOActasJunta;	
	
  	/**
     * Default constructor. 
     */
    public ActasJuntaFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<ActasJunta> getServiceDAO() {
		return serviceDAOActasJunta;
	}

	

	
	
}