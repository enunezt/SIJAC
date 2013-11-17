package co.gov.sijac.common.util;

import java.util.ResourceBundle;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("deprecation")
public class FacesUtils {
	/**
	 * Get servlet context.
	 *
	 * @return the servlet context
	 */
	public static ServletContext getServletContext() {
		return (ServletContext)getCurrentInstancia().getExternalContext().getContext();
	}

    /*public static PortletContext getPortletContext() {
        return (PortletContext)getCurrentInstancia().getExternalContext().getContext();
    }

    public static ExternalContext getExternalCpntext() {
		return getCurrentInstancia().getExternalContext();
	}*/

	public static HttpServletResponse getServletResponse() {
		return (HttpServletResponse) getCurrentInstancia()
				.getExternalContext().getResponse();
	}


	
	
	/**
	 * Store the managed bean inside the session scope.
	 * 
	 * @param beanName the name of the managed bean to be stored
	 * @param managedBean the managed bean to be stored
	 */
	public static void setManagedBeanInSession(String beanName, Object managedBean) {
		getCurrentInstancia().getExternalContext().getSessionMap().put(beanName, managedBean);
	}
	
	/**
	 * Get parameter value from request scope.
	 * 
	 * @param name the name of the parameter
	 * @return the parameter value
	 */
	public static String getRequestParameter(String name) {
		return (String)getCurrentInstancia().getExternalContext().getRequestParameterMap().get(name);
	}


	
	/**
	 * Add information message.
	 * 
	 * @param msg the information message
	 */
	public static void addInfoMessage(String msg) {
		addInfoMessage(null, msg);
	}
	
	/**
	 * Add information message to a sepcific client.
	 * 
	 * @param clientId the client id 
	 * @param msg the information message
	 */
	public static void addInfoMessage(String clientId, String msg) {
		getCurrentInstancia().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	/**
	 * Add error message.
	 * 
	 * @param msg the error message
	 */
	public static void addErrorMessage(String msg) {
		addErrorMessage(null, msg);
	}
	
	/**
	 * Add error message to a sepcific client.
	 * 
	 * @param clientId the client id 
	 * @param msg the error message
	 */	
	public static void addErrorMessage(String clientId, String msg) {
		getCurrentInstancia().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}
	
	
	
	public static Application getApplication() {
		ApplicationFactory appFactory = (ApplicationFactory)FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
		return appFactory.getApplication(); 
	}
	
	public static ValueExpression getValueBinding(String el, Class<?> clazz) {		
 Application app = FacesUtils.getApplication();	    	 
     	 ExpressionFactory exprFactory = app.getExpressionFactory();
     	// getting the ELContext from faces context
     	
     	 ELContext elContext = getCurrentInstancia().getELContext();
     	 // creating value expression with the help of the expression factory and the ELContext
      	return  exprFactory.createValueExpression(elContext, el,clazz);
	}
	
	@SuppressWarnings("unused")
	public static HttpServletRequest getServletRequest() {
		return (HttpServletRequest)getCurrentInstancia().getExternalContext().getRequest();
	}
	
	public static Object getElValue(String elExpression, Class<?> clazz) {
			return getValueBinding(elExpression,clazz).getValue(getCurrentInstancia().getELContext());
	}
	

    public static String getMessageByKey(String key) {
        String messageBundleName = getCurrentInstancia().getApplication().getMessageBundle();
        ResourceBundle resourceBundle = ResourceBundle.getBundle(messageBundleName);

        try {
            return resourceBundle.getString(key);
        } catch (Exception e) {
            return key;
        }

    }
    
    public static void setSessionAttribute(String name,Object arg){    	
    	FacesContext ctx = getCurrentInstancia();
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
		request.getSession().setAttribute(name, arg);    	
    }
    public static Object getSessionAttribute(String name){    	
    	FacesContext ctx = getCurrentInstancia();
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
		return request.getSession().getAttribute(name);    	
    }
    public static void removeSessionAttribute(String name){    	
    	FacesContext ctx = getCurrentInstancia();
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
		request.getSession().removeAttribute(name);    	
    }
    
    public static FacesContext getCurrentInstancia(){
    return	FacesContext.getCurrentInstance();    	
    }
}
