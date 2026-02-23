package Vistas.GestionOrdenReparacion;

import Modelo.GestorOrdenDeReparacion;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FrmAdmOrdenRep extends javax.swing.JInternalFrame {

    GestorVistaAdmOrdenRep ges = new GestorVistaAdmOrdenRep();
    GestorVistaNuevaOrden gesno = new GestorVistaNuevaOrden();
    GestorOrdenDeReparacion gestorOrdenReparacion = new GestorOrdenDeReparacion();

    public GestorOrdenDeReparacion getGestorOrdenReparacion() {
        return gestorOrdenReparacion;
    }

    public void setGestorOrdenReparacion(GestorOrdenDeReparacion gestorOrdenReparacion) {
        this.gestorOrdenReparacion = gestorOrdenReparacion;
    }
    
    public GestorVistaAdmOrdenRep getGes() {
        return ges;
    }

    public void setGes(GestorVistaAdmOrdenRep ges) {
        this.ges = ges;
    }

    public GestorVistaNuevaOrden getGesno() {
        return gesno;
    }

    public void setGesno(GestorVistaNuevaOrden gesno) {
        this.gesno = gesno;
    }

    public JButton getBtnBorrarO() {
        return btnBorrarO;
    }

    public void setBtnBorrarO(JButton btnBorrarO) {
        this.btnBorrarO = btnBorrarO;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

//    public JButton getBtnCerrar() {
//        return btnCerrar;
//    }
//
//    public void setBtnCerrar(JButton btnCerrar) {
//        this.btnCerrar = btnCerrar;
//    }

    public JButton getBtnEditarO() {
        return btnEditarO;
    }

    public void setBtnEditarO(JButton btnEditarO) {
        this.btnEditarO = btnEditarO;
    }

    public JButton getBtnNuevaO() {
        return btnNuevaO;
    }

    public void setBtnNuevaO(JButton btnNuevaO) {
        this.btnNuevaO = btnNuevaO;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public static JRadioButton getRadioNumO() {
        return radioNumO;
    }

    public static void setRadioNumO(JRadioButton radioNumO) {
        FrmAdmOrdenRep.radioNumO = radioNumO;
    }

    public static JTable getTablaOrden() {
        return tablaOrden;
    }

    public static void setTablaOrden(JTable tablaOrden) {
        FrmAdmOrdenRep.tablaOrden = tablaOrden;
    }

    public static JTextField getTxtBuscarO() {
        return txtBuscarO;
    }

    public static void setTxtBuscarO(JTextField txtBuscarO) {
        FrmAdmOrdenRep.txtBuscarO = txtBuscarO;
    }

    public FrmAdmOrdenRep() {
        initComponents();
        ges.crearModeloDeDatos(ges.getOrden());
        ges.materializarColecciones();
    }

    public FrmAdmOrdenRep(GestorVistaAdmOrdenRep ges) {
        initComponents();
        ges.crearModeloDeDatos(ges.getOrden());
        ges.materializarColecciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        radioNumO = new javax.swing.JRadioButton();
        txtBuscarO = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnEditarO = new javax.swing.JButton();
        btnBorrarO = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrden = new javax.swing.JTable();
        btnReporte = new javax.swing.JButton();
        btnNuevaO = new javax.swing.JButton();
        radioCliente = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Administrar Ordenes de Reparación");
        setPreferredSize(new java.awt.Dimension(1363, 523));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtrar por:");

        buttonGroup1.add(radioNumO);
        radioNumO.setSelected(true);
        radioNumO.setText("N° de Orden");
        radioNumO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNumOActionPerformed(evt);
            }
        });

        btnEditarO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editar.gif"))); // NOI18N
        btnEditarO.setText("Editar");
        btnEditarO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarOActionPerformed(evt);
            }
        });

        btnBorrarO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar.gif"))); // NOI18N
        btnBorrarO.setText("Borrar");
        btnBorrarO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditarO)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarO)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnEditarO, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnBorrarO, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tablaOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° Orden", "Cliente", "Motivo", "Estado", "Fecha"
            }
        ));
        tablaOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaOrden.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tablaOrden);

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PhotoPrint_6314.png"))); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnNuevaO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.gif"))); // NOI18N
        btnNuevaO.setText("Nuevo");
        btnNuevaO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaOActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioCliente);
        radioCliente.setText("Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1327, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtBuscarO, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioNumO)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioCliente)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevaO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(336, 336, 336))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNumO)
                    .addComponent(radioCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevaO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioNumOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNumOActionPerformed

    }//GEN-LAST:event_radioNumOActionPerformed

    private void btnNuevaOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaOActionPerformed
        ges.abrirNuevaOrden(0);
    }//GEN-LAST:event_btnNuevaOActionPerformed

    private void btnEditarOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarOActionPerformed
        ges.abrirNuevaOrden(1);
    }//GEN-LAST:event_btnEditarOActionPerformed

    private void btnBorrarOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarOActionPerformed
        gesno.eliminarO();
    }//GEN-LAST:event_btnBorrarOActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ges.filtro();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        ges.reporte();
    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarO;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditarO;
    private javax.swing.JButton btnNuevaO;
    private javax.swing.JButton btnReporte;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JRadioButton radioCliente;
    public static javax.swing.JRadioButton radioNumO;
    public static javax.swing.JTable tablaOrden;
    public static javax.swing.JTextField txtBuscarO;
    // End of variables declaration//GEN-END:variables

}
