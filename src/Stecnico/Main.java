
package Stecnico;

import Vistas.MenuPrincipal.*;
import javax.swing.UIManager;

public class Main {

     
    public static void main(String[] args) {
         try {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	} catch (Exception e) {
		e.printStackTrace();
        }
        
          GestorVistaPrincipal gestorVista = new GestorVistaPrincipal();
            gestorVista.abrirPrincipal();
      
    }
    
}
