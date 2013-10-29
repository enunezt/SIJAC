 
	
package co.gov.sijac.admin.lugares.services.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.lugares.dao.CiudadDAO;
import co.gov.sijac.admin.lugares.dao.DepartamentoDAO;
import co.gov.sijac.admin.lugares.dao.PaisDAO;
import co.gov.sijac.admin.lugares.model.entidades.Departamento;
import co.gov.sijac.admin.lugares.model.entidades.Pais;
import co.gov.sijac.admin.lugares.services.LugaresServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.exception.DAOExcepcion;
import co.gov.sijac.exception.ServicioExcepcion;

@Stateless
@Local(LugaresServicio.class)
@Servicio(clase="PaisServicioImpl",descripcion="Implementacion Logica de negocio de Lugares")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class LugaresServicioImpl implements LugaresServicio{
    
    @Inject
	PaisDAO paisDAO;
    
    @Inject
   	DepartamentoDAO departamentoDAO;
    
    @Inject
   	CiudadDAO ciudadDAO;

    /* (non-Javadoc)
     * @see co.gov.sijac.admin.lugares.model.LugaresModel#consultarPaises(co.gov.sijac.common.dto.RequestDTO)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO consultarPaises(RequestDTO request)
	    throws ServicioExcepcion {
	try {
	    request.setParam(EParametro.NamedQuery,"Pais.findAll");
	    return paisDAO.findWithNamedQuery(request);
	} catch (DAOExcepcion e) {
		throw new ServicioExcepcion(e);
	} catch (Exception e) {
			throw new ServicioExcepcion(e);
		}
    }

    /* (non-Javadoc)
     * @see co.gov.sijac.admin.lugares.model.LugaresModel#consultarDepartamentos(co.gov.sijac.common.dto.RequestDTO)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO consultarDepartamentos(RequestDTO request)
	    throws ServicioExcepcion {
	try {
	    
	    Map<String,Object> parameters=new HashMap<String, Object>();
	    Pais idPais=new Pais();
	    idPais.setIdPais((Integer)request.getParam(EParametro.IdEntidad));	    
		parameters.put("idPais",idPais);
		
		request.setParam(EParametro.NamedQuery,"Departamento.findByPais");
		request.setParam(EParametro.ParemtrosQuery,parameters);
		return departamentoDAO.findWithNamedQuery(request);
	} catch (DAOExcepcion e) {
		throw new ServicioExcepcion(e);
	} catch (Exception e) {
			throw new ServicioExcepcion(e);
		}
    }

    /* (non-Javadoc)
     * @see co.gov.sijac.admin.lugares.model.LugaresModel#consultarCiudades(co.gov.sijac.common.dto.RequestDTO)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO consultarCiudades(RequestDTO request)
	    throws ServicioExcepcion {
	try {
	    Departamento idDepartamento=new Departamento();
	    idDepartamento.setIdDepartamento((Integer)request.getParam(EParametro.IdEntidad));	    
	    Map<String,Object> parameters=new HashMap<String, Object>();
		parameters.put("idDepartamento", idDepartamento);
         	request.setParam(EParametro.NamedQuery,"Ciudad.findByDepartamento");
		request.setParam(EParametro.ParemtrosQuery,parameters);
	    return ciudadDAO.findWithNamedQuery(request);
	} catch (DAOExcepcion e) {
		throw new ServicioExcepcion(e);
	} catch (Exception e) {
			throw new ServicioExcepcion(e);
		}
    }

    /* (non-Javadoc)
     * @see co.gov.sijac.admin.lugares.model.LugaresModel#consultarComunas(co.gov.sijac.common.dto.RequestDTO)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO consultarComunas(RequestDTO request)
	    throws ServicioExcepcion {
	/*try {
	    
		    Map<String,Object> parameters=new HashMap<String, Object>();
			parameters.put("idEntidad", (Long)request.getParam(EParametro.IdEntidad));
			parameters.put("tipo", (EParametro)request.getParam(EParametro.ImagenTipo));

			
			request.setParam(EParametro.NamedQuery,"Imagen.findByEnte");
			request.setParam(EParametro.ParemtrosQuery,parameters);
			
			ResponseDTO resp=imagenDAO.findWithNamedQuery(request);
			
			
			//Imagen.findById
			Set<Imagen> ret=null;
			@SuppressWarnings("unchecked")
			List<Imagen> lst=(List<Imagen>) resp.getParam(EParametro.ResultList);
			
			if(lst!=null && !lst.isEmpty()){				
				ret=new HashSet<Imagen>(lst);
				for (Imagen imagen : ret) {
					imagen.getContent();
				}
			}			
			ResponseDTO retorno=new ResponseDTO();
			retorno.setParam(EParametro.Set, ret);
			return retorno;
			
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
				throw new ServicioExcepcion(e);
			}*/
	
	return null;
    }

    /* (non-Javadoc)
     * @see co.gov.sijac.admin.lugares.model.LugaresModel#consultarBarrios(co.gov.sijac.common.dto.RequestDTO)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO consultarBarrios(RequestDTO request)
	    throws ServicioExcepcion {
	// TODO Auto-generated method stub
	return null;
    } 
}
