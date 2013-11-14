 
package co.gov.sijac.juntas;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.common.BaseTest;
import co.gov.sijac.juntas.facade.PersonaFacade;
import co.gov.sijac.juntas.model.entidades.Persona;
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
public class PersonaTest extends BaseTest{	
	
	public PersonaTest() {
		super();
		
			
		
	}
  static{
	  lst.add(co.gov.sijac.juntas.dao.impl.PersonaDAOImpl.class);
	   lst.add(co.gov.sijac.juntas.dao.PersonaDAO.class);
	   lst.add(co.gov.sijac.juntas.facade.impl.PersonaFacadeImpl.class);
	   lst.add(co.gov.sijac.juntas.facade.PersonaFacade.class);
	   lst.add(co.gov.sijac.juntas.model.entidades.Persona.class);
	   lst.add(co.gov.sijac.juntas.services.impl.PersonaServicioImpl.class);
	   lst.add(co.gov.sijac.juntas.services.PersonaServicio.class);
	 
	   //lst.add(co.gov.sijac.juntas.PersonaTest.class);
  }
  @Deployment
  public static Archive<?> createTestArchive() {
	  
	
     return ShrinkWrap.create(WebArchive.class, "test-Persona.war")
           .addClasses(getListClazzes()) .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
           .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
           // Deploy our test datasource
           .addAsWebInfResource("test-ds.xml", "test-ds.xml");
  }

   @EJB
   PersonaFacade PersonaSrv; 
   
   @Inject
   Logger log;

   @Test
   public void testCrearPersona() throws Exception {
	   log.info("-------------------------TEST INI testCrearPersona-----------------------");
	   Persona entPersonaTest=new Persona();
	   //TODO: Completar entidad
	   RequestDTO req=new RequestDTO();
	   req.setEntidadLocal(entPersonaTest);
	   ResponseDTO resp= PersonaSrv.crear(req);  
	   entPersonaTest= (Persona) resp.getEntidadLocal();
	   
	   log.info(Persona.class.getSimpleName()+" creado exitosamente");
		//assertNotNull(entPersonaTest.getIdPersona());
	 log.info("-------------------------TEST FIN testCrearPersona-----------------------");
   }
   
   @Test
   public void testConsultarPersona() throws Exception {
	   log.info("-------------------------TEST INI testConsultarPersona-----------------------");
	   Persona entPersonaTest=new Persona(); 
	    RequestDTO req=new RequestDTO();
	    req.setParam(EParametro.IdEntidadLocal, 1);
	   entPersonaTest=PersonaSrv.buscarPorId(req);	   
	   log.info("-------------------------TEST FIN testConsultarPersona-----------------------");
   }
  
   
}