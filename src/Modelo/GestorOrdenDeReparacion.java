package Modelo;

import Vistas.GestionOrdenReparacion.FrmAdmOrdenRep;
import Vistas.GestionOrdenReparacion.FrmNuevaOrden;
import static Vistas.GestionOrdenReparacion.FrmNuevaOrden.*;
import Vistas.GestiónClientes.GestorVistaNuevoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sql.InstanciaConexion;

public class GestorOrdenDeReparacion {

    private OrdenDeReparacion model;
    private FrmNuevaOrden form;

    public OrdenDeReparacion getModel() {
        return model;
    }

    public void setModel(OrdenDeReparacion model) {
        this.model = model;
    }

    public FrmNuevaOrden getForm() {
        return form;
    }

    public void setForm(FrmNuevaOrden form) {
        this.form = form;
    }

    private List<OrdenDeReparacion> orden = new ArrayList<OrdenDeReparacion>();

    public void vaciarTabla() {
        DefaultTableModel tb = (DefaultTableModel) FrmAdmOrdenRep.tablaOrden.getModel();
        tb.setRowCount(0);
    }

    public void materializarColecciones() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from orden order by numOrden");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[11];
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmOrdenRep.tablaOrden.getModel();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorOrdenDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vaciarCampos() {
        FrmNuevaOrden.txtIdEquipo.setText("");
        FrmNuevaOrden.txtTipoEquipo.setText("");
        FrmNuevaOrden.txtMarca.setText("");
        FrmNuevaOrden.txtModelo.setText("");
        FrmNuevaOrden.txtNSerie.setText("");
        FrmNuevaOrden.txtColor.setText("");
        FrmNuevaOrden.txtFalla.setText("");
        FrmNuevaOrden.txtAccesorio.setText("");
        FrmNuevaOrden.radioPres.setSelected(false);
        FrmNuevaOrden.radioRep.setSelected(false);
        FrmNuevaOrden.txtDia.setText("");
        FrmNuevaOrden.txtMes.setText("");
        FrmNuevaOrden.txtAño.setText("");
        FrmNuevaOrden.txtDiag.setText("");
        FrmNuevaOrden.txtMonto.setText("");
        FrmNuevaOrden.txtSeña.setText("");
        FrmNuevaOrden.txtNumO.setText("");
        FrmNuevaOrden.cmbCli.setSelectedIndex(0);
        FrmNuevaOrden.cmbFalla.setSelectedIndex(0);
        FrmNuevaOrden.cmbTec.setSelectedIndex(0);
        FrmNuevaOrden.cmbEstado.setSelectedIndex(0);
        buscarOrden();
        buscarTiempo();
    }

    public void opcionGuardar(String mod) {
        if ("0".equals(mod)) {
            int i = JOptionPane.showConfirmDialog(form, "¿Desea registrar una nueva orden?", "Registrar Orden de Reparación", JOptionPane.OK_CANCEL_OPTION); //ventana de confirmación.
            if (i == 0) {
                this.guardarNuevo();
                JOptionPane.showMessageDialog(null, "Se ha registrado una nueva orden con éxito.");
                vaciarCampos();
                vaciarTabla();
                materializarColecciones();
            }
        } else {
            String au = txtEditar.getText();
            int j = JOptionPane.showConfirmDialog(form, "¿Desea modificar la orden?", "Modificar Orden de Reparación", JOptionPane.OK_CANCEL_OPTION); //ventana de confirmación.
            if (j == 0) {
                this.editarOrden();
                JOptionPane.showMessageDialog(null, "Se ha modificado la orden con éxito.");
                vaciarTabla();
                materializarColecciones();
            }
        }
    }

    public void newModel() {
        this.setModel(new OrdenDeReparacion());
    }

//    public void guardarNuevo(String numOrden, String cliente, String fecha, String equipo, String modelo, String fallas, String motivo, String tecnico, String estado, String accesorios, String fechaEstimada, String diagnostico, String montoTotal, String sena) {
//        OrdenDeReparacion nuevo = new OrdenDeReparacion(Integer.parseInt(numOrden), cliente, fecha, equipo, modelo, fallas, motivo, tecnico, estado, accesorios, fechaEstimada, diagnostico, montoTotal, sena);
//        this.orden.add(nuevo);
//        guardarOrdenEnDB(nuevo);
//    }
    public void guardarNuevo() {
        this.orden.add(this.getModel());
        guardarOrdenEnDB(this.getModel());
    }

