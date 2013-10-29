package co.gov.sijac.common;

import java.util.Collection;
import java.util.Map;

import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;

public interface GenericoInterface<T,E extends Exception> {
	
	 /**
     * Permite insertar un regisgtro en la respectiva tabla
     * @param entidad Entidad en RequestDTO.EntidadLocal
     * @return
     * @throws E
     */
	 public ResponseDTO crear(RequestDTO entidad) throws E,Exception;
	 /**
	     * Permite actualizar un regisgtro en la respectiva tabla
	     * @param entidad Entidad en RequestDTO.EntidadLocal
	     * @throws E
	     */
     public ResponseDTO actualizar(RequestDTO entidad) throws E,Exception;
   /**
    *  Permite eliminar un regisgtro en la respectiva tabla
    * @param entidad Entidad en RequestDTO.EntidadLocal
    * @throws E
    */
    public void eliminar(RequestDTO entidad) throws E,Exception;
    /**
     * Debe estar asignado el valor de EntidadLocal en el argumento id, el cual corresponde al 
     * objeto genérico Que se retorna
     * @param id
     * @return
     * @throws E
     */
   
    public T buscarPorId(RequestDTO id) throws E,Exception;
    
    /**
     * Se debe pasar en el request los parametros EParametro.NamedQueryLocal y EParametro.IdEntidadLocal
     * NamedQueryLocal=query de la entidad local del dao
     * IdEntidadLocal=id de la entidad local del dao,el atributo @id de la entidad se debe llamar "id"
     * @param id
     * @return 
     * @throws E
     */   
    public T buscarPorIdNamedQeryId(RequestDTO request) throws E,Exception;//RequestDTO request
    
    /**
     * Realiza la busqueda todos los registros
     * @param request con el atributo RequestDTO.EntidadLocal
     * @return List<T> en el parametro EParametro.ResultList
     * @throws E
     */
   
    public ResponseDTO buscarTodos(RequestDTO request) throws E,Exception;
    
    /**
     * Realiza la busqueda filtrando los atributos!=null de la entidad   
     * se le debe pasar el paraemtro EParametro.EntidadLocal en el argumento
     * @param  request con el atributo RequestDTO.EntidadLocal
     * @return List<T> en el parametro EParametro.ResultList
     * @throws E
     * @throws Exception
     */
    public ResponseDTO buscarPorEntidad(RequestDTO request) throws E,Exception;
    /**
     *  Se debe pasar el parametro EParametro.NamedQuery y opcional el parametro EParametro.ParemtrosQuery
     *  NamedQuery=valor del namedQuery  declarado en las entidades
     *  ParemtrosQuery= es opcional y corresponde a los parameros con sus repectivos valores para ser 
     *                  utiliza en el query.
     *  Adicionalemente este método controla la paginación
     * @param queryName :NamedQuery invocado
     * @return List<?> en el parametro EParametro.ResultList
     * @throws E
     */
    
    public ResponseDTO findWithNamedQuery(RequestDTO queryName)throws E,Exception;
   

}
