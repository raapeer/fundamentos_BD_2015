/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.Calendar;

/**
 *
 * @author ale_m
 */
public class Citas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Citas
     */
    public Citas() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdt = new com.toedter.calendar.JDateChooser();
        jCombopaci = new javax.swing.JComboBox();
        jtextHorario = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        buttoncita = new javax.swing.JButton();
        jtextnombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha");

        jLabel2.setText("Paciente");

        jLabel3.setText("Horario");

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

        buttoncita.setText("Agregar Cita");
        buttoncita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttoncitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(buttoncita, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtextHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jdt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCombopaci, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtextnombre)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtextHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCombopaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttoncita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
    String dia = Integer.toString(jdt.getCalendar().get(Calendar.DAY_OF_MONTH));
    String mes = Integer.toString(jdt.getCalendar().get(Calendar.MONTH) + 1);
    String year = Integer.toString(jdt.getCalendar().get(Calendar.YEAR));
    String fecha = (  dia + "/" + mes+ "/" + year);
    txtfecha.setText(fecha);    // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    private void buttoncitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoncitaActionPerformed
Connection cn = Conexion.conectar();
       if(cn != null){
           try {
               PreparedStatement ps = cn.prepareStatement("insert into Cita (Fecha_Cita, IdPaciente, Paciente, Horario) values(?,?,?,?)");
               ps.setString(1,txtfecha.getText().toString());
               ps.setString(2,jCombopaci.getSelectedItem().toString());
               ps.setString(3,jtextnombre.getText().toString());
               ps.setString(4,jtextHorario.getText().toString());
               ps.execute();
               txtfecha.setText("");
               jtextHorario.setText("");
               jtextnombre.setText("");
               
               System.out.println("Cita Agregada");
           } catch (Exception e) {
           System.out.println("Error en al bd: "+ e);
           }
       }else{
           System.out.println("Error en al coenxion");
       }        // TODO add your handling code here:
            
    }//GEN-LAST:event_buttoncitaActionPerformed

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
        }
    }//GEN-LAST:event_jCombopaciActionPerformed

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
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Citas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttoncita;
    private javax.swing.JComboBox jCombopaci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.toedter.calendar.JDateChooser jdt;
    private javax.swing.JTextField jtextHorario;
    private javax.swing.JTextField jtextnombre;
    private javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables
}
