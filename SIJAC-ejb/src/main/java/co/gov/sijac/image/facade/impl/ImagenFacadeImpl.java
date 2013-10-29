package co.gov.sijac.image.facade.impl;

import java.util.Set;

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
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;
import co.gov.sijac.exception.ServicioExcepcion;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
import co.gov.sijac.image.dao.ImagenDAO;
import co.gov.sijac.image.facade.ImagenFacade;
import co.gov.sijac.image.model.entidades.EImagen;
import co.gov.sijac.image.model.entidades.Imagen;
import co.gov.sijac.image.service.ImagenServicio;

/**
 * Session Bean implementation class OpcionFacade
 */
@Stateless
@Local(ImagenFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="ImagenFacadeImpl",descripcion="Centraliza la logica de negocio para las Imagenes")
public class ImagenFacadeImpl extends GenericoDAOFacade<Imagen> implements ImagenFacade{

	@Inject
	private ImagenDAO serviceImagenGenerico;	
	
	@Inject
	private ImagenServicio serviceImagen;

	/**
     * Default constructor. 
     */
    public ImagenFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Imagen> getServiceDAO() {
		return serviceImagenGenerico;
	}

	@Override
	public ResponseDTO consultarIdFotoUsuario(RequestDTO request)
			throws ServicioFacadeExcepcion {
		try {
			return serviceImagen.consultarIdFotoUsuario(request);
		} catch (ServicioExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}
	}

	@Override
	public Imagen consultarImagen(RequestDTO request) throws ServicioFacadeExcepcion {
		try {
			return serviceImagen.consultarImagen(request);
		} catch (ServicioExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}
	}

	@Override
	public ResponseDTO consultarLstImagenes(RequestDTO request)
			throws ServicioFacadeExcepcion {
		try {
			return serviceImagen.consultarLstImagenes(request);
		} catch (ServicioExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}
	}

	@Override
	public ResponseDTO consultarLstIdImagenes(RequestDTO request)
			throws ServicioFacadeExcepcion {
		try {
			return serviceImagen.consultarLstIdImagenes(request);	
		} catch (ServicioExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}
	}

}
