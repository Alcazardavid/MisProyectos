/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controlador.ControladorCarrito;
import Controlador.ControladorCliente;
import Controlador.ControladorProveedores;
import Controlador.ControladorReportes;
import Modelo.CRUD.ProveedoresDao;
import Modelo.CRUD.crudVentas;
import Modelo.CrudCliente;
import Modelo.MetodosCarritoBD;

/**
 *
 * @author david_alcazar
 */
public class VistaCarrito extends javax.swing.JFrame {

    /**
     * Creates new form VistaCarrito
     */
    ControladorCarrito crrito;
    ControladorProveedores provee;
    ControladorCliente cliente;
    ControladorReportes reporte;
    
    public VistaCarrito() {
        initComponents();
        crrito = new ControladorCarrito(this, new MetodosCarritoBD());
        provee = new ControladorProveedores(this, new ProveedoresDao());
        cliente = new ControladorCliente(this, new CrudCliente()) ; 
        reporte = new ControladorReportes(this, new crudVentas());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jTextNombre = new javax.swing.JTextField();
        jTextEdad = new javax.swing.JTextField();
        jTextTele = new javax.swing.JTextField();
        jButtoGuardar = new javax.swing.JButton();
        jTextIngresar = new javax.swing.JTextField();
        jButtonEli = new javax.swing.JButton();
        jButtonActu = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextIdCliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jTextFieldCantidad = new javax.swing.JTextField();
        BotonAgregar = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        BotonModificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCarrito = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        BotonPagar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonSemanal = new javax.swing.JButton();
        jButtonQuincenal = new javax.swing.JButton();
        jButtonMensual = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextIdProducto = new javax.swing.JTextField();
        jTextCantidad = new javax.swing.JTextField();
        jButtonActualizar = new javax.swing.JButton();
        jButtonCrear = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField1nom = new javax.swing.JTextField();
        jTextField2tele = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 220, 30));
        jPanel4.add(jTextEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 220, 30));
        jPanel4.add(jTextTele, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 220, 30));

        jButtoGuardar.setText("GUARDAR");
        jButtoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(jButtoGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 220, 110, 30));
        jPanel4.add(jTextIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 150, 39));

        jButtonEli.setText("ELIMINAR");
        jPanel4.add(jButtonEli, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 110, 30));

        jButtonActu.setText("ACTUALIZAR");
        jPanel4.add(jButtonActu, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 328, 110, 30));

        jButtonBuscar.setText("BUSCAR");
        jPanel4.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));
        jPanel4.add(jTextIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 100, 30));

        jButton1.setText("CONTINUAR");
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, -1, -1));

        jTabbedPane1.addTab("CLIENTES", jPanel4);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 510, 290));
        jPanel1.add(jTextFieldCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 110, 30));

        BotonAgregar.setText("AGREGAR");
        jPanel1.add(BotonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 100, 40));

        BotonEliminar.setText("ELIMINAR");
        jPanel1.add(BotonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 110, 40));

        BotonModificar.setText("MODIFICAR");
        jPanel1.add(BotonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 110, 40));

        jTableCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableCarrito);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 260, 230));

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 220, 50));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 17, 150, 30));

        BotonPagar.setText("PAGAR");
        jPanel1.add(BotonPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 110, 40));

        jTabbedPane1.addTab("VENTA ", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSemanal.setText("SEMANAL");
        jPanel3.add(jButtonSemanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 103, 38));

        jButtonQuincenal.setText("QUINCENAL");
        jPanel3.add(jButtonQuincenal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 120, 38));

        jButtonMensual.setText("MENSUAL");
        jPanel3.add(jButtonMensual, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 114, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 686, 260));

        jTabbedPane1.addTab("REPORTES", jPanel3);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jTextIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 170, 39));

        jTextCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCantidadActionPerformed(evt);
            }
        });
        jPanel2.add(jTextCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 160, 36));

        jButtonActualizar.setText("ACTUALIZAR");
        jPanel2.add(jButtonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, 40));

        jButtonCrear.setText("CREAR NUEVO PROVEEDOR");
        jPanel2.add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, 37));

        jButtonEliminar.setText("ELIMINAR");
        jPanel2.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 100, 40));

        jButtonGuardar.setText("GUARDAR");
        jPanel2.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 112, 47));

        jPanel2.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 220, 40));
        jPanel2.add(jTextField1nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 170, 40));
        jPanel2.add(jTextField2tele, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 170, 40));

        jTabbedPane1.addTab("PROVEEDORES", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCantidadActionPerformed

    private void jButtoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtoGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCarrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonAgregar;
    public javax.swing.JButton BotonEliminar;
    public javax.swing.JButton BotonModificar;
    public javax.swing.JButton BotonPagar;
    public javax.swing.JButton jButtoGuardar;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButtonActu;
    public javax.swing.JButton jButtonActualizar;
    public javax.swing.JButton jButtonBuscar;
    public javax.swing.JButton jButtonCrear;
    public javax.swing.JButton jButtonEli;
    public javax.swing.JButton jButtonEliminar;
    public javax.swing.JButton jButtonGuardar;
    public javax.swing.JButton jButtonMensual;
    public javax.swing.JButton jButtonQuincenal;
    public javax.swing.JButton jButtonSemanal;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JComboBox<String> jComboBox3;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTableCarrito;
    public javax.swing.JTable jTableProductos;
    public javax.swing.JTextField jTextCantidad;
    public javax.swing.JTextField jTextEdad;
    public javax.swing.JTextField jTextField1nom;
    public javax.swing.JTextField jTextField2tele;
    public javax.swing.JTextField jTextFieldCantidad;
    public javax.swing.JTextField jTextIdCliente;
    public javax.swing.JTextField jTextIdProducto;
    public javax.swing.JTextField jTextIngresar;
    public javax.swing.JTextField jTextNombre;
    public javax.swing.JTextField jTextTele;
    // End of variables declaration//GEN-END:variables
}
