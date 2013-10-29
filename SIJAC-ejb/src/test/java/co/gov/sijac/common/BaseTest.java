package co.gov.sijac.common;

import java.util.ArrayList;
import java.util.List;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 * Clase gnerica para los test
 * @author ENUNEZT
 *
 */
public class BaseTest {
	protected static List<Class> lst=new ArrayList<Class>();  ;
	
	 

	public BaseTest() {
		
	}

	 protected static Class[] getListClazzes(){
		
		   lst.add(co.gov.sijac.admin.dao.impl.MenuDAOImpl.class);
		   lst.add(co.gov.sijac.admin.dao.impl.PerfilDAOImpl.class);
		   lst.add(co.gov.sijac.admin.dao.impl.UsuarioDAOImpl.class);
		   lst.add(co.gov.sijac.admin.dao.MenuDAO.class);
		   lst.add(co.gov.sijac.admin.dao.PerfilDAO.class);
		   lst.add(co.gov.sijac.admin.dao.UsuarioDAO.class);
		   lst.add(co.gov.sijac.admin.facade.impl.MenuFacadeImpl.class);
		   lst.add(co.gov.sijac.admin.facade.impl.PerfilFacadeImpl.class);
		   lst.add(co.gov.sijac.admin.facade.impl.UsuarioFacadeImpl.class);
		   lst.add(co.gov.sijac.admin.facade.impl.UsuarioSettingsFacadeImpl.class);
		   lst.add(co.gov.sijac.admin.facade.MenuFacade.class);
		   lst.add(co.gov.sijac.admin.facade.PerfilFacade.class);
		   lst.add(co.gov.sijac.admin.facade.UsuarioFacade.class);
		   lst.add(co.gov.sijac.admin.facade.UsuarioSettingsFacade.class);
		   lst.add(co.gov.sijac.admin.model.entidades.Menu.class);
		   lst.add(co.gov.sijac.admin.model.entidades.Opcion.class);
		   lst.add(co.gov.sijac.admin.model.entidades.Perfil.class);
		   lst.add(co.gov.sijac.admin.model.entidades.PerfilOpcion.class);
		   lst.add(co.gov.sijac.admin.model.entidades.PerfilOpcionPK.class);
		   lst.add(co.gov.sijac.admin.model.entidades.Usuario.class);
		   lst.add(co.gov.sijac.admin.model.UsuarioModel.class);
		   lst.add(co.gov.sijac.admin.model.UsuarioSettingsModel.class);
		   lst.add(co.gov.sijac.admin.services.users.impl.UserSettingsServicioImpl.class);
		   lst.add(co.gov.sijac.admin.services.users.UserSettingsServicio.class);
		   lst.add(co.gov.sijac.common.annotation.GestorEntidad.class);
		   lst.add(co.gov.sijac.common.annotation.Servicio.class);
		   lst.add(co.gov.sijac.common.annotation.ServicioFacade.class);
		   lst.add(co.gov.sijac.common.dao.impl.GenericoDAO.class);
		   lst.add(co.gov.sijac.common.dao.GenericoDAOInterface.class);
		   lst.add(co.gov.sijac.common.facade.impl.GenericoDAOFacade.class);
		   lst.add(co.gov.sijac.common.facade.GenericoFacadeInterface.class);
		   lst.add(co.gov.sijac.common.GenericoInterface.class);
		   lst.add(co.gov.sijac.exception.DAOExcepcion.class);
		   lst.add(co.gov.sijac.exception.ServicioExcepcion.class);
		   lst.add(co.gov.sijac.exception.ServicioFacadeExcepcion.class);
		   lst.add(co.gov.sijac.member.data.MemberListProducer.class);
		   lst.add(co.gov.sijac.member.data.MemberRepository.class);
		   lst.add(co.gov.sijac.member.model.Member.class);
		   lst.add(co.gov.sijac.member.service.MemberRegistration.class);
		   lst.add(co.gov.sijac.util.Resources.class);
		   lst.add(co.gov.sijac.admin.dao.impl.OpcionDAOImpl.class);
		   lst.add(co.gov.sijac.admin.dao.OpcionDAO.class);
		   lst.add(co.gov.sijac.admin.facade.impl.OpcionFacadeImpl.class);
		   lst.add(co.gov.sijac.admin.facade.OpcionFacade.class);
		   lst.add(co.gov.sijac.common.BaseTest.class);
		   lst.add(co.gov.sijac.common.dto.BaseRequestResponseDTO.class);
		   lst.add(co.gov.sijac.common.dto.PaginationDTO.class);
		   lst.add(co.gov.sijac.common.dto.RequestDTO.class);
		   lst.add(co.gov.sijac.common.dto.ResponseDTO.class);
		   lst.add(co.gov.sijac.common.dto.SettingsContext.class);
		   lst.add(co.gov.sijac.common.enums.EParametro.class);
		   lst.add(co.gov.sijac.common.enums.IParametro.class);
		   lst.add(co.gov.sijac.admin.enums.EParametrosAdmin.class);
		   lst.add(co.gov.sijac.admin.services.users.UsuarioServicio.class);
		   lst.add(co.gov.sijac.admin.services.users.impl.UsuarioServicioImpl.class);
		   
		 
			  lst.add(co.gov.sijac.image.dao.impl.ImagenDAOImpl.class);
			   lst.add(co.gov.sijac.image.dao.ImagenDAO.class);
			   lst.add(co.gov.sijac.image.facade.impl.ImagenFacadeImpl.class);
			   lst.add(co.gov.sijac.image.facade.ImagenFacade.class);
			   lst.add(co.gov.sijac.image.model.entidades.EImagen.class);
			   lst.add(co.gov.sijac.image.model.entidades.Imagen.class);
			   lst.add(co.gov.sijac.image.model.ImagenModel.class);
			   lst.add(co.gov.sijac.image.service.impl.ImagenServicioImpl.class);
			   lst.add(co.gov.sijac.image.service.ImagenServicio.class);
			   lst.add(co.gov.sijac.image.model.entidades.ETipoImagen.class);
			   
		   
		   
		   
		   
		   
		   Class arr[]=new Class[lst.size()] ;
		   int pos=0;
		   for (Class class1 : lst) {
			   arr[pos++]=class1;
		}
		   
		   return arr;   
	   }
	 
	
}
