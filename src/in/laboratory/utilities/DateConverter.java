/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author ajay
 */
public class DateConverter extends Converter<Object, Object> {

    /**
     * Convert Date Object into String
     * @param value
     * @return 
     */
    @Override
    public Object convertForward(Object value) {
        if (value != null && value.getClass() == java.util.Date.class) {
            String date = new SimpleDateFormat("dd/MM/yyyy").format(value);
            return date;
        }
        
        return value;
    }

    /**
     * Add your reverse code when it is a JCombobox, JTextField etc.
     * that returns Date Object (for example)
     * 
     * @param value
     * @return 
     */
    @Override
    public Object convertReverse(Object value) {
        Date date = new Date();
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = formatter.parse(String.valueOf(value));
        } catch (ParseException ex) {
            Logger.getLogger(DateConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return date;
    }
}
