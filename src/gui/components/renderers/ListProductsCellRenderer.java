/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components.renderers;

import shopboots.classes.Client;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.UIManager;
import shopboots.classes.Product;

/**
 *
 * @author Melnikov
 */
public class ListProductsCellRenderer extends DefaultListCellRenderer{
    private final Color background = new Color(0, 100, 255, 15);
    private final Color defaultBackground = (Color) UIManager.get("List.background");
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value,int index,
                                                    boolean isSelected, boolean cellHasFocus){
        Component component = super.getListCellRendererComponent(list, value, index, 
                isSelected, cellHasFocus);
            if(component instanceof JLabel){
                JLabel label = (JLabel) component;
                Product product = (Product) value;
                label.setText(String.format("%d. %s. Размер:%.1f. Фирма: %s. Цена: %.2f. Кол-во: %d"
                        ,product.getId()
                        ,product.getModell()
                        ,product.getSize()
                        ,product.getBywho()
                        ,product.getPrice()
                        ,product.getPiece()
                        ,product.getMaxPiece()
                ));
                if(!isSelected){
                    label.setBackground(index % 2 == 0 ? background : defaultBackground);
                }
            }
            return component;                                            
        }
    
}
