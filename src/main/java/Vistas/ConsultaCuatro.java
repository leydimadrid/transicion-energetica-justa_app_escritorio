
package Vistas;

import Controllers.EnergiaRenovableController;
import Model.EnergiaEolica;
import Repository.EnergiaRenovableRepository;
import Services.EnergiaRenovableService;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Lenovo
 */
public class ConsultaCuatro extends javax.swing.JFrame {
    
    private final EnergiaRenovableController energiaController;
    

    public ConsultaCuatro() {
        initComponents(); // Inicializa los componentes de la interfaz
        
        // Crear instancias del repositorio y el servicio de energía renovable
        EnergiaRenovableRepository energiaRenovableRepository = new EnergiaRenovableRepository();
        EnergiaRenovableService energiaRenovableService = new EnergiaRenovableService(energiaRenovableRepository);
        
         // Crear una instancia del controlador usando el servicio
        this.energiaController = new EnergiaRenovableController(energiaRenovableService);
        
        
        llenarComboBoxAnios(); // Llena el ComboBox
        personalizarComponentes(); // Personaliza los componentes
        
        aplicarEstilosComunes(jButton2, jComboBox1, jTable1); // Aplica estilos a los componentes
        
        jPanel2.setLayout(new java.awt.BorderLayout());
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);// Acción del botón
        }
    });
    }
    
        // Método para llenar el JComboBox con los años disponibles de 2020 a 2023.
        private void llenarComboBoxAnios() {
            DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(); 
            for (int año = 2020; año <= 2023; año++) { modelo.addElement(String.valueOf(año)); 
            } 
            jComboBox1.setModel(modelo); 
        }
        
        
       private CategoryDataset obtenerDatosProduccionPorAño(int año) {
        // Método que obtiene los datos de producción de energía eólica para el año especificado.
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       
        // Obtener el top 10 de países por producción de energía eólica en el año especificado
        List<EnergiaEolica> topPaisesEolica = energiaController.obtenerTop10PaisesEolica(año);
        
        // Llenar el dataset con los datos de producción
        for (EnergiaEolica energia : topPaisesEolica) {
            dataset.addValue(energia.getCapacidadRotor(), "Producción", energia.getNombreFuente());
        }
    return dataset; // Devolver el dataset lleno.
}
       
   // Método para actualizar la tabla según el año seleccionado
   private void actualizarTabla(int año) {
    // Definir las columnas de la tabla
    String[] columnas = {"Año", "País", "Producción Eólica (MWh)"};
    
    // Crear un modelo de tabla vacío
    DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
    List<EnergiaEolica> topPaisesEolica = energiaController.obtenerTop10PaisesEolica(año);
    for (EnergiaEolica energia : topPaisesEolica) {
        Object[] fila = {energia.getAnio(), energia.getNombreFuente(), energia.getCapacidadRotor()};
        modeloTabla.addRow(fila);
    }

    // Asignar el modelo de tabla actualizado a la tabla
    jTable1.setModel(modeloTabla);
}
   
   
         // Método que crea un gráfico de barras para la producción de energía eólica del año especificado.
        private void crearGrafico(int año) {
        CategoryDataset dataset = obtenerDatosProduccionPorAño(año);
        JFreeChart barChart = ChartFactory.createBarChart(
                "Producción de Energía Eólica en " + año,
                "País",
                "Producción Eólica (MWh)",
                dataset);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 300));
        
        jPanel2.removeAll();
        jPanel2.add(chartPanel);
        jPanel2.revalidate();
        jPanel2.repaint();
    }
        
        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener el año seleccionado en el JComboBox
        int añoSeleccionado = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        crearGrafico(añoSeleccionado);
        actualizarTabla(añoSeleccionado);// Generar el gráfico para el año seleccionado
    }
    
      
        
    private void personalizarComponentes() {
    Font fuenteBonita = new Font("Sans-Serif", Font.BOLD, 18); // Fuente sans-serif, negrita, tamaño 18
    Font fuenteBonitaDos = new Font("Sans.Serif", Font.BOLD, 13);
    Color colorNegroSuave = new Color(0, 0, 0); 
    
   
    jLabel1.setFont(fuenteBonita); 
    jLabel1.setForeground(colorNegroSuave); 
    
    jLabel2.setFont(fuenteBonitaDos); 
    jLabel2.setForeground(colorNegroSuave);  

}
    
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

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Top 10 países por producción de  energía eólica en año");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText(" Seleccione el año:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Buscar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Año", "País", "Producción (MWh)"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1)
                                .addGap(169, 169, 169)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(253, 253, 253)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jButton2)))
                        .addGap(0, 235, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Boton atras para ir al panel principal
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        PanelMenuPrincipal mi_PanelMenuPrincipal = new PanelMenuPrincipal ();
        mi_PanelMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaCuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaCuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaCuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaCuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCuatro().setVisible(true);
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
