package co.gov.sijac.common.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ReferencedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import co.gov.sijac.common.dto.SettingsContext;
import co.gov.sijac.common.util.FacesUtils;

@ReferencedBean
public class BaseController {
	 //public static final String PUSH_CDI_TOPIC = "pushCdi";
		@Inject
		protected Logger log;
		
		protected SettingsContext context;
		
		protected final String outcome ="/index.jsf"; // Do your thing?

	    @Inject
	    protected FacesContext facesContext;
	public BaseController() {
		if(context==null){		
		context= (SettingsContext)FacesUtils.getSessionAttribute("settCtx");
		
		}
	}
	
	@PostConstruct
	protected void verificarContextoSesion(){
	    

		if(context==null && facesContext!=null){
		    
		    addInfoMessage("Sesión Expirada","Ingrese al sistema con su usuario y contraseña");
		    ExternalContext ctx = facesContext.getExternalContext();
		    String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
		    String ipLocal=((ServletRequest) ctx.getRequest()).getLocalAddr();
		    String nameLocal=((ServletRequest) ctx.getRequest()).getLocalName();
		    
		    String view=ctx.getRequestServletPath();
		        try {
		          
			   if(!outcome.equals(view) && !"/login.jsf".equals(view))
			    ctx.redirect(ctxPath);
			    
			} catch (IOException e) {
			log.severe(e.getMessage());
			}
		        catch (IllegalStateException e) {
				log.severe(e.toString() +" -> Se intentó ingresar ilegalmenta a :"+view+ipLocal);
				}
		}
	    
	}
	
	public void logout() {
	    ExternalContext ctx = facesContext.getExternalContext();
	    String ctxPath = 
	        ((ServletContext) ctx.getContext()).getContextPath();

	    try {
	      // Usar el contexto de JSF para invalidar la sesión,
	      // NO EL DE SERVLETS (nada de HttpServletRequest)
	      ((HttpSession) ctx.getSession(false)).invalidate();

	      // Redirección de nuevo con el contexto de JSF,
	      // si se usa una HttpServletResponse fallará.
	      // Sin embargo, como ya está fuera del ciclo de vida 
	      // de JSF se debe usar la ruta completa -_-U
	      ctx.redirect(ctxPath + outcome);
	    } catch (IOException ex) {
		log.severe(ex.getMessage());
	    }
	  }
	
	  /**
     * Añade un mensaje de error a la jeraquia de componetes de la página JSF
     * @param mensaje
     */
   
    public  void addErrorMessage(String msg,String msgDetalle) {
		 facesContext.addMessage(null,
                 new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msgDetalle));
	}
    
    /**
     * Añade un mensaje de error a la jeraquia de componetes de la página JSF
     * @param mensaje
     */
   
    public  void addErrorMessage(Exception e) {
    	
    	 String errorMessage = getRootErrorMessage(e);
         FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, e.getMessage());
         facesContext.addMessage(null, m);
         log.log(Level.SEVERE, errorMessage, e);
	}
    
    
    
    /**
	 * Add information message to a sepcific client.
	 * 
	 * @param msg the information message
	 */
	public  void addInfoMessage(String msg,String msgDetalle) {
		 facesContext.addMessage(null,
                 new FacesMessage(FacesMessage.SEVERITY_INFO, msgDetalle, msg));
	}
	
	

    protected String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }
    
    /**
     *  creating value expression with the help of the expression factory and the ELContext
     * @param expressionAtt
     * @param value
     */
    public void setValueExpression(String expressionAtt,byte[] value){
   	 Application app = FacesContext.getCurrentInstance().getApplication();		 
   	 
   	 ExpressionFactory exprFactory = app.getExpressionFactory();
   	// getting the ELContext from faces context
   	 ELContext elContext = FacesContext.getCurrentInstance().getELContext();
   	 // creating value expression with the help of the expression factory and the ELContext

   	 ValueExpression valExpr = exprFactory.createValueExpression(elContext, "#{"+ expressionAtt+"}",value.getClass() );
   	 valExpr.setValue(elContext,value);
   	 

   	 
    }
  
    public static String downloadFile( byte[] imageInByte/*String url*/) {
        FileOutputStream file = null;
        String filePath = "";
        try {
              //  URL p = new URL(url);
                
                InputStream in = new ByteArrayInputStream(imageInByte);

                BufferedInputStream bin = new BufferedInputStream(in);

                filePath = System.getProperty("java.io.tmpdir") + "imgWebApp";
                System.out.println("Ruta Archivo:-->"+filePath);
                String _filePath = filePath.replaceAll("/", File.separator + File.separator);
                File f = new File(_filePath);
                f.getParentFile().mkdirs();

                file = new FileOutputStream(f);
                BufferedOutputStream out = new BufferedOutputStream(file);

                for (int b; (b = bin.read()) != -1; ) {
                        out.write(b);
                }

                out.flush();
                file.close();
                bin.close();

                return _filePath;
        } catch (Exception e) {
                throw new RuntimeException("Download file failed.  " + e.getMessage(), e);
        }
}
	
    public SettingsContext getContext() {
		return context;
	}

	public void setContext(SettingsContext context) {
		this.context = context;
	}

}
