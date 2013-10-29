package co.gov.sijac.imagen;

import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.MenuFacade;
import co.gov.sijac.admin.facade.OpcionFacade;
import co.gov.sijac.admin.model.entidades.Catalogo;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.common.BaseTest;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.image.facade.ImagenFacade;
import co.gov.sijac.image.model.entidades.EImagen;
import co.gov.sijac.image.model.entidades.ETipoImagen;
import co.gov.sijac.image.model.entidades.Imagen;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ImagenMenuTest extends BaseTest{
	
	public static String pathImage=getPath();
	
	
	public ImagenMenuTest() {
		super();
		
			
		
	}
	
	private static String getPath(){
		 String[] path=System.getProperty("java.class.path").split(";");
			pathImage=path[0]+"\\logo.png";
		return pathImage;
	}

	public static long idMenu=0;
  static{
	  lst.add(co.gov.sijac.image.dao.impl.ImagenDAOImpl.class);
	   lst.add(co.gov.sijac.image.dao.ImagenDAO.class);
	   lst.add(co.gov.sijac.image.facade.impl.ImagenFacadeImpl.class);
	   lst.add(co.gov.sijac.image.facade.ImagenFacade.class);
	   lst.add(co.gov.sijac.image.model.entidades.EImagen.class);
	   lst.add(co.gov.sijac.image.model.entidades.Imagen.class);
	   lst.add(co.gov.sijac.image.model.ImagenModel.class);
	   lst.add(co.gov.sijac.image.service.impl.ImagenServicioImpl.class);
	   lst.add(co.gov.sijac.image.service.ImagenServicio.class);
	 
	   //lst.add(co.gov.sijac.imagen.ImagenMenuTest.class);
  }
  @Deployment
  public static Archive<?> createTestArchive() {
	  
	/*
	String[] path=System.getProperty("java.class.path").split(";");
	pathImage=path[0]+"/logo.png";*/
     return ShrinkWrap.create(WebArchive.class, "test-img-SIJAC.war")
           .addClasses(getListClazzes()) .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
           .addAsResource(new File(pathImage), "logo.png")
           .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
           // Deploy our test datasource
           .addAsWebInfResource("test-ds.xml", "test-ds.xml");
  }

   @EJB
   ImagenFacade imagenSrv;
 
   @Inject
   Logger log;


   @Test
   public void testCrearImagen() throws Exception {
	   log.info("-------------------------TEST INI testCrearImagen-----------------------");	  
	  
	   //this.getClass().getResource("\\logo.png").getPath() D:\jboss-as-7.1.1.Final\jboss-modules.jar\logo.png
	  // String path=new ImagenMenuTest().getClass().getClassLoader().getResource("logo.png");
	   File file = new File("c:\\logo.png");
	   byte[] bFile = new byte[(int) file.length()];
	   
	   try {
	   FileInputStream fileInputStream = new FileInputStream(file);
	   fileInputStream.read(bFile);
	   fileInputStream.close();
	   } catch (Exception e) {
	   	   log.log(Level.SEVERE, "testCrearOpcion", e);
	   }
	   Imagen img=new Imagen();
	   img.setIdEntidad(1L);
	   img.setNombre("imagenPart-"+1);
	   img.setTipo(EImagen.IMAGEN);
	   img.setFechaRegistro(new Date());
	   img.setExtension(ETipoImagen.jpg);
	   img.setContent(bFile); 
	   
	   RequestDTO req=new RequestDTO();
	   req.setEntidadLocal(img);
	   imagenSrv.crear(req) ;
	   log.info(img.getNombre()+ " creado exitosamente  numero " + img.getIdImagen());
		assertNotNull(img.getIdImagen());
	   
	/*  int maxTamanio=255;//bFile.length;
	   int pk=0;
	   int byt=0;
	   int maxbyt=maxTamanio;
	   List<byte[]> lstBytes=new ArrayList<byte[]>();
	   
	   byte[] bFilePart=new byte[maxbyt];
	   while (byt<bFile.length) {		 
		  
		   int pos=0;
		  for (int i = byt; i < maxbyt; i++) {
			  if(bFile.length<=i){
				  break;
			  }
			  bFilePart[pos++] =bFile[i];
				   }
		  System.out.println(bFilePart.length); 
		  lstBytes.add(pk++,bFilePart);
		  byt=maxbyt;
		  maxbyt=maxbyt+maxTamanio;
		  
		  bFilePart=new byte[byt];
		  
		  if((bFile.length-byt)>0 && (bFile.length-byt)<maxTamanio){
			   bFilePart=new byte[(bFile.length-byt)];
		   }
		  
	}
	  for (int i = 0; i < pk; i++) {
		    img=new Imagen();
		   img.setIdEntidad(1L);
		   img.setNombre("imagenPart-"+ (i+1));
		   img.setTipo(EImagen.IMAGEN);
		   img.setFechaRegistro(new Date());
		   img.setContent(lstBytes.get(i));
		  
			   imagenSrv.crear(img) ;
			   log.info(img.getNombre()+ " creado exitosamente  numero " + img.getId());
				assertNotNull(img.getId());
				
		
	}*/
	
	   
	
	
	 log.info("-------------------------TEST FIN testCrearImagen-----------------------");
     // assertNotNull(newMember.getId());
  
	   //System.out.println("-------------------------TEST FIN-----------------------");
   }
   
   @Test
   public void testConsultarImagen() throws Exception {
	   log.info("-------------------------TEST INI testConsultarImagen -----------------------");		  
	
	  
	   RequestDTO req=new RequestDTO();
	   req.setParam(EParametro.Imagen, 1L);
	  Imagen imgsrc=  imagenSrv.consultarImagen(req);
		try {
			 byte[] imageInByte= imgsrc.getContent();		
 
			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(imageInByte);
			BufferedImage bImageFromConvert = ImageIO.read(in);
 
			ImageIO.write(bImageFromConvert, "jpg", new File(
					"c:/new-log.jpg"));
 
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		 log.info("-------------------------TEST FIN testConsultarImagen-----------------------");
   }
  
   
}
