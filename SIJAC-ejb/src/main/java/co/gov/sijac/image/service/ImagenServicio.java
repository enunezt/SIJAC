package co.gov.sijac.image.service;

/*import co.gov.sijac.common.GenericoInterface;*/
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.exception.ServicioExcepcion;
import co.gov.sijac.image.model.ImagenModel;


@Servicio(clase="ImagenServicio",descripcion="Contrato para la Logica de negocio para la gestion de imagenes")
public interface ImagenServicio/*<T>*/ extends ImagenModel<ServicioExcepcion>/*, GenericoInterface<T,ServicioExcepcion>*/{

}
