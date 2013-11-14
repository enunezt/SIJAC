 
package co.gov.sijac.juntas;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.common.BaseTest;
import co.gov.sijac.juntas.facade.PagosAfiliadoFacade;
import co.gov.sijac.juntas.model.entidades.PagosAfiliado;
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
public class PagosAfiliadoTest extends BaseTest{	
	
	public PagosAfiliadoTest() {
		super();
		
			
		
	}
  static{
	  lst.add(co.gov.sijac.juntas.dao.impl.PagosAfiliadoDAOImpl.class);
	   lst.add(co.gov.sijac.juntas.dao.PagosAfiliadoDAO.class);
	   lst.add(co.gov.sijac.juntas.facade.impl.PagosAfiliadoFacadeImpl.class);
	   lst.add(co.gov.sijac.juntas.facade.PagosAfiliadoFacade.class);
	   lst.add(co.gov.sijac.juntas.model.entidades.PagosAfiliado.class);
	   lst.add(co.gov.sijac.juntas.services.impl.PagosAfiliadoServicioImpl.class);
	   lst.add(co.gov.sijac.juntas.services.PagosAfiliadoServicio.class);
	 
	   //lst.add(co.gov.sijac.juntas.PagosAfiliadoTest.class);
  }
  @Deployment
  public static Archive<?> createTestArchive() {
	  
	
     return ShrinkWrap.create(WebArchive.class, "test-PagosAfiliado.war")
           .addClasses(getListClazzes()) .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
           .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
           // Deploy our test datasource
           .addAsWebInfResource("test-ds.xml", "test-ds.xml");
  }

   @EJB
   PagosAfiliadoFacade PagosAfiliadoSrv; 
   
   @Inject
   Logger log;

   @Test
   public void testCrearPagosAfiliado() throws Exception {
	   log.info("-------------------------TEST INI testCrearPagosAfiliado-----------------------");
	   PagosAfiliado entPagosAfiliadoTest=new PagosAfiliado();
	   //TODO: Completar entidad
	   RequestDTO req=new RequestDTO();
	   req.setEntidadLocal(entPagosAfiliadoTest);
	   ResponseDTO resp= PagosAfiliadoSrv.crear(req);  
	   entPagosAfiliadoTest= (PagosAfiliado) resp.getEntidadLocal();
	   
	   log.info(PagosAfiliado.class.getSimpleName()+" creado exitosamente");
		//assertNotNull(entPagosAfiliadoTest.getIdPagosAfiliado());
	 log.info("-------------------------TEST FIN testCrearPagosAfiliado-----------------------");
   }
   
   @Test
   public void testConsultarPagosAfiliado() throws Exception {
	   log.info("-------------------------TEST INI testConsultarPagosAfiliado-----------------------");
	   PagosAfiliado entPagosAfiliadoTest=new PagosAfiliado(); 
	    RequestDTO req=new RequestDTO();
	    req.setParam(EParametro.IdEntidadLocal, 1);
	   entPagosAfiliadoTest=PagosAfiliadoSrv.buscarPorId(req);	   
	   log.info("-------------------------TEST FIN testConsultarPagosAfiliado-----------------------");
   }
  
   
}