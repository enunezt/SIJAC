 
package co.gov.sijac.admin;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.CatalogoFacade;
import co.gov.sijac.admin.model.entidades.Catalogo;
import co.gov.sijac.common.BaseTest;
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
public class CatalogoTest extends BaseTest{	
	
	public CatalogoTest() {
		super();
		
			
		
	}
  static{
	  lst.add(co.gov.sijac.admin.dao.impl.CatalogoDAOImpl.class);
	   lst.add(co.gov.sijac.admin.dao.CatalogoDAO.class);
	   lst.add(co.gov.sijac.admin.dao.impl.CatalogoDetalleDAOImpl.class);
	   lst.add(co.gov.sijac.admin.dao.CatalogoDetalleDAO.class);
	   lst.add(co.gov.sijac.admin.facade.impl.CatalogoFacadeImpl.class);
	   lst.add(co.gov.sijac.admin.facade.CatalogoFacade.class);
	   lst.add(co.gov.sijac.admin.model.entidades.Catalogo.class);
	   lst.add( co.gov.sijac.admin.model.entidades.CatalogoDetalle.class);	  
	   lst.add(co.gov.sijac.admin.services.catalogo.impl.CatalogoServicioImpl.class);
	   lst.add(co.gov.sijac.admin.services.catalogo.CatalogoServicio.class);
	 
	   //lst.add(co.gov.sijac.admin.CatalogoTest.class);
  }
  @Deployment
  public static Archive<?> createTestArchive() {
	  
	
     return ShrinkWrap.create(WebArchive.class, "test-Catalogo.war")
           .addClasses(getListClazzes()) .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
           .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
           // Deploy our test datasource
           .addAsWebInfResource("test-ds.xml", "test-ds.xml");
  }

   @EJB
   CatalogoFacade CatalogoSrv; 
   
   @Inject
   Logger log;

   @Test
   public void testCrearCatalogo() throws Exception {
	   log.info("-------------------------TEST INI testCrearCatalogo-----------------------");
	/*   Catalogo entCatalogoTest=new Catalogo();
	   //TODO: Completar entidad
	   RequestDTO req=new RequestDTO();
	   req.setEntidadLocal(entCatalogoTest);
	   CatalogoSrv.crear(req);
	   log.info(Catalogo.class.getSimpleName()+" creado exitosamente");
		assertNotNull(entCatalogoTest.getIdCatalogo());*/
	 log.info("-------------------------TEST FIN testCrearCatalogo-----------------------");
   }
   
   @Test
   public void testConsultarCatalogo() throws Exception {
	   log.info("-------------------------TEST INI testConsultarCatalogo-----------------------");
	  //Catalogo entCatalogoTest=  CatalogoSrv.buscarPorId(new Long(1l));
	  
	  RequestDTO req=new RequestDTO();	 
	  req.setParam(EParametro.IdEntidadLocal, new Integer(1)); 
	  Catalogo cat=CatalogoSrv.buscarPorId(req);
		log.info("-------------------------TEST FIN testConsultarCatalogo-----------------------");
   }
  
   
}