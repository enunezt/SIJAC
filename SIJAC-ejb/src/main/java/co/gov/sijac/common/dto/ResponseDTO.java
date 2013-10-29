/**
 * 
 */
package co.gov.sijac.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import co.gov.sijac.common.enums.IParametro;


/**
 * @author Edgar
 * 
 */
@SuppressWarnings("serial")
public class ResponseDTO extends BaseRequestResponseDTO  implements Serializable {
	
	//private Map<IParametro, Object> param;

	public ResponseDTO() {
		super();
		param = new HashMap<IParametro, Object>();
	}
	
	public ResponseDTO(Object entidadLocal) {
		super();
		param = new HashMap<IParametro, Object>();
		setEntidadLocal(entidadLocal);
	}
	
}
