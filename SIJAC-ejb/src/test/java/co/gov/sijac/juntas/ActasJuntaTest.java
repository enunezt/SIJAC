 
package co.gov.sijac.juntas;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.common.BaseTest;
import co.gov.sijac.juntas.facade.ActasJuntaFacade;
import co.gov.sijac.juntas.model.entidades.ActasJunta;
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
public class ActasJuntaTest extends BaseTest{	
	
	public ActasJuntaTest() {
		super();
		
			
		
	}
  static{
	  lst.add(co.gov.sijac.juntas.dao.impl.ActasJuntaDAOImpl.class);
	   lst.add(co.gov.sijac.juntas.dao.ActasJuntaDAO.class);
	   lst.add(co.gov.sijac.juntas.facade.impl.ActasJuntaFacadeImpl.class);
	   lst.add(co.gov.sijac.juntas.facade.ActasJuntaFacade.class);
	   lst.add(co.gov.sijac.juntas.model.entidades.ActasJunta.class);
	   lst.add(co.gov.sijac.juntas.services.impl.ActasJuntaServicioImpl.class);
	   lst.add(co.gov.sijac.juntas.services.ActasJuntaServicio.class);
	 
	   //lst.add(co.gov.sijac.juntas.ActasJuntaTest.class);
  }
  @Deployment
  public static Archive<?> createTestArchive() {
	  
	
     return ShrinkWrap.create(WebArchive.class, "test-ActasJunta.war")
           .addClasses(getListClazzes()) .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
           .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
           // Deploy our test datasource
           .addAsWebInfResource("test-ds.xml", "test-ds.xml");
  }

   @EJB
   ActasJuntaFacade ActasJuntaSrv; 
   
   @Inject
   Logger log;

   @Test
   public void testCrearActasJunta() throws Exception {
	   log.info("-------------------------TEST INI testCrearActasJunta-----------------------");
	   ActasJunta entActasJuntaTest=new ActasJunta();
	   //TODO: Completar entidad
	   RequestDTO req=new RequestDTO();
	   req.setEntidadLocal(entActasJuntaTest);
	   ResponseDTO resp= ActasJuntaSrv.crear(req);  
	   entActasJuntaTest= (ActasJunta) resp.getEntidadLocal();
	   
	   log.info(ActasJunta.class.getSimpleName()+" creado exitosamente");
		//assertNotNull(entActasJuntaTest.getIdActasJunta());
	 log.info("-------------------------TEST FIN testCrearActasJunta-----------------------");
   }
   
   @Test
   public void testConsultarActasJunta() throws Exception {
	   log.info("-------------------------TEST INI testConsultarActasJunta-----------------------");
	   ActasJunta entActasJuntaTest=new ActasJunta(); 
	    RequestDTO req=new RequestDTO();
	    req.setParam(EParametro.IdEntidadLocal, 1);
	   entActasJuntaTest=ActasJuntaSrv.buscarPorId(req);	   
	   log.info("-------------------------TEST FIN testConsultarActasJunta-----------------------");
   }
  
   
}