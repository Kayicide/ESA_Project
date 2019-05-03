/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author kayde
 */
@FacesValidator(value = "dateValidator")
public class DateValidator implements Serializable, Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            Date date = (Date) value;
            Date now = new Date();
            if (date.before(now)) {
                FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Date has already passed!", "Date has already passed!");
                throw new ValidatorException(fmsg);
            }
    }
}