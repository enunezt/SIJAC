 
	
package co.gov.sijac.juntas.dao.impl;

import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.juntas.dao.JuntaDAO;
import co.gov.sijac.juntas.model.entidades.Junta;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.exception.DAOExcepcion;

/**
 * Session Bean implementation class JuntaDAO
 */
@Stateless
@Local(JuntaDAO.class)
@GestorEntidad(clase="JuntaDAOImpl",descripcion="Gestiona Junta del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class JuntaDAOImpl extends GenericoDAO<Junta> implements JuntaDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public JuntaDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}
	
	  @Override
	    public ResponseDTO crear(RequestDTO entidad) throws DAOExcepcion{
		
	      Junta junta=(Junta)entidad.getEntidadLocal();
	      if(junta.getFecRegistro()==null)
	            junta.setFecRegistro(new Date());
	            
	            junta.setFecCambio(new Date());
	            junta.setUsuario( entidad.getSettingsContext().getUserLogin()); 
	      
	    	getEntityManager().persist(junta); // Crea una nueva tupla en la BD con los datos de "entidad"
	                            // -> ademas genera su ID  
	    	entidad.setEntidadLocal(junta);
	    	ResponseDTO response=new ResponseDTO(junta);
	       return response;
	    }

	    @Override
	    public ResponseDTO actualizar(RequestDTO entidad) throws DAOExcepcion{    
		
		 Junta junta=(Junta)entidad.getEntidadLocal();
		 junta.setFecCambio(new Date());
		 junta.setUsuario( entidad.getSettingsContext().getUserLogin()); 
		            
	   	ResponseDTO response=new ResponseDTO(getEntityManager().merge(junta));
	      return response;
	    }

}