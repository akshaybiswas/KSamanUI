/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.parva;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.dgrf.ksamancore.bl.service.KSCoreService;

/**
 *
 * @author bhaduri
 */
@Named(value = "parvaList")
@ViewScoped
public class ParvaList implements Serializable{
    
    /**
     * Creates a new instance of ParvaList
     */
    public ParvaList() {
    }
    public void getParvaList() {
        KSCoreService ksCoreService = new KSCoreService();
        ksCoreService.getAllParva();
    }
}
