package co.gov.sijac.common.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.exception.DAOExcepcion;


/**
 * EJB generico que implementa las opciones de altas, bajas, modificaciones y acceso por clave
 * para cualquier tipo de Entidad
 * @author enunezt
 * @param <T>
 */


@SuppressWarnings("unchecked")
public  abstract class GenericoDAO<T> implements GenericoDAOInterface<T> {

   // @PersistenceContext(unitName = "EjemploTiendaPU")
	
	
	
	/**
	 * Retorna el EntityManager indicado para la entidad
	 * @return
	 */
	 public abstract EntityManager getEntityManager();


    
    @Override
    public ResponseDTO crear(RequestDTO entidad) throws DAOExcepcion{
	
      Object ent=getEntidadLocal(entidad);
    	getEntityManager().persist((T)ent); // Crea una nueva tupla en la BD con los datos de "entidad"
                            // -> ademas genera su ID  
    	entidad.setEntidadLocal(ent);
    	ResponseDTO response=new ResponseDTO(ent);
       return response;
    }

    @Override
    public ResponseDTO actualizar(RequestDTO entidad) throws DAOExcepcion{       
	 Object ent=getEntidadLocal(entidad);
       // Actualiza los datos de "entidad" en su correspondiente tupla BD
   	ResponseDTO response=new ResponseDTO(getEntityManager().merge(ent));
      return response;
    }

    
    @Override
    public void eliminar(RequestDTO entidad) throws DAOExcepcion{
	getEntityManager().remove(getEntityManager().merge(getEntidadLocal(entidad)));  // Actualiza y elimina
    }
/**
 * Debe estar asignado el valor de EntidadLocal en el argumento id, el cual corresponde al 
 * objeto genérico Que se retorna
 * @param id RequestDTO RequestDTO.EntidadLocal
 * @return
 * @throws DAOExcepcion
 */
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public T buscarPorId(RequestDTO id) throws DAOExcepcion{
        @SuppressWarnings("unchecked")
		Class<T> claseEntidad = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                             // Identifica la clase real de las entidades gestionada por este objeto (T.class)
        Object idEntidad=id.getParam(EParametro.IdEntidadLocal);
        return getEntityManager().find(claseEntidad,idEntidad);
    }
    /**
     * Se debe pasar en el request los parametros EParametro.NamedQueryLocal y EParametro.IdEntidadLocal
     * NamedQueryLocal=query de la entidad local del dao ej: "Imagen.findById", query = "SELECT i FROM Imagen i WHERE i.idImagen = :idImagen" 
     * IdEntidadLocal=id de la entidad local del dao,el atributo @id de la entidad se debe llamar "id" +NombreEntidad
     * @param request
     * @return
     * @throws DAOExcepcion
     */
    @SuppressWarnings("unchecked")
	@Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public T buscarPorIdNamedQeryId(RequestDTO request) throws DAOExcepcion{	
	String namedQuery=(String) request.getParam(EParametro.NamedQueryLocal);
	Long id=(Long) request.getParam(EParametro.IdEntidadLocal);
    	 Query query = getEntityManager().createNamedQuery(namedQuery);
    	 Class<T> claseEntidad = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
         
              query.setParameter("id"+claseEntidad.getSimpleName(), id);
       
        return (T) query.getSingleResult();
    }
       /**
        *  Se debe pasar el parametro EParametro.NamedQuery y opcional el parametro EParametro.ParemtrosQuery
        *  NamedQuery=valor del namedQuery  declarado en las entidades
        *  ParemtrosQuery= es opcional y corresponde a los parameros con sus repectivos valores para ser 
        *                  utiliza en el query.
        *  Adicionalemente este método controla la paginación
        * @param queryName RequestDTO
        * @return
        * @throws DAOExcepcion
        */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO findWithNamedQuery(RequestDTO queryName)throws DAOExcepcion{
	//List<Object>	
	String namedQueryName=(String) queryName.getParam(EParametro.NamedQuery);
	Map parameters=(Map) queryName.getParam(EParametro.ParemtrosQuery);
	ResponseDTO response=new ResponseDTO();
	Query query = getEntityManager().createNamedQuery(namedQueryName);
	
	if(parameters!=null){
	 Set<Entry> rawParameters = parameters.entrySet();
	        for (Entry entry : rawParameters) {
	            
	            query.setParameter(entry.getKey().toString(), entry.getValue());
	        }
	}
	List<Object> list=verificarPaginacion(query,queryName);
	
	response.setParam(EParametro.ResultList,list);
	
        return response;
    }
    /**
     * se le debe pasar el paraemtro EParametro.EntLocal en el argumento entidad
     */
    @SuppressWarnings("unchecked")
	@Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO buscarTodos(RequestDTO clazz) throws DAOExcepcion{
	//List<Object>	
	ResponseDTO response=new ResponseDTO();
	Class<?> clzz=getEntidadLocal(clazz).getClass();
        String namedQuery="FROM "+clzz.getSimpleName()+" ";  
        Query query = getEntityManager().createQuery(namedQuery);
        List<Object> list=verificarPaginacion(query,clazz);
	response.setParam(EParametro.ResultList,list);	
        return response;
      
    }
    /**
     * se le debe pasar el paraemtro EParametro.EntLocal en el argumento entidad
     */
    @SuppressWarnings("unchecked")
	@Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO buscarPorEntidad(RequestDTO entidad) throws DAOExcepcion{
	
        //String namedQuery="FROM Menu ";  
        maintest((T) entidad.getEntidadLocal());
       
    
      //List<Object>	
      	ResponseDTO response=new ResponseDTO();
      	Class<?> clzz=getEntidadLocal(entidad).getClass();
       String namedQuery="FROM "+clzz.getSimpleName()+" ";  
        Query query = getEntityManager().createQuery(namedQuery);
       List<Object> list=verificarPaginacion(query,entidad);
      	response.setParam(EParametro.ResultList,list);	
              return response;
       
      
    }
    
