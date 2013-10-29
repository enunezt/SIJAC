/*
+ * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.gov.sijac.imagen.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;
import javax.xml.ws.WebServiceException;

import co.gov.sijac.common.constantes.IConstantes;
import co.gov.sijac.common.controller.BaseController;
import co.gov.sijac.common.util.FacesUtils;
import co.gov.sijac.image.facade.ImagenFacade;
import org.primefaces.event.CaptureEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.StreamedContent;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation

@ManagedBean(name ="imagenController")
@ViewScoped
public class ImagenController extends BaseController{   
	
    @Inject
    private ImagenFacade imagenServicio;    
    private byte[] data;
    private StreamedContent image;	
	private List<String> photos = new ArrayList<String>();  
	private int countFotos;
	private String photo;
	private String photoRecorte;
	
	private byte[] dataSelect;
	
	private CroppedImage croppedImage;  
	

public ImagenController() {
		
	}


/**
 * usado en el boton select de cada tabla en el formulario para selcción de entidades
 * @param event
 */
//@SuppressWarnings("unchecked")
public void doSelectImagenListener(ActionEvent event) {
	 
	 String att=(String) event.getComponent().getAttributes().get("attImagenBckBeanOrigen");
	 if(att!=null && dataSelect!=null){
		 setValueExpression(att,dataSelect);
		FacesUtils.setSessionAttribute(photoRecorte, dataSelect);
	
	 }
	   
	}

	public void oncapture(CaptureEvent captureEvent) {  
      
        this.photos.clear();
      int contTmp=countFotos++; 
     photo=IConstantes.FOTO_CAPTURA+contTmp;
      data = captureEvent.getData(); 
     // FacesUtils.removeSessionAttribute(IConstantes.FOTO_CAPTURA+(contTmp-1));
      FacesUtils.setSessionAttribute(photo, data);
      this.photos.add(0,photo);  
      
      
      ServletContext servletContext = FacesUtils.getServletContext();  
      String newFileName = servletContext.getRealPath("/") + File.separator + "resources" + File.separator + getPhoto()+ ".jpg";  
        
      FileImageOutputStream imageOutput;  
      try {  
          imageOutput = new FileImageOutputStream(new File(newFileName));  
          imageOutput.write(data, 0, data.length);  
          imageOutput.close();  
      } catch (FileNotFoundException e) {  
         throw new WebApplicationException(Status.NO_CONTENT);
      } catch (IOException e) {  
    	  throw new WebApplicationException(Status.NO_CONTENT);
      }  
       // ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
  //      String newFileName = servletContext.getRealPath("") + File.separator + "resources" + File.separator + photo + ".png";  
        
     /*   Imagen img=new Imagen();
 	   img.setIdEntidad(1L);
 	   img.setNombre("foto"+1);
 	   img.setTipo(EImagen.FOTO);
 	   img.setFechaRegistro(new Date());
 	   img.setExtension(ETipoImagen.jpg);
 	   img.setContent(data); 
 	   
 	  try {
		imagenServicio.crear(img);
	} catch ( Exception e) {
		//log.log(Level.SEVERE, "Error Creando Imagen", e);
		addErrorMessage(e);
	} 
     */
    }  
    
 public void obtenerImagen(){
	 
	 
 }

/**
 * TODO: Pendiente porque no funcionó  StreamedContent
 * @return
 */

public StreamedContent getImage() {
	/*
	FacesContext context = FacesContext.getCurrentInstance();

    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
        return new DefaultStreamedContent();
    }
    else {
        // So, browser is requesting the image. Get ID value from actual request param.
        String id = context.getExternalContext().getRequestParameterMap().get("id");
       
    
	
        if (data!=null && image==nulltrue)
        {
        	
        	ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        	//  InputStream inputStream = contextClassLoader.getResourceAsStream("resources/images/Photo - 0.png");
        	 
        	 //  InputStream is = new ByteArrayInputStream(data);
          
               // image= new DefaultStreamedContent(is,"image/png");
               
                BufferedImage imageBuffer = null;
             //  ByteArrayInputStream in = new ByteArrayInputStream(data);
                try {
				//	imageBuffer = ImageIO.read(in);
				
              //  ByteArrayOutputStream os = new ByteArrayOutputStream();
             //   ImageIO.write(imageBuffer, "png", os);
                
              //Barcode  
                File barcodeFile = new File("dynamicbarcode");  
                BarcodeImageHandler.saveJPEG(BarcodeFactory.createCode128("PRIMEFACES"), barcodeFile);  
                image = new DefaultStreamedContent(new FileInputStream(barcodeFile), "image/jpeg");  
               // image=new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");
                } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (OutputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BarcodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
    }*/
	return image;
}

public String crop() {  
    if(croppedImage == null)  
        return null;  
    
    
     // 
       photoRecorte="FotoRecorte"+countFotos++;
	  FacesUtils.setSessionAttribute(photoRecorte, croppedImage.getBytes() );
	  dataSelect=croppedImage.getBytes();
      
   
      
    return null;  
}


public void setImage(StreamedContent image) {
	this.image = image;
}  
   
public byte[] getData() {
	return data;
}



public void setData(byte[] data) {
	this.data = data;
}



public String getPhoto() {
	return photo;
}



public void setPhoto(String photo) {	
	this.photo = photo;
}



public List<String> getPhotos() {  
   return photos;  
}      
 

public CroppedImage getCroppedImage() {  
    return croppedImage;  
}  

public void setCroppedImage(CroppedImage croppedImage) {  
    this.croppedImage = croppedImage;  
} 


public String getPhotoRecorte() {
	return photoRecorte;
}


public void setPhotoRecorte(String photoRecorte) {
	this.photoRecorte = photoRecorte;
}


	
}
