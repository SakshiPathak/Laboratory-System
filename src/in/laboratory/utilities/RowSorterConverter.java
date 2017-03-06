/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.utilities;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author ajay
 */
public class RowSorterConverter extends Converter<Object, Object> {

    private JTable table;

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    
    @Override
    public Object convertForward(Object value) {
        return value.toString();
    }

    @Override
    public Object convertReverse(Object value) {
        TableRowSorter sorter = new TableRowSorter(table.getModel());
        
        String val = value.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            sb.append('[').append(Character.toLowerCase(c)).append(Character.toUpperCase(c)).append(']');
        }
        // second argument can be passed in regexFilter which 
        // would be an index number to filter on the basis of 
        // specific column, for e.g., 0 for first column and so on
        sorter.setRowFilter(RowFilter.regexFilter(".*" + sb + ".*"));

        return sorter;
    }
    
}
