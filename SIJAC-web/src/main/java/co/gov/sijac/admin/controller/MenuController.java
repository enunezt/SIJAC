package co.gov.sijac.admin.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.MenuFacade;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.common.controller.GenericoPrimeFacesController;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
/**
 *
 * @author ENUNEZT
 */
@ManagedBean(name ="menuController")
@ViewScoped
public class MenuController extends GenericoPrimeFacesController<Menu>{
	
	@Inject
	private MenuFacade menuService;
	
  /**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1424688172794333819L;
private Menu menu;
    public MenuController() {    	
     
    }
    @SuppressWarnings("unchecked")
	@Override
    public String doConsultar(){
      	 try{
      	     
      	 RequestDTO reqDTO=new RequestDTO(context);
	 reqDTO.setEntidadLocal(getNewEntidad()); 
	 ResponseDTO resp=getGenericoFacade().buscarPorEntidad(reqDTO);

		 entidadLst=(List<Menu>)resp.getParam(EParametro.ResultList) ;
      		addInfoMessage("Consulta exitosa","Consulta exitosa con "+entidadLst.size() +" Registros.");
      		    	
      	    	}catch(Exception e){
      	    		addErrorMessage(e);	
      	    	}
      	        
      	    	return null;	
      	 }
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	@Override
	public GenericoFacadeInterface<Menu> getGenericoFacade() {
	
		return menuService;
	}


	@Override
	public Menu getNewEntidad() {
			return menu;
	}
	@Override
	public void setNewEntidad(Menu newEntidad) {		
		this.menu=newEntidad;
	}


	@Override
	@PostConstruct
	public void initNewEntidad() {
		menu= new Menu();
	}

		}
	