package co.gov.sijac.admin;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.MenuFacade;
import co.gov.sijac.admin.facade.OpcionFacade;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.common.BaseTest;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class OpcionMenuTest extends BaseTest{
	
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
   OpcionFacade opcionSrv;
   @EJB
   MenuFacade menuSrv;

   @Inject
   Logger log;


   @Test
   public void testCrearOpcion() throws Exception {
	   System.out.println("-------------------------TEST INI -----------------------");
	   Opcion opcion=new Opcion();
	  // INSERT INTO `opcion` VALUES (1,'/pgadmin/gestionarUsuario.jsf',2,1,NULL),(2,'/pgadmin/gestionarPerfil.jsf',4,1,NULL),(3,'/pgadmin/gestionarOpcion.jsf',6,1,NULL),(4,'/pgadmin/gestionarMenu.jsf',7,1,NULL),(5,'/pages/gestionarEnte.jsf',8,1,NULL),(6,'/pages/gestionarBalance.jsf',9,1,NULL),(7,'/pages/gestionarCuentasPuc.jsf',10,1,NULL),(8,'/pages/gestionarFormato.jsf',12,1,NULL),(9,'/pages/gestionarCasilla.jsf',13,1,NULL);
	   opcion.setUrl("/pgadmin/gestionarUsuario.jsf");
	   Menu menu=new Menu();
		 // menu.setId(0L);
		   menu.setDescripcion("Test-Crear-Menu");
		   menu.setNombre("Test-Nombre-Menu");
		   
		   RequestDTO req=new RequestDTO();
		   req.setEntidadLocal(menu);
		   menuSrv.crear(req);
		   opcion.setMenu(menu);
		   opcion.setTipo(1);
		   opcion.setFecCambio(new Date());
		   req=new RequestDTO();
		   req.setEntidadLocal(opcion);
		  ResponseDTO resp= opcionSrv.crear(req);
		  opcion= (Opcion) resp.getEntidadLocal();
		   log.info(opcion.getUrl()+ " creado exitosamente  numero " + opcion.getIdOpcion());
		   assertNotNull(opcion.getIdOpcion());
	
	 System.out.println("-------------------------TEST FIN-----------------------");
     // assertNotNull(newMember.getId());
  
	   //System.out.println("-------------------------TEST FIN-----------------------");
   }
  
   
}
