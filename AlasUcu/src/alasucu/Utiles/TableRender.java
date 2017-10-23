/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alasucu.Utiles;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author German
 */
public class TableRender extends DefaultTableCellRenderer {
     int col;
      public TableRender(int i){
          col = i;
      }
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected  ,boolean hasFocus, int row, int column) {
        // Obtenemos la celda que se esta renderizando
         JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(column==col){
            c.setBackground(Color.blue);
            c.setForeground(Color.white);
        }else{
            c.setBackground(Color.white);
            c.setForeground(Color.black);
        }

        // Regresamos la celda para que se agrege a la tabla
        return c;
    }
 
}
