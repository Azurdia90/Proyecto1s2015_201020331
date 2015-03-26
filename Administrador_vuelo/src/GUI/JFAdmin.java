package GUI;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.json.*;
import java.io.IOException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 * @author Cristian
 * CLASE QUE SE COMUNICA CON EL WEB SERVICE 
 * Y QUE MANEJA EL ARBOL AVL DE VUELS
 * LA LISTA ENLZADA DE AEROPUERTOS
 */
public class JFAdmin extends javax.swing.JFrame {
    OkHttpClient cliente = new OkHttpClient();
    int id = 1;
 
    public JFAdmin() {
        initComponents();
        jTFestado_modificar.setEditable(false);
        jTFlugar_llegada_modificar.setEnabled(false);
        jTFlugar_salida_modificar.setEnabled(false);
    }
    
    /*Este metodo utiliza la libreria okhttp y oki para realizar un response
    a nuestro web service enviandole la url que deseamos, asi como tambien
    podemos obtener el response realizado y enviarlo como una cadena String
    que luego decidiremos si volverlo un objeto Json*/
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
    
    public int buscar_ultimo(){
        int devolver = 0;
        try{
            Response respuesta = get(new URL("http://127.0.0.1:5000/ultimo_aereo"));
            JSONObject ultimo = new JSONObject(respuesta.body().string());
            int prueba = ultimo.getInt("id");
            if(prueba != 0){
                devolver = prueba + 1;
            }else{
                devolver = 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas en el response de ultimo aeropuerto");
        }
        return devolver;
    }
    
    public void imprimir_aereos(){
        try{
            URL url  = new URL("http://127.0.0.1:5000/imprimir_aereos");
            Response respuestas = get(url);
            JSONArray aereos = new JSONArray(respuestas.body().string());
            int tamaño = aereos.length();
            jCBsalida.removeAllItems();
            jCBllegada.removeAllItems();
            for(int x = 0; x < tamaño; x++){
                JSONObject aereo = aereos.getJSONObject(x);
                jCBsalida.addItem(aereo.get("nombre"));
                jCBllegada.addItem(aereo.get("nombre"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas al imprimir aeropuertos");            
        }
    }//fin metodo imprimir aeropuertos
    
    public void limpiar_aereo(){
        jTFnombre_aeropuerto.setText(""); 
        jTFciudad_aeropuerto.setText("");
        jTFcontraseña_aeropuerto.setText("");
    }
    
    public void limpiar_vuelo(){
        jTFhora_salida_insertar.setText("");
        jTFhora_llegada_insertar.setText(""); 
        jTFfecha_salida_insertar.setText(""); 
        jTFfecha_llegada_insertar.setText("");
        jTFcantidad_primeraclase_insertar.setText(""); 
        jTFcosto_primeraclase_insertar.setText("");
        jTFcantidad_ejecutiva_insertar.setText("");
        jTFcosto_ejecutiva_insertar.setText("");
        jTFcantidad_turistas_insertar.setText(""); 
        jTFcosto_turistas_insertar.setText("");
    }
    
    public void imprimir_vuelos(){
         try{
            URL url  = new URL("http://127.0.0.1:5000/imprimir_vuelos");
            Response respuestas = get(url);
            JSONArray vuelos = new JSONArray(respuestas.body().string());
            int tamaño = vuelos.length();
            jCBvuelo_modificar.removeAllItems();
            for(int x = 0; x < tamaño; x++){
                JSONObject vuelo = vuelos.getJSONObject(x);
                jCBvuelo_modificar.addItem(vuelo.get("id"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas al imprimir aeropuertos");            
        }
    }
    
    public void imprimir_vuelo(String respuesta){
        JSONObject vuelo = new JSONObject(respuesta);
        jTFlugar_salida_modificar.setText(vuelo.getString("lugar salida"));
        jTFlugar_llegada_modificar.setText(vuelo.getString("lugar llegada"));
        jTFhora_salida_modificar.setText(vuelo.getString("hora salida"));
        jTFhora_llegada_modificar.setText(vuelo.getString("hora llegada")); 
        jTFfecha_salida_modificar.setText(vuelo.getString("fecha salida")); 
        jTFfecha_llegada_modificar.setText(vuelo.getString("fecha llegada"));
        jTFcantidad_primeraclase_modificar.setText(vuelo.getString("cantidad primera")); 
        jTFcosto_primeraclase_modificar.setText(vuelo.getString("costo primera"));
        jTFcantidad_ejecutiva_modificar.setText(vuelo.getString("cantidad ejecutiva"));
        jTFcosto_ejecutiva_modificar.setText(vuelo.getString("costo ejecutiva"));
        jTFcantidad_turistas_modificar.setText(vuelo.getString("cantidad turista")); 
        jTFcosto_turistas_modifcar.setText(vuelo.getString("costo turista"));  
        jTFestado_modificar.setText(vuelo.getString("estado"));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFnombre_aeropuerto = new javax.swing.JTextField();
        jTFciudad_aeropuerto = new javax.swing.JTextField();
        jTFcontraseña_aeropuerto = new javax.swing.JTextField();
        jBagregar_aeorupuerto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jBcrear_vuelo = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTFhora_salida_insertar = new javax.swing.JTextField();
        jTFfecha_salida_insertar = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTFhora_llegada_insertar = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTFfecha_llegada_insertar = new javax.swing.JTextField();
        jLcantidad_primeraclase_modificar1 = new javax.swing.JLabel();
        jTFcantidad_primeraclase_insertar = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTFcosto_primeraclase_insertar = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTFcantidad_turistas_insertar = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTFcosto_turistas_insertar = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTFcantidad_ejecutiva_insertar = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTFcosto_ejecutiva_insertar = new javax.swing.JTextField();
        jCBllegada = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jCBsalida = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTFhora_salida_modificar = new javax.swing.JTextField();
        jTFhora_llegada_modificar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTFcantidad_primeraclase_modificar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLcantidad_primeraclase_modificar = new javax.swing.JLabel();
        jTFlugar_llegada_modificar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTFcantidad_turistas_modificar = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTFcantidad_ejecutiva_modificar = new javax.swing.JTextField();
        jTFestado_modificar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jBmodificar = new javax.swing.JButton();
        jBmodificar_estado_vuelo = new javax.swing.JButton();
        jBmodificar_estodo_vuelo2 = new javax.swing.JButton();
        jBeliminar_vuelo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jBbuscar_vuelo = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jTFfecha_salida_modificar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTFfecha_llegada_modificar = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTFcosto_primeraclase_modificar = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTFcosto_turistas_modifcar = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTFcosto_ejecutiva_modificar = new javax.swing.JTextField();
        jCBvuelo_modificar = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTFlugar_salida_modificar = new javax.swing.JTextField();

        jLabel23.setText("jLabel23");

        jLabel26.setText("jLabel26");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel13.setText("Usuario");

        jLabel21.setText("Contraseña");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(29, 29, 29)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jTextField2))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", jPanel4);

        jLabel2.setText("Nombre aeropuerto");

        jLabel3.setText("Ciudad aeropuerto");

        jLabel4.setText("Contraseña ");

        jBagregar_aeorupuerto.setText("Aceptar");
        jBagregar_aeorupuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBagregar_aeorupuertoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBagregar_aeorupuerto)
                    .addComponent(jTFciudad_aeropuerto, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jTFnombre_aeropuerto)
                    .addComponent(jTFcontraseña_aeropuerto))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFnombre_aeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFciudad_aeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFcontraseña_aeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jBagregar_aeorupuerto)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Creación Aeropuertos", jPanel1);

        jBcrear_vuelo.setText("Crear");
        jBcrear_vuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcrear_vueloActionPerformed(evt);
            }
        });

