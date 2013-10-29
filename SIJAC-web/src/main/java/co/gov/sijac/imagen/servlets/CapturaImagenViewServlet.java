package co.gov.sijac.imagen.servlets;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/imagescapture/*")
public class CapturaImagenViewServlet extends HttpServlet {

   
     /**
	 * 
	 */
	private static final long serialVersionUID = 1955578277632130753L;
	@Inject
	protected Logger log;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String image= String.valueOf(request.getPathInfo().substring(1)); // Gets string that goes after "/images/".
      
     Object dataVal=request.getSession().getAttribute(image);
     	if(dataVal==null)
     	   return;
       
     	
       byte[] data=(byte[]) dataVal;
       
       

       BufferedInputStream input = null;
       BufferedOutputStream output = null;
	try {
		//img = imagenSrv.consultarImagen(Long.valueOf(imageId));
		String str=getServletContext().getMimeType("jpg");
		
		response.setHeader("Content-Type", str);
	    response.setHeader("Content-Disposition", "inline; filename=\"" + image + "\"");
	 //  System.out.println( data.length);
		InputStream in = new ByteArrayInputStream(data);
        input = new BufferedInputStream(in); // Creates buffered input stream.
        output = new BufferedOutputStream(response.getOutputStream());
        byte[] buffer = new byte[8192];//8192
        for (int length = 0; (length = input.read(buffer)) > 0;) {
            output.write(buffer, 0, length);
        }
	} catch (NumberFormatException e) {
		log.log(Level.SEVERE, "Error consultando imagen", e);
	}
     finally {
            if (output != null) try { 
            	output.flush();
            	output.close(); 
            } catch (IOException logOrIgnore) {
            	
            }
            if (input != null) try {
            	input.close(); 
            } catch (IOException logOrIgnore) {
            	
            }            
          request.getSession().removeAttribute(image);
        }
    
    }
}