/**
 * 
 */
package co.gov.sijac.exception;

/**
 * @author ENUNEZT
 *
 */
@SuppressWarnings("serial")
public class DAOExcepcion extends Exception {

	/**
	 * 
	 */
	public DAOExcepcion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DAOExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DAOExcepcion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DAOExcepcion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
