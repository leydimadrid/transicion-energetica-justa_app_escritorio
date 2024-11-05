
package Vistas;

import Controllers.EnergiaRenovableController;
import Model.Dtos.ConsumoRegion;
import Repository.EnergiaRenovableRepository;
import Services.EnergiaRenovableService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Lenovo
 */
public class ConsultaaDos extends javax.swing.JFrame {

    private final EnergiaRenovableController energiaController;
     
    /**
     * Creates new form ConsultaDos
     */
    
    public ConsultaaDos() {
        initComponents();  // Inicializa los componentes de la interfaz
        
        // Crear instancias del repositorio y el servicio de energía renovable
        EnergiaRenovableRepository energiaRenovableRepository = new EnergiaRenovableRepository();
        EnergiaRenovableService energiaRenovableService = new EnergiaRenovableService(energiaRenovableRepository);
        
        // Crear una instancia del controlador usando el servicio
        this.energiaController = new EnergiaRenovableController(energiaRenovableService);
       
        llenarComboBoxConPaises(); // Llena el ComboBox
        personalizarComponentes(); // Personaliza los componentes
        
        aplicarEstilosComunes(jButton2, jComboBox1, jTable1); // Aplica estilos a los componentes
        
        jPanel2.setLayout(new java.awt.BorderLayout());
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt); // Acción del botón
        }
        });
    }
    
    //Llenar la lista desplegable con la informacion de la BD
    private void llenarComboBoxConPaises() {
    jComboBox1.removeAllItems(); // Limpia el ComboBox antes de llenarlo
    List<ConsumoRegion> datos = energiaController.obtenerPorcentajeConsumoElectricoTotalRegion();
    for (ConsumoRegion dato : datos) {
        jComboBox1.addItem(dato.getRegion());
    }
}

    //visualizar la producción de energía renovable por región en gráficos de barras u otros gráficos categóricos
    private CategoryDataset obtenerDatosConsumoRegion(int region) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
    List<ConsumoRegion> consumoRegion = energiaController.obtenerPorcentajeConsumoElectricoTotalRegion();
    for (ConsumoRegion consumo : consumoRegion) {
        dataset.addValue(consumo.getCapacidadInstaladaEnergiaRenovable(), "Producción", consumo.getRegion());
    }
    return dataset;
}

    //Llenar tabla con los datos buscados en la BD
    private void llenarTablaConDatosSegunPais() {
    String[] columnas = {"País", "Consumo Total", "Producción renovable (MWh)", "Porcentaje energía renovable"};
    String paisSeleccionado = (String) jComboBox1.getSelectedItem();
    
    if (paisSeleccionado == null || paisSeleccionado.isEmpty()) {
        System.out.println("Por favor, seleccione un país.");
        return;
    }
    
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0);
    
    try {
        List<ConsumoRegion> datos = energiaController.obtenerPorcentajeConsumoElectricoTotalRegion();
        for (ConsumoRegion dato : datos) {
            if (dato.getRegion().equals(paisSeleccionado)) {
                modelo.addRow(new Object[]{dato.getRegion(), dato.getConsumoTotal(), dato.getCapacidadInstaladaEnergiaRenovable(),
                    dato.getPorcentajeEnergiaRenovable()});
            }
        }
    } catch (Exception e) {
        System.err.println("Error al obtener datos: " + e.getMessage());
    }
}
    
    //Crear Grafico con los datos buscados en la BD
    private void mostrarGrafico() {
    String paisSeleccionado = (String) jComboBox1.getSelectedItem();
    List<ConsumoRegion> datos = energiaController.obtenerPorcentajeConsumoElectricoTotalRegion();
    
    if (datos != null && !datos.isEmpty()) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (ConsumoRegion dato : datos) {
            if (dato.getRegion().equals(paisSeleccionado)) {
                dataset.addValue(dato.getConsumoTotal(), "Consumo Total (kWh)", dato.getRegion());
                dataset.addValue(dato.getCapacidadInstaladaEnergiaRenovable(), "Producción Renovable (kWh)", dato.getRegion());
            }
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Consumo y Producción de Energía",
            "País",
            "Cantidad (kWh)",
            dataset
        );

        CategoryPlot plot = chart.getCategoryPlot();
        plot.getDomainAxis().setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 400));
        jPanel2.removeAll();
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(chartPanel, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    } else {
        System.out.println("No hay datos para mostrar el gráfico.");
    }
}

    //Estilos para los jlabels
    private void personalizarComponentes() {
    Font fuenteBonita = new Font("Sans-Serif", Font.BOLD, 18); // Fuente sans-serif, negrita, tamaño 18
    Font fuenteBonitaDos = new Font("Sans.Serif", Font.BOLD, 13);
    Color colorNegroSuave = new Color(0, 0, 0); 
    
   
    jLabel1.setFont(fuenteBonita); 
    jLabel1.setForeground(colorNegroSuave); 
    
    jLabel2.setFont(fuenteBonitaDos); 
    jLabel2.setForeground(colorNegroSuave);  

}
    
    //Estilos en los componentes
    private void aplicarEstilosComunes(JButton button, JComboBox<String> comboBox, JTable table) {
    // Estilos para los botones
    button.setBackground(new Color(70, 130, 180)); // Color azul suave
    button.setForeground(Color.WHITE); // Texto blanco
    button.setFont(new Font("Sans-Serif", Font.BOLD, 14)); // Fuente sans-serif, negrita, tamaño 14

    // Estilos para los JComboBox
    comboBox.setFont(new Font("Sans-Serif", Font.PLAIN, 14)); // Fuente sans-serif, tamaño 14

    // Estilos para la tabla
    table.getTableHeader().setFont(new Font("Sans-Serif", Font.BOLD, 14));
    table.getTableHeader().setBackground(new Color(200, 200, 200)); // Fondo gris claro para el encabezado
    table.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
    table.setRowHeight(20); // Altura de las filas
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Porcentaje de Energía Renovable en el Consumo Eléctrico Total por Región");

        jLabel2.setText("Seleccionar país");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Calcular");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "País", "Consumo Total", "Producción Renovable (kWh)", "Porcentaje Energía Renovable (%)"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel1)))
                        .addGap(0, 459, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Accion del boton atras para ir hacia el panel principal
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        PanelMenuPrincipal mi_PanelMenuPrincipal = new PanelMenuPrincipal ();
        mi_PanelMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    //Accion del boton para llenar grafica y tabla al dar buscar
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        llenarTablaConDatosSegunPais();
        mostrarGrafico();
    }
    
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
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(ConsultaaDos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            ConsultaaDos frame = new ConsultaaDos();
            frame.setLocationRelativeTo(null);       
            frame.setVisible(true);                  
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
