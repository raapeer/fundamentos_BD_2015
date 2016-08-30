/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author ale_m
 */
public class Pagos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pagos
     */
    public Pagos() {
        initComponents();
        jcombodescrpcion = llenarcombo(jcombodescrpcion, "select Descripcion from servicios order by descripcion");
        jCombopaci = llenarcombo(jCombopaci, "select IdPaciente from Paciente order by IdPaciente");
    }
public JComboBox llenarcombo(JComboBox selector, String query){
        selector.removeAllItems();
        selector.addItem("Selecciona--");
        Connection cn = Conexion.conectar();
        if (cn != null){
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    selector.addItem(rs.getString(1));
                }
                return selector;
            } catch (Exception e) {
                System.out.println("Error el llenar el mcombo " + e);
               
            }
        }else{
            System.out.println("Error al conectar la base");
        }
        return selector;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcombodescrpcion = new javax.swing.JComboBox();
        jtexprecio = new javax.swing.JTextField();
        jCombopaci = new javax.swing.JComboBox();
        txtfecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbuttonagre = new javax.swing.JButton();
        jtextnombre = new javax.swing.JTextField();
        jdt = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha");

        jcombodescrpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombodescrpcionActionPerformed(evt);
            }
        });

        jCombopaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCombopaciActionPerformed(evt);
            }
        });

        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });

        jLabel2.setText("Descripcion");

        jLabel3.setText("Precio");

        jLabel4.setText("paciente");

        jbuttonagre.setText("Agregar");
        jbuttonagre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonagreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbuttonagre)
                    .addComponent(jcombodescrpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtexprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCombopaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcombodescrpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtexprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCombopaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbuttonagre)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcombodescrpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombodescrpcionActionPerformed

try {
            Connection cn = Conexion.conectar();
            PreparedStatement st = cn.prepareStatement("select Cantidad_Pago from servicios where Descripcion=(?)");
            st.setString(1,(jcombodescrpcion.getSelectedItem().toString()));
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                jtexprecio.setText(rs.getString(1));
            }else{
                System.out.print("no existe");
            }
            
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }//GEN-LAST:event_jcombodescrpcionActionPerformed

    private void jbuttonagreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonagreActionPerformed
Connection cn = Conexion.conectar();
       if(cn != null){
           try {
               PreparedStatement ps = cn.prepareStatement("insert into Pago (Fecha_Pago, Descripcion, Cantidad_Pago, IdPaciente, Paciente) values(?,?,?,?,?)");
               ps.setString(1,txtfecha.getText().toString());
               ps.setString(2,jcombodescrpcion.getSelectedItem().toString());
               ps.setString(3,jtexprecio.getText().toString());
               ps.setString(4,jCombopaci.getSelectedItem().toString());
               ps.setString(5,jtextnombre.getText().toString());
               ps.execute();
               txtfecha.setText("");
               jtexprecio.setText("");
               System.out.println("Pago Agregado");
           } catch (Exception e) {
           System.out.println("Error en al bd: "+ e);
           }
       }else{
           System.out.println("Error en al coenxion");
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jbuttonagreActionPerformed

    private void jCombopaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCombopaciActionPerformed
try {
            Connection cn = Conexion.conectar();
            PreparedStatement st = cn.prepareStatement("select Nombre from Paciente where IdPaciente=(?)");
            st.setString(1,(jCombopaci.getSelectedItem().toString()));
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                jtextnombre.setText(rs.getString(1));
            }else{
                System.out.print("no existe");
            }
            
        } catch (Exception e) {
            System.out.println("error" + e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jCombopaciActionPerformed

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
String dia = Integer.toString(jdt.getCalendar().get(Calendar.DAY_OF_MONTH));
    String mes = Integer.toString(jdt.getCalendar().get(Calendar.MONTH) + 1);
    String year = Integer.toString(jdt.getCalendar().get(Calendar.YEAR));
    String fecha = (  dia + "/" + mes +"/" + year);
    txtfecha.setText(fecha);         // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

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
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jCombopaci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbuttonagre;
    private javax.swing.JComboBox jcombodescrpcion;
    private com.toedter.calendar.JDateChooser jdt;
    private javax.swing.JTextField jtexprecio;
    private javax.swing.JTextField jtextnombre;
    private javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables
}
