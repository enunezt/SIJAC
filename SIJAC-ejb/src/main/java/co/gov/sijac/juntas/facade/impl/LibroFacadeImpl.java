 
	
package co.gov.sijac.juntas.facade.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.juntas.dao.LibroDAO;
import co.gov.sijac.juntas.facade.LibroFacade;
import co.gov.sijac.juntas.model.entidades.Libro;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;

/**
 * Session Bean implementation class LibroFacade
 */
@Stateless
@Local(LibroFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="LibroFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Libro")
public class LibroFacadeImpl extends GenericoDAOFacade<Libro> implements LibroFacade{

	@Inject
	private LibroDAO serviceDAOLibro;	
	
  	/**
     * Default constructor. 
     */
    public LibroFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Libro> getServiceDAO() {
		return serviceDAOLibro;
	}

	

	
	
}