
package Vistas;

import Controllers.EnergiaRenovableController;
import Model.Dtos.ProduccionEnergia;
import Repository.EnergiaRenovableRepository;
import Services.EnergiaRenovableService;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ConsultaUno extends javax.swing.JFrame {
    
    public ConsultaUno() {
        initComponents();
        this.setVisible(true);
        aniosConsulta();
        agregarTiposEnergia();
        setLocationRelativeTo(null);

        

        jPanel1.add(jLabel1);
        jPanel1.add(JbSeleccionAnio);
        //jPanel1.add(jLabel2); no sé que hace... test
        jPanel1.add(JbSeleccionEnergia);
        jPanel1.add(jButton1);

        

        // Añadir el panel de la gráfica al jPanel2
        jPanel2.setLayout(new BorderLayout());
        jPanel2.revalidate();  // Refrescar el panel para que se vea el nuevo gráfico
        jPanel2.repaint();
    }

    private void crearGrafica (String tipoEnergia, int anio){
    
    // Crear el dataset
        CategoryDataset dataset = crearDataset(tipoEnergia,anio);

        // Crear la gráfica
        JFreeChart grafico = ChartFactory.createBarChart(
                "Producción de Energía", // Título de la gráfica
                "Tipo de Energía", // Etiqueta del eje X
                "Producción (MWh)", // Etiqueta del eje Y
                dataset, // Datos
                PlotOrientation.VERTICAL, // Orientación de la gráfica
                true, // Incluir leyenda
                true, // Incluir tooltips
                false // Incluir URLs
        );

        // Crear un panel de la gráfica
        ChartPanel chartPanel = new ChartPanel(grafico);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    
        // Crear un nuevo panel para la gráfica
        chartPanel = new ChartPanel(grafico);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    
        jPanel2.add(chartPanel, BorderLayout.CENTER);
        
    }
    
    
    // Metodo para crear el dataset de la gráfica
    private CategoryDataset crearDataset(String tipoEnergia, int anio) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<ProduccionEnergia> produccionEnergiaLista = consultarProduccionDeEnergia(tipoEnergia, anio);
        if (!produccionEnergiaLista.isEmpty() ){
    
            for (int i=0; i<produccionEnergiaLista.size(); i++ ){
           
                // Añadir valores al dataset
                dataset.addValue(produccionEnergiaLista.get(i).getProduccionTotal(), produccionEnergiaLista.get(i).getRegion(), produccionEnergiaLista.get(i).getRegion());
            
            }
        }
        return dataset;
    }
    
    private List<ProduccionEnergia> consultarProduccionDeEnergia(String tipoEnergia, int anio){
    
        EnergiaRenovableRepository energiaRenovableRepository = new EnergiaRenovableRepository();
        EnergiaRenovableService energiaRenovableService = new EnergiaRenovableService(energiaRenovableRepository);
        EnergiaRenovableController energiaController = new EnergiaRenovableController(energiaRenovableService);
        
        /*obtenerProduccionTotalEnergia Prueba metodo */
        return energiaController.obtenerProduccionTotalEnergia(tipoEnergia, anio);
    
    }
    
    private void aniosConsulta(){
    
        for (int anioInicial=2000; anioInicial <= 2022; anioInicial ++ ){
            JbSeleccionAnio.addItem(String.valueOf(anioInicial));
            
            
        }
    }
    
    private void agregarPaises() {
        // Lista de consultas
        List<String> consultas = new ArrayList<>();
        consultas.add("España");
        consultas.add("Mexico");
        consultas.add("Uruguay");
        consultas.add("España");
        consultas.add("Mexico");
        consultas.add("Uruguay");
        consultas.add("España");
        consultas.add("Mexico");
        consultas.add("Uruguay");
        // Agregar elementos al JComboBox
        for (String consulta : consultas) {
           // jComboBox3.addItem(consulta);
        }
    }

    private void agregarTiposEnergia() {
        // Lista de consultas
        /*List<String> consultas = new ArrayList<>();
        consultas.add("Energia Solar");
        consultas.add("Energia Eolica");
        consultas.add("Energia Bicombustible");
        // Agregar elementos al JComboBox
        for (String consulta : consultas) {
            JbSeleccionEnergia.addItem(consulta);
        }*/

        JbSeleccionEnergia.addItem("Solar");
        JbSeleccionEnergia.addItem("Eólica");
        JbSeleccionEnergia.addItem("Hidráulica");
        JbSeleccionEnergia.addItem("Geotérmica");
        JbSeleccionEnergia.addItem("Biomasa");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JbSeleccionAnio = new javax.swing.JComboBox<>();
        JbSeleccionEnergia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Producción total Energia Renovable");

        JbSeleccionAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona año" }));
        JbSeleccionAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbSeleccionAnioActionPerformed(evt);
            }
        });

        JbSeleccionEnergia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoger tipo energia" }));
        JbSeleccionEnergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbSeleccionEnergiaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tipo de Energia");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Año");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        jButton2.setText("Atras");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbSeleccionAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(JbSeleccionEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbSeleccionAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbSeleccionEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //VistaPrincipal vistaP = new VistaPrincipal();
        this.setVisible(false);
        PanelMenuPrincipal mi_PanelMenuPrincipal = new PanelMenuPrincipal ();
        mi_PanelMenuPrincipal.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        

        String tipoEnergia = (String) JbSeleccionEnergia.getSelectedItem();
        String anio = (String) JbSeleccionAnio.getSelectedItem();
        
        // Inicializa el repositorio
        EnergiaRenovableRepository energiaRepository = new EnergiaRenovableRepository();

        // Crear instancia del servicio
        EnergiaRenovableService energiaService = new EnergiaRenovableService(energiaRepository);

        // Crear instancia del controlador
        EnergiaRenovableController controller = new EnergiaRenovableController(energiaService);

        // Llamar al método del controlador para procesar la consulta
        //String res = controller.obtenerPorcentajeConsumoElectricoTotalRegion();

        //jTextArea1.setText(res);
        System.out.println("Fecha elegida: "+ anio);
        System.out.println("Fecha tipoEnergia: "+ tipoEnergia);
        crearGrafica(tipoEnergia, Integer.parseInt(anio));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JbSeleccionEnergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSeleccionEnergiaActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) JbSeleccionEnergia.getSelectedItem();

    }//GEN-LAST:event_JbSeleccionEnergiaActionPerformed

    private void JbSeleccionAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSeleccionAnioActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) JbSeleccionAnio.getSelectedItem();

    }//GEN-LAST:event_JbSeleccionAnioActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ConsultaUno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaUno().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JbSeleccionAnio;
    private javax.swing.JComboBox<String> JbSeleccionEnergia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
