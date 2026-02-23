
package Vistas.GestiónEquipos;

import Modelo.GestorEquipo;
import static Vistas.GestiónEquipos.FrmAdmEquipo.tablaEquipo;
import static Vistas.GestiónEquipos.FrmNuevoEquipo.ban;
import static Vistas.GestiónEquipos.FrmNuevoEquipo.*;
import Vistas.MenuPrincipal.FrmMenuPrincipal;
import javax.swing.JOptionPane;

public class GestorVistaNuevoEquipo {
    GestorEquipo gestorEquipo= new GestorEquipo();
    FrmNuevoEquipo form;
    GestorVistaAdmEquipo gestorVista;

    public GestorEquipo getGestorEquipo() {
        return gestorEquipo;
    }

    public void setGestorEquipo(GestorEquipo gestorEquipo) {
        this.gestorEquipo = gestorEquipo;
    }

    public FrmNuevoEquipo getForm() {
        return form;
    }

    public void setForm(FrmNuevoEquipo form) {
        this.form = form;
    }
    
    public void abrirVentNuevoEquipo(int modo){
        if(modo==0){
           FrmNuevoEquipo nuevoEquipo = new FrmNuevoEquipo();
           FrmMenuPrincipal.escritorio.add(nuevoEquipo);
           nuevoEquipo.setVisible(true);
           FrmNuevoEquipo.btnB.setVisible(false);
           FrmNuevoEquipo.txtB.setVisible(false);
           FrmNuevoEquipo.ban.setText("0");
           FrmNuevoEquipo.ban.setVisible(false);
        } else{
           FrmNuevoEquipo nuevoEquipo = new FrmNuevoEquipo();
           FrmMenuPrincipal.escritorio.add(nuevoEquipo);
           nuevoEquipo.setVisible(true);
           FrmNuevoEquipo.txtId.setText("");
           FrmNuevoEquipo.txtId.setEnabled(true);
           FrmNuevoEquipo.ban.setText("1");
           FrmNuevoEquipo.ban.setVisible(false);
           String regis = tablaEquipo.getValueAt(tablaEquipo.getSelectedRow(), 0).toString();
           FrmNuevoEquipo.txtB.setText(regis);
        }
         
    }

    public void guardarNuevo(){
        int v = this.validarDatos();
        
        if (v == 1){
            this.getGestorEquipo().newModel();
            this.getGestorEquipo().getModel().setId(Integer.parseInt(txtId.getText()));
            this.getGestorEquipo().getModel().setNombre(txtNombre.getText());
            this.getGestorEquipo().getModel().setMarca(txtMarca.getText());
            this.getGestorEquipo().getModel().setModelo(txtModelo.getText());
            this.getGestorEquipo().getModel().setNumeroSerie(txtNSerie.getText());
            this.getGestorEquipo().getModel().setColor(txtColor.getText());
            
            String mod = ban.getText();
            
            this.getGestorEquipo().opcionGuardar(mod);
        }
    }

    public void abrirVentana() {
        FrmNuevoEquipo nuevEquipo = new FrmNuevoEquipo();
           FrmMenuPrincipal.escritorio.add(nuevEquipo);
           nuevEquipo.setVisible(true);
    }

    public int validarDatos() {
        if (this.getForm().txtNombre.getText().length() == 0){
             JOptionPane.showMessageDialog(null, "Falta ingresar el tipo de Equipo.");
             return 0;
        }
        
        if (this.getForm().txtMarca.getText().length() == 0){
             JOptionPane.showMessageDialog(null, "Falta ingresar la marca del Equipo.");
             return 0;
        }
        
        if (this.getForm().txtModelo.getText().length() == 0){
             JOptionPane.showMessageDialog(null, "Falta ingresar el modelo del Equipo.");
             return 0;
        }
        
        if (this.getForm().txtNSerie.getText().length() == 0){
             JOptionPane.showMessageDialog(null, "Falta ingresar el número de serie del Equipo.");
             return 0;
        }
        
        if (this.getForm().txtColor.getText().length() == 0){
             JOptionPane.showMessageDialog(null, "Falta ingresar el color del Equipo.");
             return 0;
        }
        
        return 1;
    }
    
    public void soloNumeros(java.awt.event.KeyEvent evt){
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

}
