package co.gov.sijac.admin.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import co.gov.sijac.admin.dao.PerfilDAO;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.admin.model.entidades.Perfil;
import co.gov.sijac.admin.model.entidades.PerfilOpcion;
import co.gov.sijac.admin.model.entidades.PerfilOpcionPK;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;

/**
 * Session Bean implementation class GEPerfil
 */
@Stateless
@Local(PerfilDAO.class)
@GestorEntidad(clase="PerfilDAOImpl",descripcion="Gestiona los perfiles del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PerfilDAOImpl extends GenericoDAO<Perfil> implements PerfilDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PerfilDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see PerfilDAO#consultarOpcionesDisponiblesPerfil(Perfil)
     */
    @Override
    @SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO consultarOpcionesDisponiblesPerfil(RequestDTO request) {
		/*CriteriaBuilder cb = em.getCriteriaBuilder();
		   CriteriaQuery<Opcion> criteria = cb.createQuery(Opcion.class);*/
	Perfil perfil=(Perfil) request.getEntidadLocal();
    	String criteria="FROM Opcion";
		List<Opcion> lista = em.createQuery(criteria).getResultList();
        
		
		ResponseDTO resp= consultarOpcionesPerfil(request);
		List<Opcion> listaOP =(List<Opcion>) resp.getParam(EParametro.ResultList);
		
         
         if(lista!=null && !lista.isEmpty() &&  listaOP!=null && !listaOP.isEmpty()){
        	 for (Opcion opPO : listaOP) {
        		 lista.remove(opPO);
        		/* if(!listaOP.contains(opPO)){
        			 listaTmp.add(opPO) ;
        		 }*/
			}
         } /*else{
        	 if(listaOP==null || listaOP.isEmpty() && lista!=null){
        		 listaTmp.addAll(lista);
        		 
        	 }
        	 
         }*/
         ResponseDTO response=new ResponseDTO();
         response.setParam(EParametro.ResultList, lista);
         return response;
	
	}

	/**
     * @see PerfilDAO#consultarOpcionesPerfil(Perfil)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO consultarOpcionesPerfil(RequestDTO request) {
		
		 List<Opcion> listReturn=new ArrayList<Opcion>();
		 Perfil perfil=(Perfil) request.getEntidadLocal();
        @SuppressWarnings("unchecked")
		List<PerfilOpcion> lista = em.createQuery("from PerfilOpcion where id_perfil="+perfil.getIdPerfil()).getResultList();;
        
        if(lista!=null && !lista.isEmpty()){
       	 for (PerfilOpcion perfilOpcion : lista) {
       			 listReturn.add(perfilOpcion.getOpcion());
			}
       	 
        } 
        ResponseDTO response=new ResponseDTO();
        response.setParam(EParametro.ResultList, listReturn);
        return response;
	}
    @Override
    public ResponseDTO actualizar(RequestDTO request) {   
	Perfil perfil=(Perfil) request.getEntidadLocal();
    	em.createQuery("delete PerfilOpcion where id_perfil="+perfil.getIdPerfil()).executeUpdate();    	
        ResponseDTO response=new ResponseDTO(em.merge(perfil));
        return response;

}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	

}
