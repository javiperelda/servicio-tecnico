package Modelo;

import Vistas.GestionOrdenReparacion.FrmNuevaOrden;
import Vistas.GestiónClientes.FrmAdmCliente;
import Vistas.GestiónClientes.FrmNuevoCliente;
import static Vistas.GestiónClientes.FrmNuevoCliente.txtB;
import Vistas.GestiónClientes.GestorVistaNuevoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import sql.Conexion;
import sql.InstanciaConexion;

public class GestorCliente {

    private Cliente model;
    private FrmNuevoCliente form;

    public Cliente getModel() {
        return model;
    }

    public void setModel(Cliente model) {
        this.model = model;
    }

    private List<Cliente> cliente = new ArrayList<Cliente>();

    public void guardarNuevo() {
        this.cliente.add(this.getModel());
        guardarClienteEnDB(this.getModel());
    }

    private void guardarClienteEnDB(Cliente nuevo) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement psInsert = miConexion.prepareStatement("INSERT INTO cliente (id,nombre,apellido,tipoDeDocumento,numDocumento,fechaNacimiento,provincia,localidad,direccion,telefono,email) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            psInsert.setInt(1, nuevo.getId());
            psInsert.setString(2, nuevo.getNombre());
            psInsert.setString(3, nuevo.getApellido());
            psInsert.setString(4, nuevo.getTipoDeDocumento());
            psInsert.setString(5, nuevo.getNumDocumento());
            psInsert.setString(6, nuevo.getFechaNacimiento());
            psInsert.setString(7, nuevo.getProvincia());
            psInsert.setString(8, nuevo.getLocalidad());
            psInsert.setString(9, nuevo.getDireccion());
            psInsert.setString(10, nuevo.getTelefono());
            psInsert.setString(11, nuevo.getEmail());

            psInsert.execute();
            miConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarCliente() {
        int valor = model.getId();
        this.cliente.add(this.getModel());
        editarClienteEnDB(this.getModel(), valor);
    }

    public void editarClienteEnDB(Cliente nuevo, int valor) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement psInsert = miConexion.prepareStatement("UPDATE cliente SET nombre=?, apellido=?,tipoDeDocumento=?,numDocumento=?,fechaNacimiento=?, provincia=?, localidad=?, direccion=?, telefono=?, email=? WHERE id='" + valor + "'");
            //psInsert.setInt(1, nuevo.getId());
            psInsert.setString(1, nuevo.getNombre());
            psInsert.setString(2, nuevo.getApellido());
            psInsert.setString(3, nuevo.getTipoDeDocumento());
            psInsert.setString(4, nuevo.getNumDocumento());
            psInsert.setString(5, nuevo.getFechaNacimiento());
            psInsert.setString(6, nuevo.getProvincia());
            psInsert.setString(7, nuevo.getLocalidad());
            psInsert.setString(8, nuevo.getDireccion());
            psInsert.setString(9, nuevo.getTelefono());
            psInsert.setString(10, nuevo.getEmail());
            psInsert.execute();

            miConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarReg(String regis, int a) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("DELETE from cliente where id='" + regis + "'");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se elimino el cliente con éxito.", "Eliminar Cliente", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel) FrmAdmCliente.tabla.getModel();
        model.removeRow(a);
    }

    public void newModel() {
        this.setModel(new Cliente());
    }

