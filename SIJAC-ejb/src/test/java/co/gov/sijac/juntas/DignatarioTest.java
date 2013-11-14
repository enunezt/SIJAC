 
package co.gov.sijac.juntas;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.common.BaseTest;
import co.gov.sijac.juntas.facade.DignatarioFacade;
import co.gov.sijac.juntas.model.entidades.Dignatario;
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
public class DignatarioTest extends BaseTest{	
	
	public DignatarioTest() {
		super();
		
			
		
	}
  static{
	  lst.add(co.gov.sijac.juntas.dao.impl.DignatarioDAOImpl.class);
	   lst.add(co.gov.sijac.juntas.dao.DignatarioDAO.class);
	   lst.add(co.gov.sijac.juntas.facade.impl.DignatarioFacadeImpl.class);
	   lst.add(co.gov.sijac.juntas.facade.DignatarioFacade.class);
	   lst.add(co.gov.sijac.juntas.model.entidades.Dignatario.class);
	   lst.add(co.gov.sijac.juntas.services.impl.DignatarioServicioImpl.class);
	   lst.add(co.gov.sijac.juntas.services.DignatarioServicio.class);
	 
	   //lst.add(co.gov.sijac.juntas.DignatarioTest.class);
  }
  @Deployment
  public static Archive<?> createTestArchive() {
	  
	
     return ShrinkWrap.create(WebArchive.class, "test-Dignatario.war")
           .addClasses(getListClazzes()) .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
           .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
           // Deploy our test datasource
           .addAsWebInfResource("test-ds.xml", "test-ds.xml");
  }

   @EJB
   DignatarioFacade DignatarioSrv; 
   
   @Inject
   Logger log;

   @Test
   public void testCrearDignatario() throws Exception {
	   log.info("-------------------------TEST INI testCrearDignatario-----------------------");
	   Dignatario entDignatarioTest=new Dignatario();
	   //TODO: Completar entidad
	   RequestDTO req=new RequestDTO();
	   req.setEntidadLocal(entDignatarioTest);
	   ResponseDTO resp= DignatarioSrv.crear(req);  
	   entDignatarioTest= (Dignatario) resp.getEntidadLocal();
	   
	   log.info(Dignatario.class.getSimpleName()+" creado exitosamente");
		//assertNotNull(entDignatarioTest.getIdDignatario());
	 log.info("-------------------------TEST FIN testCrearDignatario-----------------------");
   }
   
   @Test
   public void testConsultarDignatario() throws Exception {
	   log.info("-------------------------TEST INI testConsultarDignatario-----------------------");
	   Dignatario entDignatarioTest=new Dignatario(); 
	    RequestDTO req=new RequestDTO();
	    req.setParam(EParametro.IdEntidadLocal, 1);
	   entDignatarioTest=DignatarioSrv.buscarPorId(req);	   
	   log.info("-------------------------TEST FIN testConsultarDignatario-----------------------");
   }
  
   
}