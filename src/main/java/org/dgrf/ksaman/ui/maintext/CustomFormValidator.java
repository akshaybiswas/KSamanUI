/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.maintext;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author dgrfiv
 */
@Named(value = "customFormValidator")
@FacesValidator
public class CustomFormValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        //Check if user has typed only blank spaces
        if (value.toString().trim().isEmpty()) {
            context.getExternalContext().getFlash().setKeepMessages(true);
            FacesMessage msg
                    = new FacesMessage("Incorrect input provided",
                            "The input must provide some meaningful character");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, msg);
            throw new ValidatorException(msg);

        }
    }
}
