package co.gov.sijac.admin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import co.gov.sijac.admin.dao.UsuarioDAO;
import co.gov.sijac.admin.enums.EParametrosAdmin;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.admin.model.entidades.Perfil;
import co.gov.sijac.admin.model.entidades.Usuario;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.exception.DAOExcepcion;

/**
 * Session Bean implementation class GEUsuario
 */
@Stateless
@Local(UsuarioDAO.class)
@GestorEntidad(clase="UsuarioDAOImpl",descripcion="Gestiona los Usuarios del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UsuarioDAOImpl extends GenericoDAO<Usuario> implements UsuarioDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UsuarioDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarPerfilesDisponibles(RequestDTO usuario)
			throws DAOExcepcion {
	    Usuario user=(Usuario) usuario.getEntidadLocal();
	   // EParametrosAdmin.PerfilesDisponiblesUser;
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		   CriteriaQuery<Perfil> criteria = cb.createQuery(Perfil.class);
		 Root<Perfil> perfil = criteria.from(Perfil.class);
		 criteria.select(perfil);;
      
		List<Perfil> lista = em.createQuery(criteria).getResultList();
		List<Perfil> listaOP = user.getPerfiles();
      
      if(lista!=null && !lista.isEmpty() /*&&  listaOP!=null && !listaOP.isEmpty()*/){
     	 for (Perfil opPO : listaOP) {
     		 lista.remove(opPO);
			}
      } 
      
      ResponseDTO response=new ResponseDTO();
      response.setParam(EParametrosAdmin.PerfilesDisponiblesUser,lista);
      return response;
	}

	@Override
	public ResponseDTO consultarPerfilesUsuario(RequestDTO usuario)
			throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarUsuario(RequestDTO request)
			throws DAOExcepcion {
		Usuario user=(Usuario) request.getEntidadLocal();
		 
         Query q =em.createQuery("from Usuario where usuario= '"+user.getUsuario()+"' and clave='"+user.getClave()+"'");
     
         @SuppressWarnings("unchecked")
		List<Usuario> lista = q.getResultList();        
         if(lista!=null && !lista.isEmpty()){
        	
             user=lista.iterator().next();
             user.getPerfiles();
        	 
         } else{
        	 
        	throw  new DAOExcepcion("Usuario o clave incorrecta");
         }
    
         ResponseDTO response=new ResponseDTO();
         response.setEntidadLocal(user);
         return response;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarMenu(RequestDTO request)
			throws DAOExcepcion {		
		Map<Long, Menu> retornoMap=null;		
        Query q = em.createQuery("from Menu ");     
         
         @SuppressWarnings("unchecked")
		List<Menu> lista = q.getResultList();
         if(lista!=null && !lista.isEmpty()){
             retornoMap=new HashMap<Long, Menu>();
        	 
        	 for (Menu menu : lista) {
        		 
        	     retornoMap.put(menu.getIdMenu(), menu);
			}
        	 
         }
         ResponseDTO response=new ResponseDTO();
         response.setParam(EParametro.Map, retornoMap);
         return response;
		
		
	}
}