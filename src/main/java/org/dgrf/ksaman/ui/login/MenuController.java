/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.login;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;



import org.primefaces.model.menu.DefaultMenuItem;

import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;

import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author bhaduri
 */
@Named(value = "menuController")
@RequestScoped
public class MenuController {

    private MenuModel menuModel;

    /**
     * Creates a new instance of MenuController
     */
    @Inject
    LoginController loginController;

    public MenuController() {
    }

    @PostConstruct
    void init() {
        if (loginController.getUserAuthDTO().getUserId() == null) {
           
        } else {

            
            menuModel = new DefaultMenuModel();

            
            //DefaultSubMenu rootMenu = new DefaultSubMenu("User Menu");
            
            
            DefaultMenuItem maintextList = new DefaultMenuItem("Shloka Gucchho");
            String maintextBrowseUrl = "/edit/maintext/ParvaListTabView?faces-redirect=true";
            maintextList.setOutcome(maintextBrowseUrl);
            menuModel.addElement(maintextList);
            
            DefaultMenuItem parvaList = new DefaultMenuItem("Parva");
            String parvaBrowseUrl = "/edit/parva/ParvaList?faces-redirect=true";
            parvaList.setOutcome(parvaBrowseUrl);
            menuModel.addElement(parvaList);
            //menuModel.addElement(menuMaker.getUserMenu());
            
            DefaultMenuItem ubachaList = new DefaultMenuItem("Ubacha");
            String ubachaBrowseUrl = "/edit/ubacha/UbachaList?faces-redirect=true";
            ubachaList.setOutcome(ubachaBrowseUrl);
            menuModel.addElement(ubachaList);

        }
    }

    
    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

}
