/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.dao;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Yader Jr
 */

//clase que extiende de la clase DefaultTableCellRenderer para poder modificar las celdas de la tabla y poder ingresar imagenes
public class RenderImgs extends DefaultTableCellRenderer{

    //metodo 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if(value instanceof JButton){
            JButton btn = (JButton)value;
            if(isSelected){
                btn.setForeground(table.getSelectionForeground());
                btn.setBackground(table.getSelectionBackground());
            }else{
                btn.setForeground(table.getForeground());
                btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
        }
        //concional para validar que el jlabel sea instancia de un Object
        if (value instanceof JLabel)
        {
            //objeto label que almacena el objeto value y lo reconozca como object
            JLabel jbl =(JLabel)value;
            return jbl;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
    }

    
}
