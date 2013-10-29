 
package co.gov.sijac.admin.lugares;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.common.BaseTest;
import co.gov.sijac.admin.lugares.facade.LugaresFacade;
import co.gov.sijac.admin.lugares.model.entidades.Ciudad;
import co.gov.sijac.admin.lugares.model.entidades.Departamento;
import co.gov.sijac.admin.lugares.model.entidades.Pais;
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
public class LugaresTest extends BaseTest{	
	
	public LugaresTest() {
		super();
		
			
		
	}
  static{
      lst.add(co.gov.sijac.admin.lugares.model.LugaresModel.class);
	  lst.add(co.gov.sijac.admin.lugares.dao.impl.PaisDAOImpl.class);
	   lst.add(co.gov.sijac.admin.lugares.dao.PaisDAO.class);
	   lst.add(co.gov.sijac.admin.lugares.dao.impl.DepartamentoDAOImpl.class);
	   lst.add(co.gov.sijac.admin.lugares.dao.DepartamentoDAO.class);
	   lst.add(co.gov.sijac.admin.lugares.dao.impl.CiudadDAOImpl.class);
	   lst.add(co.gov.sijac.admin.lugares.dao.CiudadDAO.class);	   
	   lst.add(co.gov.sijac.admin.lugares.facade.impl.LugaresFacadeImpl.class);
	   lst.add(co.gov.sijac.admin.lugares.facade.LugaresFacade.class);	   
	   lst.add(co.gov.sijac.admin.lugares.services.LugaresServicio.class);
	   lst.add(co.gov.sijac.admin.lugares.services.impl.LugaresServicioImpl.class);	   
	   lst.add(co.gov.sijac.admin.lugares.model.entidades.Pais.class);
	   lst.add(co.gov.sijac.admin.lugares.model.entidades.Departamento.class);
	   lst.add(co.gov.sijac.admin.lugares.model.entidades.Ciudad.class);
	 
	   //lst.add(co.gov.sijac.admin.lugares.PaisTest.class);
  }
  @Deployment
  public static Archive<?> createTestArchive() {
	  
	
     return ShrinkWrap.create(WebArchive.class, "test-Lugares.war")
           .addClasses(getListClazzes()) .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
           .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
           // Deploy our test datasource
           .addAsWebInfResource("test-ds.xml", "test-ds.xml");
  }

   @EJB
   LugaresFacade lugaresSrv; 
   
   @Inject
   Logger log;

   @Test
   public void testCunsultarPaises() throws Exception {
	   log.info("-------------------------TEST INI testCunsultarPaises-----------------------");
	   Pais entPaisTest=new Pais();
	   //TODO: Completar entidad
	   RequestDTO req=new RequestDTO();
	   ResponseDTO resp= lugaresSrv.consultarPaises(req);  
	 List<Pais> lst=(List<Pais>) resp.getParam(EParametro.ResultList);
	for (Pais pais : lst) {
	    Set<Departamento> lstDtos=pais.getDepartamentos();
	    
	    for (Departamento departamento : lstDtos) {
		
		Set<Ciudad> lstCiudades=departamento.getCiudades();
		for (Ciudad ciudad : lstCiudades) {
		    System.out.println(pais.getNombre()+":"+departamento.getNombre()+":"+ciudad.getNombre());
		}
		
	    }
	    
	    
	}
	
		//assertNotNull(entPaisTest.getIdPais());
	 log.info("-------------------------TEST FIN testCunsultarPaises-----------------------");
   }
   
   @Test
   public void testCunsultarDepartamento() throws Exception {
	   log.info("-------------------------TEST INI testCunsultarDepartamento-----------------------");
	   Pais entPaisTest=new Pais();
	   //TODO: Completar entidad
	   RequestDTO req=new RequestDTO();
	   req.setParam(EParametro.IdEntidad, 52); 
	   ResponseDTO resp= lugaresSrv.consultarDepartamentos(req);  
	 List<Departamento> lstDtos=(List<Departamento>) resp.getParam(EParametro.ResultList);
	
	    
	    for (Departamento departamento : lstDtos) {
		
		Set<Ciudad> lstCiudades=departamento.getCiudades();
		for (Ciudad ciudad : lstCiudades) {
		    System.out.println(departamento.getNombre()+":"+ciudad.getNombre());
		}
		
	    }
	    
	
		//assertNotNull(entPaisTest.getIdPais());
	 log.info("-------------------------TEST FIN testCunsultarDepartamento-----------------------");
   }
   
   
   
}