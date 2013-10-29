 
	
package co.gov.sijac.admin.services.catalogo;

import java.util.Set;

import co.gov.sijac.admin.model.entidades.Catalogo;
import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.exception.ServicioExcepcion;


@Servicio(clase="CatalogoServicio",descripcion="Contrato para la Logica de negocio para Catalogo")
public interface CatalogoServicio {
//TODO :agregar metodos de contrato
	
	/**
	 * Consulta Catalogo y sus detalle
	 * @param name EParametro.Nombre
	 * @return Catalgo en ResponseDTO.EntidadLocal 
	 * @throws ServicioExcepcion
	 */
	public ResponseDTO consultarCatalogo(RequestDTO request)throws ServicioExcepcion;
	/**
	 * Consulta Catalogo y sus detalle
	 * @param request RequestDTO.EntidadLocal
	 * @return Catalgo
	 * @throws ServicioExcepcion
	 */
	public Catalogo consultarCatalogoId(RequestDTO request)throws ServicioExcepcion;
	/**
	 * Retorna detalle catalogo segun su id
	 * @param request con idCatalogoDetalle  EParametro.CatalogoDet
	 * @return  CatalogoDetalle 
	 * @throws ServicioExcepcion
	 */
	public CatalogoDetalle consultarCatalogDetalle(RequestDTO request)throws ServicioExcepcion;
	
	/**
	 * Retorna listado catalogo segun id
	 * @param request con idCatalogo EParametro.Catalogo
	 * @return Set<CatalogoDetalle> en EParametro.Set
	 * @throws ServicioExcepcion
	 */
	public ResponseDTO consultarLstCatalogDetalle(RequestDTO request)throws ServicioExcepcion;
	

}