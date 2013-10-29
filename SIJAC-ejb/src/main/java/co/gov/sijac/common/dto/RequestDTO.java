/**
 * 
 */
package co.gov.sijac.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.common.enums.IParametro;


/**
 * @author ENUNEZT
 * 
 */
@SuppressWarnings("serial")
public class RequestDTO extends BaseRequestResponseDTO implements Serializable {
	// private List<String> messages;
	private SettingsContext settingsContext;
	
	
	public RequestDTO() {
		super();
		param = new HashMap<IParametro, Object>();
	}

	public RequestDTO(SettingsContext settingsContext) {
		super();
		this.settingsContext = settingsContext;		
		param = new HashMap<IParametro, Object>();
	}
	public RequestDTO(SettingsContext settingsContext,PaginationDTO paginationDTO) {
		super();
		this.settingsContext = settingsContext;		
		param = new HashMap<IParametro, Object>();
		this.pagination=true;
		setParam(EParametro.Paginable, paginationDTO);
	}

	/**
	 * @return the param
	 */
	public Object getParam(IParametro param) {
		Object retorno = null;
		if (param != null)
			retorno = this.param.get(param);

		return retorno;
		// return messages;
	}
	
	/**
	 * 
	 * Returns true if this map contains a mapping for the specified key. 
	 * More formally, returns true if and only if this map contains a mapping 
	 * for a key k such that (key==null ? k==null : key.equals(k)). 
	 * (There can be at most one such mapping.)
	 * @return the param
	 */
	public boolean containParam(IParametro param) {
		boolean retorno = false;
		//if (param != null)
			retorno = this.param.containsKey(param);

		return retorno;
		// return messages;
	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void setParam(IParametro param, Object object) {

		this.param.put(param, object);

	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void removeParam(IParametro param) {
		// Object retorno=null;
		if (param != null/* && this.param.containsKey(param)*/)
			this.param.remove(param);

	}

	public String getDataSession() {

		return "IP:" ;//+ this.ipLocal + ";USR:" + this.usuario;
	}

	/**
	 * @return the settingsContext
	 */
	public SettingsContext getSettingsContext() {
	    return settingsContext;
	}

	/**
	 * @param settingsContext the settingsContext to set
	 */
	public void setSettingsContext(SettingsContext settingsContext) {
	    this.settingsContext = settingsContext;
	}

	/**
	 * @return the param
	 */
	public Map<IParametro, Object> getParams() {
	    return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParams(Map<IParametro, Object> params) {
	    this.param = params;
	}
	

	/**
	 * Retorna la entidad local utilizada en las clases genéricas
	 * @return the entidadLocal
	 */
	public Object getEntidadLocal() {
	    return getParam(EParametro.EntLocal);
	}

	/**
	 * Asigna la entidad local utilizada en las clases genéricas
	 * @param entidadLocal the entidadLocal to set
	 */
	public void setEntidadLocal(Object entidadLocal) {
	    setParam(EParametro.EntLocal, entidadLocal);;
	}

	/**
	 * @return the pagination
	 */
	public boolean isPagination() {
	    return pagination;
	}

	

	/**
	 * @return the paginationDTO
	 */
	public PaginationDTO getPaginationDTO() {
	    return (PaginationDTO) getParam(EParametro.Paginable);
	}

	/**
	 * @param paginationDTO the paginationDTO to set
	 */
	public void setPaginationDTO(PaginationDTO paginationDTO) {
	    this.pagination=true;
		setParam(EParametro.Paginable, paginationDTO);
	}


}
