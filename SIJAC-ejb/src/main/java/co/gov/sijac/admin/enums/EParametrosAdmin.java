/**
 * 
 */
package co.gov.sijac.admin.enums;

import co.gov.sijac.common.enums.IParametro;


/**
 * @author enunezt
 *
 */
public enum EParametrosAdmin implements IParametro {
	
    PerfilesDisponiblesUser ("PerfilesDisponiblesUser"),
    PerfilesUser ("PerfilesUser"),
    User ("User"),;//, OTRO(),....;

    private final String name; // in meters
    EParametrosAdmin(String name) {
   
        this.name = name;
    }

	@Override
	public String getName() {
		return this.name;
	}

}