    /**
     * Retorna la entidad local que hacer referencia al atributo genérico T
     * @param request
     * @return
     */
    private T getEntidadLocal(RequestDTO request){
	
	return (T) request.getEntidadLocal();
    }
    
    private List<Object> verificarPaginacion(Query query,RequestDTO request){
	
	if(request.isPagination()){
	    query.setFirstResult(request.getPaginationDTO().getIncio());
	    query.setMaxResults(request.getPaginationDTO().getRango());	    
	    
	
	 List<Object> lista=query.getResultList();
	 if(lista!=null){  
	     if(lista.size()<request.getPaginationDTO().getRango())
		request.getPaginationDTO().setFin(request.getPaginationDTO().getIncio()+lista.size());
	     else
		 request.getPaginationDTO().setFin(request.getPaginationDTO().getIncio()+request.getPaginationDTO().getRango());
		
	     request.getPaginationDTO().setIncio(request.getPaginationDTO().getIncio()+lista.size());
	 }else{
	request.getPaginationDTO().setFin(request.getPaginationDTO().getIncio());	    
	 }
	 
	 return lista;
	}else{
	return query.getResultList();
	}
    }
    
    public void maintest(T entidad) {
    	
    	Class clase;
    	Field campo, campos[];
    	Method metodo, metodos[];
    
    	// Cargamos la clase
    	clase = entidad.getClass();//Class.forName(entidad.getClass().getName());
    	
    	// Recorremos los campos
    	System.out.println("Lista de campos:\n");
    	campos = clase.getDeclaredFields();
    	for (int i=0; i < campos.length; i++) {
    	campo = campos[i];
    	System.out.println("\t" + campo.getName());
    	}
    	// Recorremos los metodos
    	System.out.println("\nLista de metodos:\n");
    	metodos = clase.getMethods();
    	for (int i=0; i < metodos.length; i++) {
    	metodo = metodos[i];
    	System.out.println("\t" + metodo.getName());
    	}
    	
    	}
    
}
