package co.gov.sijac.admin.services.users.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.model.entidades.Usuario;
import co.gov.sijac.admin.services.users.UsuarioServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.exception.ServicioExcepcion;
import co.gov.sijac.image.model.entidades.Imagen;
import co.gov.sijac.image.service.ImagenServicio;

@Stateless
@Local(UsuarioServicio.class)
@Servicio(clase="UsuarioServicioImpl",descripcion="Implementacion Logica de negocio de Usuarios")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UsuarioServicioImpl implements UsuarioServicio/*<Imagen>*/{ 

	
	@Inject
	private ImagenServicio imagenServicio;
	
	/*@Inject
	private UsuarioDAO usuarioDAO;*/
	

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO cargarFotoUsuario(RequestDTO request) throws ServicioExcepcion {
		try {
			Usuario usuario=(Usuario) request.getEntidadLocal();
			if(usuario.getFotoPerfil()!=null){
			  //  usuario.getFotoPerfil().getIdImagen()  idImagen Long en EParametro.Imagen
			    
			    RequestDTO req=new RequestDTO(request.getSettingsContext());
			    req.setParam(EParametro.Imagen,usuario.getFotoPerfil().getIdImagen());
			    
			Imagen img=imagenServicio.consultarImagen(req);			
			usuario.setFotoPerfil(img);
			
			}

			  ResponseDTO response=new ResponseDTO(usuario);
			  request.setEntidadLocal(usuario);   
			         return response;
			
		} catch (ServicioExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
	}

	

}
