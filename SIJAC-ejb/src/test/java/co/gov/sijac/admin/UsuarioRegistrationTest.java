package co.gov.sijac.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;

import co.gov.sijac.admin.dao.PerfilDAO;
import co.gov.sijac.admin.dao.UsuarioDAO;
import co.gov.sijac.admin.dao.impl.PerfilDAOImpl;
import co.gov.sijac.admin.dao.impl.UsuarioDAOImpl;
import co.gov.sijac.admin.facade.PerfilFacade;
import co.gov.sijac.admin.facade.UsuarioFacade;
import co.gov.sijac.admin.facade.UsuarioSettingsFacade;
import co.gov.sijac.admin.facade.impl.PerfilFacadeImpl;
import co.gov.sijac.admin.facade.impl.UsuarioFacadeImpl;
import co.gov.sijac.admin.facade.impl.UsuarioSettingsFacadeImpl;
import co.gov.sijac.admin.model.UsuarioModel;
import co.gov.sijac.admin.model.UsuarioSettingsModel;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.admin.model.entidades.Perfil;
import co.gov.sijac.admin.model.entidades.PerfilOpcion;
import co.gov.sijac.admin.model.entidades.PerfilOpcionPK;
import co.gov.sijac.admin.model.entidades.Usuario;
import co.gov.sijac.admin.services.users.UserSettingsServicio;
import co.gov.sijac.admin.services.users.impl.UserSettingsServicioImpl;
import co.gov.sijac.common.BaseTest;
import co.gov.sijac.common.GenericoInterface;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.dao.impl.GenericoDAO;
import co.gov.sijac.common.dto.SettingsContext;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;
import co.gov.sijac.exception.DAOExcepcion;
import co.gov.sijac.exception.ServicioExcepcion;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
import co.gov.sijac.member.model.Member;
import co.gov.sijac.member.service.MemberRegistration;
import co.gov.sijac.util.Resources;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class UsuarioRegistrationTest extends BaseTest{
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
   UsuarioSettingsFacade userSrv;

   @Inject
   Logger log;


   @Test
   public void testLogin() throws Exception {
	   System.out.println("-------------------------TEST INI -----------------------");
	// Usuario newMember=userSrv.consultarUsuario("SIJAC", "1234");
	 System.out.println("-------------------------TEST FIN-----------------------");
     // assertNotNull(newMember.getId());
    //  log.info(newMember.getNombre1() + " consultado exitosamente  numero " + newMember.getId());
	   //System.out.println("-------------------------TEST FIN-----------------------");
   }
   
   
   private static Class[] getListClazzes2(){
	   
	   List<Class> lst=new ArrayList<Class>();
	  
	 lst.add(PerfilDAOImpl.class);
	   lst.add(UsuarioDAOImpl.class);
	   lst.add(PerfilDAO.class);
	   lst.add(UsuarioDAO.class);
	   lst.add(PerfilFacadeImpl.class);
	   lst.add(UsuarioFacadeImpl.class);
	   lst.add(UsuarioSettingsFacadeImpl.class);
	   lst.add(PerfilFacade.class);
	   lst.add(UsuarioFacade.class);
	   lst.add(UsuarioSettingsFacade.class);
	   lst.add(Member.class);
	   lst.add(Menu.class);
	   lst.add(Opcion.class);
	   lst.add(Perfil.class);
	   lst.add(PerfilOpcion.class);
	   lst.add(PerfilOpcionPK.class);
	   lst.add(SettingsContext.class);
	   lst.add(Usuario.class);
	   lst.add(UsuarioModel.class);
	   lst.add(UsuarioSettingsModel.class);
	   lst.add(UserSettingsServicioImpl.class);
	   lst.add(UserSettingsServicio.class);
	   lst.add(MemberRegistration.class);
	   lst.add(GestorEntidad.class);
	   lst.add(Servicio.class);
	   lst.add(ServicioFacade.class);
	   lst.add(GenericoDAO.class);
	   lst.add(GenericoDAOInterface.class);
	   lst.add(GenericoDAOFacade.class);
	   lst.add(GenericoFacadeInterface.class);
	   lst.add(GenericoInterface.class);
	   lst.add(DAOExcepcion.class);
	   lst.add(ServicioExcepcion.class);
	   lst.add(ServicioFacadeExcepcion.class);
	   lst.add(Resources.class); 
	   
	   Class arr[]=new Class[lst.size()] ;
	   int pos=0;
	   for (Class class1 : lst) {
		   arr[pos++]=class1;
	}
	   
	   return arr;   
   }
   
}
