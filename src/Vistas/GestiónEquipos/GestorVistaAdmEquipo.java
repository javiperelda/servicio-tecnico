
package Vistas.GestiónEquipos;
import Modelo.Equipo;
import Modelo.GestorEquipo;
import Vistas.GestionOrdenReparacion.FrmNuevaOrden;
import static Vistas.GestiónEquipos.FrmAdmEquipo.tablaEquipo;
import Vistas.MenuPrincipal.FrmMenuPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorVistaAdmEquipo{
    
    private FrmAdmEquipo nuevoEquipo;
    
    private List<Equipo> equipo = new ArrayList<Equipo>();
    private GestorEquipo gestorEquipo = new GestorEquipo();
    private GestorVistaNuevoEquipo gesNuevoEquipo = new GestorVistaNuevoEquipo();
    private FrmAdmEquipo form;
    
////////////////////////////////////////

    public FrmAdmEquipo getNuevoEquipo() {
        return nuevoEquipo;
    }

    public void setNuevoEquipo(FrmAdmEquipo nuevoEquipo) {
        this.nuevoEquipo = nuevoEquipo;
    }

    public GestorEquipo getGestorEquipo() {
        return gestorEquipo;
    }

    public void setGestorEquipo(GestorEquipo gestorEquipo) {
        this.gestorEquipo = gestorEquipo;
    }

    public GestorVistaNuevoEquipo getGesNuevoEquipo() {
        return gesNuevoEquipo;
    }

    public void setGesNuevoEquipo(GestorVistaNuevoEquipo gesNuevoEquipo) {
        this.gesNuevoEquipo = gesNuevoEquipo;
    }

    public FrmAdmEquipo getForm() {
        return form;
    }

    public void setForm(FrmAdmEquipo form) {
        this.form = form;
    }
    
/////////////////////////////////////////    
    
    public void abrirVent() {
        this.setNuevoEquipo(new FrmAdmEquipo(this));
        FrmMenuPrincipal.escritorio.add(this.getNuevoEquipo());
        nuevoEquipo.setVisible(true);
    }

    public void abrirNuevoEquipo(int modo) {
        this.getGesNuevoEquipo().abrirVentNuevoEquipo(modo);
    }
    
     public void editarEquipo(int modo) {
        this.getGesNuevoEquipo().abrirVentNuevoEquipo(modo);
    }

    public List<Equipo> getEquipo() {
        return this.equipo;
    }

    public void crearModeloDeDatos(List<Equipo> equipo) {
        DefaultTableModel modelo = new DefaultTableModel(
                null,
                new String[]{"Código", "Tipo", "Marca", "Modelo", "N° Serie"});

        for (Equipo r : equipo) {
            if (r != null) {
                Object[] fila = new Object[]{
                    r,
                    r.getNombre(),
                    r.getMarca(),
                    r.getModelo(),
                    r.getNumeroSerie()};
                modelo.addRow(fila);
            }
        }
        FrmAdmEquipo.tablaEquipo.setModel(modelo);
    }
    
    
    public void vaciarTabla() {
        DefaultTableModel tb = (DefaultTableModel) FrmAdmEquipo.tablaEquipo.getModel();
        tb.setRowCount(0);

    }
    
    void eliminarRegistro() {
        String regis = form.tablaEquipo.getValueAt(form.tablaEquipo.getSelectedRow(), 0).toString();
        int a = form.tablaEquipo.getSelectedRow();
        int i = JOptionPane.showConfirmDialog(form, "¿Desea eliminar el cliente seleccionado?", "Eliminar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (i == 0) {
            this.getGestorEquipo().eliminarEquipo(regis, a);
        }
    }  
    
    public void soloNumeros(java.awt.event.KeyEvent evt){
           if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
      }
      
      public void soloLetras(java.awt.event.KeyEvent evt){
           if (!Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
      }
    
    public void buscarEquipo() {
        this.getGestorEquipo().buscarEquipo();
    }
    
    
    public void abrirVentSelectorAdmEquipo( ){
           FrmAdmEquipo admEquipo = new FrmAdmEquipo();
           FrmMenuPrincipal.escritorio.add(admEquipo);
           admEquipo.setVisible(true);
           FrmAdmEquipo.panelAdmEquipo.setVisible(false);
           FrmAdmEquipo.btnSeleccionar.setVisible(true);
           FrmAdmEquipo.btnSeleccionar.setEnabled(true);
           FrmAdmEquipo.btnAgregarEquipo.setVisible(true);
        
    }
    
    public void seleccionEquipo(){
        String regis = tablaEquipo.getValueAt(tablaEquipo.getSelectedRow(), 0).toString();
        FrmNuevaOrden.txtIdEquipo.setText(regis);
    }
    
    
    
    
    
    
     public void filtro() {
        String band = FrmAdmEquipo.txtBuscar.getText();
        int lon = band.length();

        if (lon != 0) {
            this.getGestorEquipo().filtro(band);
        }else{
            this.vaciarTabla();
            this.getGestorEquipo().materializarColecciones();
        }

    }
    
}