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
@Named(value = "translatedTextTabView")
@ViewScoped
public class TranslatedTextTabView implements Serializable {

    /**
     * Creates a new instance of TranslatedTextTabView
     */
    private List<MaintextDTO> translationDTOList;
    private int parvaId;
    private int adhyayId;
    private int ubachaId;
    private int shlokaLine;
    private int shlokaNum;
    private String ubachaName;
    private String parvaName;
    private String ubachaBachan;
    private String shlokaText;
    private String shlokaAnubad;

    public void loadTranslatedText() {
        KSCoreService ksCoreService = new KSCoreService();
        translationDTOList = ksCoreService.getMaintextTranslation(parvaId, adhyayId, shlokaNum);

        if (translationDTOList.size() != 0) {
            ubachaName = translationDTOList.get(0).getUbachaName();
            ubachaBachan = translationDTOList.get(0).getUbachaBachan();
            parvaName = translationDTOList.get(0).getParvaName();
            ubachaId = translationDTOList.get(0).getUbachaId();
            parvaId = translationDTOList.get(0).getParvaId();
            shlokaNum = translationDTOList.get(0).getShlokaNum();
            adhyayId = translationDTOList.get(0).getAdhyayId();
            shlokaAnubad = translationDTOList.get(0).getAnubadText();

            if (shlokaAnubad == null) {
                shlokaAnubad = "অনুবাদ করা হয় নি";
            }
        }

        for (int i = 0; i < translationDTOList.size(); i++) {

            shlokaText = translationDTOList.get(i).getShlokaText();
            shlokaLine = translationDTOList.get(i).getShlokaLine();

        }
    }

    public String previousPage() {
        return "ShlokaListTabView?faces-redirect=true&parvaId=" + parvaId + "&adhyayId=" + adhyayId;
    }

    public List<MaintextDTO> getTranslationDTOList() {
        return translationDTOList;
    }

    public void setTranslationDTOList(List<MaintextDTO> translationDTOList) {
        this.translationDTOList = translationDTOList;
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

    public String getUbachaName() {
        return ubachaName;
    }

    public void setUbachaName(String ubachaName) {
        this.ubachaName = ubachaName;
    }

    public String getUbachaBachan() {
        return ubachaBachan;
    }

    public void setUbachaBachan(String ubachaBachan) {
        this.ubachaBachan = ubachaBachan;
    }

    public String getShlokaText() {
        return shlokaText;
    }

    public void setShlokaText(String shlokaText) {
        this.shlokaText = shlokaText;
    }

    public String getShlokaAnubad() {
        return shlokaAnubad;
    }

    public void setShlokaAnubad(String shlokaAnubad) {
        this.shlokaAnubad = shlokaAnubad;
    }

    public String getParvaName() {
        return parvaName;
    }

    public void setParvaName(String parvaName) {
        this.parvaName = parvaName;
    }

    
}
