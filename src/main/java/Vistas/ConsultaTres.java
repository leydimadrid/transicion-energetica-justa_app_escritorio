
package Vistas;

import Controllers.EnergiaRenovableController;
import Model.Dtos.CapacidadInstaladaSolar;
import Repository.EnergiaRenovableRepository;
import Services.EnergiaRenovableService;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ConsultaTres extends javax.swing.JFrame {

    
    public ConsultaTres() {
        initComponents();
        agregarGrafico(); // Llama al método que agrega el gráfico al JPanel 
    }
    
    private List<CapacidadInstaladaSolar> consultarPeriodoEnergia(){
    
        EnergiaRenovableRepository energiaRenovableRepository = new EnergiaRenovableRepository();
        EnergiaRenovableService energiaRenovableService = new EnergiaRenovableService(energiaRenovableRepository);
        EnergiaRenovableController energiaController = new EnergiaRenovableController(energiaRenovableService);
        
        return energiaController.obtenerCapacidadInstaladaEnergiaSolarTodosLosAnios();
    }
    
    private void agregarGrafico() {
        // Crea el dataset con los datos de tendencia de capacidad instalada
        DefaultCategoryDataset dataset = crearDataset();
                
        // Crea el gráfico
        JFreeChart chart = ChartFactory.createLineChart(
                "Tendencia de la Capacidad Instalada de Energía Solar",
                "Año",
                "Capacidad (MW)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Crea un panel con el gráfico y añádelo a jPanel1
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(816, 490));
        JPGrafica.setLayout(new java.awt.BorderLayout());
        JPGrafica.add(chartPanel, java.awt.BorderLayout.CENTER);
        JPGrafica.validate();
        
    }
    
    private void datosTestGrafica (){
        // Crea el dataset con los datos de tendencia de capacidad instalada
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        // Agrega los datos de ejemplo
        dataset.addValue(10, "Capacidad Instalada", "2010");
        dataset.addValue(15, "Capacidad Instalada", "2011");
        dataset.addValue(40, "Capacidad Instalada", "2012");
        dataset.addValue(25, "Capacidad Instalada", "2013");
        dataset.addValue(30, "Capacidad Instalada", "2014");
        dataset.addValue(50, "Capacidad Instalada", "2015");

    
    }
    
    private DefaultCategoryDataset crearDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<CapacidadInstaladaSolar> periodoEnergiaLista = consultarPeriodoEnergia();
        if (!periodoEnergiaLista.isEmpty() ){
        
            for (int i=0; i<periodoEnergiaLista.size(); i++ ){
           
                // Añadir valores al dataset
                dataset.addValue(periodoEnergiaLista.get(i).getCapacidadTotalInstalada(),"Capacidad Instalada", String.valueOf(periodoEnergiaLista.get(i).getAnio()));
                
            }
        }
        return dataset;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JPGrafica = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tendencia de la capacidad instalada de energia solar a lo largo de los años");

        JPGrafica.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout JPGraficaLayout = new javax.swing.GroupLayout(JPGrafica);
        JPGrafica.setLayout(JPGraficaLayout);
        JPGraficaLayout.setHorizontalGroup(
            JPGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
        );
        JPGraficaLayout.setVerticalGroup(
            JPGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        jButton2.setText("Atras");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addComponent(JPGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //VistaPrincipal vistaP = new VistaPrincipal();
        this.setVisible(false);
        PanelMenuPrincipal mi_PanelMenuPrincipal = new PanelMenuPrincipal ();
        mi_PanelMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaTres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaTres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaTres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaTres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaTres().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPGrafica;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
