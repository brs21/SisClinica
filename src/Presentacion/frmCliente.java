package Presentacion;

import Datos.vcliente;
import Datos.vconsulta;
import Datos.vexpediente;
import Logica.conexion;
import Logica.fcliente;
import Logica.fconsulta;
import Logica.fexpediente;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Boris
 */
public class frmCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCliente
     */
    public frmCliente() {
        initComponents();

        this.setTitle("Registro de Pacientes");
        inhabilitar();
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        mostrar("");

    }

    private String accion = "guardar";
    public int fila;
    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(3).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(3).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(5).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(5).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(6).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(6).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(6).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(7).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(7).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(7).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(9).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(9).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(9).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(10).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(10).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(10).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(11).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(11).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(11).setPreferredWidth(0);
    }

    void inhabilitar() {

        //cajas de texto
        lblruta.setVisible(false);
        txtidpersona.setVisible(false);
        txtrutaimagen.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
        cbotipo_documento.setEnabled(false);
        txtnumero_documento.setEnabled(false);
        txtdireccion.setEnabled(false);
        txttelefono.setEnabled(false);
        txtemail.setEnabled(false);
        dcfecha_nacimiento.setEnabled(false);
        txtcodigo_cliente.setEnabled(false);

        //botones
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnbuscarimagen.setEnabled(false);
        //dejar en blanco las cajas de texto
        txtidpersona.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtnumero_documento.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtemail.setText("");
        dcfecha_nacimiento.setDate(null);
        txtcodigo_cliente.setText("");
        txtrutaimagen.setText("");
        lblfotografia.setIcon(null);
        accion = "guardar";
    }

    void habilitar() {

        //cajas de texto
        txtidpersona.setVisible(false);
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        cbotipo_documento.setEnabled(true);
        txtnumero_documento.setEnabled(true);
        txtdireccion.setEnabled(true);
        txttelefono.setEnabled(true);
        txtemail.setEnabled(true);
        dcfecha_nacimiento.setEnabled(true);
        txtcodigo_cliente.setEnabled(true);

        //botones
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnbuscarimagen.setEnabled(true);
        //dejar en blanco las cajas de texto

        txtidpersona.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtnumero_documento.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtemail.setText("");
        dcfecha_nacimiento.setDate(null);
        txtcodigo_cliente.setText("");
        txtrutaimagen.setText("");
        lblfotografia.setIcon(null);
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fcliente func = new fcliente();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            //lbltotalregistro.setText("Total Registros" + Integer.toString(func.totalregistros));

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(rootPane, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lblfotografia = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbotipo_documento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnumero_documento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcodigo_cliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dcfecha_nacimiento = new com.toedter.calendar.JDateChooser();
        txtidpersona = new javax.swing.JTextField();
        btnbuscarimagen = new javax.swing.JButton();
        lblbuscarImagen = new javax.swing.JLabel();
        txtrutaimagen = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdireccion = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        lblruta = new javax.swing.JLabel();
        txtbuscarcliente = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btnasignarconsulta = new javax.swing.JButton();
        btncancelarConsultas = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Pacientes"));

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfotografia, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfotografia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Apellido:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tipo Doc:");

        cbotipo_documento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DUI", "PASAPORTE" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Num. Doc:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Dirección:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Código:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Correo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Teléfono:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fec. Nac.");

        btnbuscarimagen.setText("...");
        btnbuscarimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarimagenActionPerformed(evt);
            }
        });

        lblbuscarImagen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblbuscarImagen.setText("Imagen:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtdireccion.setColumns(20);
        txtdireccion.setRows(5);
        jScrollPane2.setViewportView(txtdireccion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtemail))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbotipo_documento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(txtidpersona, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addComponent(lblbuscarImagen, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtrutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscarimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtapellido)
                    .addComponent(txtnumero_documento)
                    .addComponent(txttelefono)
                    .addComponent(dcfecha_nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcodigo_cliente)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtnumero_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcfecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblbuscarImagen)
                            .addComponent(txtrutaimagen)
                            .addComponent(btnbuscarimagen)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbotipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 67, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(txtcodigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtidpersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/nuevo.GIF"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/salir.gif"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/File/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        lblruta.setText("jLabel10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblruta)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblruta)
                .addGap(14, 14, 14))
        );

        btnbuscar.setText("Buscar Paciente");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnasignarconsulta.setText("Asignar Consulta");
        btnasignarconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnasignarconsultaActionPerformed(evt);
            }
        });

        btncancelarConsultas.setText("Ver Consultas");
        btncancelarConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnasignarconsulta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btncancelarConsultas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(txtbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnasignarconsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncancelarConsultas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:

        btnguardar.setText("Guardar");
        inhabilitar();
        habilitar();

        mostrar("");
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        try {
            if (txtnombre.getText().length() == 0) {
                JOptionPane.showConfirmDialog(rootPane, "Debe Ingresar un Nombre para el cliente");
                txtnombre.requestFocus();
                return;
            }
            if (txtapellido.getText().length() == 0) {
                JOptionPane.showConfirmDialog(rootPane, "Debe Ingresar Apellido para el cliente");
                txtapellido.requestFocus();
                return;
            }

            if (txtnumero_documento.getText().length() == 0) {
                JOptionPane.showConfirmDialog(rootPane, "Debe Ingresar numero de documento para el cliente");
                txtnumero_documento.requestFocus();
                return;
            }
            if (txtdireccion.getText().length() == 0) {
                JOptionPane.showConfirmDialog(rootPane, "Debe Ingresar una direccion");
                txtdireccion.requestFocus();
                return;
            }
            if (txttelefono.getText().length() == 0) {
                JOptionPane.showConfirmDialog(rootPane, "Debe Ingresar un número de teléfono");
                txttelefono.requestFocus();
                return;
            }

            if (txtcodigo_cliente.getText().length() == 0) {
                JOptionPane.showConfirmDialog(rootPane, "Debe Ingresar un Código para el cliente");
                txtcodigo_cliente.requestFocus();
                return;
            }

            vcliente dts = new vcliente();
            fcliente func = new fcliente();

            dts.setNombre(txtnombre.getText());
            dts.setApellido(txtapellido.getText());
            int seleccionado = cbotipo_documento.getSelectedIndex();
            dts.setTipo_documento((String) cbotipo_documento.getItemAt(seleccionado));
            dts.setNumero_documento(txtnumero_documento.getText());
            dts.setDireccion(txtdireccion.getText());
            dts.setTelefono(txttelefono.getText());
            dts.setEmail(txtemail.getText());
            dts.setNom_imagen(txtrutaimagen.getText());

            FileInputStream archivofoto;
            archivofoto = new FileInputStream(txtrutaimagen.getText());
            dts.setImagen(archivofoto);

            Calendar cal;
            int d, m, a;

            cal = dcfecha_nacimiento.getCalendar();
            d = cal.get(Calendar.DAY_OF_MONTH);
            m = cal.get(Calendar.MONTH);
            a = cal.get(Calendar.YEAR) - 1900;
            dts.setFecha_nacimiento(new Date(a, m, d));

            dts.setCodigo_cliente(txtcodigo_cliente.getText());

            if (accion.equals("guardar")) {
                if (func.insertar(dts)) {
                    JOptionPane.showMessageDialog(rootPane, "EL Cliente fue registrado");
                    mostrar("");
                    inhabilitar();
                }
            } else if (accion.equals("editar")) {
                dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));
                
                if (func.editar(dts)) {
                    JOptionPane.showMessageDialog(rootPane, "EL cliente fue editado");
                    mostrar("");
                    inhabilitar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        vcliente dts = new vcliente();
        fcliente func = new fcliente();
        String sql="select imagen from persona where";
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        fila = tablalistado.rowAtPoint(evt.getPoint());
        
        txtidpersona.setText(tablalistado.getValueAt(fila, 0).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 1).toString());
        txtapellido.setText(tablalistado.getValueAt(fila, 2).toString());
        cbotipo_documento.setSelectedItem(tablalistado.getValueAt(fila, 3).toString());
        txtnumero_documento.setText(tablalistado.getValueAt(fila, 4).toString());
        txtdireccion.setText(tablalistado.getValueAt(fila, 5).toString());
        txttelefono.setText(tablalistado.getValueAt(fila, 6).toString());
        txtemail.setText(tablalistado.getValueAt(fila, 7).toString());
        dcfecha_nacimiento.setDate(Date.valueOf(tablalistado.getValueAt(fila, 8).toString()));
        txtcodigo_cliente.setText(tablalistado.getValueAt(fila, 9).toString());
        int numero = Integer.parseInt(txtidpersona.getText());
        Image foto;
        try {
            foto = func.obtenerImagenEnBD(numero);
            foto = foto.getScaledInstance(180, 215, Image.SCALE_DEFAULT);
            lblfotografia.setIcon(new ImageIcon(foto));
        } catch (IOException ex) {
            Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtrutaimagen.setText(tablalistado.getValueAt(fila, 10).toString());
        //Image foto = getToolkit().getImage(txtrutaimagen.getText());
        
        
        lblfotografia.setIcon((Icon) tablalistado.getValueAt(fila, 11));
        
       
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidpersona.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de eliminar el cliente", "Confirmacion", 2);

            if (confirmacion == 0) {
                fcliente func = new fcliente();
                vcliente dts = new vcliente();

                dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:}
        inhabilitar();
        mostrar("");
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        mostrar(txtbuscarcliente.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnasignarconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnasignarconsultaActionPerformed
        // TODO add your handling code here:
        if(!txtidpersona.getText().equals(null)){
        frmAsignarConsulta form = new frmAsignarConsulta();
        frmInicio.escritorio.add(form);
        Dimension escritoriosize = frmInicio.escritorio.getSize();
        Dimension frameSize = form.getSize();
        form.setLocation((escritoriosize.width - frameSize.width) / 2, (escritoriosize.height - frameSize.height) / 2);
        form.toFront();
        form.setVisible(true);
        frmAsignarConsulta.lblIdParaAsignarConsulta.setText(txtidpersona.getText());
        mostrar("");
        inhabilitar();    
        }else{
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un paciente");
        }
        

    }//GEN-LAST:event_btnasignarconsultaActionPerformed

    private void btnbuscarimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarimagenActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de archivos JPEG(*.JPG;*.JPEG)", "jpg", "jpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        File ruta = new File("C:Documentos");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(null);

        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            txtrutaimagen.setText(String.valueOf(file));
            Image foto = getToolkit().getImage(txtrutaimagen.getText());
            foto = foto.getScaledInstance(180, 215, Image.SCALE_DEFAULT);
            lblfotografia.setIcon(new ImageIcon(foto));

        }
    }//GEN-LAST:event_btnbuscarimagenActionPerformed

    private void btncancelarConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarConsultasActionPerformed
        // TODO add your handling code here:
        frmVistaConsulta form = new frmVistaConsulta();
        frmInicio.escritorio.add(form);
        Dimension escritoriosize = frmInicio.escritorio.getSize();
        Dimension frameSize = form.getSize();
        form.setLocation((escritoriosize.width - frameSize.width) / 2, (escritoriosize.height - frameSize.height) / 2);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btncancelarConsultasActionPerformed
private Connection connection = new conexion().conectar();
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnasignarconsulta;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnbuscarimagen;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncancelarConsultas;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbotipo_documento;
    private com.toedter.calendar.JDateChooser dcfecha_nacimiento;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblbuscarImagen;
    private javax.swing.JLabel lblfotografia;
    private javax.swing.JLabel lblruta;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscarcliente;
    private javax.swing.JTextField txtcodigo_cliente;
    private javax.swing.JTextArea txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtidpersona;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnumero_documento;
    private javax.swing.JTextField txtrutaimagen;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
