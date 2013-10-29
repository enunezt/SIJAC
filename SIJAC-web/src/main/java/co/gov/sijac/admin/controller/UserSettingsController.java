package co.gov.sijac.admin.controller;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import co.gov.sijac.admin.facade.UsuarioFacade;
import co.gov.sijac.admin.facade.UsuarioSettingsFacade;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.admin.model.entidades.Usuario;
import co.gov.sijac.common.controller.BaseController;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.dto.SettingsContext;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.common.util.Theme;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
import co.gov.sijac.image.facade.ImagenFacade;
import co.gov.sijac.image.model.entidades.Imagen;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.panelmenu.PanelMenu;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;





/**
 * User settings.
 *
 * @author 
 * @version 
 */
@ManagedBean (name ="userSettingsController")
@ViewScoped
public class UserSettingsController extends BaseController{

		
	@Inject
    private UsuarioFacade usuarioServicio;
	
	@Inject
    private ImagenFacade imagenServicio;
	
	@Inject
    private UsuarioSettingsFacade seettingsServicio;
	private String usuario;
	private String pass;
	
	private Usuario userLogin;
	private Long fotoId;
	

	protected transient PanelMenu model;
	private Map<Long,Long>  menu;
	private Map<Long, Menu>  mapIdMenu; 
	
	private Map<String, String> themes;    
    private List<Theme> advancedThemes;       
    private String theme;  
    
    private String infoUser;
    private String urlFoto;
    
	
	public String getInfoUser() {
		return infoUser;
	}

