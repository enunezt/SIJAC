 
	
package co.gov.sijac.admin.facade;


import co.gov.sijac.admin.model.entidades.Catalogo;
import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.exception.ServicioFacadeExcepcion;



@ServicioFacade(clase="CatalogoFacade",descripcion="Contrato de la logica de negocio para la gestion de Catalogos")
public interface CatalogoFacade extends  GenericoFacadeInterface<Catalogo>{ 	
    /**
	 * Consulta Catalogo y sus detalle
	 * @param name EParametro.Nombre
	 * @return Catalgo en ResponseDTO.EntidadLocal 
	 * @throws ServicioFacadeExcepcion
	 */
	public ResponseDTO consultarCatalogo(RequestDTO request)throws ServicioFacadeExcepcion;
	/**
	 * Consulta Catalogo y sus detalle
	 * @param request RequestDTO.EntidadLocal
	 * @return Catalgo
	 * @throws ServicioFacadeExcepcion
	 */
	public Catalogo consultarCatalogoId(RequestDTO request)throws ServicioFacadeExcepcion;
	/**
	 * Retorna detalle catalogo segun su id
	 * @param request con idCatalogoDetalle  EParametro.CatalogoDet
	 * @return  CatalogoDetalle 
	 * @throws ServicioFacadeExcepcion
	 */
	public CatalogoDetalle consultarCatalogDetalle(RequestDTO request)throws ServicioFacadeExcepcion;
	
	/**
	 * Retorna listado catalogo segun id
	 * @param request con idCatalogo EParametro.Catalogo tipo Integer
	 * @return Set<CatalogoDetalle> en EParametro.Set
	 * @throws ServicioFacadeExcepcion
	 */
	public ResponseDTO consultarLstCatalogDetalle(RequestDTO request)throws ServicioFacadeExcepcion;
	
	
		

}
