 
	
package co.gov.sijac.juntas.facade.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.juntas.dao.PersonaDAO;
import co.gov.sijac.juntas.facade.PersonaFacade;
import co.gov.sijac.juntas.model.entidades.Persona;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;

/**
 * Session Bean implementation class PersonaFacade
 */
@Stateless
@Local(PersonaFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="PersonaFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Persona")
public class PersonaFacadeImpl extends GenericoDAOFacade<Persona> implements PersonaFacade{

	@Inject
	private PersonaDAO serviceDAOPersona;	
	
  	/**
     * Default constructor. 
     */
    public PersonaFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Persona> getServiceDAO() {
		return serviceDAOPersona;
	}

	

	
	
}