    public void cargarComboProvincia() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from provincia order by provincia_nombre");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("provincia_nombre");
                FrmNuevoCliente.cmbProv.addItem(tmpStrObtenido);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(GestorVistaNuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarComboLocalidad() {
        try {
            FrmNuevoCliente.cmbLocalidad.removeAllItems();
            String auxProv = (String) FrmNuevoCliente.cmbProv.getSelectedItem();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from ciudad where fk_provincia='" + auxProv + "' order by ciudad_nombre");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("ciudad_nombre");
                FrmNuevoCliente.cmbLocalidad.addItem(tmpStrObtenido);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(GestorVistaNuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void materializarColecciones() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from cliente order by id");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[11];
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmCliente.tabla.getModel();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarTodo() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from cliente");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[11];
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmCliente.tabla.getModel();
                vaciarTabla();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarPorNombre(String nom) {
        try {
            vaciarTabla();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from cliente where nombre LIKE '%" + nom + "%'");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[11];
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmCliente.tabla.getModel();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vaciarTabla() {
        DefaultTableModel tb = (DefaultTableModel) FrmAdmCliente.tabla.getModel();
        tb.setRowCount(0);
    }

    public void buscarPorDni(String dni) {
        try {
            vaciarTabla();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from cliente where numDocumento LIKE'%" + dni + "%'");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[11];
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmCliente.tabla.getModel();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarEditar(/*String band*/) {
        try {
            String band = FrmNuevoCliente.txtB.getText();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from cliente where id='" + band + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tmpStrObtenido = rs.getString("id");
                FrmNuevoCliente.txtId.setText(tmpStrObtenido);
                String tmpStrObtenido1 = rs.getString("nombre");
                FrmNuevoCliente.txtNombre.setText(tmpStrObtenido1);
                String tmpStrObtenido2 = rs.getString("apellido");
                FrmNuevoCliente.txtApellido.setText(tmpStrObtenido2);
                String tmpStrObtenido3 = rs.getString("tipoDeDocumento");
                //FrmNuevoCliente.cmbTipoDocu.addItem(tmpStrObtenido3);
                FrmNuevoCliente.cmbTipoDocu.setSelectedItem(tmpStrObtenido3);
                String tmpStrObtenido4 = rs.getString("numDocumento");
                FrmNuevoCliente.txtDocu.setText(tmpStrObtenido4);
                String tmpStrObtenido5 = rs.getString("provincia");
                //FrmNuevoCliente.cmbProv.addItem(tmpStrObtenido5);
                FrmNuevoCliente.cmbProv.setSelectedItem(tmpStrObtenido5);
                String tmpStrObtenido6 = rs.getString("localidad");
                //FrmNuevoCliente.cmbLocalidad.addItem(tmpStrObtenido6);
                FrmNuevoCliente.cmbLocalidad.setSelectedItem(tmpStrObtenido6);
                String tmpStrObtenido7 = rs.getString("direccion");
                FrmNuevoCliente.txtDire.setText(tmpStrObtenido7);
                String tmpStrObtenido8 = rs.getString("telefono");
                FrmNuevoCliente.txtTel.setText(tmpStrObtenido8);
                String tmpStrObtenido9 = rs.getString("email");
                FrmNuevoCliente.txtEmail.setText(tmpStrObtenido9);
                String tmpStrObtenido10 = rs.getString("fechaNacimiento");
                FrmNuevoCliente.txtFechaNacimiento.setText(tmpStrObtenido10.substring(0, 2));
                FrmNuevoCliente.txtMesNac.setText(tmpStrObtenido10.substring(3, 5));
                FrmNuevoCliente.txtAñoNac.setText(tmpStrObtenido10.substring(6, 10));
                FrmNuevoCliente.txtId.setEnabled(false);

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vaciarCampos() {
        FrmNuevoCliente.txtNombre.setText("");
        FrmNuevoCliente.txtApellido.setText("");
        FrmNuevoCliente.txtDocu.setText("");
        FrmNuevoCliente.txtDire.setText("");
        FrmNuevoCliente.txtEmail.setText("");
        FrmNuevoCliente.txtTel.setText("");
        FrmNuevoCliente.txtFechaNacimiento.setText("");
        FrmNuevoCliente.txtMesNac.setText("");
        FrmNuevoCliente.txtAñoNac.setText("");
        this.buscarCliente();

    }

    public void buscarCliente() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select id from cliente ORDER BY id DESC limit 1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("id");
                if (tmpStrObtenido.length() == 0) {
                    FrmNuevoCliente.txtId.setEnabled(true);
                    FrmNuevoCliente.txtId.setText("1");
                    FrmNuevoCliente.txtId.setEnabled(false);
                } else {
                    FrmNuevoCliente.txtId.setEnabled(false);
                    int y = Integer.parseInt(tmpStrObtenido) + 1;
                    String l = String.valueOf(y);
                    FrmNuevoCliente.txtId.setText(l);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void opcionGuardar(String mod) {
        if ("0".equals(mod)) {
            int i = JOptionPane.showConfirmDialog(form, "¿Desea registrar un nuevo cliente?", "Registrar Cliente", JOptionPane.OK_CANCEL_OPTION); //ventana de confirmación.
            if (i == 0) {
                this.guardarNuevo();
                JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo cliente con éxito.");
                vaciarCampos();
                vaciarTabla();
                materializarColecciones();
            }
        } else {
            if ("2".equals(mod)){
            int i = JOptionPane.showConfirmDialog(form, "¿Desea registrar un nuevo cliente?", "Registrar Cliente", JOptionPane.OK_CANCEL_OPTION); //ventana de confirmación.
            if (i == 0) {
                this.guardarNuevo();
                JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo cliente con éxito.");
                vaciarCampos();
            }
        } else {
            String au = txtB.getText();
            int j = JOptionPane.showConfirmDialog(form, "¿Desea modificar el cliente?", "Modificar Cliente", JOptionPane.OK_CANCEL_OPTION); //ventana de confirmación.
            if (j == 0) {
                this.editarCliente();
                JOptionPane.showMessageDialog(null, "Se ha modificado el cliente con éxito.");
                vaciarTabla();
                materializarColecciones();
            }
        }
    }
    }

    private Connection con = null;
    Conexion conexion = null;

    public void GenerarReporte() {

        conexion = new Conexion("");
        con = conexion.con;
        try {
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteCliente.jasper"));
            } catch (JRException e) {
                System.out.println("Error cargando el reporte maestro");
            }
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, null, con);
            JasperViewer jViewer = new JasperViewer(jasperPrint, false);
            jViewer.setTitle("Reporte");
            jViewer.setVisible(true);

        } catch (JRException e) {
            System.out.println("Error Generando Reporte " + e.getMessage());
        }
    }

}
