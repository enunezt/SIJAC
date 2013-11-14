 
package co.gov.sijac.juntas;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.common.BaseTest;
import co.gov.sijac.juntas.facade.LibroFacade;
import co.gov.sijac.juntas.model.entidades.Libro;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class LibroTest extends BaseTest{	
	
	public LibroTest() {
		super();
		
			
		
	}
  static{
	  lst.add(co.gov.sijac.juntas.dao.impl.LibroDAOImpl.class);
	   lst.add(co.gov.sijac.juntas.dao.LibroDAO.class);
	   lst.add(co.gov.sijac.juntas.facade.impl.LibroFacadeImpl.class);
	   lst.add(co.gov.sijac.juntas.facade.LibroFacade.class);
	   lst.add(co.gov.sijac.juntas.model.entidades.Libro.class);
	   lst.add(co.gov.sijac.juntas.services.impl.LibroServicioImpl.class);
	   lst.add(co.gov.sijac.juntas.services.LibroServicio.class);
	 
	   //lst.add(co.gov.sijac.juntas.LibroTest.class);
  }
  @Deployment
  public static Archive<?> createTestArchive() {
	  
	
     return ShrinkWrap.create(WebArchive.class, "test-Libro.war")
           .addClasses(getListClazzes()) .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
           .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
           // Deploy our test datasource
           .addAsWebInfResource("test-ds.xml", "test-ds.xml");
  }

   @EJB
   LibroFacade LibroSrv; 
   
   @Inject
   Logger log;

   @Test
   public void testCrearLibro() throws Exception {
	   log.info("-------------------------TEST INI testCrearLibro-----------------------");
	   Libro entLibroTest=new Libro();
	   //TODO: Completar entidad
	   RequestDTO req=new RequestDTO();
	   req.setEntidadLocal(entLibroTest);
	   ResponseDTO resp= LibroSrv.crear(req);  
	   entLibroTest= (Libro) resp.getEntidadLocal();
	   
	   log.info(Libro.class.getSimpleName()+" creado exitosamente");
		//assertNotNull(entLibroTest.getIdLibro());
	 log.info("-------------------------TEST FIN testCrearLibro-----------------------");
   }
   
   @Test
   public void testConsultarLibro() throws Exception {
	   log.info("-------------------------TEST INI testConsultarLibro-----------------------");
	   Libro entLibroTest=new Libro(); 
	    RequestDTO req=new RequestDTO();
	    req.setParam(EParametro.IdEntidadLocal, 1);
	   entLibroTest=LibroSrv.buscarPorId(req);	   
	   log.info("-------------------------TEST FIN testConsultarLibro-----------------------");
   }
  
   
}