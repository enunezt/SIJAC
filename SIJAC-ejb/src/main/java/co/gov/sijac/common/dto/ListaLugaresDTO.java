package co.gov.sijac.common.dto;

import java.util.List;

import co.gov.sijac.admin.lugares.model.entidades.Ciudad;
import co.gov.sijac.admin.lugares.model.entidades.Departamento;
import co.gov.sijac.admin.lugares.model.entidades.Pais;

public class ListaLugaresDTO {
    private List<Pais> paisItems;
    private List<Departamento> deptoItems;
    private List<Ciudad> ciudadItems;
    
    /**
     * @param paisItems
     * @param deptoItems
     * @param ciudadItems
     */
    public void LugarTO(List<Pais> paisItems, List<Departamento> deptoItems,
	    List<Ciudad> ciudadItems) {
	this.paisItems = paisItems;
	this.deptoItems = deptoItems;
	this.ciudadItems = ciudadItems;
    }
    
   
    /**
     * 
     */
    public ListaLugaresDTO() {
	super();
	// TODO Auto-generated constructor stub
    }


    /**
     * @return the paisItems
     */
    public List<Pais> getPaisItems() {
        return paisItems;
    }
   
    /**
     * @param paisItems the paisItems to set
     */
    public void setPaisItems(List<Pais> paisItems) {
        this.paisItems = paisItems;
    }
    /**
     * @return the deptoItems
     */
    public List<Departamento> getDeptoItems() {
        return deptoItems;
    }
    /**
     * @param deptoItems the deptoItems to set
     */
    public void setDeptoItems(List<Departamento> deptoItems) {
        this.deptoItems = deptoItems;
    }
    /**
     * @return the ciudadItems
     */
    public List<Ciudad> getCiudadItems() {
        return ciudadItems;
    }
    /**
     * @param ciudadItems the ciudadItems to set
     */
    public void setCiudadItems(List<Ciudad> ciudadItems) {
        this.ciudadItems = ciudadItems;
    }
    
    
    
    
    
}