 
package co.gov.sijac.juntas;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.common.BaseTest;
import co.gov.sijac.juntas.facade.JuntaFacade;
import co.gov.sijac.juntas.model.entidades.Junta;
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
public class JuntaTest extends BaseTest{	
	
	public JuntaTest() {
		super();
		
			
		
	}
  static{
	  lst.add(co.gov.sijac.juntas.dao.impl.JuntaDAOImpl.class);
	   lst.add(co.gov.sijac.juntas.dao.JuntaDAO.class);
	   lst.add(co.gov.sijac.juntas.facade.impl.JuntaFacadeImpl.class);
	   lst.add(co.gov.sijac.juntas.facade.JuntaFacade.class);
	   lst.add(co.gov.sijac.juntas.model.entidades.Junta.class);
	   lst.add(co.gov.sijac.juntas.services.impl.JuntaServicioImpl.class);
	   lst.add(co.gov.sijac.juntas.services.JuntaServicio.class);
	 
	   //lst.add(co.gov.sijac.juntas.JuntaTest.class);
  }
  @Deployment
  public static Archive<?> createTestArchive() {
	  
	
     return ShrinkWrap.create(WebArchive.class, "test-Junta.war")
           .addClasses(getListClazzes()) .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
           .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
           // Deploy our test datasource
           .addAsWebInfResource("test-ds.xml", "test-ds.xml");
  }

   @EJB
   JuntaFacade JuntaSrv; 
   
   @Inject
   Logger log;

   @Test
   public void testCrearJunta() throws Exception {
	   log.info("-------------------------TEST INI testCrearJunta-----------------------");
	   Junta entJuntaTest=new Junta();
	   //TODO: Completar entidad
	   RequestDTO req=new RequestDTO();
	   req.setEntidadLocal(entJuntaTest);
	   ResponseDTO resp= JuntaSrv.crear(req);  
	   entJuntaTest= (Junta) resp.getEntidadLocal();
	   
	   log.info(Junta.class.getSimpleName()+" creado exitosamente");
		//assertNotNull(entJuntaTest.getIdJunta());
	 log.info("-------------------------TEST FIN testCrearJunta-----------------------");
   }
   
   @Test
   public void testConsultarJunta() throws Exception {
	   log.info("-------------------------TEST INI testConsultarJunta-----------------------");
	   Junta entJuntaTest=new Junta(); 
	    RequestDTO req=new RequestDTO();
	    req.setParam(EParametro.IdEntidadLocal, 1);
	   entJuntaTest=JuntaSrv.buscarPorId(req);	   
	   log.info("-------------------------TEST FIN testConsultarJunta-----------------------");
   }
  
   
}