    private void guardarOrdenEnDB(OrdenDeReparacion nuevo) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement psInsert = miConexion.prepareStatement("INSERT INTO orden (numOrden,cliente,fecha,equipo,fallas,motivo,tecnico,estado,accesorios,fechaEstimada,hora,diagnostico,montoTotal,sena) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            psInsert.setInt(1, nuevo.getNumOrden());
            psInsert.setString(2, nuevo.getCliente());
            psInsert.setString(3, nuevo.getFecha());
            psInsert.setString(4, nuevo.getEquipo());
            psInsert.setString(5, nuevo.getFallas());
            psInsert.setString(6, nuevo.getMotivo());
            psInsert.setString(7, nuevo.getTecnico());
            psInsert.setString(8, nuevo.getEstado());
            psInsert.setString(9, nuevo.getAccesorios());
            psInsert.setString(10, nuevo.getFechaEstimada());
            psInsert.setString(11, nuevo.getHora());
            psInsert.setString(12, nuevo.getDiagnostico());
            psInsert.setString(13, nuevo.getMontoTotal());
            psInsert.setString(14, nuevo.getSena());

            psInsert.execute();
            miConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorOrdenDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarO() {
        String regis = FrmAdmOrdenRep.tablaOrden.getValueAt(FrmAdmOrdenRep.tablaOrden.getSelectedRow(), 0).toString();
        int a = FrmAdmOrdenRep.tablaOrden.getSelectedRow();
        int i = JOptionPane.showConfirmDialog(form, "¿Desea eliminar la orden seleccionada?", "Eliminar Orden de Reparación", JOptionPane.OK_CANCEL_OPTION);
        if (i == 0) {
            eliminarOrden(regis, a);
        }
    }

    public void eliminarOrden(String regis, int a) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("DELETE from orden where numOrden='" + regis + "'");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se elimino la orden con éxito.", "Eliminar Orden de Reparación", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel) FrmAdmOrdenRep.tablaOrden.getModel();
        model.removeRow(a);
    }

    public void cargarCliente() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from cliente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("nombre");

