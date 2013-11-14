 
	
package co.gov.sijac.juntas.facade.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.juntas.dao.PagosAfiliadoDAO;
import co.gov.sijac.juntas.facade.PagosAfiliadoFacade;
import co.gov.sijac.juntas.model.entidades.PagosAfiliado;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;

/**
 * Session Bean implementation class PagosAfiliadoFacade
 */
@Stateless
@Local(PagosAfiliadoFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="PagosAfiliadoFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad PagosAfiliado")
public class PagosAfiliadoFacadeImpl extends GenericoDAOFacade<PagosAfiliado> implements PagosAfiliadoFacade{

	@Inject
	private PagosAfiliadoDAO serviceDAOPagosAfiliado;	
	
  	/**
     * Default constructor. 
     */
    public PagosAfiliadoFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<PagosAfiliado> getServiceDAO() {
		return serviceDAOPagosAfiliado;
	}

	

	
	
}