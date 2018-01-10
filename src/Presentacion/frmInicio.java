
package Presentacion;

import Logica.conexion;
import java.awt.Dimension;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class frmInicio extends javax.swing.JFrame {

    
    public frmInicio() {
        initComponents();
        this.setExtendedState(frmInicio.MAXIMIZED_BOTH);
        this.setTitle("Sistema de Control de Paciente");
        ocultarlabel();
    }

    void ocultarlabel(){
        lblidpersona.setVisible(false);
        lblnombre.setVisible(false);
        lblapellido.setVisible(false);
        lblacceso.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        lblidpersona = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblapellido = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        mnuarchivo = new javax.swing.JMenu();
        itemPacientes = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuconfiguraciones = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblidpersona.setText("jLabel1");
        escritorio.add(lblidpersona);
        lblidpersona.setBounds(10, 20, 34, 14);

        lblnombre.setText("jLabel1");
        escritorio.add(lblnombre);
        lblnombre.setBounds(10, 40, 34, 14);

        lblapellido.setText("jLabel1");
        escritorio.add(lblapellido);
        lblapellido.setBounds(20, 60, 34, 14);

        lblacceso.setText("jLabel1");
        escritorio.add(lblacceso);
        lblacceso.setBounds(20, 80, 34, 14);

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/Inicio.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("SisClinica");
        menuBar.add(fileMenu);

        mnuarchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/Archivo.png"))); // NOI18N
        mnuarchivo.setMnemonic('e');
        mnuarchivo.setText("Pacientes");

        itemPacientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/clientes.png"))); // NOI18N
        itemPacientes.setText("Pacientes");
        itemPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPacientesActionPerformed(evt);
            }
        });
        mnuarchivo.add(itemPacientes);

        menuBar.add(mnuarchivo);

        mnuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/Consultas.png"))); // NOI18N
        mnuConsultas.setText("Consulta");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/reservas-consumos.png"))); // NOI18N
        jMenuItem1.setText("Consultas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuConsultas.add(jMenuItem1);

        menuBar.add(mnuConsultas);

        mnuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/Reservas.png"))); // NOI18N
        mnuReportes.setText("Reportes");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/pagos.png"))); // NOI18N
        jMenuItem2.setText("Pacientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/habitaciones.png"))); // NOI18N
        jMenuItem3.setText("Consultas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem3);

        menuBar.add(mnuReportes);

        mnuconfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/Configuraciones.png"))); // NOI18N
        mnuconfiguraciones.setMnemonic('h');
        mnuconfiguraciones.setText("Configuraciones");

        contentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        contentMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/trabajadores.png"))); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Usuarios y Accesos");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        mnuconfiguraciones.add(contentMenuItem);

        menuBar.add(mnuconfiguraciones);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/Salir.png"))); // NOI18N
        jMenu1.setText("Salir");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPacientesActionPerformed
        // TODO add your handling code here:
        frmCliente form = new frmCliente();
        
        escritorio.add(form);
        Dimension escritoriosize = escritorio.getSize();
        Dimension frameSize = form.getSize();
        form.setLocation((escritoriosize.width - frameSize.width)/2, (escritoriosize.height - frameSize.height)/2);
        form.toFront();
        form.setVisible(true);
        
    }//GEN-LAST:event_itemPacientesActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        // TODO add your handling code here:
        frmTrabajador form = new frmTrabajador();
        escritorio.add(form);
        Dimension escritoriosize = escritorio.getSize();
        Dimension frameSize = form.getSize();
        form.setLocation((escritoriosize.width - frameSize.width)/2, (escritoriosize.height - frameSize.height)/2);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        frmConsulta form = new frmConsulta();
        escritorio.add(form);
        Dimension escritoriosize = escritorio.getSize();
        Dimension frameSize = form.getSize();
        form.setLocation((escritoriosize.width - frameSize.width)/2, (escritoriosize.height - frameSize.height)/2);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
private Connection connection = new conexion().conectar();
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;
        try{
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/rptPacente.jrxml");
            
            print=JasperFillManager.fillReport(report, p,connection);
            JasperViewer view = new JasperViewer(print,false);
            view.setTitle("Reporte de Pacientes");
            view.setVisible(true);
            
        }catch(Exception e){
           e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;
        try{
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/rptConsultas.jrxml");
            
            print=JasperFillManager.fillReport(report, p,connection);
            JasperViewer view = new JasperViewer(print,false);
            view.setTitle("Reporte de Consultas");
            view.setVisible(true);
            
        }catch(Exception e){
           e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem contentMenuItem;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu fileMenu;
    public static javax.swing.JMenuItem itemPacientes;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblapellido;
    public static javax.swing.JLabel lblidpersona;
    public static javax.swing.JLabel lblnombre;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu mnuConsultas;
    public static javax.swing.JMenu mnuReportes;
    public static javax.swing.JMenu mnuarchivo;
    public static javax.swing.JMenu mnuconfiguraciones;
    // End of variables declaration//GEN-END:variables

}