                String tmpStrObtenido1 = rs.getString("apellido");
                FrmNuevaOrden.cmbCli.addItem(tmpStrObtenido + " " + tmpStrObtenido1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorVistaNuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarEquipoEnOrden() {
        try {
            String band = FrmNuevaOrden.txtIdEquipo.getText();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from equipo where id='" + band + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tmpStrObtenido = rs.getString("id");
                FrmNuevaOrden.txtIdEquipo.setText(tmpStrObtenido);
                String tmpStrObtenido1 = rs.getString("nombre");
                FrmNuevaOrden.txtTipoEquipo.setText(tmpStrObtenido1);
                String tmpStrObtenido2 = rs.getString("marca");
                FrmNuevaOrden.txtMarca.setText(tmpStrObtenido2);
                String tmpStrObtenido3 = rs.getString("modelo");
                FrmNuevaOrden.txtModelo.setText(tmpStrObtenido3);
                String tmpStrObtenido4 = rs.getString("numSerie");
                FrmNuevaOrden.txtNSerie.setText(tmpStrObtenido4);
                String tmpStrObtenido5 = rs.getString("color");
                FrmNuevaOrden.txtColor.setText(tmpStrObtenido5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarEditar() {
        try {
            String band = FrmNuevaOrden.txtEditar.getText();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from orden INNER JOIN equipo on (equipo.id = orden.equipo) where numOrden='" + band + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tmpStrObtenido = rs.getString("numOrden");
                FrmNuevaOrden.txtNumO.setText(tmpStrObtenido);
                FrmNuevaOrden.cmbCli.removeAllItems();
                String tmpStrObtenido1 = rs.getString("cliente");
                //FrmNuevaOrden.cmbCli.addItem(tmpStrObtenido1);
                FrmNuevaOrden.cmbCli.setSelectedItem(tmpStrObtenido1);
                String tmpStrObtenido2 = rs.getString("fecha");
                FrmNuevaOrden.txtFecha.setText(tmpStrObtenido2);
                String tmpStrObtenido3 = rs.getString("hora");
                FrmNuevaOrden.txtHora.setText(tmpStrObtenido3);
                String tmpStrObtenido4 = rs.getString("estado");
                //FrmNuevaOrden.cmbEstado.addItem(tmpStrObtenido4);
                FrmNuevaOrden.cmbEstado.setSelectedItem(tmpStrObtenido4);
                String tmpStrObtenido5 = rs.getString("equipo");
                FrmNuevaOrden.txtIdEquipo.setText(tmpStrObtenido5);
                String tmpStrObtenido6 = rs.getString("nombre");
                FrmNuevaOrden.txtTipoEquipo.setText(tmpStrObtenido6);
                String tmpStrObtenido7 = rs.getString("marca");
                FrmNuevaOrden.txtMarca.setText(tmpStrObtenido7);
                String tmpStrObtenido8 = rs.getString("modelo");
                FrmNuevaOrden.txtModelo.setText(tmpStrObtenido8);
                String tmpStrObtenido9 = rs.getString("numserie");
                FrmNuevaOrden.txtNSerie.setText(tmpStrObtenido9);
                String tmpStrObtenido10 = rs.getString("color");
                FrmNuevaOrden.txtColor.setText(tmpStrObtenido10);
                String tmpStrObtenido11 = rs.getString("fallas");
                FrmNuevaOrden.txtFalla.setText(tmpStrObtenido11);
                String tmpStrObtenido12 = rs.getString("accesorios");
                FrmNuevaOrden.txtAccesorio.setText(tmpStrObtenido12);
                String tmpStrObtenido13 = rs.getString("diagnostico");
                FrmNuevaOrden.txtDiag.setText(tmpStrObtenido13);
                String tmpStrObtenido14 = rs.getString("montototal");
                FrmNuevaOrden.txtMonto.setText(tmpStrObtenido14);
                String tmpStrObtenido15 = rs.getString("sena");
                FrmNuevaOrden.txtSeña.setText(tmpStrObtenido15);
                String tmpStrObtenido16 = rs.getString("tecnico");
                //FrmNuevaOrden.cmbTec.addItem(tmpStrObtenido16);
                FrmNuevaOrden.cmbTec.setSelectedItem(tmpStrObtenido16);
                
                String tmpStrObtenido17 = rs.getString("motivo");
                if (tmpStrObtenido17 == "Presupuestar") {
                    FrmNuevaOrden.radioPres.setSelected(true);
                } else {
                    FrmNuevaOrden.radioRep.setSelected(true);
                }
                String tmpStrObtenido18 = rs.getString("fechaEstimada");
                FrmNuevaOrden.txtDia.setText(tmpStrObtenido18.substring(0, 2));
                FrmNuevaOrden.txtMes.setText(tmpStrObtenido18.substring(3, 5));
                FrmNuevaOrden.txtAño.setText(tmpStrObtenido18.substring(6, 10));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorOrdenDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarOrden() {

        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select numOrden from orden ORDER BY numOrden DESC limit 1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("numOrden");
                if (tmpStrObtenido.length() == 0) {
                    txtNumO.setEnabled(true);
                    txtNumO.setText("1");
                    txtNumO.setEnabled(false);
                } else {
                    txtNumO.setEnabled(false);
                    int y = Integer.parseInt(tmpStrObtenido) + 1;
                    String l = String.valueOf(y);
                    txtNumO.setText(l);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorOrdenDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void buscarTiempo() {
        //Fecha
        Calendar c1 = Calendar.getInstance();
        Calendar c = new GregorianCalendar();
        String fecha = Integer.toString(c.get(Calendar.DATE)) + "/" + Integer.toString(c.get(Calendar.MONTH) + 1) + "/" + Integer.toString(c.get(Calendar.YEAR));
        FrmNuevaOrden.txtFecha.setText(fecha);
        //Hora actual.
        String hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(c.get(Calendar.MINUTE));
        FrmNuevaOrden.txtHora.setText(hora);
    }

    public void editarOrden() {
        int valor = model.getNumOrden();
        this.orden.add(this.getModel());
        editarOrdenEnDB(this.getModel(), valor);
    }

    public void editarOrdenEnDB(OrdenDeReparacion nuevo, int valor) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement psInsert = miConexion.prepareStatement("UPDATE orden SET cliente=?, fecha=?, equipo=?,fallas=?, motivo=?, tecnico=?, estado=?, accesorios=?, fechaEstimada=?,  hora=?,diagnostico=?, montoTotal=?, sena=? WHERE numOrden='" + valor + "'");
            //psInsert.setInt(1, nuevo.getNumOrden());
            psInsert.setString(1, nuevo.getCliente());
            psInsert.setString(2, nuevo.getFecha());
            psInsert.setString(3, nuevo.getEquipo());
            psInsert.setString(4, nuevo.getFallas());
            psInsert.setString(5, nuevo.getMotivo());
            psInsert.setString(6, nuevo.getTecnico());
            psInsert.setString(7, nuevo.getEstado());
            psInsert.setString(8, nuevo.getAccesorios());
            psInsert.setString(9, nuevo.getFechaEstimada());
            psInsert.setString(10, nuevo.getHora());
            psInsert.setString(11, nuevo.getDiagnostico());
            psInsert.setString(12, nuevo.getMontoTotal());
            psInsert.setString(13, nuevo.getSena());
            psInsert.execute();

            miConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorOrdenDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarFalla() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select distinct fallas from orden");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("fallas");
                FrmNuevaOrden.cmbFalla.addItem(tmpStrObtenido);

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorOrdenDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarTecnico() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from tecnico");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("nombre");

                String tmpStrObtenido1 = rs.getString("apellido");
                FrmNuevaOrden.cmbTec.addItem(tmpStrObtenido + " " + tmpStrObtenido1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorOrdenDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
