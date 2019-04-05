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
import org.dgrf.ksamancore.DTO.MaintextDTO;
import org.dgrf.ksamancore.bl.service.KSCoreService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "shlokaListTabView")
@ViewScoped
public class ShlokaListTabView implements Serializable {

    /**
     * Creates a new instance of ShlokaListTabView
     */
    
    private List<MaintextDTO> shlokaDTOList;
    private MaintextDTO selectedShloka;
    private int parvaId;
    private int adhyayId;
    private int ubachaId;
    private int shlokaLine;
    private int shlokaNum;
    private String shlokaText;
    
    public void loadAllShlokaList() {
        KSCoreService ksCoreService = new KSCoreService();
        shlokaDTOList = ksCoreService.getShlokaList(parvaId, adhyayId);
        
        for(int i=0; i<shlokaDTOList.size(); i++) {
            ubachaId = shlokaDTOList.get(i).getUbachaId();
            shlokaText = shlokaDTOList.get(i).getShlokaText();
            shlokaLine = shlokaDTOList.get(i).getShlokaLine();
            shlokaNum = shlokaDTOList.get(i).getShlokaNum();
        }
    }

    public List<MaintextDTO> getShlokaDTOList() {
        return shlokaDTOList;
    }

    public void setShlokaDTOList(List<MaintextDTO> shlokaDTOList) {
        this.shlokaDTOList = shlokaDTOList;
    }

    public MaintextDTO getSelectedShloka() {
        return selectedShloka;
    }

    public void setSelectedShloka(MaintextDTO selectedShloka) {
        this.selectedShloka = selectedShloka;
    }

    public int getParvaId() {
        return parvaId;
    }

    public void setParvaId(int parvaId) {
        this.parvaId = parvaId;
    }

    public int getAdhyayId() {
        return adhyayId;
    }

    public void setAdhyayId(int adhyayId) {
        this.adhyayId = adhyayId;
    }

    public int getUbachaId() {
        return ubachaId;
    }

    public void setUbachaId(int ubachaId) {
        this.ubachaId = ubachaId;
    }

    public int getShlokaLine() {
        return shlokaLine;
    }

    public void setShlokaLine(int shlokaLine) {
        this.shlokaLine = shlokaLine;
    }

    public int getShlokaNum() {
        return shlokaNum;
    }

    public void setShlokaNum(int shlokaNum) {
        this.shlokaNum = shlokaNum;
    }

    public String getShlokaText() {
        return shlokaText;
    }

    public void setShlokaText(String shlokaText) {
        this.shlokaText = shlokaText;
    }
    
    
    
}
