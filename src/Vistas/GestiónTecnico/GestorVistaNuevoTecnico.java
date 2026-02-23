package Vistas.GestiónTecnico;

import Modelo.GestorTecnico;
import static Vistas.GestiónTecnico.FrmAdmTecnico.tabla;
import static Vistas.GestiónTecnico.FrmNuevoTecnico.*;
import Vistas.MenuPrincipal.FrmMenuPrincipal;
import Vistas.MenuPrincipal.GestorVista;
import java.awt.Color;
import javax.swing.JOptionPane;

public class GestorVistaNuevoTecnico extends GestorVista {

    GestorTecnico gestorTecnico = new GestorTecnico();
    FrmNuevoTecnico form;
    GestorVistaAdmTecnico gestorVista;

    public FrmNuevoTecnico getForm() {
        return form;
    }

    public void setForm(FrmNuevoTecnico form) {
        this.form = form;
    }

    public GestorVistaAdmTecnico getGestorVista() {
        return gestorVista;
    }

    public void setGestorVista(GestorVistaAdmTecnico gestorVista) {
        this.gestorVista = gestorVista;
    }

    public GestorTecnico getGestorTecnico() {
        return gestorTecnico;
    }

    public void setGestorTecnico(GestorTecnico gestorTecnico) {
        this.gestorTecnico = gestorTecnico;
    }

    public void abrirVentNuevoC(int modo) {
        if (modo == 0) {
            FrmNuevoTecnico nc = new FrmNuevoTecnico();
            FrmMenuPrincipal.escritorio.add(nc);
            nc.setVisible(true);
            FrmNuevoTecnico.btnB.setVisible(false);
            FrmNuevoTecnico.txtB.setVisible(false);
            FrmNuevoTecnico.band.setText("0");
            FrmNuevoTecnico.band.setVisible(false);
        } else {
            FrmNuevoTecnico nc = new FrmNuevoTecnico();
            FrmMenuPrincipal.escritorio.add(nc);
            nc.setVisible(true);
            FrmNuevoTecnico.txtId.setText("");
            FrmNuevoTecnico.txtId.setEnabled(true);
            FrmNuevoTecnico.band.setText("1");
            FrmNuevoTecnico.band.setVisible(false);
            String regis = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            FrmNuevoTecnico.txtB.setText(regis);
        }
    }
    
    public void abrirNuevoClienteOrden() {
            FrmNuevoTecnico nc = new FrmNuevoTecnico();
            FrmMenuPrincipal.escritorio.add(nc);
            nc.setVisible(true);
            FrmNuevoTecnico.btnB.setVisible(false);
            FrmNuevoTecnico.txtB.setVisible(false);
            FrmNuevoTecnico.band.setText("2");
            FrmNuevoTecnico.band.setVisible(false);
    }

    public void cargarComboProv() {
        this.getGestorTecnico().cargarComboProvincia();
    }

    public void cargarComboLocalidad() {
        this.getGestorTecnico().cargarComboLocalidad();
    }

    public int validarDatos() {
        if (isVacio(txtNombre)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el nombre del Técnico.");
            return 0;
        }

        if (isVacio(txtApellido)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el apellido del Técnico.");
            return 0;
        }

        if (isVacio(cmbTipoDocu)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el tipo de documento del Técnico.");
            return 0;
        }

        if (isVacio(txtDocu)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el número de documento del Técnico.");
            return 0;
        }

        if (isVacio(txtDire)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la dirección del Técnico.");
            return 0;
        }

        if (isVacio(txtTel)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el telefono del Técnico.");
            return 0;
        }

        if (isVacio(txtEmail)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el email del Técnico.");
            return 0;
        }

        if (txtAñoNac.getText().length() != 4 || txtMesNac.getText().length() != 2 || txtFechaNacimiento.getText().length() != 2) {
            txtAñoNac.setBackground(Color.red);
            txtMesNac.setBackground(Color.red);
            txtFechaNacimiento.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "La fecha ingresada es incorrecta, vuelva a ingresar una fecha valida.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        if (txtDocu.getText().length() != 8) {
            JOptionPane.showMessageDialog(null, "El número de documento ingresado es incorrecta, vuelva a ingresar un número valido.", "Error", JOptionPane.ERROR_MESSAGE);
            txtDocu.setBackground(Color.red);
            return 0;
        }
        return 1;
    }

    void guardarNuevo() {
        int v = this.validarDatos();

        if (v == 1) {
            this.getGestorTecnico().newModel();
            this.getGestorTecnico().getModel().setId(Integer.parseInt(txtId.getText()));
            this.getGestorTecnico().getModel().setNombre(txtNombre.getText());
            this.getGestorTecnico().getModel().setApellido(txtApellido.getText());
            this.getGestorTecnico().getModel().setTipoDeDocumento((String) cmbTipoDocu.getSelectedItem());
            this.getGestorTecnico().getModel().setNumDocumento(txtDocu.getText());
            this.getGestorTecnico().getModel().setFechaNacimiento(txtFechaNacimiento.getText() + "/" + txtMesNac.getText() + "/" + txtAñoNac.getText());
            this.getGestorTecnico().getModel().setProvincia((String) cmbProv.getSelectedItem());
            this.getGestorTecnico().getModel().setLocalidad((String) cmbLocalidad.getSelectedItem());
            this.getGestorTecnico().getModel().setDireccion(txtDire.getText());
            this.getGestorTecnico().getModel().setTelefono(txtTel.getText());
            this.getGestorTecnico().getModel().setEmail(txtEmail.getText());
            String mod = band.getText();

            this.getGestorTecnico().opcionGuardar(mod);
        }

    }
}
