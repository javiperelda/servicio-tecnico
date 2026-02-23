package Vistas.GestionOrdenReparacion;

import Modelo.GestorOrdenDeReparacion;
import static Vistas.GestionOrdenReparacion.FrmAdmOrdenRep.*;
import static Vistas.GestionOrdenReparacion.FrmNuevaOrden.*;
import Vistas.MenuPrincipal.FrmMenuPrincipal;
import Vistas.MenuPrincipal.GestorVista;
import java.awt.Color;
import javax.swing.JOptionPane;

public class GestorVistaNuevaOrden extends GestorVista {

    GestorOrdenDeReparacion gor = new GestorOrdenDeReparacion();
    FrmNuevaOrden form;
    GestorVistaAdmOrdenRep gestorVista;
    public String aux1 = "";
    public int banderaFalla = 0;

    public void abrirVentNuevaO(int modo) {
        if (modo == 0) {
            FrmNuevaOrden no = new FrmNuevaOrden();
            FrmMenuPrincipal.escritorio.add(no);
            no.setVisible(true);
            FrmNuevaOrden.btnEditar.setVisible(false);
            FrmNuevaOrden.txtEditar.setVisible(false);
            FrmNuevaOrden.band.setText("0");
            FrmNuevaOrden.band.setVisible(false);

        } else {
            FrmNuevaOrden nc = new FrmNuevaOrden();
            FrmMenuPrincipal.escritorio.add(nc);
            nc.setVisible(true);
            FrmNuevaOrden.txtNumO.setText("");
            FrmNuevaOrden.txtNumO.setEnabled(true);
            FrmNuevaOrden.btnEditar.setVisible(true);
            FrmNuevaOrden.txtEditar.setVisible(true);
            String regis = tablaOrden.getValueAt(tablaOrden.getSelectedRow(), 0).toString();
            FrmNuevaOrden.txtEditar.setText(regis);
            FrmNuevaOrden.band.setText("1");
            FrmNuevaOrden.band.setVisible(false);
        }

    }

    public void eliminarO() {
        gor.eliminarO();
    }

    public FrmNuevaOrden getForm() {
        return form;
    }

    public void setForm(FrmNuevaOrden form) {
        this.form = form;
    }

    public GestorVistaAdmOrdenRep getGestorVista() {
        return gestorVista;
    }

    public void setGestorVista(GestorVistaAdmOrdenRep gestorVista) {
        this.gestorVista = gestorVista;
    }

    public GestorOrdenDeReparacion getGestorOrden() {
        return gor;
    }

    public void setGestorOrden(GestorOrdenDeReparacion gor) {
        this.gor = gor;
    }

    public void cargarCliente() {
        gor.cargarCliente();
    }

    public void buscarCliente() {
        this.gor.cargarCliente();
    }

    public void cargarFalla() {
        this.gor.cargarFalla();
    }

    public void buscarTiempo() {
        this.gor.buscarTiempo();
    }

    public void validarMotivo(int motivo) {
        if (motivo == 0) {
            if (FrmNuevaOrden.radioPres.isEnabled() == true) {
                FrmNuevaOrden.cmbTec.setEnabled(false);
                FrmNuevaOrden.txtDia.setEnabled(false);
                FrmNuevaOrden.txtMes.setEnabled(false);
                FrmNuevaOrden.txtAño.setEnabled(false);
                FrmNuevaOrden.txtDia.setText("");
                FrmNuevaOrden.txtMes.setText("");
                FrmNuevaOrden.txtAño.setText("");
                FrmNuevaOrden.txtDiag.setEnabled(false);
                FrmNuevaOrden.txtMonto.setEnabled(false);
                FrmNuevaOrden.txtSeña.setEnabled(false);
                FrmNuevaOrden.btnAgregarTecnico.setEnabled(false);
            }
        } else {
            if (FrmNuevaOrden.radioRep.isEnabled() == true) {
                FrmNuevaOrden.cmbTec.setEnabled(true);
                FrmNuevaOrden.txtDia.setEnabled(true);
                FrmNuevaOrden.txtMes.setEnabled(true);
                FrmNuevaOrden.txtAño.setEnabled(true);
                FrmNuevaOrden.txtDiag.setEnabled(true);
                FrmNuevaOrden.txtMonto.setEnabled(true);
                FrmNuevaOrden.txtSeña.setEnabled(true);
                FrmNuevaOrden.btnAgregarTecnico.setEnabled(true);
            }
        }
    }

