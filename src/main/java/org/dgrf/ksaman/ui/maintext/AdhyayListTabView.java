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
@Named(value = "adhyayListTabView")
@ViewScoped
public class AdhyayListTabView implements Serializable {

    /**
     * Creates a new instance of AdhyayListTabView
     */
    private List<MaintextDTO> adhyayDTOList;
    private MaintextDTO selectedAdhyay;
    private int parvaId;
    private int adhyayId;

    public String loadAllAdhyayList() {
        KSCoreService ksCoreService = new KSCoreService();
        adhyayDTOList = ksCoreService.getAdhyayIdList(parvaId);

        if (adhyayDTOList.isEmpty()) {
            return "ShlokaListTabView?faces-redirect=true&parvaId=" + parvaId + "&adhyayId=" + 1;
        } else {
            for (int i = 0; i < adhyayDTOList.size(); i++) {
                adhyayId = adhyayDTOList.get(i).getAdhyayId();
            }
            return "";
        }
    }

    public String shlokaView() {
        return "/edit/maintext/ShlokaListTabView?faces-redirect=true&parvaId=" + parvaId + "&adhyayId=" + selectedAdhyay.getAdhyayId();
    }

    public List<MaintextDTO> getAdhyayDTOList() {
        return adhyayDTOList;
    }

    public void setAdhyayDTOList(List<MaintextDTO> adhyayDTOList) {
        this.adhyayDTOList = adhyayDTOList;
    }

    public MaintextDTO getSelectedAdhyay() {
        return selectedAdhyay;
    }

    public void setSelectedAdhyay(MaintextDTO selectedAdhyay) {
        this.selectedAdhyay = selectedAdhyay;
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

}
