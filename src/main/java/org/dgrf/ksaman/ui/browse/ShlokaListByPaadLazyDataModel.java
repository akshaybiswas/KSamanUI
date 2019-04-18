/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.browse;

import java.util.List;
import java.util.Map;
import org.dgrf.ksamancore.DTO.MaintextDTO;
import org.dgrf.ksamancore.bl.service.KSCoreService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author dgrfiv
 */
public class ShlokaListByPaadLazyDataModel extends LazyDataModel<MaintextDTO> {
    
    public ShlokaListByPaadLazyDataModel(String firstChar) {
        System.out.println("--------- " + this + " -----------------");
        KSCoreService kSCoreService = new KSCoreService();
        this.setRowCount(kSCoreService.getShlokaCountByFirstChar(firstChar));
    }

    public List<MaintextDTO> load(String firstChar, int first, int pageSize, String sortField,
            SortOrder sortOrder, Map<String, Object> filters) {
        KSCoreService kSCoreService = new KSCoreService();
        List<MaintextDTO> listShlokaByPaad = kSCoreService.getShlokaListByFirstChar(firstChar, first, pageSize);
        return listShlokaByPaad;
    }
}
