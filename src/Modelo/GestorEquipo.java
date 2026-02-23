package Modelo;

import Vistas.GestiónClientes.FrmNuevoCliente;
import Vistas.GestiónEquipos.FrmAdmEquipo;
import Vistas.GestiónEquipos.FrmNuevoEquipo;
import static Vistas.GestiónEquipos.FrmNuevoEquipo.txtB;
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
import sql.InstanciaConexion;

public class GestorEquipo{
    private Equipo model;
    private FrmNuevoEquipo form;

    public Equipo getModel() {
        return model;
    }

    public void setModel(Equipo model) {
        this.model = model;
    }
 
    private List<Equipo> equipo = new ArrayList<Equipo>();

    public void guardarNuevo() {
        this.equipo.add(this.getModel());
        guardarEquipoEnDB(this.getModel());
    }

    private void guardarEquipoEnDB(Equipo nuevo) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement psInsert = miConexion.prepareStatement("INSERT INTO equipo (id,nombre,marca, modelo, numSerie, color) VALUES (?,?,?,?,?,?)");
            psInsert.setInt(1, nuevo.getId());
            psInsert.setString(2, nuevo.getNombre());
            psInsert.setString(3, nuevo.getMarca());
            psInsert.setString(4, nuevo.getModelo());
            psInsert.setString(5, nuevo.getNumeroSerie());
            psInsert.setString(6, nuevo.getColor());
            psInsert.execute();
            miConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editarEquipo() {
        int valor = model.getId();
        this.equipo.add(this.getModel());
        editarEquipoEnDB(this.getModel(), valor);
    }

    public void editarEquipoEnDB(Equipo nuevo, int valor) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement psInsert = miConexion.prepareStatement("UPDATE equipo SET nombre=?, marca=?,modelo=?, numSerie=?, color=? WHERE id='" + valor + "'");
            //psInsert.setInt(1, nuevo.getId());
            psInsert.setString(1, nuevo.getNombre());
            psInsert.setString(2, nuevo.getMarca());
            psInsert.setString(3, nuevo.getModelo());
            psInsert.setString(4, nuevo.getNumeroSerie());
            psInsert.setString(5, nuevo.getColor());
            psInsert.execute();

            miConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarEquipo(String regis, int a) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("DELETE from equipo where id='" + regis + "'");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se elimino el equipo con éxito.", "Eliminar Equipo", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(GestorEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel) FrmAdmEquipo.tablaEquipo.getModel();
        model.removeRow(a);
    }
    
    public void newModel() {
        this.setModel(new Equipo());
    }
    
    public void materializarColecciones() {  
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from equipo");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[5];
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmEquipo.tablaEquipo.getModel();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void vaciarTabla() {
        DefaultTableModel tb = (DefaultTableModel) FrmAdmEquipo.tablaEquipo.getModel();
        tb.setRowCount(0);
    }
    
    public void buscarEditar() {
        try {
            String band = FrmNuevoEquipo.txtB.getText();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from equipo where id='" + band + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tmpStrObtenido = rs.getString("id");
                FrmNuevoEquipo.txtId.setText(tmpStrObtenido);
                String tmpStrObtenido1 = rs.getString("nombre");
                FrmNuevoEquipo.txtNombre.setText(tmpStrObtenido1);
                String tmpStrObtenido2 = rs.getString("marca");
                FrmNuevoEquipo.txtMarca.setText(tmpStrObtenido2);
                String tmpStrObtenido3 = rs.getString("modelo");
                FrmNuevoEquipo.txtModelo.setText(tmpStrObtenido3);
                String tmpStrObtenido4 = rs.getString("numSerie");
                FrmNuevoEquipo.txtNSerie.setText(tmpStrObtenido4);
                String tmpStrObtenido5 = rs.getString("color");
                FrmNuevoEquipo.txtColor.setText(tmpStrObtenido5);
                FrmNuevoEquipo.txtId.setEnabled(false);

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscarEquipo() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select id from equipo ORDER BY id DESC limit 1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("id");
                if (tmpStrObtenido.length() == 0) {
                    FrmNuevoEquipo.txtId.setEnabled(true);
                    FrmNuevoEquipo.txtId.setText("1");
                    FrmNuevoEquipo.txtId.setEnabled(false);
                } else {
                    FrmNuevoEquipo.txtId.setEnabled(false);
                    int y = Integer.parseInt(tmpStrObtenido) + 1;
                    String l = String.valueOf(y);
                    FrmNuevoEquipo.txtId.setText(l);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void opcionGuardar(String mod) {
        if ("0".equals(mod)) {
                int i = JOptionPane.showConfirmDialog(form, "¿Desea registrar un nuevo equipo?", "Registrar Equipo", JOptionPane.OK_CANCEL_OPTION); //ventana de confirmación.
                if (i == 0) {
                    this.guardarNuevo();
                    JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo cliente con éxito.");
                    vaciarCampos();
                    vaciarTabla();
                    materializarColecciones();
                }
            } else {
                int j = JOptionPane.showConfirmDialog(form, "¿Desea modificar el equipo?", "Modificar Equipo", JOptionPane.OK_CANCEL_OPTION); //ventana de confirmación.
                if (j == 0) {
                    this.editarEquipo();
                    JOptionPane.showMessageDialog(null, "Se ha modificado el equipo con éxito.");
                    vaciarTabla();
                    materializarColecciones();
               }
            }
    }
    
    
    
    
    
        public void filtro(String id) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from equipo where id LIKE'%" + id + "%'");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[11];
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmEquipo.tablaEquipo.getModel();
                vaciarTabla();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
        
     public void vaciarCampos(){
         FrmNuevoEquipo.txtNombre.setText("");
         FrmNuevoEquipo.txtMarca.setText("");
         FrmNuevoEquipo.txtModelo.setText("");
         FrmNuevoEquipo.txtNSerie.setText("");
         FrmNuevoEquipo.txtColor.setText("");
         buscarEquipo();                
     }   
        
}