        jLabel28.setText("Lugar de Llegada ");

        jLabel29.setText("Hora de Salida");

        jLabel30.setText("Fecha de Salida");

        jLabel31.setText("Hora  de Llegada");

        jLabel32.setText("Fecha de Llegada");

        jLcantidad_primeraclase_modificar1.setText("Cantida  de pasajeros primera clase");

        jLabel33.setText("Costo de pasajeros primera clase");

        jLabel34.setText("Cantidad  de pasajeros clase turista");

        jLabel35.setText("Costo de pasajero clase turista");

        jLabel36.setText("Cantidad  de pasajeros clase ejecutiva");

        jLabel37.setText("Costo de pasajeros clase ejecutiva");

        jLabel1.setText("Lugar de Salida");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(0, 296, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCBllegada, 0, 249, Short.MAX_VALUE)
                            .addComponent(jCBsalida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jBcrear_vuelo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel28))
                            .addGap(27, 27, 27)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTFhora_llegada_insertar, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                .addComponent(jTFhora_salida_insertar))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTFfecha_salida_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel32)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTFfecha_llegada_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(44, 44, 44)
                                .addComponent(jTFcosto_turistas_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLcantidad_primeraclase_modificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel33))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTFcantidad_primeraclase_insertar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                        .addComponent(jTFcosto_primeraclase_insertar)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel34)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                    .addComponent(jTFcantidad_turistas_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel37)
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFcantidad_ejecutiva_insertar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(jTFcosto_ejecutiva_insertar))))
                        .addComponent(jLabel31))
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCBsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addComponent(jBcrear_vuelo)
                .addGap(67, 67, 67))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel29)
                                .addComponent(jLabel30)
                                .addComponent(jTFfecha_salida_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFhora_salida_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel31)
                                .addComponent(jTFhora_llegada_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32)
                                .addComponent(jTFfecha_llegada_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLcantidad_primeraclase_modificar1)
                                .addComponent(jTFcantidad_primeraclase_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33)
                                .addComponent(jTFcosto_primeraclase_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTFcantidad_turistas_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35)
                                .addComponent(jTFcosto_turistas_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTFcantidad_ejecutiva_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel36))
                            .addGap(31, 31, 31))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFcosto_ejecutiva_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)))
                    .addContainerGap(111, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Creación de Vuelos", jPanel2);

        jLabel14.setText("Lugar de Llegada ");

        jLabel15.setText("Hora de Salida");

        jLabel16.setText("Hora  de Llegada");

        jLcantidad_primeraclase_modificar.setText("Cantida  de pasajeros primera clase");

        jLabel18.setText("Cantidad  de pasajeros clase turista");

        jLabel19.setText("Cantidad  de pasajeros clase ejecutiva");

        jLabel20.setText("Estado inicial");

        jBmodificar.setText("Modificar");
        jBmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificarActionPerformed(evt);
            }
        });

        jBmodificar_estado_vuelo.setText("Estado en vuelo");
        jBmodificar_estado_vuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificar_estado_vueloActionPerformed(evt);
            }
        });

        jBmodificar_estodo_vuelo2.setText("Estado en arribo");
        jBmodificar_estodo_vuelo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificar_estodo_vuelo2ActionPerformed(evt);
            }
        });

        jBeliminar_vuelo.setText("Eliminación");

        jLabel12.setText("ID Vuelo ");

        jBbuscar_vuelo.setText("Buscar");
        jBbuscar_vuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscar_vueloActionPerformed(evt);
            }
        });

        jLabel17.setText("Fecha de Salida");

        jLabel22.setText("Fecha de Llegada");

        jLabel24.setText("Costo de pasajeros primera clase");

        jLabel25.setText("Costo de pasajero clase turista");

        jLabel27.setText("Costo de pasajeros clase ejecutiva");

        jLabel5.setText("Lugar de Salida");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCBvuelo_modificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTFhora_llegada_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                        .addComponent(jTFhora_salida_modificar))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTFfecha_salida_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel22)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTFfecha_llegada_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jTFlugar_llegada_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addComponent(jTFlugar_salida_modificar)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(44, 44, 44)
                                .addComponent(jTFcosto_turistas_modifcar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLcantidad_primeraclase_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel24))
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTFcantidad_primeraclase_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                        .addComponent(jTFcosto_primeraclase_modificar)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                    .addComponent(jTFcantidad_turistas_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFestado_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTFcantidad_ejecutiva_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                        .addComponent(jTFcosto_ejecutiva_modificar))))))
                    .addComponent(jLabel16))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBmodificar)
                .addGap(2, 2, 2)
                .addComponent(jBmodificar_estado_vuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBmodificar_estodo_vuelo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBeliminar_vuelo)
                .addGap(34, 34, 34))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jBbuscar_vuelo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jCBvuelo_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBbuscar_vuelo)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFlugar_salida_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTFlugar_llegada_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jTFfecha_salida_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFhora_salida_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTFhora_llegada_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jTFfecha_llegada_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLcantidad_primeraclase_modificar)
                            .addComponent(jTFcantidad_primeraclase_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jTFcosto_primeraclase_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFcantidad_turistas_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jTFcosto_turistas_modifcar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFcantidad_ejecutiva_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFcosto_ejecutiva_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFestado_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBmodificar_estado_vuelo)
                    .addComponent(jBmodificar)
                    .addComponent(jBmodificar_estodo_vuelo2)
                    .addComponent(jBeliminar_vuelo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modificación Vuelo", jPanel3);

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

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBmodificar_estodo_vuelo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificar_estodo_vuelo2ActionPerformed
        jTFestado_modificar.setText("En arribo");
    }//GEN-LAST:event_jBmodificar_estodo_vuelo2ActionPerformed

    private void jBbuscar_vueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscar_vueloActionPerformed
         try{
                URL url  = new URL("http://127.0.0.1:5000/buscar_vuelo");
                RequestBody body = new FormEncodingBuilder()
                    .add("id", jCBvuelo_modificar.getSelectedItem().toString())
		    .build();
                String resultado = post(url, body);
                imprimir_vuelo(resultado);
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Problemas en el response de buscar vuelo"); 
            }
    }//GEN-LAST:event_jBbuscar_vueloActionPerformed

    private void jBagregar_aeorupuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBagregar_aeorupuertoActionPerformed
        if(!jTFnombre_aeropuerto.getText().equals("") && !jTFciudad_aeropuerto.getText().equals("") 
                && !jTFcontraseña_aeropuerto.getText().equals("")){
            try{
                URL url  = new URL("http://127.0.0.1:5000/insertar_aereo");
                int id_aereo = buscar_ultimo();
                RequestBody body = new FormEncodingBuilder()
                    .add("id", Integer.toString(id_aereo))
                    .add("nombre", jTFnombre_aeropuerto.getText())
                    .add("ciudad", jTFciudad_aeropuerto.getText())
                    .add("contraseña", jTFcontraseña_aeropuerto.getText())
		    .build();
                String resultado = post(url, body);
                limpiar_aereo();
                imprimir_aereos();
                JOptionPane.showMessageDialog(null, resultado); 
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Problemas en el response"); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "No deben dejarse campos vacios");
        }
    }//GEN-LAST:event_jBagregar_aeorupuertoActionPerformed

    private void jBmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificarActionPerformed
        if(!jTFhora_salida_modificar.getText().equals("") && !jTFhora_llegada_modificar.getText().equals("") 
                && !jTFfecha_salida_modificar.getText().equals("") && !jTFfecha_llegada_modificar.getText().equals("")
                && !jTFcantidad_primeraclase_modificar.getText().equals("") && !jTFcosto_primeraclase_modificar.getText().equals("")
                && !jTFcantidad_ejecutiva_modificar.getText().equals("") && !jTFcosto_ejecutiva_modificar.getText().equals("")
                && !jTFcantidad_turistas_modificar.getText().equals("") && !jTFcosto_turistas_modifcar.getText().equals("")) {
            try{
                URL url  = new URL("http://127.0.0.1:5000/modificar_vuelo");
                RequestBody body = new FormEncodingBuilder()
                    .add("id", jCBvuelo_modificar.getSelectedItem().toString())
                    .add("hora salida", jTFhora_salida_modificar.getText())
                    .add("hora llegada", jTFhora_llegada_modificar.getText())
                    .add("fecha salida", jTFfecha_salida_modificar.getText())
                    .add("fecha llegada", jTFfecha_llegada_modificar.getText())
                    .add("cantidad primera clase", jTFcantidad_primeraclase_modificar.getText())
                    .add("costo primera clase", jTFcosto_primeraclase_modificar.getText())
                    .add("cantidad clase turista", jTFcantidad_turistas_modificar.getText())               
                    .add("costo clase turista", jTFcosto_turistas_modifcar.getText())
                    .add("cantidad clase ejecutiva", jTFcantidad_ejecutiva_modificar.getText())
                    .add("costo clase ejecutiva", jTFcosto_ejecutiva_modificar.getText())   
                    .add("estado inicial", jTFestado_modificar.getText())
		    .build();
                limpiar_vuelo();
                String resultado = post(url, body);
                JOptionPane.showMessageDialog(null, resultado); 
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Problemas en el response de vuelos"); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "No deben dejarse campos vacios");
        }
    }//GEN-LAST:event_jBmodificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBcrear_vueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcrear_vueloActionPerformed
        if(!jTFhora_salida_insertar.getText().equals("") && !jTFhora_llegada_insertar.getText().equals("") 
                && !jTFfecha_salida_insertar.getText().equals("") && !jTFfecha_llegada_insertar.getText().equals("")
                && !jTFcantidad_primeraclase_insertar.getText().equals("") && !jTFcosto_primeraclase_insertar.getText().equals("")
                && !jTFcantidad_ejecutiva_insertar.getText().equals("") && !jTFcosto_ejecutiva_insertar.getText().equals("")
                && !jTFcantidad_turistas_insertar.getText().equals("") && !jTFcosto_turistas_insertar.getText().equals("")) {
            try{
                URL url  = new URL("http://127.0.0.1:5000/insertar_vuelo");
                //int id = buscar_ultimo();
                RequestBody body = new FormEncodingBuilder()
                    .add("id", Integer.toString(id))
                    .add("lugar salida", jCBsalida.getSelectedItem().toString())
                    .add("lugar llegada", jCBllegada.getSelectedItem().toString())
                    .add("hora salida", jTFhora_salida_insertar.getText())
                    .add("hora llegada", jTFhora_llegada_insertar.getText())
                    .add("fecha salida", jTFfecha_salida_insertar.getText())
                    .add("fecha llegada", jTFfecha_llegada_insertar.getText())
                    .add("cantidad primera clase", jTFcantidad_primeraclase_insertar.getText())
                    .add("costo primera clase", jTFcosto_primeraclase_insertar.getText())
                    .add("cantidad clase turista", jTFcantidad_turistas_insertar.getText())               
                    .add("costo clase turista", jTFcosto_turistas_insertar.getText())
                    .add("cantidad clase ejecutiva", jTFcantidad_ejecutiva_insertar.getText())
                    .add("costo clase ejecutiva", jTFcosto_ejecutiva_insertar.getText())   
                    .add("estado inicial", "En aeropuerto")
		    .build();
                String resultado = post(url, body);
                imprimir_vuelos();
                limpiar_vuelo();
                id++;
                JOptionPane.showMessageDialog(null, resultado); 
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Problemas en el response de vuelos"); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "No deben dejarse campos vacios");
        }   
    }//GEN-LAST:event_jBcrear_vueloActionPerformed

    private void jBmodificar_estado_vueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificar_estado_vueloActionPerformed
        jTFestado_modificar.setText("En vuelo");
    }//GEN-LAST:event_jBmodificar_estado_vueloActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBagregar_aeorupuerto;
    private javax.swing.JButton jBbuscar_vuelo;
    private javax.swing.JButton jBcrear_vuelo;
    private javax.swing.JButton jBeliminar_vuelo;
    private javax.swing.JButton jBmodificar;
    private javax.swing.JButton jBmodificar_estado_vuelo;
    private javax.swing.JButton jBmodificar_estodo_vuelo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCBllegada;
    private javax.swing.JComboBox jCBsalida;
    private javax.swing.JComboBox jCBvuelo_modificar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLcantidad_primeraclase_modificar;
    private javax.swing.JLabel jLcantidad_primeraclase_modificar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTFcantidad_ejecutiva_insertar;
    private javax.swing.JTextField jTFcantidad_ejecutiva_modificar;
    private javax.swing.JTextField jTFcantidad_primeraclase_insertar;
    private javax.swing.JTextField jTFcantidad_primeraclase_modificar;
    private javax.swing.JTextField jTFcantidad_turistas_insertar;
    private javax.swing.JTextField jTFcantidad_turistas_modificar;
    private javax.swing.JTextField jTFciudad_aeropuerto;
    private javax.swing.JTextField jTFcontraseña_aeropuerto;
    private javax.swing.JTextField jTFcosto_ejecutiva_insertar;
    private javax.swing.JTextField jTFcosto_ejecutiva_modificar;
    private javax.swing.JTextField jTFcosto_primeraclase_insertar;
    private javax.swing.JTextField jTFcosto_primeraclase_modificar;
    private javax.swing.JTextField jTFcosto_turistas_insertar;
    private javax.swing.JTextField jTFcosto_turistas_modifcar;
    private javax.swing.JTextField jTFestado_modificar;
    private javax.swing.JTextField jTFfecha_llegada_insertar;
    private javax.swing.JTextField jTFfecha_llegada_modificar;
    private javax.swing.JTextField jTFfecha_salida_insertar;
    private javax.swing.JTextField jTFfecha_salida_modificar;
    private javax.swing.JTextField jTFhora_llegada_insertar;
    private javax.swing.JTextField jTFhora_llegada_modificar;
    private javax.swing.JTextField jTFhora_salida_insertar;
    private javax.swing.JTextField jTFhora_salida_modificar;
    private javax.swing.JTextField jTFlugar_llegada_modificar;
    private javax.swing.JTextField jTFlugar_salida_modificar;
    private javax.swing.JTextField jTFnombre_aeropuerto;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
