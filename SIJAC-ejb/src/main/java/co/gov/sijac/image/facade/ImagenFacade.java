package co.gov.sijac.image.facade;

import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
import co.gov.sijac.image.model.ImagenModel;
import co.gov.sijac.image.model.entidades.Imagen;


@ServicioFacade(clase="ImagenFacade",descripcion="Contrato de la logica de negocio para las imagenes")
public interface ImagenFacade extends  GenericoFacadeInterface<Imagen>,ImagenModel<ServicioFacadeExcepcion> { 	

}
