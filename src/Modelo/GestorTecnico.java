package Modelo;

import Vistas.GestiónTecnico.FrmAdmTecnico;
import Vistas.GestiónTecnico.FrmNuevoTecnico;
import Vistas.GestiónClientes.GestorVistaNuevoCliente;
import static Vistas.GestiónTecnico.FrmNuevoTecnico.txtB;
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

public class GestorTecnico {
    private Tecnico model;
    private FrmNuevoTecnico form;

    public Tecnico getModel() {
        return model;
    }

    public void setModel(Tecnico model) {
        this.model = model;
    }
 
    private List<Tecnico> tecnico = new ArrayList<Tecnico>();
    
    
    
    
    
    
    public void guardarNuevo() {
        this.tecnico.add(this.getModel());
        guardarTecnicoEnDB(this.getModel());
    }
   
    private void guardarTecnicoEnDB(Tecnico nuevo) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement psInsert = miConexion.prepareStatement("INSERT INTO tecnico (id,nombre,apellido,tipoDeDocumento,numDocumento,fechaNacimiento,provincia,localidad,direccion,telefono,email) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
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
            Logger.getLogger(GestorTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarTecnico() {
        int valor = model.getId();
        this.tecnico.add(this.getModel());
        editarTecnicoEnDB(this.getModel(), valor);
    }
    
    public void editarTecnicoEnDB(Tecnico nuevo, int valor){
       try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement psInsert = miConexion.prepareStatement("UPDATE tecnico SET nombre=?, apellido=?,tipoDeDocumento=?,numDocumento=?,fechaNacimiento=?, provincia=?, localidad=?, direccion=?, telefono=?, email=? WHERE id='"+valor+"'");
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
            Logger.getLogger(GestorTecnico.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void eliminarReg(String regis, int a) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("DELETE from tecnico where id='" + regis + "'");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se elimino el técnico con éxito.", "Eliminar Técnico", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel) FrmAdmTecnico.tabla.getModel();
        model.removeRow(a);
    }   

    public void newModel() {
        this.setModel(new Tecnico());
    }
    

    public void cargarComboProvincia() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from provincia order by provincia_nombre");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("provincia_nombre");
                FrmNuevoTecnico.cmbProv.addItem(tmpStrObtenido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorVistaNuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarComboLocalidad(){
        try {
            String auxProv = (String) FrmNuevoTecnico.cmbProv.getSelectedItem();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from ciudad where fk_provincia='"+ auxProv +"' AND ciudad_nombre<> ' ' order by ciudad_nombre");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("ciudad_nombre");
                FrmNuevoTecnico.cmbLocalidad.addItem(tmpStrObtenido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorVistaNuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void materializarColecciones() {  
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from tecnico");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[11];
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmTecnico.tabla.getModel();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscarTodo(){
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from tecnico");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[11];
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmTecnico.tabla.getModel();
                vaciarTabla();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void buscarPorNombre(String nom) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from tecnico where nombre='" + nom + "'");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[11];
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmTecnico.tabla.getModel();
                vaciarTabla();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void vaciarTabla() {
        DefaultTableModel tb = (DefaultTableModel) FrmAdmTecnico.tabla.getModel();
        tb.setRowCount(0);
    }

    public void buscarPorDni(String dni) {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from tecnico where numDocumento='" + dni + "'");
            ResultSet rs = ps.executeQuery();
            Object datos[] = new Object[11];
            while (rs.next()) {
                for (int i = 0; i < 11; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                DefaultTableModel model = (DefaultTableModel) FrmAdmTecnico.tabla.getModel();
                vaciarTabla();
                model.addRow(datos);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarEditar() {
        try {
            String band = FrmNuevoTecnico.txtB.getText();
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select * from tecnico where id='" + band + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tmpStrObtenido = rs.getString("id");
                FrmNuevoTecnico.txtId.setText(tmpStrObtenido);
                String tmpStrObtenido1 = rs.getString("nombre");
                FrmNuevoTecnico.txtNombre.setText(tmpStrObtenido1);
                String tmpStrObtenido2 = rs.getString("apellido");
                FrmNuevoTecnico.txtApellido.setText(tmpStrObtenido2);
                String tmpStrObtenido3 = rs.getString("tipoDeDocumento");
                //FrmNuevoTecnico.cmbTipoDocu.addItem(tmpStrObtenido3);
                FrmNuevoTecnico.cmbTipoDocu.setSelectedItem(tmpStrObtenido3);
                String tmpStrObtenido4 = rs.getString("numDocumento");
                FrmNuevoTecnico.txtDocu.setText(tmpStrObtenido4);
                String tmpStrObtenido5 = rs.getString("provincia");
                //FrmNuevoTecnico.cmbProv.addItem(tmpStrObtenido5);
                FrmNuevoTecnico.cmbProv.setSelectedItem(tmpStrObtenido5);
                String tmpStrObtenido6 = rs.getString("localidad");
                //FrmNuevoTecnico.cmbLocalidad.addItem(tmpStrObtenido6);
                FrmNuevoTecnico.cmbLocalidad.setSelectedItem(tmpStrObtenido6);
                String tmpStrObtenido7 = rs.getString("direccion");
                FrmNuevoTecnico.txtDire.setText(tmpStrObtenido7);
                String tmpStrObtenido8 = rs.getString("telefono");
                FrmNuevoTecnico.txtTel.setText(tmpStrObtenido8);
                String tmpStrObtenido9 = rs.getString("email");
                FrmNuevoTecnico.txtEmail.setText(tmpStrObtenido9);
                String tmpStrObtenido10 = rs.getString("fechaNacimiento");
                FrmNuevoTecnico.txtFechaNacimiento.setText(tmpStrObtenido10.substring(0,2));
                FrmNuevoTecnico.txtMesNac.setText(tmpStrObtenido10.substring(3,5));
                FrmNuevoTecnico.txtAñoNac.setText(tmpStrObtenido10.substring(6,10));
                FrmNuevoTecnico.txtId.setEnabled(false);

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarTecnico() {
        try {
            Connection miConexion = InstanciaConexion.getInstanciaUnica().getConexion();
            PreparedStatement ps = miConexion.prepareStatement("select id from tecnico ORDER BY id DESC limit 1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String tmpStrObtenido = rs.getString("id");
                if (tmpStrObtenido.length() == 0) {
                    FrmNuevoTecnico.txtId.setEnabled(true);
                    FrmNuevoTecnico.txtId.setText("1");
                    FrmNuevoTecnico.txtId.setEnabled(false);
                } else {
                    FrmNuevoTecnico.txtId.setEnabled(false);
                    int y = Integer.parseInt(tmpStrObtenido) + 1;
                    String l = String.valueOf(y);
                    FrmNuevoTecnico.txtId.setText(l);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void vaciarCampos() {
        FrmNuevoTecnico.txtNombre.setText("");
        FrmNuevoTecnico.txtApellido.setText("");
        FrmNuevoTecnico.txtDocu.setText("");
        FrmNuevoTecnico.txtDire.setText("");
        FrmNuevoTecnico.txtEmail.setText("");
        FrmNuevoTecnico.txtTel.setText("");
        FrmNuevoTecnico.txtFechaNacimiento.setText("");
        FrmNuevoTecnico.txtMesNac.setText("");
        FrmNuevoTecnico.txtAñoNac.setText("");
        this.buscarTecnico();

    }

    public void opcionGuardar(String mod) {
        if ("0".equals(mod)) {
            int i = JOptionPane.showConfirmDialog(form, "¿Desea registrar un nuevo técnico?", "Registrar Técnico", JOptionPane.OK_CANCEL_OPTION); //ventana de confirmación.
            if (i == 0) {
                this.guardarNuevo();
                JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo técnico con éxito.");
                vaciarCampos();
                vaciarTabla();
                materializarColecciones();
            }
        } else{
            if ("2".equals(mod)){
                int i = JOptionPane.showConfirmDialog(form, "¿Desea registrar un nuevo técnico?", "Registrar Técnico", JOptionPane.OK_CANCEL_OPTION); //ventana de confirmación.
                    if (i == 0) {
                        this.guardarNuevo();
                        JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo técnico con éxito.");
                        vaciarCampos();
            }
        } else {
            String au = txtB.getText();
            int j = JOptionPane.showConfirmDialog(form, "¿Desea modificar el técnico?", "Modificar Técnico", JOptionPane.OK_CANCEL_OPTION); //ventana de confirmación.
            if (j == 0) {
                this.editarTecnico();
                JOptionPane.showMessageDialog(null, "Se ha modificado el técnico con éxito.");
                vaciarTabla();
                materializarColecciones();
            }
        }
    }
    }
}
  


    
    
    
    
    

