/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.GestiónTecnico;
import Modelo.GestorTecnico;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class FrmAdmTecnico extends javax.swing.JInternalFrame {
    private GestorVistaAdmTecnico gestorVista = new GestorVistaAdmTecnico();
    private GestorTecnico gestorTecnico = new GestorTecnico(); 

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

    public static JRadioButton getRadDniC() {
        return radDniC;
    }

    public static void setRadDniC(JRadioButton radDniC) {
        FrmAdmTecnico.radDniC = radDniC;
    }

    public static JRadioButton getRadNombreC() {
        return radNombreC;
    }

    public static void setRadNombreC(JRadioButton radNombreC) {
        FrmAdmTecnico.radNombreC = radNombreC;
    }

    public static JTable getTabla() {
        return tabla;
    }

    public static void setTabla(JTable tabla) {
        FrmAdmTecnico.tabla = tabla;
    }
    
    
    
    public FrmAdmTecnico() {
        initComponents();
    
        this.getGestorVista().crearModeloDeDatos(this.getGestorVista().getTecnico());
        this.getGestorTecnico().materializarColecciones();
    }
    
    public FrmAdmTecnico(GestorVistaAdmTecnico gestorVista) {
      
        initComponents();
        this.setGestorVista(gestorVista);
        
        this.getGestorVista().crearModeloDeDatos(gestorVista.getTecnico());
        this.getGestorTecnico().materializarColecciones();     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnNuevoCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnBorrarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnBuscarC = new javax.swing.JButton();
        txtBuscarC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        radNombreC = new javax.swing.JRadioButton();
        radDniC = new javax.swing.JRadioButton();
        btnMaterializar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Administrador de Técnicos");

        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.gif"))); // NOI18N
        btnNuevoCliente.setText("Nuevo");
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editar.gif"))); // NOI18N
        btnEditarCliente.setText("Editar");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnBorrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar.gif"))); // NOI18N
        btnBorrarCliente.setText("Borrar");
        btnBorrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoCliente)
                .addGap(18, 18, 18)
                .addComponent(btnEditarCliente)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnBorrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tabla);

        btnBuscarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscarC.setText("Buscar");
        btnBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtrar por:");

        buttonGroup1.add(radNombreC);
        radNombreC.setText("Nombre");

        buttonGroup1.add(radDniC);
        radDniC.setText("DNI");

        btnMaterializar.setText("Todo");
        btnMaterializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterializarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1337, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)
                                .addComponent(radNombreC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radDniC))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarC)
                                .addGap(18, 18, 18)
                                .addComponent(btnMaterializar)))
                        .addContainerGap(960, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(498, 498, 498))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaterializar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radNombreC)
                    .addComponent(radDniC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        gestorVista.abrirNuevoTecnico(0);
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnBorrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarClienteActionPerformed
        gestorVista.eliminarRegistro();
    }//GEN-LAST:event_btnBorrarClienteActionPerformed

    private void btnBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCActionPerformed
       gestorVista.busquedaTecnico();
    }//GEN-LAST:event_btnBuscarCActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        gestorVista.editarTecnico(1);
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnMaterializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterializarActionPerformed
        gestorVista.vaciarTabla();
        this.getGestorTecnico().materializarColecciones();
    }//GEN-LAST:event_btnMaterializarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarCliente;
    private javax.swing.JButton btnBuscarC;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnMaterializar;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JRadioButton radDniC;
    public static javax.swing.JRadioButton radNombreC;
    public static javax.swing.JTable tabla;
    public static javax.swing.JTextField txtBuscarC;
    // End of variables declaration//GEN-END:variables
}
