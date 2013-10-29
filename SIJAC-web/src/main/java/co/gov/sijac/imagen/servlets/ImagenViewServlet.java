package co.gov.sijac.imagen.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.gov.sijac.admin.facade.UsuarioFacade;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.common.util.StringUtils;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
import co.gov.sijac.image.facade.ImagenFacade;
import co.gov.sijac.image.model.entidades.Imagen;
@WebServlet("/images/*")
public class ImagenViewServlet extends HttpServlet {

   
    @Inject
    private ImagenFacade imagenSrv;
    @Inject
	protected Logger log;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String imageId = String.valueOf(request.getPathInfo().substring(1)); // Gets string that goes after "/images/".
       if(StringUtils.isNullorEmpty(imageId))
    	   return;
       
       Imagen img;
       byte[] data=null;

       BufferedInputStream input = null;
       BufferedOutputStream output = null;
	try {
	    RequestDTO reqDTO=new RequestDTO();
		 reqDTO.setParam(EParametro.Imagen, Long.valueOf(imageId));
		img = imagenSrv.consultarImagen(reqDTO/**/);
		data=img.getContent();
		response.setHeader("Content-Type", getServletContext().getMimeType(img.getNombre()));
	    response.setHeader("Content-Disposition", "inline; filename=\"" + img.getNombre() + "\"");

		InputStream in = new ByteArrayInputStream(data);
        input = new BufferedInputStream(in); // Creates buffered input stream.
        output = new BufferedOutputStream(response.getOutputStream());
        byte[] buffer = new byte[8192];
        for (int length = 0; (length = input.read(buffer)) > 0;) {
            output.write(buffer, 0, length);
        }
	} catch (NumberFormatException e) {
		log.log(Level.SEVERE, "Error consultando imagen", e);
	} catch (ServicioFacadeExcepcion e) {
	log.log(Level.SEVERE, "Error consultando imagen", e);
	} // Get Image from DB.
     finally {
            if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
            if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
        }
    
    }
}