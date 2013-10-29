package co.gov.sijac.image.service.impl;

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

import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.exception.DAOExcepcion;
import co.gov.sijac.exception.ServicioExcepcion;
import co.gov.sijac.image.dao.ImagenDAO;
import co.gov.sijac.image.model.entidades.EImagen;
import co.gov.sijac.image.model.entidades.Imagen;
import co.gov.sijac.image.model.enums.ETipoEntidad;
import co.gov.sijac.image.service.ImagenServicio;
@Stateless
@Local(ImagenServicio.class)
@Servicio(clase="ImagenServicioImpl",descripcion="Implementacion Logica de negocio para la gestion de imagenes")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ImagenServicioImpl implements ImagenServicio/*<Imagen>*/{ 

	@Inject
	private ImagenDAO imagenDAO;

	
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarIdFotoUsuario(RequestDTO request) throws ServicioExcepcion {
	    Long idUsuario=(Long) request.getParam(EParametro.User);
		try {
			Map<String,Object> parameters=new HashMap<String, Object>();
			String idUserImagen=""+ETipoEntidad.USER.getId()+idUsuario.longValue();
			parameters.put("idEntidad", Long.valueOf(idUserImagen)); 
			parameters.put("tipo", EImagen.FOTO_PERFIL);

			
			request.setParam(EParametro.NamedQuery,"Imagen.findByEnte");
			request.setParam(EParametro.ParemtrosQuery,parameters);
			
			ResponseDTO resp=imagenDAO.findWithNamedQuery(request);
			
			//Imagen.findById
			@SuppressWarnings("unchecked")
			List<Imagen> lst=(List<Imagen>) resp.getParam(EParametro.ResultList);
			Long idImagen=null;
			if(lst!=null && !lst.isEmpty()){
			    idImagen=lst.iterator().next().getIdImagen();
			}
			
			ResponseDTO retorno=new ResponseDTO();
			retorno.setParam(EParametro.Imagen, idImagen);
			//retorno.setParam(EParametro.Set,(Set<CatalogoDetalle>) resp.getParam(EParametro.ResultList)); 
			return retorno;
			
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
	}

	@Override
	public Imagen consultarImagen(RequestDTO request) throws ServicioExcepcion {
		try {
			//Imagen.findById
		 
			
			RequestDTO requestTmp=new RequestDTO();
			
			requestTmp.setParam(EParametro.IdEntidadLocal ,(Long) request.getParam(EParametro.Imagen));
			requestTmp.setParam(EParametro.NamedQueryLocal ,"Imagen.findById");		
			
			Imagen img=imagenDAO.buscarPorIdNamedQeryId(requestTmp);
			img.getContent();
			
		return img;
			
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
	}

	@Override
	public ResponseDTO consultarLstImagenes(RequestDTO request)
			throws ServicioExcepcion {
		try {
		    
		   // idEntidad Long , tipo EImagen EParametro.ImagenTipo

		    Map<String,Object> parameters=new HashMap<String, Object>();
			parameters.put("idEntidad", (Long)request.getParam(EParametro.IdEntidad));
			parameters.put("tipo", (EParametro)request.getParam(EParametro.ImagenTipo));

			
			request.setParam(EParametro.NamedQuery,"Imagen.findByEnte");
			request.setParam(EParametro.ParemtrosQuery,parameters);
			
			ResponseDTO resp=imagenDAO.findWithNamedQuery(request);
			
			
			//Imagen.findById
			Set<Imagen> ret=null;
			@SuppressWarnings("unchecked")
			List<Imagen> lst=(List<Imagen>) resp.getParam(EParametro.ResultList);
			
			if(lst!=null && !lst.isEmpty()){				
				ret=new HashSet<Imagen>(lst);
				for (Imagen imagen : ret) {
					imagen.getContent();
				}
			}			
			ResponseDTO retorno=new ResponseDTO();
			retorno.setParam(EParametro.Set, ret);
			//retorno.setParam(EParametro.Set,(Set<CatalogoDetalle>) resp.getParam(EParametro.ResultList)); 
			return retorno;
			
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarLstIdImagenes(RequestDTO request)
			throws ServicioExcepcion {
		try {
				
			
			  Map<String,Object> parameters=new HashMap<String, Object>();
				parameters.put("idEntidad", (Long)request.getParam(EParametro.IdEntidad));
				parameters.put("tipo", (EParametro)request.getParam(EParametro.ImagenTipo));

				
				request.setParam(EParametro.NamedQuery,"Imagen.findIdByEnte");
				request.setParam(EParametro.ParemtrosQuery,parameters);
				
				ResponseDTO resp=imagenDAO.findWithNamedQuery(request);
				
				
				Set<Long> ret=null;
				@SuppressWarnings("unchecked")
				List<Long> lst=(List<Long>) resp.getParam(EParametro.ResultList);
				
				if(lst!=null && !lst.isEmpty()){				
					ret=new HashSet<Long>(lst);
					}
				ResponseDTO retorno=new ResponseDTO();
				retorno.setParam(EParametro.Set, ret);
				return retorno;
			
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
	}

	/*@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Usuario consultarUsuario(String usuario, String pass)
			throws ServicioExcepcion {
		
    
		try {
			return userDAO.consultarUsuario(usuario, pass);
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
	
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Map<Long, Menu> consultarMenu(Usuario usuario)
			throws ServicioExcepcion {		

		try {
			return userDAO.consultarMenu(usuario);
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		}
		
	}

	*/

}
