package Vistas.GestiónClientes;
import Modelo.GestorCliente;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class FrmAdmCliente extends javax.swing.JInternalFrame {
    private GestorVistaAdmCliente gestorVista = new GestorVistaAdmCliente();
    private GestorCliente gestorCliente = new GestorCliente();
    

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

    public static JRadioButton getRadDniC() {
        return radDniC;
    }

    public static void setRadDniC(JRadioButton radDniC) {
        FrmAdmCliente.radDniC = radDniC;
    }

    public static JRadioButton getRadNombreC() {
        return radNombreC;
    }

    public static void setRadNombreC(JRadioButton radNombreC) {
        FrmAdmCliente.radNombreC = radNombreC;
    }

    public static JTable getTabla() {
        return tabla;
    }

    public static void setTabla(JTable tabla) {
        FrmAdmCliente.tabla = tabla;
    }
    
    
    
    public FrmAdmCliente() {
        initComponents();
    
        this.getGestorVista().crearModeloDeDatos(this.getGestorVista().getCliente());
        this.getGestorCliente().materializarColecciones();
    }
    
    public FrmAdmCliente(GestorVistaAdmCliente gestorVista) {
      
        initComponents();
        this.setGestorVista(gestorVista);
        
        this.getGestorVista().crearModeloDeDatos(gestorVista.getCliente());
        this.getGestorCliente().materializarColecciones();     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnEditarCliente = new javax.swing.JButton();
        btnBorrarCliente = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtBuscarC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        radNombreC = new javax.swing.JRadioButton();
        radDniC = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Administrador de Clientes");

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

        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.gif"))); // NOI18N
        btnNuevoCliente.setText("Nuevo");
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(btnNuevoCliente)
                .addGap(18, 18, 18)
                .addComponent(btnEditarCliente)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarCliente)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnBorrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tabla.setSelectionBackground(new java.awt.Color(0, 153, 204));
        tabla.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tabla);

        txtBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCActionPerformed(evt);
            }
        });
        txtBuscarC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarCKeyPressed(evt);
            }
        });

        jLabel1.setText("Filtrar por:");

        buttonGroup1.add(radNombreC);
        radNombreC.setSelected(true);
        radNombreC.setText("Nombre");

        buttonGroup1.add(radDniC);
        radDniC.setText("DNI");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PhotoPrint_6314.png"))); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(50, 50, 50)
                                        .addComponent(radNombreC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radDniC))
                                    .addComponent(txtBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(478, 478, 478))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radNombreC)
                    .addComponent(radDniC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        gestorVista.abrirNuevoCliente(0);
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnBorrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarClienteActionPerformed
        gestorVista.eliminarRegistro();
    }//GEN-LAST:event_btnBorrarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        gestorVista.editarCliente(1);
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void txtBuscarCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCKeyPressed
        //gestorVista.busquedaCliente(); 
    }//GEN-LAST:event_txtBuscarCKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       gestorVista.busquedaCliente(); 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        gestorVista.GenerarReporte();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarCliente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnReporte;
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
