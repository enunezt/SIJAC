package co.gov.sijac.image.model;

import java.util.Set;

import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.image.model.entidades.EImagen;
import co.gov.sijac.image.model.entidades.Imagen;

public interface ImagenModel<E extends Exception> { 	
	
	/**
	 * Consulta url de la foto del usuario.
	 * @param request idUsuario con EParametro.User de tipo Long
	 * @return ResponseDTO con id Long Imagen en EParametro.Imagen
	 * @throws E
	 */
	public ResponseDTO consultarIdFotoUsuario(RequestDTO request) throws E;
	
	/**
	 * Consulta una imagen según su ID
	 * @param request idImagen Long en EParametro.Imagen
	 * @return Imagen
	 * @throws E
	 */
	public Imagen consultarImagen(RequestDTO request) throws E;
	
	/**
	 * Consulta listado de imagenes segun entidad y tipo.
	 * @param request
	 * 		 idEntidad Long EParametro.IdEntidad, tipo EImagen EParametro.ImagenTipo
	 * @return Set<Imagen> en EParametro.Set
	 * @throws E
	 */
	public ResponseDTO consultarLstImagenes(RequestDTO request) throws E;
	
	
	/**
	 * Consulta listado de ids de imagenes segun entidad y tipo.
	 * @param request
	 * 		 idEntidad Long EParametro.IdEntidad, tipo EImagen EParametro.ImagenTipo
	 * @return Set<Long>  en EParametro.Set
	 * @throws E
	 */
	public ResponseDTO consultarLstIdImagenes(RequestDTO request) throws E;
	


}