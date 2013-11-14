 
package co.gov.sijac.juntas;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.common.BaseTest;
import co.gov.sijac.juntas.facade.ComiteFacade;
import co.gov.sijac.juntas.model.entidades.Comite;
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
public class ComiteTest extends BaseTest{	
	
	public ComiteTest() {
		super();
		
			
		
	}
  static{
	  lst.add(co.gov.sijac.juntas.dao.impl.ComiteDAOImpl.class);
	   lst.add(co.gov.sijac.juntas.dao.ComiteDAO.class);
	   lst.add(co.gov.sijac.juntas.facade.impl.ComiteFacadeImpl.class);
	   lst.add(co.gov.sijac.juntas.facade.ComiteFacade.class);
	   lst.add(co.gov.sijac.juntas.model.entidades.Comite.class);
	   lst.add(co.gov.sijac.juntas.services.impl.ComiteServicioImpl.class);
	   lst.add(co.gov.sijac.juntas.services.ComiteServicio.class);
	 
	   //lst.add(co.gov.sijac.juntas.ComiteTest.class);
  }
  @Deployment
  public static Archive<?> createTestArchive() {
	  
	
     return ShrinkWrap.create(WebArchive.class, "test-Comite.war")
           .addClasses(getListClazzes()) .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
           .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
           // Deploy our test datasource
           .addAsWebInfResource("test-ds.xml", "test-ds.xml");
  }

   @EJB
   ComiteFacade ComiteSrv; 
   
   @Inject
   Logger log;

   @Test
   public void testCrearComite() throws Exception {
	   log.info("-------------------------TEST INI testCrearComite-----------------------");
	   Comite entComiteTest=new Comite();
	   //TODO: Completar entidad
	   RequestDTO req=new RequestDTO();
	   req.setEntidadLocal(entComiteTest);
	   ResponseDTO resp= ComiteSrv.crear(req);  
	   entComiteTest= (Comite) resp.getEntidadLocal();
	   
	   log.info(Comite.class.getSimpleName()+" creado exitosamente");
		//assertNotNull(entComiteTest.getIdComite());
	 log.info("-------------------------TEST FIN testCrearComite-----------------------");
   }
   
   @Test
   public void testConsultarComite() throws Exception {
	   log.info("-------------------------TEST INI testConsultarComite-----------------------");
	   Comite entComiteTest=new Comite(); 
	    RequestDTO req=new RequestDTO();
	    req.setParam(EParametro.IdEntidadLocal, 1);
	   entComiteTest=ComiteSrv.buscarPorId(req);	   
	   log.info("-------------------------TEST FIN testConsultarComite-----------------------");
   }
  
   
}