    public int validarDatos() {
        if (isVacio(txtIdEquipo)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el número de equipo.");
            return 0;
        }

        if (isVacio(txtTipoEquipo)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el tipo de equipo.");
            return 0;
        }

        if (isVacio(txtMarca)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la marca del equipo.");
            return 0;
        }

        if (isVacio(txtModelo)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el modelo del equipo.");
            return 0;
        }

        if (isVacio(txtNSerie)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el número de serie.");
            return 0;
        }

        if (isVacio(txtColor)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el color del equipo.");
            return 0;
        }

        if (isVacio(cmbCli)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el Cliente.");
            return 0;
        }

        if (isVacio(cmbEstado)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el estado de la orden.");
            return 0;
        }

        if (isVacio(txtFalla)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la descripcion de las fallas del equipo.");
            return 0;
        }

        if (isVacio(txtAccesorio)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar los accesorios del equipo.");
            return 0;
        }
        if (radioRep.isSelected() == true) {
            if (isVacio(txtDia)) {
                JOptionPane.showMessageDialog(null, "Falta ingresar día de la fecha estimada de reparación.");
                return 0;
            } else if (isVacio(txtMes)) {
                JOptionPane.showMessageDialog(null, "Falta ingresar mes de la fecha estimada de reparación");
                return 0;
            } else if (isVacio(txtAño)) {
                JOptionPane.showMessageDialog(null, "Falta ingresar año de la fecha estimada de reparación.");
                return 0;
            } else if ((txtAño.getText().length() != 4) || (txtMes.getText().length() != 2) || (txtDia.getText().length() != 2)) {
                txtAño.setBackground(Color.red);
                txtMes.setBackground(Color.red);
                txtDia.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "La fecha ingresada es incorrecta, vuelva a ingresar una fecha valida.", "Error", JOptionPane.ERROR_MESSAGE);
                return 0;
            } else {
                String fechaActu = txtFecha.getText();
                int DiaFE = Integer.parseInt(txtDia.getText());
                int MesFE = Integer.parseInt(txtMes.getText());
                int AñoFE = Integer.parseInt(txtAño.getText());
                int DiaFA = Integer.parseInt(fechaActu.substring(0, 2));
                int MesFA = Integer.parseInt(fechaActu.substring(3, 4));
                int AñoFA = Integer.parseInt(fechaActu.substring(6, 9));

                if (((AñoFE < AñoFA) || (DiaFE < DiaFA && MesFE < MesFA))) {
                    JOptionPane.showMessageDialog(null, "La fecha ingresada no puede ser menor a la fecha actual, vuelva a ingresar una fecha valida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            }

            if (isVacio(cmbTec)) {
                JOptionPane.showMessageDialog(null, "Falta seleccionar un técnico.");
                return 0;
            }

            if (isVacio(txtDiag)) {
                JOptionPane.showMessageDialog(null, "Falta ingresar la descripción de las reparaciones realizadas.");
                return 0;
            }

            if (isVacio(txtMonto)) {
                JOptionPane.showMessageDialog(null, "Falta ingresar el monto total.");
                return 0;
            }
            if (isVacio(txtSeña)) {
                JOptionPane.showMessageDialog(null, "Falta ingresar un monto para la seña.");
                return 0;
            }
        }
        return 1;

    }

    public void vaciarCampos() {
        getGestorOrden().vaciarCampos();
    }

    void guardarNuevo() {
        int v = this.validarDatos();

        if (v == 1) {
            this.getGestorOrden().newModel();
            this.getGestorOrden().getModel().setNumOrden(Integer.parseInt(txtNumO.getText()));
            this.getGestorOrden().getModel().setCliente((String) cmbCli.getSelectedItem());
            this.getGestorOrden().getModel().setFecha(txtFecha.getText());
            this.getGestorOrden().getModel().setHora(txtHora.getText());
            this.getGestorOrden().getModel().setEquipo(txtIdEquipo.getText());
            this.getGestorOrden().getModel().setFallas(txtFalla.getText());
            this.getGestorOrden().getModel().setAccesorios(txtAccesorio.getText());
            this.getGestorOrden().getModel().setFechaEstimada(txtDia.getText() + "/" + txtMes.getText() + "/" + txtAño.getText());
            this.getGestorOrden().getModel().setTecnico((String) cmbTec.getSelectedItem());
            this.getGestorOrden().getModel().setEstado((String) cmbEstado.getSelectedItem());
            this.getGestorOrden().getModel().setDiagnostico(txtDiag.getText());
            this.getGestorOrden().getModel().setMontoTotal(txtMonto.getText());
            this.getGestorOrden().getModel().setSeña(txtSeña.getText());
            if (radioPres.isSelected() == true) {
                this.getGestorOrden().getModel().setMotivo("Presupuestar");
            } else {
                this.getGestorOrden().getModel().setMotivo("Reparar");
            }
            String mod = band.getText();

            this.getGestorOrden().opcionGuardar(mod);
        }

    }

    public void buscarOrden() {
        getGestorOrden().buscarOrden();
    }

    public void cargarTecnico() {
        getGestorOrden().cargarTecnico();
    }
    
    public void ingresarFallas(){
        String aux = (String) cmbFalla.getSelectedItem();
        if (banderaFalla != 1){
            aux1 = aux1 + aux;
            txtFalla.setText(aux1);
            banderaFalla = 1;
        }else{
         aux1 = aux1 +", "+ aux;
        txtFalla.setText(aux1);
        }
    }
    
    public void limpiaFallas(){
        txtFalla.setText("");
    }
            
        

}
