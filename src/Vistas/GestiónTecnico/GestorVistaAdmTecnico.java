package Vistas.GestiónTecnico;

import Modelo.Tecnico;
import Modelo.GestorTecnico;
import static Vistas.GestiónTecnico.FrmAdmTecnico.radDniC;
import static Vistas.GestiónTecnico.FrmAdmTecnico.radNombreC;
import Vistas.MenuPrincipal.FrmMenuPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorVistaAdmTecnico {
 FrmAdmTecnico nuevoTecnico ;

    private List<Tecnico> tecnico = new ArrayList<Tecnico>();
    private GestorTecnico gestorTecnico = new GestorTecnico();
    private GestorVistaNuevoTecnico gesNuevoTecnico = new GestorVistaNuevoTecnico();
    private FrmAdmTecnico form;

    public FrmAdmTecnico getNuevoTecnico() {
        return nuevoTecnico;
    }

    public void setNuevoTecnico(FrmAdmTecnico nuevoTecnico) {
        this.nuevoTecnico = nuevoTecnico;
    }

    public GestorVistaNuevoTecnico getGesNuevoTecnico() {
        return gesNuevoTecnico;
    }

    public void setGesNuevoCliente(GestorVistaNuevoTecnico gesNuevoCliente) {
        this.gesNuevoTecnico = gesNuevoTecnico;
    }

    public GestorTecnico getGestorTecnico() {
        return gestorTecnico;
    }

    public void setGestorCliente(GestorTecnico gestorCliente) {
        this.gestorTecnico = gestorCliente;
    }

    public FrmAdmTecnico getForm() {
        return form;
    }

    public void setForm(FrmAdmTecnico form) {
        this.form = form;
    }
    
    
    
    ///////////////////////////////////////////////////////////////
    
    
    public void abrirVent() {
       this.setNuevoTecnico(new FrmAdmTecnico(this));
        FrmMenuPrincipal.escritorio.add(this.getNuevoTecnico());
        nuevoTecnico.setVisible(true);
    }

    public void abrirNuevoTecnico(int modo) {
        this.getGesNuevoTecnico().abrirVentNuevoC(modo);
    }
    
    public void abrirNuevoTecnicoOrden() {
        this.getGesNuevoTecnico().abrirNuevoClienteOrden();
    }

    public void editarTecnico(int modo) {
        this.getGesNuevoTecnico().abrirVentNuevoC(modo);
    }

    public List<Tecnico> getTecnico() {
        return this.tecnico;
    }

    public void crearModeloDeDatos(List<Tecnico> tecnico) {
        DefaultTableModel modelo = new DefaultTableModel(
                null,
                new String[]{"Código de Técnico", "Nombre", "Apellido", "Tipo de Docu", "N° Docu", "Fecha Nacimiento","Provincia","Localidad","Dirección","Telefono","Email"});

        for (Tecnico r : tecnico) {
            if (r != null) {
                Object[] fila = new Object[]{
                    r,
                    r.getNombre(),
                    r.getApellido(),
                    r.getTipoDeDocumento(),
                    r.getNumDocumento(),
                    r.getFechaNacimiento(),
                    r.getProvincia(),
                    r.getLocalidad(),
                    r.getDireccion(),
                    r.getTelefono(),
                    r.getEmail()};
                modelo.addRow(fila);
            }
        }
        FrmAdmTecnico.tabla.setModel(modelo);
    }

    public void vaciarTabla() {
        DefaultTableModel tb = (DefaultTableModel) FrmAdmTecnico.tabla.getModel();
        tb.setRowCount(0);
    }

    public void buscarTecnico() {
        this.getGestorTecnico().buscarTecnico();
    }
    
      public void busquedaTecnico() {
        if (radNombreC.isEnabled() == true) {
            String band = FrmAdmTecnico.txtBuscarC.getText();
            this.getGestorTecnico().buscarPorNombre(band);
        }
        if (radDniC.isEnabled() == true) {
            String band = FrmAdmTecnico.txtBuscarC.getText();
            this.getGestorTecnico().buscarPorDni(band);
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

    void eliminarRegistro() {
        String regis = form.tabla.getValueAt(form.tabla.getSelectedRow(), 0).toString();
        int a = form.tabla.getSelectedRow();
       int i = JOptionPane.showConfirmDialog(form,"¿Desea eliminar el técnico seleccionado?","Eliminar Técnico",JOptionPane.OK_CANCEL_OPTION);
       if(i==0){
           this.getGestorTecnico().eliminarReg(regis, a);
       }
    } 
}

