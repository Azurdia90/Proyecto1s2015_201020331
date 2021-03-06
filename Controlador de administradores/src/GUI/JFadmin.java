package GUI;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian
 */
public class JFadmin extends javax.swing.JFrame {
    OkHttpClient cliente = new OkHttpClient();
    public JFadmin() {
        initComponents();
    }
    public Response get(URL url)throws IOException {
            Request request = new Request.Builder()
                .url(url)
                .build();
            Response response = cliente.newCall(request).execute();
            return response;
    }//fin del metod consumir get
    
    String post(URL url, RequestBody body) throws IOException {
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = cliente.newCall(request).execute();
        String response_string = response.body().string();
        return response_string;
    }
    public void graficar_usuarios(){
         try{
            URL url  = new URL("http://127.0.0.1:5000/graficar_arbol_usuarios");
            Response respuestas = get(url);
            File grafica = new File("C:\\Administrador_vuelos\\grafica_arbol_usuarios.dot");
            PrintWriter escribir = new PrintWriter(grafica);
            escribir.print(respuestas.body().string());
            escribir.close();
            Runtime.getRuntime().exec("CMD /C C:\\Grapvhiz\\bin\\dot -Tjpg C:\\Administrador_vuelos\\grafica_arbol_usuarios.dot -o C:\\Administrador_vuelos\\grafica_arbol_usuarios.jpg");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas al graficar aeropuertos");            
        }
    }
    public void graficar_aereos(){
         try{
            URL url  = new URL("http://127.0.0.1:5000/graficar_aereos");
            Response respuestas = get(url);
            File grafica = new File("C:\\Administrador_vuelos\\grafica_lista.dot");
            PrintWriter escribir = new PrintWriter(grafica);
            escribir.print(respuestas.body().string());
            escribir.close();
            Runtime.getRuntime().exec("CMD /C C:\\Grapvhiz\\bin\\dot -Tjpg C:\\Administrador_vuelos\\grafica_lista.dot -o C:\\Administrador_vuelos\\grafica_lista.jpg");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas al graficar aeropuertos");            
        }
    }
    public void graficar_vuelos(){
         try{
            URL url  = new URL("http://127.0.0.1:5000/graficar_arbol");
            Response respuestas = get(url);
            File grafica = new File("C:\\Administrador_vuelos\\grafica_arbol.dot");
            PrintWriter escribir = new PrintWriter(grafica);
            escribir.print(respuestas.body().string());
            escribir.close();
             Runtime.getRuntime().exec("CMD /C C:\\Grapvhiz\\bin\\dot -Tjpg C:\\Administrador_vuelos\\grafica_arbol.dot -o C:\\Administrador_vuelos\\grafica_arbol.jpg");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas al imprimir aeropuertos");            
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jBgrafica_lista_aeropuertos = new javax.swing.JButton();
        jBgrafica_arbol_vuelos = new javax.swing.JButton();
        jBgrafica_usuarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reportes usuarios", jPanel1);
        jTabbedPane1.addTab("Reportes Vuelos", jTabbedPane2);

        jBgrafica_lista_aeropuertos.setText("Graficar Lista Aeropuertos");
        jBgrafica_lista_aeropuertos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBgrafica_lista_aeropuertosActionPerformed(evt);
            }
        });

        jBgrafica_arbol_vuelos.setText("Graficar Arbol Vuelos");
        jBgrafica_arbol_vuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBgrafica_arbol_vuelosActionPerformed(evt);
            }
        });

        jBgrafica_usuarios.setText("Graficar Arbol Usuarios");
        jBgrafica_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBgrafica_usuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBgrafica_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBgrafica_lista_aeropuertos)
                            .addComponent(jBgrafica_arbol_vuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jBgrafica_usuarios)
                .addGap(18, 18, 18)
                .addComponent(jBgrafica_lista_aeropuertos)
                .addGap(18, 18, 18)
                .addComponent(jBgrafica_arbol_vuelos)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Graficas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBgrafica_arbol_vuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgrafica_arbol_vuelosActionPerformed
        graficar_vuelos();
    }//GEN-LAST:event_jBgrafica_arbol_vuelosActionPerformed

    private void jBgrafica_lista_aeropuertosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgrafica_lista_aeropuertosActionPerformed
        graficar_aereos();
    }//GEN-LAST:event_jBgrafica_lista_aeropuertosActionPerformed

    private void jBgrafica_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgrafica_usuariosActionPerformed
        graficar_usuarios();
    }//GEN-LAST:event_jBgrafica_usuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBgrafica_arbol_vuelos;
    private javax.swing.JButton jBgrafica_lista_aeropuertos;
    private javax.swing.JButton jBgrafica_usuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
