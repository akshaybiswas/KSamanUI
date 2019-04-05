/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.maintext;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.dgrf.ksamancore.DTO.ParvaDTO;
import org.dgrf.ksamancore.bl.service.KSCoreService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "parvaListTabView")
@ViewScoped
public class ParvaListTabView implements Serializable {

    /**
     * Creates a new instance of ParvaListTabView
     */
    
    private List<ParvaDTO> parvaDTOList;
    private ParvaDTO selectedParva;
    
    public void loadAllParvaList() {
        KSCoreService ksCoreService = new KSCoreService();
        parvaDTOList = ksCoreService.getParvaDTOList();
    }
    
    public String adhyayView() {
        return "/edit/maintext/AdhyayListTabView?faces-redirect=true&parvaId=" + selectedParva.getParvaId();
    }

    public List<ParvaDTO> getParvaDTOList() {
        return parvaDTOList;
    }

    public void setParvaDTOList(List<ParvaDTO> parvaDTOList) {
        this.parvaDTOList = parvaDTOList;
    }

    public ParvaDTO getSelectedParva() {
        return selectedParva;
    }

    public void setSelectedParva(ParvaDTO selectedParva) {
        this.selectedParva = selectedParva;
    }
    
    
}
