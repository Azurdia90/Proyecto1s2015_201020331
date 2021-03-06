/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian
 */
public class JFnuevo_usuario extends javax.swing.JFrame {
    OkHttpClient cliente = new OkHttpClient();
    public JFnuevo_usuario() {
        initComponents();
    }
    String post(URL url, RequestBody body) throws IOException {
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = cliente.newCall(request).execute();
        String response_string = response.body().string();
        return response_string;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFnombre_insertar = new javax.swing.JTextField();
        jTFcontraseña_insertar = new javax.swing.JTextField();
        jTFnickname_insertar = new javax.swing.JTextField();
        jTFdireccion_insertar = new javax.swing.JTextField();
        jTFtelefono_insertar = new javax.swing.JTextField();
        jTFtarjeta_insertar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTFdireccion_actual_insertar = new javax.swing.JTextField();
        jBingresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        jLabel2.setText("Contraseña");

        jLabel3.setText("Nickname");

        jLabel4.setText("Direccion");

        jLabel5.setText("Telefono");

        jLabel6.setText("Numero de Tarjeta de Credito");

        jLabel7.setText("Direccion actual");

        jBingresar.setText("Ingresar");
        jBingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBingresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFnickname_insertar, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(jTFdireccion_insertar)
                                    .addComponent(jTFtelefono_insertar)
                                    .addComponent(jTFcontraseña_insertar)
                                    .addComponent(jTFnombre_insertar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFtarjeta_insertar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jTFdireccion_actual_insertar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jBingresar)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFnombre_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTFcontraseña_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTFnickname_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTFdireccion_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTFtelefono_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFtarjeta_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFdireccion_actual_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addComponent(jBingresar)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBingresarActionPerformed
        if(!jTFnombre_insertar.getText().equals("") && !jTFcontraseña_insertar.getText().equals("")
           && !jTFdireccion_actual_insertar.getText().equals("") && !jTFdireccion_insertar.getText().equals("")    
           && !jTFnickname_insertar.getText().equals("") && !jTFtarjeta_insertar.getText().equals("")   
           && !jTFtelefono_insertar.getText().equals("")){
            try{
                URL url  = new URL("http://127.0.0.1:5000/insertar_usuario");
                RequestBody body = new FormEncodingBuilder()
                    .add("nombre", jTFnombre_insertar.getText())
                    .add("contraseña", jTFcontraseña_insertar.getText())
                    .add("nickname", jTFnickname_insertar.getText())
                    .add("direccion", jTFdireccion_insertar.getText())
                    .add("telefono", jTFtelefono_insertar.getText())
                    .add("tarjeta", jTFtarjeta_insertar.getText())
                    .add("direccion actual", jTFdireccion_actual_insertar.getText())
		    .build();
                String resultado = post(url, body);
                JOptionPane.showMessageDialog(null, resultado); 
                this.dispose();
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Problemas en el response de vuelos"); 
            }
            
        }
    }//GEN-LAST:event_jBingresarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTFcontraseña_insertar;
    private javax.swing.JTextField jTFdireccion_actual_insertar;
    private javax.swing.JTextField jTFdireccion_insertar;
    private javax.swing.JTextField jTFnickname_insertar;
    private javax.swing.JTextField jTFnombre_insertar;
    private javax.swing.JTextField jTFtarjeta_insertar;
    private javax.swing.JTextField jTFtelefono_insertar;
    // End of variables declaration//GEN-END:variables
}
