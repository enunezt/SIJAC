package co.gov.sijac.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.PerfilFacade;
import co.gov.sijac.admin.model.entidades.Perfil;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.admin.model.entidades.PerfilOpcion;
import co.gov.sijac.common.controller.GenericoPrimeFacesController;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import org.primefaces.model.DualListModel;
/**
 *
 * @author ENUNEZT
 */
@ManagedBean(name ="perfilController")
@ViewScoped
public class PerfilController extends GenericoPrimeFacesController<Perfil>{
	
	@Inject
	private PerfilFacade perfilService;
	private DualListModel<String> opciones;
	private List<Opcion> target; 
	private List<Opcion> source;
	private List<String> sourceStr ; 
	private List<String> targetStr ;  
	private Map<Long, Opcion> mapOpciones;
	private short nivel;
	private Perfil perfil;
	
    public PerfilController() {  
    	sourceStr = new ArrayList<String>(); 
    	targetStr = new ArrayList<String>();
    	
    	sourceStr.add("No hay registros");
    	opciones= new DualListModel<String>(sourceStr,targetStr);
     
    }
    /**
     * Carga las opciones asociadas y libres de cada perfil
     */
    @SuppressWarnings("unchecked")
    public void  cargarOpciones(){
		
		try{
		List<String> sourceStr = new ArrayList<String>(); 
		 List<String> targetStr = new ArrayList<String>(); 
		 target = new ArrayList<Opcion>();
		 
		 RequestDTO reqDTO=new RequestDTO(context);
		 reqDTO.setEntidadLocal(perfil); 
		 ResponseDTO resp=perfilService.consultarOpcionesDisponiblesPerfil(reqDTO);
		 source=(List<Opcion>) resp.getParam(EParametro.ResultList);
		 
		 resp=perfilService.consultarOpcionesPerfil(reqDTO);
		 target=(List<Opcion>) resp.getParam(EParametro.ResultList);
		 
		 mapOpciones=new HashMap<Long, Opcion>();
		 if(target!=null && !target.isEmpty()){
			
			 for (Opcion opcion : target) {
				 mapOpciones.put(opcion.getIdOpcion(), opcion);
				 targetStr.add(""+opcion.getIdOpcion()+"-"+opcion.getMenu().getNombre());
			}
		 }
		 
		 if(source!=null && !source.isEmpty()){
			 
			 for (Opcion opcion : source) {
				 mapOpciones.put(opcion.getIdOpcion(), opcion);
				 sourceStr.add(""+opcion.getIdOpcion()+"-"+opcion.getMenu().getNombre());
			}
		 }
	     
	     
	     opciones= new DualListModel<String>(sourceStr, targetStr);  
		}catch(Exception e){		
			addErrorMessage(e);	
		}
		
	}
    
    @Override
	public String doCrear() {
	perfil.setFecCambio(new Date());
	super.doCrear();
	cargarOpciones();
	
		return null;
	}
    @Override
	public String doActualizar() {

	perfil.setFecCambio(new Date());
	if(mapOpciones!=null){
		
		Set<PerfilOpcion> lstTmp=null;
		 if(!opciones.getTarget().isEmpty()){
			 lstTmp= new HashSet<PerfilOpcion>();
			 for (String opc : opciones.getTarget()) {
					
				 long id=Long.valueOf(opc.split("-")[0]);
				 Opcion mapOp=mapOpciones.get(id);
				if( mapOp.getIdOpcion().longValue()==id){	
					PerfilOpcion oops=new PerfilOpcion(mapOp,perfil);
					lstTmp.add(oops);					
				}
				}
		 }
			 perfil.setPerfilOpciones(lstTmp);
		
	 }
	super.doActualizar();
	cargarOpciones();		
	return null;
	}

    @Override
	public String doEditar() {
		 super.doEditar();
		cargarOpciones();		
		return null;
	}
   
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	@Override
	public GenericoFacadeInterface<Perfil> getGenericoFacade() {
	
		return perfilService;
	}


	@Override
	public Perfil getNewEntidad() {
			return perfil;
	}
	
	@Override
	public void setNewEntidad(Perfil newEntidad) {		
		this.perfil=newEntidad;
	}
	
	@Override
	@PostConstruct
	public void initNewEntidad() {
		perfil= new Perfil();
	}
	public DualListModel<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(DualListModel<String> opciones) {
		this.opciones = opciones;
	}

	public List<Opcion> getTarget() {
		return target;
	}

	public void setTarget(List<Opcion> target) {
		this.target = target;
	}

	public List<Opcion> getSource() {
		return source;
	}

	public void setSource(List<Opcion> source) {
		this.source = source;
	}

	public List<String> getSourceStr() {
		return sourceStr;
	}

	public void setSourceStr(List<String> sourceStr) {
		this.sourceStr = sourceStr;
	}

	public List<String> getTargetStr() {
		return targetStr;
	}

	public void setTargetStr(List<String> targetStr) {
		this.targetStr = targetStr;
	}

	public Map<Long, Opcion> getMapOpciones() {
		return mapOpciones;
	}

	public void setMapOpciones(Map<Long, Opcion> mapOpciones) {
		this.mapOpciones = mapOpciones;
	}

	public short getNivel() {
		return nivel;
	}

	public void setNivel(short nivel) {
		this.nivel = nivel;
	}

	public Perfil getPerfil() {
		return perfil;
	}
}
	