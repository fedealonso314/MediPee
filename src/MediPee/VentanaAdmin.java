/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediPee;

import java.io.*;
import java.util.logging.Level;
import com.panamahitek.*;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLUE;
import static java.awt.Color.GRAY;
import static java.awt.Color.YELLOW;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Point;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Usuario
 */
public class VentanaAdmin extends javax.swing.JFrame {

    private static Point point = new Point();
    DefaultTableModel model;
    private float ph;
    private String puerto;
    private ArrayList<String> puertos;
    private FileWriter fw;
    private PanamaHitek_Arduino arduino;
    conectar cc = new conectar();
    Connection cn = cc.conexion();
    private SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                String mensaje = "";
                mensaje = arduino.printMessage();
                if (mensaje != "No hay datos disponibles") {
                    txtContador1.setText("" + mensaje);
                    ph = Float.parseFloat(mensaje);
                    fw.append(mensaje + "\n");
                }
            } catch (SerialPortException | ArduinoException | IOException ex) {
                Logger.getLogger(VentanaAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    public VentanaAdmin() {
        initComponents();

        getContentPane().setBackground(new Color(41,41,41));
        try {
            fw = new FileWriter("log.txt");
            fw.write("pH\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLocationRelativeTo(null);
        setResizable(false);
        arduino = new PanamaHitek_Arduino();
        puertos = (ArrayList<String>) arduino.getSerialPorts();
        for (String s : puertos) {
            cbListaPuertos.addItem(s);
        }
        txtfAltura.setText("");
        txtfPeso.setText("");
        cargarTabla("");

    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDatos_02 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbListaPuertos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jbuttonConectarCom = new javax.swing.JButton();
        jbuttonDesconectar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        graph = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtfAltura = new javax.swing.JTextField();
        txtfPeso = new javax.swing.JTextField();
        txtContador1 = new javax.swing.JTextField();
        txtfNroEncuestados = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCargarDatos1 = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MediPeeV3.0");
        setBackground(new java.awt.Color(51, 51, 51));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableDatos_02.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableDatos_02.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableDatos_02.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableDatos_02);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 20, 502, 553));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbListaPuertos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbListaPuertos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbListaPuertosItemStateChanged(evt);
            }
        });
        cbListaPuertos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbListaPuertosMouseClicked(evt);
            }
        });
        jPanel2.add(cbListaPuertos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 143, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/panel conexion.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 200));

        jbuttonConectarCom.setBackground(new java.awt.Color(51, 51, 51));
        jbuttonConectarCom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbuttonConectarCom.setForeground(new java.awt.Color(255, 255, 255));
        jbuttonConectarCom.setText("Conectar");
        jbuttonConectarCom.setToolTipText("");
        jbuttonConectarCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonConectarComActionPerformed(evt);
            }
        });
        jPanel2.add(jbuttonConectarCom, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 143, -1));

        jbuttonDesconectar.setBackground(new java.awt.Color(51, 51, 51));
        jbuttonDesconectar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbuttonDesconectar.setForeground(new java.awt.Color(255, 255, 255));
        jbuttonDesconectar.setText("Desconectar");
        jbuttonDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonDesconectarActionPerformed(evt);
            }
        });
        jPanel2.add(jbuttonDesconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 143, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Conexión Arduino");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 190));

        graph.setBackground(new java.awt.Color(102, 102, 102));
        graph.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        graph.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout graphLayout = new javax.swing.GroupLayout(graph);
        graph.setLayout(graphLayout);
        graphLayout.setHorizontalGroup(
            graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        graphLayout.setVerticalGroup(
            graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        getContentPane().add(graph, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 78, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfAltura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtfAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfAlturaKeyPressed(evt);
            }
        });
        jPanel1.add(txtfAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 110, 35));

        txtfPeso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtfPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfPesoKeyPressed(evt);
            }
        });
        jPanel1.add(txtfPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 110, 35));

        txtContador1.setEditable(false);
        txtContador1.setBackground(new java.awt.Color(255, 255, 153));
        txtContador1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtContador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 110, 37));

        txtfNroEncuestados.setEditable(false);
        txtfNroEncuestados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtfNroEncuestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfNroEncuestadosActionPerformed(evt);
            }
        });
        jPanel1.add(txtfNroEncuestados, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 180, 37));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/panel de cantidad de encuestados.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 350));

        btnCargarDatos1.setBackground(new java.awt.Color(51, 51, 51));
        btnCargarDatos1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCargarDatos1.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarDatos1.setText("Añadir");
        btnCargarDatos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDatos1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 273, 100, 20));

        jButtonSalir.setBackground(new java.awt.Color(153, 0, 0));
        jButtonSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 100, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad de encuestados: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 22, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Peso");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 219, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("pH: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 118, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Altura");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 166, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 208, 260, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/ventana principal.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1520, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void cargarDatos() {
        try {
            int codFinal;
            float altura;
            float peso;
            altura = Float.parseFloat(txtfAltura.getText());
            peso = Float.parseFloat(txtfPeso.getText());
            float imc = peso / ((altura) * (altura));
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM datos_encuestados LIMIT 0, 1000");
            rs.last();
            st.executeUpdate("INSERT INTO datos_encuestados ( pH, altura, peso, imc) "
                    + "VALUES (" + ph + ", " + altura + ", " + peso + ", " + imc + ")");
            txtfAltura.setText("");
            txtfPeso.setText("");
            cargarTabla("");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaAdmin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Hubo un error al cargar los datos");
        }
    }

    void cargarTabla(String valor) {
        String mostrar = "SELECT * FROM datos_encuestados "
                + "WHERE CONCAT(codEncuestado, pH, altura, peso, imc) "
                + "LIKE '%" + valor + "%'";
        String[] titulos = {"Codigo", "pH", "Altura", "Peso", "IMC"};
        String[] Registros = new String[6];
        model = new DefaultTableModel(null, titulos);
        
        float[] arrayGrafico = {};
        int c=0; 
        
        
        XYSeries series = new XYSeries("IMC");
        XYSeries series2 = new XYSeries("pH");
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            
            float imc, pH, cod;
            while (rs.next()) {
                Registros[0] = rs.getString("codEncuestado");
                Registros[1] = rs.getString("pH");
                Registros[2] = rs.getString("altura");
                Registros[3] = rs.getString("peso");
                Registros[4] = rs.getString("imc");
                
                model.addRow(Registros);
            }
            
       
            rs.first();
            jTableDatos_02.setModel(model);
            int codFinal = 1;
            while (rs.next()) {
                codFinal = codFinal + 1;
            }
            String codFinalString = String.valueOf(codFinal);
            txtfNroEncuestados.setText(codFinalString);
            rs.close();
            String orden = "SELECT * FROM datos_encuestados ORDER BY imc ASC";
            float imc2, pH2, cod2;
            int c2=1; 
            ResultSet rss = st.executeQuery(orden);
            while (rss.next()){
                imc = rss.getFloat("imc");
                cod = rss.getInt("codEncuestado");
                ph = rss.getFloat("pH");
                System.out.println(imc+" "+ cod+" "+ ph);
                
                series.add(c2, imc);
                series2.add(c2, ph);
                
                c2++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaAdmin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Hubo un error al leer la tabla");
        }
        
	
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(series2);
        JFreeChart chart = ChartFactory.createXYLineChart("", "Encuestados", "", dataset, PlotOrientation.VERTICAL, true, false, false);
        final XYPlot plot = (XYPlot) chart.getPlot();
        final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
        
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(686, 319));
        graph.setLayout(new BorderLayout());
        graph.add(panel, BorderLayout.NORTH);
        chart.setBackgroundPaint(GRAY);
        renderer.setSeriesShapesVisible(0, true);
	renderer.setSeriesShapesVisible(1, true);
	renderer.setSeriesPaint(0, BLUE);
	renderer.setSeriesPaint(1, YELLOW);
        pack();
        repaint();

    }
    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        try {
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(VentanaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            arduino.killArduinoConnection();
        } catch (ArduinoException ex) {
            Logger.getLogger(VentanaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.dispose();
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void btnCargarDatos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatos1ActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnCargarDatos1ActionPerformed

    private void jbuttonConectarComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonConectarComActionPerformed
        if (puerto != null) {
            try {
                arduino.arduinoRX(puerto, 9600, listener);
            } catch (ArduinoException ex) {
                Logger.getLogger(VentanaAdmin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Hubo un error en la conexión del arduino");
            } catch (SerialPortException ex) {
                Logger.getLogger(VentanaAdmin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Hubo un error en la conexión del arduino");
            }
        }

    }//GEN-LAST:event_jbuttonConectarComActionPerformed

    private void cbListaPuertosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbListaPuertosItemStateChanged
        puerto = puertos.get(cbListaPuertos.getSelectedIndex());
    }//GEN-LAST:event_cbListaPuertosItemStateChanged

    private void txtfPesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfPesoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cargarDatos();
            txtfAltura.requestFocus();
        }
    }//GEN-LAST:event_txtfPesoKeyPressed

    private void txtfAlturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfAlturaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtfPeso.requestFocus();
        }
    }//GEN-LAST:event_txtfAlturaKeyPressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point p = this.getLocation();
        this.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

        point.x = evt.getX();
        point.y = evt.getY();

    }//GEN-LAST:event_formMousePressed

    private void jbuttonDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonDesconectarActionPerformed

        try {
            arduino.killArduinoConnection();
        } catch (ArduinoException ex) {
            Logger.getLogger(VentanaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbuttonDesconectarActionPerformed

    private void txtfNroEncuestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfNroEncuestadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfNroEncuestadosActionPerformed

    private void cbListaPuertosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbListaPuertosMouseClicked
        int c2 = 0;
        puertos = (ArrayList<String>) arduino.getSerialPorts();
        System.out.println(puertos);
        String p, p2;
        int cant=0;
        int size = cbListaPuertos.getItemCount();
        for (int c = 0; c != size; c++) {
            p = cbListaPuertos.getItemAt(c).toString();
            p2 = puertos.get(c).toString();
            if (p.equals(p2)) {
                System.out.println(p + "=" + p2);
                cant++;
            }
        }
        for (int s=0; s!=cant;s++){
            cbListaPuertos.addItem(puertos.get(cant).toString());
        }
    }//GEN-LAST:event_cbListaPuertosMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarDatos1;
    private javax.swing.JComboBox<String> cbListaPuertos;
    private javax.swing.JPanel graph;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDatos_02;
    private javax.swing.JButton jbuttonConectarCom;
    private javax.swing.JButton jbuttonDesconectar;
    private javax.swing.JTextField txtContador1;
    private javax.swing.JTextField txtfAltura;
    private javax.swing.JTextField txtfNroEncuestados;
    private javax.swing.JTextField txtfPeso;
    // End of variables declaration//GEN-END:variables
}
