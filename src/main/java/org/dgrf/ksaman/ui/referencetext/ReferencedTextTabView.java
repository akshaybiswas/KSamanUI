/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.referencetext;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.dgrf.ksamancore.DTO.MaintextDTO;
import org.dgrf.ksamancore.DTO.ReferencetextDTO;
import org.dgrf.ksamancore.bl.service.KSCoreService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "referencedTextTabView")
@ViewScoped
public class ReferencedTextTabView implements Serializable{

    /**
     * Creates a new instance of ReferencedTextTabView
     */
    private List<ReferencetextDTO> referenceDTOList;
    private int parvaId;
    private int adhyayId;
    private int shlokaLine;
    private int shlokaNum;
    private int refTextId;
    private String refText;
    private String shlokaText;
    private String shlokaAnubad;
    private List<MaintextDTO> maintextDTOList;
    
    public void loadTranslatedText() {
        KSCoreService ksCoreService = new KSCoreService();
        referenceDTOList = ksCoreService.getReftextList(parvaId, adhyayId, shlokaNum, shlokaLine);
        maintextDTOList = ksCoreService.getMaintextTranslation(parvaId, adhyayId, shlokaNum);

        if (maintextDTOList.size() != 0) {
            shlokaNum = maintextDTOList.get(0).getShlokaNum();
            shlokaAnubad = maintextDTOList.get(0).getAnubadText();
            
            if (shlokaAnubad == null) {
                shlokaAnubad = "অনুবাদ করা হয় নি";
            }
        }

        for (int i = 0; i < maintextDTOList.size(); i++) {

            shlokaText = maintextDTOList.get(i).getShlokaText();
            shlokaLine = maintextDTOList.get(i).getShlokaLine();

        }
    }
    
}