	public void setInfoUser(String infoUser) {
		this.infoUser = infoUser;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public UserSettingsController() {
		

		menu = new HashMap<Long,Long>();
	
		
		/*usuario="SIJAC";
		pass="1234";
		verificarUsuario();*/
		
		
		if(context!=null){
			model = new PanelMenu();  
			 model.setModel( construirMenu());
			 model.buildMenuFromModel();
			//model=(PanelMenu) context.getMenu();
			//model.clearInitialState();
			//model.buildMenuFromModel();
			 fotoId=context.getFotoId();
			 urlFoto= context.getUrlFoto();
			 infoUser=context.getUserLogin().getUsuario();
		}
	}
	
	private boolean login() throws ServicioFacadeExcepcion {
		boolean login=false;
	
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
			HttpSession session = request.getSession();

			if (session.isNew()) {				
				obtenerCredencialesusuario(request);
			login=true;
			}else{
				
				if(context==null){
				context= (SettingsContext) session.getAttribute("settCtx");
				
				if(context==null){
					obtenerCredencialesusuario(request);
				}
				userLogin=context.getUserLogin();
				login=true;
				}else{
					if(userLogin!=null){
						login=true;
					}else{
						obtenerCredencialesusuario(request);
						login=true;
					}	
				}
			}
			
			if(login){
			if(getModel()==null){
			 model = new PanelMenu();  
			 model.setModel( construirMenu());
			 model.buildMenuFromModel();
			 context.setMenu(model);
			 }
			
			}
		return login;
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	private void obtenerCredencialesusuario(HttpServletRequest request) throws ServicioFacadeExcepcion{
		
	    Usuario userConsulta=new Usuario();
	    userConsulta.setUsuario(usuario);
	    userConsulta.setClave(pass);
	    
	    RequestDTO requestDTO=new RequestDTO(context);
	    requestDTO.setEntidadLocal(userConsulta);  
	    
	    ResponseDTO resp=seettingsServicio.consultarUsuario(requestDTO);
		userLogin=(Usuario) resp.getEntidadLocal();
		context=new SettingsContext();
		
		requestDTO=new RequestDTO(context);
		requestDTO.setEntidadLocal(userLogin); 
		resp=seettingsServicio.consultarMenu(requestDTO) ;
		mapIdMenu=(Map<Long, Menu>) resp.getParam(EParametro.Map) ;//todo el menu 
		
		
		
		context.setMapIdMenu(mapIdMenu);
		context.setIpUsuario("127.0.0.1");
		context.setPerfilesUsuario(userLogin.getPerfiles());
		context.setUserLogin(userLogin);
		
		requestDTO=new RequestDTO(context);
		requestDTO.setParam(EParametro.User, userLogin.getIdUsuario()); 
		resp=imagenServicio.consultarIdFotoUsuario(requestDTO);
		fotoId=(Long) resp.getParam(EParametro.Imagen);
		context.setFotoId(fotoId);
		
		if(fotoId!=null){
		String dirTMP=System.getProperty("java.io.tmpdir");
		requestDTO=new RequestDTO(context);;
		requestDTO.setParam(EParametro.Imagen, fotoId); 
		Imagen imgsrc=  imagenServicio.consultarImagen(requestDTO);
			try {
				 byte[] imageInByte= imgsrc.getContent();		
	 
				// convert byte array back to BufferedImage
				InputStream in = new ByteArrayInputStream(imageInByte);
				BufferedImage bImageFromConvert = ImageIO.read(in);
				urlFoto=dirTMP+imgsrc.getNombre()+"."+imgsrc.getExtension();
				context.setUrlFoto(urlFoto);
				ImageIO.write(bImageFromConvert, imgsrc.getExtension().toString(), new File(urlFoto));
				
	 
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		log.info("login()-->"+userLogin);
	
	request.getSession().setAttribute("settCtx", context);	
	}
	public String verificarUsuario(){		
		/*usuario="SIJAC";
		pass="1234";*/	
		try {
			if(login()){				
				
			return "/index.xhtml";
			}
		} catch (Exception e) {
			usuario=null;
			pass=null;
			addErrorMessage(e);
		}	
		return null;
	}

	public Map<String, String> getThemes() {  
        return themes;  
    }  
  
    public String getTheme() {  
        return theme;  
    }  
  
    public void setTheme(String theme) {  
        this.theme = theme;  
    }  
  
    @PostConstruct  
    public void init() {  
    	 theme ="aristo";  
    	if(context!=null && context.getTema()!=null){
    		 theme =context.getTema();  
    	}      
          
        advancedThemes = new ArrayList<Theme>();  
        advancedThemes.add(new Theme("aristo", "aristo.png"));  
        advancedThemes.add(new Theme("cupertino", "cupertino.png"));  
        advancedThemes.add(new Theme("trontastic", "trontastic.png"));  
          
        themes = new TreeMap<String, String>();  
        themes.put("Aristo", "aristo");  
        themes.put("Black-Tie", "black-tie");  
        themes.put("Blitzer", "blitzer");  
        themes.put("Bluesky", "bluesky");  
        themes.put("Casablanca", "casablanca");  
        themes.put("Cupertino", "cupertino");  
        themes.put("Dark-Hive", "dark-hive");  
        themes.put("Dot-Luv", "dot-luv");  
        themes.put("Eggplant", "eggplant");  
        themes.put("Excite-Bike", "excite-bike");  
        themes.put("Flick", "flick");  
        themes.put("Glass-X", "glass-x");  
        themes.put("Hot-Sneaks", "hot-sneaks");  
        themes.put("Humanity", "humanity");  
        themes.put("Le-Frog", "le-frog");  
        themes.put("Midnight", "midnight");  
        themes.put("Mint-Choc", "mint-choc");  
        themes.put("Overcast", "overcast");  
        themes.put("Pepper-Grinder", "pepper-grinder");  
        themes.put("Redmond", "redmond");  
        themes.put("Rocket", "rocket");  
        themes.put("Sam", "sam");  
        themes.put("Smoothness", "smoothness");  
        themes.put("South-Street", "south-street");  
        themes.put("Start", "start");  
        themes.put("Sunny", "sunny");  
        themes.put("Swanky-Purse", "swanky-purse");  
        themes.put("Trontastic", "trontastic");  
        themes.put("UI-Darkness", "ui-darkness");  
        themes.put("UI-Lightness", "ui-lightness");  
        themes.put("Vader", "vader"); 
        themes.put("Muisca", "muisca");  
        
        

		
		/* File file = new File("c:\\Users\\enunezt\\Pictures\\foto.jpg");//Bibliotecas\Imágenes
		   byte[] bFile = new byte[(int) file.length()];
		   
		   try {
		   FileInputStream fileInputStream = new FileInputStream(file);
		   fileInputStream.read(bFile);
		   fileInputStream.close();
		   } catch (Exception e) {
		   	   log.log(Level.SEVERE, "testCrearOpcion", e);
		   }
		   Imagen img=new Imagen();
		   img.setIdEntidad(11L);
		   img.setNombre("imagenPart-"+1);
		   img.setTipo(EImagen.FOTO_PERFIL);
		   img.setFechaRegistro(new Date());
		   img.setExtension(ETipoImagen.jpg);
		   img.setContent(bFile); 
		   
		   try {
			imagenServicio.crear(img) ;
			fotoId=img.getId();
			  log.info(img.getNombre()+ " creado exitosamente  numero " + img.getId());
		} catch (ServicioFacadeExcepcion e) {
		addErrorMessage(e);
		} catch (Exception e) {
			addErrorMessage(e);
		}*/
        
    }  
      
    public void saveTheme() {  
    	
    	if(context!=null){
   		 context.setTema(theme);  
   	}     
      ///  gp.setTheme(theme);  
    }  
  
    public List<Theme> getAdvancedThemes() {  
        return advancedThemes;  
    } 
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	

	 private  MenuModel construirMenu() {	
        
		 Map<Long,Opcion> ops=context.getMapMenuOpcion();
	
		  	
		 if(ops!=null && !ops.isEmpty()){
		
			 Iterator<Entry<Long, Opcion>> itOps=ops.entrySet().iterator();
			 
			while (itOps.hasNext()) {
				Map.Entry<java.lang.Long, Opcion> entry = itOps.next();
				Long idMenu=entry.getKey();
				Opcion opcion=entry.getValue();
				Long idPadre=opcion.getMenu().getIdPadre();	
				if(!idMenu.equals(idPadre))
				menu.put(idMenu, idPadre);//Mapa de jerarquias
			}
		 }
		 
			mapIdMenu=context.getMapIdMenu();//todo el menu
	
			 
             MenuModel mM= new DefaultMenuModel();
             
           Map<Long,Submenu>  menuMap= new HashMap<Long,Submenu>();
           Map<Long,Submenu>  todosMenu= new HashMap<Long,Submenu>();
             
              Iterator<Map.Entry<Long, Long>> it =menu.entrySet().iterator();
              
              while (it.hasNext()) {
              Map.Entry<Long, Long> e = it.next();  
              Long itMenu= e.getKey();
          //System.out.println(rec(new Integer(e.getKey().toString()),""));              
             
              String path=rec(itMenu,"");
             
              if(path.length()>1){            	 
                   
                  String[] arr= path.split("-");
                 // MenuModel tmp=null;
                  MenuItem item =null;  
                  for (int i = 0; i < arr.length; i++) {                       
                	  Long menuJerarquia=new Long(arr[arr.length-i-1]); 
                      boolean put=false;
                      boolean addItem=false;
                      Long inPadre= i>0? new Long(arr[arr.length-i]):null; 
                      Submenu sbm2=todosMenu.get(menuJerarquia);
                    
                      if(sbm2==null){                    	  
                    	  sbm2=new Submenu();
                    	  ops.get(menuJerarquia);
                    	  
                    	 Menu mn=mapIdMenu.get(menuJerarquia);
                    	 sbm2.setLabel(mn.getNombre()); 
                    	
                    	  put=true; 
                    	  todosMenu.put(menuJerarquia, sbm2);
                      }
                      
                      if(i==(arr.length-1)){
                    	  Opcion op=ops.get(itMenu);
                    	  
                    	  if(op!=null){
                    		  item = new MenuItem();  
                              item.setValue(op.getMenu().getNombre());  
                              item.setUrl(op.getUrl()); 
                    	  }
                    	  
                    	  addItem=item!=null;
                          
                         if(inPadre!=null && todosMenu.get(inPadre)!=null && addItem){
                        	
                        	todosMenu.get(inPadre).getChildren().add(item) ;
                        	 
                        	  }else if(addItem){
                        		  sbm2.getChildren().add(item);  
                        	  }
                		  
                	  }
                	 
                	  if(inPadre!=null && todosMenu.get(inPadre)!=null ){
                		  if(i!=(arr.length-1) && !addItem) {               		  
                		  todosMenu.get(inPadre).getChildren().add(sbm2) ;
                		  }
                		  
                    	  put=false;
                      }
                	 
                	  if(put){                		                    	  
                    	  menuMap.put(menuJerarquia, sbm2);
                	  }
                	 
                    
                  }//fin for
                   
              }
              }//fin while
              
              Iterator<Entry<Long, Submenu>> it2 =menuMap.entrySet().iterator();
              while (it2.hasNext()) {
            	  Entry<Long, Submenu> e = it2.next();
              mM.addSubmenu((Submenu) e.getValue());
              }
              
           return  mM;
 }
	 
	 public  String rec(long n, String path){
         
         if(menu.get(new Long(n))==null){
             return path=path+n;
         }else{
             Long e=menu.get(new Long(n));
            
             path=path+n+"-";
             return rec(e,path);
         }
        
     }
	 
	 public PanelMenu getModel() {  
	        return model;  
	    }

	public void setModel(PanelMenu model) {
		this.model = model;
	}

	public Long getFotoId() {
		return fotoId;
	}

	public void setFotoId(Long fotoId) {
		this.fotoId = fotoId;
	}
	 
	


}