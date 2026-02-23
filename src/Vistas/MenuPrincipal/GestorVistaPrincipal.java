
package Vistas.MenuPrincipal;

import Vistas.GestionOrdenReparacion.GestorVistaAdmOrdenRep;
import Vistas.GestiónClientes.GestorVistaAdmCliente;
import Vistas.GestiónEquipos.GestorVistaAdmEquipo;
import Vistas.GestiónTecnico.GestorVistaAdmTecnico;


public class GestorVistaPrincipal {
    

    public void abrirPrincipal() {
        
        FrmMenuPrincipal frmPrincipal = new FrmMenuPrincipal();
        frmPrincipal.setVisible(true)  ;
                
    }
   
    public void abrirAdmCliente(){
        GestorVistaAdmCliente gesc= new GestorVistaAdmCliente();
        gesc.abrirVent();
    }
    
    public void abrirAdmOrdenRep(){
        GestorVistaAdmOrdenRep geso = new GestorVistaAdmOrdenRep();
        geso.abrirVent();
    }
    public void abrirAdmEquipo(){
        GestorVistaAdmEquipo gese = new GestorVistaAdmEquipo();
        gese.abrirVent();
    }
    public void abrirAdmTecnico(){
        GestorVistaAdmTecnico gesT = new GestorVistaAdmTecnico();
        gesT.abrirVent();
    }
    

    public void abrirReporte(){
    }
}
