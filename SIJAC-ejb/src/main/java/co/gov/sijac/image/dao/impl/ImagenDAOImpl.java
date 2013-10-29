package co.gov.sijac.image.dao.impl;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;
import co.gov.sijac.image.dao.ImagenDAO;
import co.gov.sijac.image.model.entidades.Imagen;

/**
 * Session Bean implementation class GEPerfil
 */
@Stateless
@Local(ImagenDAO.class)
@GestorEntidad(clase="ImagenDAOImpl",descripcion="Gestiona las Imagenes del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ImagenDAOImpl extends GenericoDAO<Imagen> implements ImagenDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ImagenDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	

}
