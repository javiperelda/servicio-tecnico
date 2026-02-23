package Vistas.GestiónClientes;

import Modelo.GestorCliente;
import static Vistas.GestiónClientes.FrmAdmCliente.tabla;
import static Vistas.GestiónClientes.FrmNuevoCliente.*;
import Vistas.MenuPrincipal.FrmMenuPrincipal;
import Vistas.MenuPrincipal.GestorVista;
import java.awt.Color;
import javax.swing.JOptionPane;

public class GestorVistaNuevoCliente extends GestorVista {

    GestorCliente gestorCliente = new GestorCliente();
    FrmNuevoCliente form;
    GestorVistaAdmCliente gestorVista;

    public FrmNuevoCliente getForm() {
        return form;
    }

    public void setForm(FrmNuevoCliente form) {
        this.form = form;
    }

    public GestorVistaAdmCliente getGestorVista() {
        return gestorVista;
    }

    public void setGestorVista(GestorVistaAdmCliente gestorVista) {
        this.gestorVista = gestorVista;
    }

    public GestorCliente getGestorCliente() {
        return gestorCliente;
    }

    public void setGestorCliente(GestorCliente gestorCliente) {
        this.gestorCliente = gestorCliente;
    }

    public void abrirVentNuevoC(int modo) {
        if (modo == 0) {
            FrmNuevoCliente nc = new FrmNuevoCliente();
            FrmMenuPrincipal.escritorio.add(nc);
            nc.setVisible(true);
            FrmNuevoCliente.btnB.setVisible(false);
            FrmNuevoCliente.txtB.setVisible(false);
            FrmNuevoCliente.band.setText("0");
            FrmNuevoCliente.band.setVisible(false);
        }
        else {
            FrmNuevoCliente nc = new FrmNuevoCliente();
            FrmMenuPrincipal.escritorio.add(nc);
            nc.setVisible(true);
            FrmNuevoCliente.txtId.setText("");
            FrmNuevoCliente.txtId.setEnabled(true);
            FrmNuevoCliente.band.setText("1");
            FrmNuevoCliente.band.setVisible(false);
            String regis = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            FrmNuevoCliente.txtB.setText(regis);
        }

    }
    
    public void abrirNuevoClienteOrden(){
            FrmNuevoCliente nc = new FrmNuevoCliente();
            FrmMenuPrincipal.escritorio.add(nc);
            nc.setVisible(true);
            FrmNuevoCliente.btnB.setVisible(false);
            FrmNuevoCliente.txtB.setVisible(false);
            FrmNuevoCliente.band.setText("2");
            FrmNuevoCliente.band.setVisible(false);
    }

    public void cargarComboProv() {
        this.getGestorCliente().cargarComboProvincia();
    }

    public void cargarComboLocalidad() {
        this.getGestorCliente().cargarComboLocalidad();
    }

    public int validarDatos() {
        if (isVacio(txtNombre)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el nombre del Cliente.");
            return 0;
        }

        if (isVacio(txtApellido)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el apellido del Cliente.");
            return 0;
        }

        if (isVacio(cmbTipoDocu)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el tipo de documento del Cliente.");
            return 0;
        }

        if (isVacio(txtDocu)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el número de documento del Cliente.");
            return 0;
        }

        if (isVacio(txtDire)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la dirección del Cliente.");
            return 0;
        }

        if (isVacio(txtTel)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el telefono del Cliente.");
            return 0;
        }

        if (isVacio(txtEmail)) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el email del Cliente.");
            return 0;
        }
        
        
        int auxAñoNac = Integer.parseInt(txtAñoNac.getText());
        if ((txtAñoNac.getText().length() != 4 || auxAñoNac<1960) || txtMesNac.getText().length() != 2 || txtFechaNacimiento.getText().length() != 2) {
            txtAñoNac.setBackground(Color.red);
            txtMesNac.setBackground(Color.red);
            txtFechaNacimiento.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "La fecha ingresada es incorrecta, vuelva a ingresar una fecha valida.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        int auxDoc = Integer.parseInt(txtDocu.getText());
        if (txtDocu.getText().length() != 8 || auxDoc < 11000000) {
            JOptionPane.showMessageDialog(null, "El número de documento ingresado es incorrecta, vuelva a ingresar un número valido.", "Error", JOptionPane.ERROR_MESSAGE);
            txtDocu.setBackground(Color.red);
            return 0;
        }
        return 1;
    }

    void guardarNuevo() {
        int v = this.validarDatos();

        if (v == 1) {
            this.getGestorCliente().newModel();
            this.getGestorCliente().getModel().setId(Integer.parseInt(txtId.getText()));
            this.getGestorCliente().getModel().setNombre(txtNombre.getText());
            this.getGestorCliente().getModel().setApellido(txtApellido.getText());
            this.getGestorCliente().getModel().setTipoDeDocumento((String) cmbTipoDocu.getSelectedItem());
            this.getGestorCliente().getModel().setNumDocumento(txtDocu.getText());
            this.getGestorCliente().getModel().setFechaNacimiento(txtFechaNacimiento.getText() + "/" + txtMesNac.getText() + "/" + txtAñoNac.getText());
            this.getGestorCliente().getModel().setProvincia((String) cmbProv.getSelectedItem());
            this.getGestorCliente().getModel().setLocalidad((String) cmbLocalidad.getSelectedItem());
            this.getGestorCliente().getModel().setDireccion(txtDire.getText());
            this.getGestorCliente().getModel().setTelefono(txtTel.getText());
            this.getGestorCliente().getModel().setEmail(txtEmail.getText());
            String mod = band.getText();

            this.getGestorCliente().opcionGuardar(mod);
            
        }

    }
}
