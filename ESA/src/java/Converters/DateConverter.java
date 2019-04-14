/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converters;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("DateConverter")
public class DateConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Date date;
        Timestamp returnDate = null;
        try{
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            date = format.parse(value); 
            returnDate = new Timestamp(date.getTime());
        }catch(ParseException e){
            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Date not in correct format!", "Date not in correct format!");
            throw new ConverterException(fmsg);
        }
        System.out.println();
        return returnDate;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Date date = new Date(((Timestamp) value).getTime());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return format.format((Date) date);
    }
}
