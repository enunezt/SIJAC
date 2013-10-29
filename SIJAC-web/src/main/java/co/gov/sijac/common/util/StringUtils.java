package co.gov.sijac.common.util;

public class StringUtils {
	
	/**
	 * Verificas si un string es null o vacio
	 * @param org
	 * @return
	 */
	public static boolean isNullorEmpty(String arg){		
		if(arg==null || "".equals(arg) || "null".equals(arg))
			return true;
		return false;
		
	}

}
