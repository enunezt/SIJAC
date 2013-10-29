package co.gov.sijac.admin;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.MenuFacade;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.common.BaseTest;
import co.gov.sijac.common.dto.RequestDTO;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GestionMenuTest extends BaseTest{
	
	public static long idMenu=0;
 
	 @Deployment
	   public static Archive<?> createTestArchive() {
	      return ShrinkWrap.create(WebArchive.class, "test-SIJAC.war")
	            .addClasses(getListClazzes())
	            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
	            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
	            // Deploy our test datasource
	            .addAsWebInfResource("test-ds.xml", "test-ds.xml");
	   }

   @EJB
   MenuFacade menuSrv;

   @Inject
   Logger log;


   @Test
   public void testCrearMenu() throws Exception {
	   System.out.println("-------------------------TEST INI -----------------------");
	   Menu menu=new Menu();
	 // menu.setId(0L);
	   menu.setDescripcion("Test-Crear-Menu");
	   menu.setNombre("Test-Nombre-Menu");
	   RequestDTO req=new RequestDTO();
	   req.setEntidadLocal(menu);
	   menuSrv.crear(req);
	   //ResponseDTO resp= opcionSrv.crear(req);
	   log.info(menu.getNombre() + " creado exitosamente  numero " + menu.getIdMenu());
	   assertNotNull(menu.getIdMenu());
	
	 System.out.println("-------------------------TEST FIN-----------------------");
     // assertNotNull(newMember.getId());
  
	   //System.out.println("-------------------------TEST FIN-----------------------");
   }
  
   
}
