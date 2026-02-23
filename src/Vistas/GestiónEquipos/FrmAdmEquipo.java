package Vistas.GestiónEquipos;

import Modelo.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FrmAdmEquipo extends javax.swing.JInternalFrame {

    private GestorVistaAdmEquipo gestorVista = new GestorVistaAdmEquipo();
    private GestorEquipo gestorEquipo = new GestorEquipo();

/////////////////////////////////////////////////
    public GestorVistaAdmEquipo getGestorVista() {
        return gestorVista;
    }

    public void setGestorVista(GestorVistaAdmEquipo gestorVista) {
        this.gestorVista = gestorVista;
    }

    public GestorEquipo getGestorEquipo() {
        return gestorEquipo;
    }

    public void setGestorEquipo(GestorEquipo gestorEquipo) {
        this.gestorEquipo = gestorEquipo;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JButton getjButton2() {
        return btnFiltro;
    }

    public void setjButton2(JButton jButton2) {
        this.btnFiltro = jButton2;
    }

    public JPanel getjPanel1() {
        return panelAdmEquipo;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.panelAdmEquipo = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public static JTable getTablaEquipo() {
        return tablaEquipo;
    }

    public static void setTablaEquipo(JTable tablaEquipo) {
        FrmAdmEquipo.tablaEquipo = tablaEquipo;
    }

    public static JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public static void setTxtBuscar(JTextField txtBuscar) {
        FrmAdmEquipo.txtBuscar = txtBuscar;
    }

    public FrmAdmEquipo() {
        initComponents();

        this.getGestorVista().crearModeloDeDatos(this.getGestorVista().getEquipo());
        this.getGestorEquipo().materializarColecciones();
        this.setLocation(400, 30);
    }

    public FrmAdmEquipo(GestorVistaAdmEquipo gestorVista) {

        initComponents();
        this.setGestorVista(gestorVista);

        this.getGestorVista().crearModeloDeDatos(gestorVista.getEquipo());
        this.getGestorEquipo().materializarColecciones();
        this.setLocation(400, 30);
    }
//////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        btnFiltro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEquipo = new javax.swing.JTable();
        panelAdmEquipo = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnAgregarEquipo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Administrar Equipos");

        btnFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnFiltro.setText("Buscar Código");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });
        btnFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnFiltroKeyPressed(evt);
            }
        });

        tablaEquipo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaEquipo.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tablaEquipo);

        panelAdmEquipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.gif"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editar.gif"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar.gif"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdmEquipoLayout = new javax.swing.GroupLayout(panelAdmEquipo);
        panelAdmEquipo.setLayout(panelAdmEquipoLayout);
        panelAdmEquipoLayout.setHorizontalGroup(
            panelAdmEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdmEquipoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnBorrar)
                .addGap(336, 336, 336))
        );
        panelAdmEquipoLayout.setVerticalGroup(
            panelAdmEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdmEquipoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAdmEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        boolean aFlag = false;
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_OK_132710.png"))); // NOI18N
        btnSeleccionar.setVisible(aFlag);
        btnSeleccionar.setToolTipText("Seleccionar un equipo");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        boolean aFlag1 = false;
        btnAgregarEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-icono-5633-16.png"))); // NOI18N
        btnAgregarEquipo.setVisible(aFlag1);
        btnAgregarEquipo.setToolTipText("Agregar un nuevo equipo");
        btnAgregarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(panelAdmEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(panelAdmEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        gestorVista.abrirNuevoEquipo(0);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        gestorVista.editarEquipo(1);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        gestorVista.eliminarRegistro();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        gestorVista.filtro();
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void btnFiltroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnFiltroKeyPressed

    }//GEN-LAST:event_btnFiltroKeyPressed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        gestorVista.seleccionEquipo();
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnAgregarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEquipoActionPerformed
        gestorVista.abrirNuevoEquipo(0);

    }//GEN-LAST:event_btnAgregarEquipoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregarEquipo;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFiltro;
    private javax.swing.JButton btnNuevo;
    public static javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JPanel panelAdmEquipo;
    public static javax.swing.JTable tablaEquipo;
    public static javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
