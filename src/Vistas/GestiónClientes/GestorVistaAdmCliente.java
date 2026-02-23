package Vistas.GestiónClientes;

import Modelo.Cliente;
import Modelo.GestorCliente;
import Vistas.GestionOrdenReparacion.FrmNuevaOrden;
import static Vistas.GestiónClientes.FrmAdmCliente.radDniC;
import static Vistas.GestiónClientes.FrmAdmCliente.radNombreC;
import static Vistas.GestionOrdenReparacion.FrmNuevaOrden.cmbCli;
import Vistas.MenuPrincipal.FrmMenuPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorVistaAdmCliente {

    private FrmAdmCliente nuevoCliente;

    private List<Cliente> cliente = new ArrayList<Cliente>();
    private GestorCliente gestorCliente = new GestorCliente();
    private GestorVistaNuevoCliente gesNuevoCliente = new GestorVistaNuevoCliente();
    private FrmAdmCliente form;
    private FrmNuevaOrden formOrden;

    public FrmAdmCliente getNuevoCliente() {
        return nuevoCliente;
    }

    public void setNuevoCliente(FrmAdmCliente nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
    }

    public GestorVistaNuevoCliente getGesNuevoCliente() {
        return gesNuevoCliente;
    }

    public void setGesNuevoCliente(GestorVistaNuevoCliente gesNuevoCliente) {
        this.gesNuevoCliente = gesNuevoCliente;
    }

    public GestorCliente getGestorCliente() {
        return gestorCliente;
    }

    public void setGestorCliente(GestorCliente gestorCliente) {
        this.gestorCliente = gestorCliente;
    }

    public FrmAdmCliente getForm() {
        return form;
    }

    public void setForm(FrmAdmCliente form) {
        this.form = form;
    }

    ///////////////////////////////////////////////////////////////
    public void abrirVent() {
        this.setNuevoCliente(new FrmAdmCliente(this));
        FrmMenuPrincipal.escritorio.add(this.getNuevoCliente());
        nuevoCliente.setVisible(true);
    }

    public void abrirNuevoCliente(int modo) {
        this.getGesNuevoCliente().abrirVentNuevoC(modo);
    }
    
    public void abrirNuevoClienteOrden(){
        this.getGesNuevoCliente().abrirNuevoClienteOrden();
    }

    public void editarCliente(int modo) {
        this.getGesNuevoCliente().abrirVentNuevoC(modo);
    }

    public List<Cliente> getCliente() {
        return this.cliente;
    }

    public void crearModeloDeDatos(List<Cliente> cliente) {
        DefaultTableModel modelo = new DefaultTableModel(
                null,
                new String[]{"Código", "Nombre", "Apellido", "Tipo de Docu", "N° Docu", "Fecha Nacimiento", "Provincia", "Localidad", "Dirección", "Telefono", "Email"});

        for (Cliente r : cliente) {
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
        FrmAdmCliente.tabla.setModel(modelo);
    }

    public void vaciarTabla() {
        DefaultTableModel tb = (DefaultTableModel) FrmAdmCliente.tabla.getModel();
        tb.setRowCount(0);
    }

    public void buscarCliente() {
        this.getGestorCliente().buscarCliente();
    }

    public void GenerarReporte() {
        this.getGestorCliente().GenerarReporte();
    }

    public void busquedaCliente() {
        String band = FrmAdmCliente.txtBuscarC.getText();
        int lon = band.length();
        if (radNombreC.isSelected() == true && (lon != 0)) {
            this.getGestorCliente().buscarPorNombre(band);
        }
        if (radDniC.isSelected() == true && (lon != 0)) {
            this.getGestorCliente().buscarPorDni(band);
        }
        if (lon == 0) {
            this.vaciarTabla();
            this.getGestorCliente().materializarColecciones();
        }

    }

    public void soloNumeros(java.awt.event.KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public void soloLetras(java.awt.event.KeyEvent evt) {
        if (!Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }

    void eliminarRegistro() {
        String regis = form.tabla.getValueAt(form.tabla.getSelectedRow(), 0).toString();
        int a = form.tabla.getSelectedRow();
        int i = JOptionPane.showConfirmDialog(form, "¿Desea eliminar el cliente seleccionado?", "Eliminar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (i == 0) {
            this.getGestorCliente().eliminarReg(regis, a);
        }
    }
}
