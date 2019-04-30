/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.landing;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.dgrf.ksamancore.bl.service.KSCoreService;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author dgrfiv
 */
@Named(value = "landingPanel")
@ViewScoped
public class landingPanel implements Serializable {

    /**
     * Creates a new instance of landingPanel
     */
    public landingPanel() {
    }

    private PieChartModel model;

    @PostConstruct
    public void init() {
        KSCoreService kSCoreService = new KSCoreService();
        int shloka = kSCoreService.getTotalShlokaCount();
        int parva = kSCoreService.getTotalParvaCount();
        int adhyay = kSCoreService.getTotalAdhyayCount();
        int words = kSCoreService.getTotalWordsCount();
        int ubacha = kSCoreService.getTotalUbachaCount();
        
        model = new PieChartModel();
        model.set("Shloka", shloka);//jobs in thousands
        model.set("Words", words);
        model.set("Translations", 38000);
        model.set("References", 31000);
        model.set("Parva", parva);
        model.set("Ubacha", ubacha);
        model.set("Adhyay", adhyay);

        //followings are some optional customizations:
        //set title
        model.setTitle("2019 Mahabharat Shloka Chart");
        //set legend position to 'e' (east), other values are 'w', 's' and 'n'
        model.setLegendPosition("e");
        //enable tooltips
        model.setShowDatatip(true);
        //show labels inside pie chart
        model.setShowDataLabels(true);
        //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
        model.setDataFormat("value");
        //format: %d for 'value', %s for 'label', %d%% for 'percent'
        model.setDataLabelFormatString("%dK");
        //pie sector colors
        model.setSeriesColors("aaf,afa,faa,ffa,aff,faf,ddd");
    }

    public PieChartModel getModel() {
        return model;
    }

}
