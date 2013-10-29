 
	
package co.gov.sijac.admin.facade.impl;

import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.dao.CatalogoDAO;
import co.gov.sijac.admin.facade.CatalogoFacade;
import co.gov.sijac.admin.model.entidades.Catalogo;
import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.admin.services.catalogo.CatalogoServicio;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;
import co.gov.sijac.exception.ServicioExcepcion;
import co.gov.sijac.exception.ServicioFacadeExcepcion;

/**
 * Session Bean implementation class CatalogoFacade
 */
@Stateless
@Local(CatalogoFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="CatalogoFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Catalogo")
public class CatalogoFacadeImpl extends GenericoDAOFacade<Catalogo> implements CatalogoFacade{

	@Inject
	private CatalogoDAO serviceCatalogoDAO;	
	@Inject
	private CatalogoServicio serviceCatalogo;
	/**
     * Default constructor. 
     */
    public CatalogoFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Catalogo> getServiceDAO() {
		return serviceCatalogoDAO;
	}

	@Override
	public ResponseDTO consultarCatalogo(RequestDTO request) throws ServicioFacadeExcepcion {
		try {
			return serviceCatalogo.consultarCatalogo(request);
		} catch (ServicioExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}
	@Override
	public Catalogo consultarCatalogoId(RequestDTO request)
			throws ServicioFacadeExcepcion {
		try {
			return serviceCatalogo.consultarCatalogoId(request);
		}  catch (ServicioExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}
	@Override
	public CatalogoDetalle consultarCatalogDetalle(RequestDTO request)
			throws ServicioFacadeExcepcion {
		try {
			return serviceCatalogo.consultarCatalogDetalle(request);
		}  catch (ServicioExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}

	@Override
	public ResponseDTO consultarLstCatalogDetalle(RequestDTO request)
			throws ServicioFacadeExcepcion {
		try {
			return serviceCatalogo.consultarLstCatalogDetalle(request);
		} catch (ServicioExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
		}

	
	
}