 
	
package co.gov.sijac.juntas.facade.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.juntas.dao.JuntaDAO;
import co.gov.sijac.juntas.facade.JuntaFacade;
import co.gov.sijac.juntas.model.entidades.Junta;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;

/**
 * Session Bean implementation class JuntaFacade
 */
@Stateless
@Local(JuntaFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="JuntaFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Junta")
public class JuntaFacadeImpl extends GenericoDAOFacade<Junta> implements JuntaFacade{

	@Inject
	private JuntaDAO serviceDAOJunta;	
	
  	/**
     * Default constructor. 
     */
    public JuntaFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Junta> getServiceDAO() {
		return serviceDAOJunta;
	}

	

	
	
}