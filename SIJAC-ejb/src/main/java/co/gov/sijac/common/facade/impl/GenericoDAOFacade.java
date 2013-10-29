package co.gov.sijac.common.facade.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.exception.DAOExcepcion;
import co.gov.sijac.exception.ServicioFacadeExcepcion;

@Stateless
public abstract class GenericoDAOFacade<T> implements GenericoFacadeInterface<T> {
	public GenericoDAOFacade() {
		// TODO Auto-generated constructor stub
	}
	public abstract GenericoDAOInterface<T> getServiceDAO();
	public ResponseDTO crear(RequestDTO entidad) throws ServicioFacadeExcepcion {
		try {
	return getServiceDAO().crear(entidad);
		} catch (DAOExcepcion e) {
		throw new ServicioFacadeExcepcion(e);
		}
		catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}
	public ResponseDTO actualizar(RequestDTO entidad) throws ServicioFacadeExcepcion {
		try {
			return getServiceDAO().actualizar(entidad);
		} catch (DAOExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}
		catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}
	public void eliminar(RequestDTO entidad) throws ServicioFacadeExcepcion {
		try {
			getServiceDAO().eliminar(entidad);
		} catch (DAOExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}
		catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}
	public T buscarPorId(RequestDTO id) throws ServicioFacadeExcepcion {
		try {
			return getServiceDAO().buscarPorId(id);
		} catch (DAOExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}
	
	public T buscarPorIdNamedQeryId(RequestDTO request) throws ServicioFacadeExcepcion {
		try {
			return getServiceDAO().buscarPorId(request);
		} catch (DAOExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}
	public ResponseDTO findWithNamedQuery(RequestDTO queryName)
			throws ServicioFacadeExcepcion {
		try {
			return getServiceDAO().findWithNamedQuery(queryName);
		} catch (DAOExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		} catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}
	
	
	public ResponseDTO buscarTodos(RequestDTO clazz) throws ServicioFacadeExcepcion {
		try {
			return getServiceDAO().buscarTodos(clazz);
		} catch (DAOExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		} catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}
	
	public ResponseDTO buscarPorEntidad(RequestDTO entidad) throws ServicioFacadeExcepcion {
		try {
			return getServiceDAO().buscarPorEntidad(entidad);
		} catch (DAOExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		} catch (Exception e) {
			throw new ServicioFacadeExcepcion(e);
			}
	}
	

}
