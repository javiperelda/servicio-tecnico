package Vistas.GestionOrdenReparacion;

import Modelo.GestorOrdenDeReparacion;
import Modelo.OrdenDeReparacion;
import static Vistas.GestionOrdenReparacion.FrmAdmOrdenRep.*;
import Vistas.MenuPrincipal.FrmMenuPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sql.Conexion;
import sql.InstanciaConexion;

public class GestorVistaAdmOrdenRep {

    GestorVistaNuevaOrden gesno = new GestorVistaNuevaOrden();
    private GestorOrdenDeReparacion GestorOrden;
    private List<OrdenDeReparacion> orden = new ArrayList<OrdenDeReparacion>();
    private FrmAdmOrdenRep form;

    private GestorOrdenDeReparacion gestorOrden = new GestorOrdenDeReparacion();

    public GestorOrdenDeReparacion getGestorOrden() {
        return GestorOrden;
    }

    public void setGestorOrden(GestorOrdenDeReparacion GestorOrden) {
        this.GestorOrden = GestorOrden;
    }

    public FrmAdmOrdenRep getForm() {
        return form;
    }

    public void setForm(FrmAdmOrdenRep form) {
        this.form = form;
    }

    public void abrirVent() {
        FrmAdmOrdenRep or = new FrmAdmOrdenRep();
        FrmMenuPrincipal.escritorio.add(or);
        or.setVisible(true);
    }

    public void abrirNuevaOrden(int modo) {
        gesno.abrirVentNuevaO(modo);
    }

    public List<OrdenDeReparacion> getOrden() {
        return this.orden;
    }

    public void vaciarTabla() {
        DefaultTableModel tb = (DefaultTableModel) FrmAdmOrdenRep.tablaOrden.getModel();
        tb.setRowCount(0);
    }

    public void buscarOrd(String norden) {
        try {
            vaciarTabla();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from orden where numorden ="+ norden);
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
    
    public void buscarCliente(String nom) {
        try {
            vaciarTabla();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from orden where cliente LIKE '%"+ nom +"%'");
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
    

    void filtro() {
        String bandera = FrmAdmOrdenRep.txtBuscarO.getText();
        int lon = bandera.length();
        if ((radioNumO.isSelected() == true) && (lon != 0)) {
            buscarOrd(bandera);
        }
        if ((radioCliente.isSelected() == true) && (lon != 0)) {
            buscarCliente(bandera);
        }

        if (lon == 0) {
            vaciarTabla();
            materializarColecciones();
        }

    }

    public void crearModeloDeDatos(List<OrdenDeReparacion> orden) {
        DefaultTableModel modelo = new DefaultTableModel(
                null,
                new String[]{"Número Orden", "Cliente", "Fecha de Alta", "Número Equipo", "Fallas", "Motivo", "Técnico Asignado", "Estado"});

        for (OrdenDeReparacion r : orden) {
            if (r != null) {
                Object[] fila = new Object[]{
                    r,
                    r.getNumOrden(),
                    r.getCliente(),
                    r.getFecha(),
                    r.getEquipo(),
                    r.getFallas(),
                    r.getMotivo(),
                    r.getTecnico(),
                    r.getEstado()};
                modelo.addRow(fila);
            }
        }
        FrmAdmOrdenRep.tablaOrden.setModel(modelo);
    }

    public void materializarColecciones() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from orden order by numOrden");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[9];
            while (rs.next()) {
                for (int i = 0; i < 9; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmOrdenRep.tablaOrden.getModel();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorVistaAdmOrdenRep.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }

    private Connection con = null;
    Conexion conexion = null;

    public void GenerarReporte() {

        conexion = new Conexion("");
        con = conexion.con;
        String band = FrmAdmOrdenRep.tablaOrden.getValueAt(FrmAdmOrdenRep.tablaOrden.getSelectedRow(), 0).toString();
        int nOrden = Integer.parseInt(band);
        try {
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteOrdenRep.jasper"));
            } catch (JRException e) {
                System.out.println("Error cargando el reporte maestro");
            }

            Map parametro = new HashMap();
            parametro.put("nOrden", nOrden);
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jViewer = new JasperViewer(jasperPrint, false);
            jViewer.setTitle("Reporte");
            jViewer.setVisible(true);

        } catch (JRException e) {
            System.out.println("Error Generando Reporte " + e.getMessage());
        }

    }

    public void reporte() {
        GenerarReporte();
    }

}
