package Vistas.MenuPrincipal;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GestorVista {
   
    public boolean isVacio(JTextField txt)    {
        return (txt.getText().length() == 0) ;
   }    
    
    public boolean isVacio(JComboBox cmb) {
        return  cmb.getSelectedItem().equals("");
    }
    
    public boolean isVacio(JTextArea txa) {
      return (txa.getText().length() == 0);
    }
}
