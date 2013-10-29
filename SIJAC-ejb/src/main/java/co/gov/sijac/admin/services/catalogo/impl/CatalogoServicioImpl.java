 
	
package co.gov.sijac.admin.services.catalogo.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.dao.CatalogoDAO;
import co.gov.sijac.admin.dao.CatalogoDetalleDAO;
import co.gov.sijac.admin.model.entidades.Catalogo;
import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.admin.services.catalogo.CatalogoServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.exception.DAOExcepcion;
import co.gov.sijac.exception.ServicioExcepcion;

@Stateless
@Local(CatalogoServicio.class)
@Servicio(clase="CatalogoServicioImpl",descripcion="Implementacion Logica de negocio de Catalogos")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CatalogoServicioImpl implements CatalogoServicio{
	
	@Inject
	CatalogoDAO catalogoDAO;
	
	@Inject
	CatalogoDetalleDAO catalogoDetalleDAO;

	@SuppressWarnings("unchecked")
	@Override
	public ResponseDTO consultarCatalogo(RequestDTO request) throws ServicioExcepcion {
		try {
		    String name=(String) request.getParam(EParametro.Nombre);
			Map<String,Object> parameters=new HashMap<String, Object>();
			parameters.put("name", name);
			
			request.setParam(EParametro.NamedQuery, "Catalogo.findIdByName");
			request.setParam(EParametro.ParemtrosQuery,parameters);
			
			return catalogoDAO.findWithNamedQuery(request);
			
			
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
	}

	@Override
	public Catalogo consultarCatalogoId(RequestDTO request)
			throws ServicioExcepcion {
		try {

		    return catalogoDAO.buscarPorId(request);
			
			
			
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
	}

	@Override
	public CatalogoDetalle consultarCatalogDetalle(RequestDTO request)
			throws ServicioExcepcion {
		try {
			
		    Integer idCatDet= (Integer) request.getParam(EParametro.CatalogoDet);
		    CatalogoDetalle catDet=new CatalogoDetalle();
		    catDet.setIdCatalogoDetalle(idCatDet);		    
		    request.setEntidadLocal(catDet);		    
			return catalogoDetalleDAO.buscarPorId(request);
			
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseDTO consultarLstCatalogDetalle(RequestDTO request)
			throws ServicioExcepcion {
		try {
		    Map<String,Object> parameters=new HashMap<String, Object>();
		    Catalogo catalogo=new Catalogo();
		    catalogo.setIdCatalogo((Integer)request.getParam(EParametro.Catalogo));
			parameters.put("idCatalogo",catalogo);
			parameters.put("estado",new String("A"));
			
			request.setParam(EParametro.NamedQuery, "CatalogoDetalle.findByCatalogo");
			request.setParam(EParametro.ParemtrosQuery,parameters);
			
			//Set<CatalogoDetalle> retorno= (Set<CatalogoDetalle>) 
				ResponseDTO resp=catalogoDetalleDAO.findWithNamedQuery(request);
			ResponseDTO retorno=new ResponseDTO();
			
			Set<CatalogoDetalle> ret=null;
			@SuppressWarnings("unchecked")
			List<CatalogoDetalle> lst=(List<CatalogoDetalle>) resp.getParam(EParametro.ResultList);
			
			if(lst!=null){				
				ret=new HashSet<CatalogoDetalle>(lst);
			}
			
			retorno.setParam(EParametro.Set,ret); 
			return retorno;
			
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
	} 
	
}
