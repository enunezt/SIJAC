 
	
package co.gov.sijac.admin.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.admin.dao.CatalogoDetalleDAO;
import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class CatalogoDetalleDAO
 */
@Stateless
@Local(CatalogoDetalleDAO.class)
@GestorEntidad(clase="CatalogoDetalleDAOImpl",descripcion="Gestiona CatalogoDetalle del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CatalogoDetalleDAOImpl extends GenericoDAO<CatalogoDetalle> implements CatalogoDetalleDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CatalogoDetalleDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}