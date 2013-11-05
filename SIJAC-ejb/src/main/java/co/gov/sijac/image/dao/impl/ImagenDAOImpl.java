package co.gov.sijac.image.dao.impl;


import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.exception.DAOExcepcion;
import co.gov.sijac.image.dao.ImagenDAO;
import co.gov.sijac.image.model.entidades.Imagen;

/**
 * Session Bean implementation class GEPerfil
 */
@Stateless
@Local(ImagenDAO.class)
@GestorEntidad(clase="ImagenDAOImpl",descripcion="Gestiona las Imagenes del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ImagenDAOImpl extends GenericoDAO<Imagen> implements ImagenDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ImagenDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	
	@Override
	public EntityManager getEntityManager() {
		return em;
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
	    public Imagen buscarPorIdNamedQeryId(RequestDTO request) throws DAOExcepcion{	
		String namedQuery=(String) request.getParam(EParametro.NamedQueryLocal);
		Long id=(Long) request.getParam(EParametro.IdEntidadLocal);
	    	 Query query = getEntityManager().createNamedQuery(namedQuery);
	    	 Class<Imagen> claseEntidad = (Class<Imagen>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	         
	              query.setParameter("id"+claseEntidad.getSimpleName(), id);
	       
	        return (Imagen) query.getSingleResult();
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
}
