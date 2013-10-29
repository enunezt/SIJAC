package co.gov.sijac.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.admin.model.entidades.Perfil;
import co.gov.sijac.admin.model.entidades.PerfilOpcion;
import co.gov.sijac.admin.model.entidades.Usuario;

//import org.primefaces.component.panelmenu.*;

public class SettingsContext implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1655517099972044317L;
	private String ipUsuario;
	private List<Perfil> perfilesUsuario;
	private Map<Long,Opcion> mapMenuOpcion;
	private Map<Long,Menu> mapIdMenu;
	private Usuario userLogin;
	private String tema;
	private Long fotoId;
	private String urlFoto;
	private Object menu;


	public SettingsContext() {
		// TODO Auto-generated constructor stub
	}
	
	
private void crearListaMenu(){
	
	if(perfilesUsuario!=null && !perfilesUsuario.isEmpty() && mapMenuOpcion==null){
		
		for (Perfil perfil : perfilesUsuario) {
			
			if(perfil.getPerfilOpciones()!=null && !perfil.getPerfilOpciones().isEmpty()){
				
				//if(mapMenuOpcion==null)
					mapMenuOpcion=new HashMap<Long, Opcion>();
					
				for (PerfilOpcion perfilOpc : perfil.getPerfilOpciones()) {
					
					Menu menu=perfilOpc.getOpcion().getMenu();
					
					mapMenuOpcion.put(menu.getIdMenu(), perfilOpc.getOpcion());					
					
					
				}
			}
			
		}
	}
}

	
	

	public String getIpUsuario() {
		return ipUsuario;
	}

	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	public List<Perfil> getPerfilesUsuario() {
		return perfilesUsuario;
	}

	public void setPerfilesUsuario(List<Perfil> perfilesUsuario) {	
		this.perfilesUsuario = perfilesUsuario;
		crearListaMenu();
		
		
	}



	public Map<Long, Opcion> getMapMenuOpcion() {
		return mapMenuOpcion;
	}

	public void setMapMenuOpcion(Map<Long, Opcion> mapMenuOpcion) {
		this.mapMenuOpcion = mapMenuOpcion;
	}
	
/**
 * 
 * @return idMenu con su opcion
 */
public Map<Long, Menu> getMapIdMenu() {
	return mapIdMenu;
}

public void setMapIdMenu(Map<Long, Menu> mapIdMenu) {
	this.mapIdMenu = mapIdMenu;
}


public Usuario getUserLogin() {
	return userLogin;
}


public void setUserLogin(Usuario userLogin) {
	this.userLogin = userLogin;
}

//protected transient PanelMenu model;


	public String getTema() {
		return tema;
	}


	public void setTema(String tema) {
		this.tema = tema;
	}


	public Long getFotoId() {
		return fotoId;
	}


	public void setFotoId(Long fotoId) {
		this.fotoId = fotoId;
	}
	
	public String getUrlFoto() {
		return urlFoto;
	}


	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}


	public Object getMenu() {
		return menu;
	}


	public void setMenu(Object menu) {
		this.menu = menu;
	}
}
