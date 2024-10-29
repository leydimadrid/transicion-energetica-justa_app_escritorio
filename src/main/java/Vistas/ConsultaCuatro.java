
package Vistas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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

    public ConsultaCuatro() {
        initComponents();
        
        llenarComboBoxAnios();
        personalizarComponentes();
        jPanel2.setLayout(new java.awt.BorderLayout());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    }
    
        private void llenarComboBoxAnios() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (int año = 2010; año <= 2023; año++) {
            modelo.addElement(String.valueOf(año));
        }
        jComboBox1.setModel(modelo);
    }
        
        private CategoryDataset obtenerDatosProduccionPorAño(int año) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    switch (año) {
        case 2010:
            dataset.addValue(180, "Producción (MW)", "País A");
            dataset.addValue(160, "Producción (MW)", "País B");
            dataset.addValue(140, "Producción (MW)", "País C");
            dataset.addValue(120, "Producción (MW)", "País D");
            dataset.addValue(300, "Producción (MW)", "País E");
            dataset.addValue(500, "Producción (MW)", "País F");
            dataset.addValue(30, "Producción (MW)", "País G");
            dataset.addValue(10, "Producción (MW)", "País H");
            dataset.addValue(40, "Producción (MW)", "País I");
            dataset.addValue(150, "Producción (MW)", "País J");
            break;
        case 2011:
            dataset.addValue(200, "Producción (MW)", "País A");
            dataset.addValue(180, "Producción (MW)", "País B");
            dataset.addValue(160, "Producción (MW)", "País C");
            dataset.addValue(140, "Producción (MW)", "País D");
            dataset.addValue(120, "Producción (MW)", "País E");
            dataset.addValue(15, "Producción (MW)", "País F");
            dataset.addValue(10, "Producción (MW)", "País G");
            dataset.addValue(160, "Producción (MW)", "País H");
            dataset.addValue(170, "Producción (MW)", "País I");
            dataset.addValue(10, "Producción (MW)", "País J");
            break;
        case 2012:
            dataset.addValue(220, "Producción (MW)", "País A");
            dataset.addValue(200, "Producción (MW)", "País B");
            dataset.addValue(180, "Producción (MW)", "País C");
            dataset.addValue(160, "Producción (MW)", "País D");
            dataset.addValue(140, "Producción (MW)", "País E");
            dataset.addValue(190, "Producción (MW)", "País F");
            dataset.addValue(110, "Producción (MW)", "País G");
            dataset.addValue(170, "Producción (MW)", "País H");
            dataset.addValue(120, "Producción (MW)", "País I");
            dataset.addValue(190, "Producción (MW)", "País J");
            break;
        case 2013:
            dataset.addValue(240, "Producción (MW)", "País A");
            dataset.addValue(220, "Producción (MW)", "País B");
            dataset.addValue(200, "Producción (MW)", "País C");
            dataset.addValue(180, "Producción (MW)", "País D");
            dataset.addValue(160, "Producción (MW)", "País E");
            dataset.addValue(180, "Producción (MW)", "País F");
            dataset.addValue(190, "Producción (MW)", "País G");
            dataset.addValue(110, "Producción (MW)", "País H");
            dataset.addValue(130, "Producción (MW)", "País I");
            dataset.addValue(140, "Producción (MW)", "País J");
            break;
        case 2014:
            dataset.addValue(260, "Producción (MW)", "País A");
            dataset.addValue(240, "Producción (MW)", "País B");
            dataset.addValue(220, "Producción (MW)", "País C");
            dataset.addValue(200, "Producción (MW)", "País D");
            dataset.addValue(180, "Producción (MW)", "País E");
            dataset.addValue(200, "Producción (MW)", "País F");
            dataset.addValue(130, "Producción (MW)", "País G");
            dataset.addValue(150, "Producción (MW)", "País H");
            dataset.addValue(140, "Producción (MW)", "País I");
            dataset.addValue(160, "Producción (MW)", "País J");
            break;
        case 2015:
            dataset.addValue(280, "Producción (MW)", "País A");
            dataset.addValue(260, "Producción (MW)", "País B");
            dataset.addValue(240, "Producción (MW)", "País C");
            dataset.addValue(220, "Producción (MW)", "País D");
            dataset.addValue(200, "Producción (MW)", "País E");
            dataset.addValue(220, "Producción (MW)", "País F");
            dataset.addValue(140, "Producción (MW)", "País G");
            dataset.addValue(160, "Producción (MW)", "País H");
            dataset.addValue(150, "Producción (MW)", "País I");
            dataset.addValue(180, "Producción (MW)", "País J");
            break;
        case 2016:
            dataset.addValue(300, "Producción (MW)", "País A");
            dataset.addValue(290, "Producción (MW)", "País B");
            dataset.addValue(250, "Producción (MW)", "País C");
            dataset.addValue(240, "Producción (MW)", "País D");
            dataset.addValue(220, "Producción (MW)", "País E");
            dataset.addValue(240, "Producción (MW)", "País F");
            dataset.addValue(160, "Producción (MW)", "País G");
            dataset.addValue(170, "Producción (MW)", "País H");
            dataset.addValue(180, "Producción (MW)", "País I");
            dataset.addValue(190, "Producción (MW)", "País J");
            break;
        case 2017:
            dataset.addValue(350, "Producción (MW)", "País A");
            dataset.addValue(320, "Producción (MW)", "País B");
            dataset.addValue(300, "Producción (MW)", "País C");
            dataset.addValue(280, "Producción (MW)", "País D");
            dataset.addValue(260, "Producción (MW)", "País E");
            dataset.addValue(300, "Producción (MW)", "País F");
            dataset.addValue(180, "Producción (MW)", "País G");
            dataset.addValue(190, "Producción (MW)", "País H");
            dataset.addValue(200, "Producción (MW)", "País I");
            dataset.addValue(210, "Producción (MW)", "País J");
            break;
        case 2018:
            dataset.addValue(380, "Producción (MW)", "País A");
            dataset.addValue(360, "Producción (MW)", "País B");
            dataset.addValue(340, "Producción (MW)", "País C");
            dataset.addValue(320, "Producción (MW)", "País D");
            dataset.addValue(300, "Producción (MW)", "País E");
            dataset.addValue(320, "Producción (MW)", "País F");
            dataset.addValue(200, "Producción (MW)", "País G");
            dataset.addValue(210, "Producción (MW)", "País H");
            dataset.addValue(220, "Producción (MW)", "País I");
            dataset.addValue(230, "Producción (MW)", "País J");
            break;
        case 2019:
            dataset.addValue(400, "Producción (MW)", "País A");
            dataset.addValue(380, "Producción (MW)", "País B");
            dataset.addValue(360, "Producción (MW)", "País C");
            dataset.addValue(340, "Producción (MW)", "País D");
            dataset.addValue(320, "Producción (MW)", "País E");
            dataset.addValue(350, "Producción (MW)", "País F");
            dataset.addValue(210, "Producción (MW)", "País G");
            dataset.addValue(220, "Producción (MW)", "País H");
            dataset.addValue(230, "Producción (MW)", "País I");
            dataset.addValue(240, "Producción (MW)", "País J");
            break;
        case 2020:
            dataset.addValue(420, "Producción (MW)", "País A");
            dataset.addValue(400, "Producción (MW)", "País B");
            dataset.addValue(380, "Producción (MW)", "País C");
            dataset.addValue(360, "Producción (MW)", "País D");
            dataset.addValue(340, "Producción (MW)", "País E");
            dataset.addValue(370, "Producción (MW)", "País F");
            dataset.addValue(220, "Producción (MW)", "País G");
            dataset.addValue(230, "Producción (MW)", "País H");
            dataset.addValue(240, "Producción (MW)", "País I");
            dataset.addValue(250, "Producción (MW)", "País J");
            break;
        case 2021:
            dataset.addValue(450, "Producción (MW)", "País A");
            dataset.addValue(430, "Producción (MW)", "País B");
            dataset.addValue(410, "Producción (MW)", "País C");
            dataset.addValue(390, "Producción (MW)", "País D");
            dataset.addValue(370, "Producción (MW)", "País E");
            dataset.addValue(390, "Producción (MW)", "País F");
            dataset.addValue(230, "Producción (MW)", "País G");
            dataset.addValue(240, "Producción (MW)", "País H");
            dataset.addValue(250, "Producción (MW)", "País I");
            dataset.addValue(260, "Producción (MW)", "País J");
            break;
        case 2022:
            dataset.addValue(480, "Producción (MW)", "País A");
            dataset.addValue(460, "Producción (MW)", "País B");
            dataset.addValue(440, "Producción (MW)", "País C");
            dataset.addValue(420, "Producción (MW)", "País D");
            dataset.addValue(400, "Producción (MW)", "País E");
            dataset.addValue(410, "Producción (MW)", "País F");
            dataset.addValue(240, "Producción (MW)", "País G");
            dataset.addValue(250, "Producción (MW)", "País H");
            dataset.addValue(260, "Producción (MW)", "País I");
            dataset.addValue(270, "Producción (MW)", "País J");
            break;
        case 2023:
            dataset.addValue(500, "Producción (MW)", "País A");
            dataset.addValue(480, "Producción (MW)", "País B");
            dataset.addValue(460, "Producción (MW)", "País C");
            dataset.addValue(440, "Producción (MW)", "País D");
            dataset.addValue(420, "Producción (MW)", "País E");
            dataset.addValue(450, "Producción (MW)", "País F");
            dataset.addValue(250, "Producción (MW)", "País G");
            dataset.addValue(260, "Producción (MW)", "País H");
            dataset.addValue(270, "Producción (MW)", "País I");
            dataset.addValue(280, "Producción (MW)", "País J");
            break;
        default:
            // Si el año no está en la lista, puedes agregar datos por defecto o dejar el dataset vacío.
            dataset.addValue(0, "Producción (MW)", "Sin datos");
            break;
    }
    
    return dataset;
}
        // Método para actualizar la tabla según el año seleccionado
   private void actualizarTabla(int año) {
    // Definir las columnas de la tabla
    String[] columnas = {"Ranking", "País", "Producción (MWh)"};
    
    // Crear un modelo de tabla vacío
    DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
    
    // Limpiar tabla existente
    modeloTabla.setRowCount(0); 

    switch (año) {
        case 2010:
            modeloTabla.addRow(new Object[]{1, "País A", 180});
            modeloTabla.addRow(new Object[]{2, "País B", 160});
            modeloTabla.addRow(new Object[]{3, "País C", 140});
            modeloTabla.addRow(new Object[]{4, "País D", 120});
            modeloTabla.addRow(new Object[]{5, "País E", 300});
            modeloTabla.addRow(new Object[]{6, "País F", 500});
            modeloTabla.addRow(new Object[]{7, "País G", 30});
            modeloTabla.addRow(new Object[]{8, "País H", 10});
            modeloTabla.addRow(new Object[]{9, "País I", 40});
            modeloTabla.addRow(new Object[]{10, "País J", 150});
            break;
        case 2011:
            modeloTabla.addRow(new Object[]{1, "País A", 200});
            modeloTabla.addRow(new Object[]{2, "País B", 180});
            modeloTabla.addRow(new Object[]{3, "País C", 160});
            modeloTabla.addRow(new Object[]{4, "País D", 140});
            modeloTabla.addRow(new Object[]{5, "País E", 120});
            modeloTabla.addRow(new Object[]{6, "País F", 15});
            modeloTabla.addRow(new Object[]{7, "País G", 10});
            modeloTabla.addRow(new Object[]{8, "País H", 160});
            modeloTabla.addRow(new Object[]{9, "País I", 170});
            modeloTabla.addRow(new Object[]{10, "País J", 10});
            break;
        case 2012:
            modeloTabla.addRow(new Object[]{1, "País A", 210});
            modeloTabla.addRow(new Object[]{2, "País B", 190});
            modeloTabla.addRow(new Object[]{3, "País C", 170});
            modeloTabla.addRow(new Object[]{4, "País D", 150});
            modeloTabla.addRow(new Object[]{5, "País E", 130});
            modeloTabla.addRow(new Object[]{6, "País F", 20});
            modeloTabla.addRow(new Object[]{7, "País G", 50});
            modeloTabla.addRow(new Object[]{8, "País H", 60});
            modeloTabla.addRow(new Object[]{9, "País I", 30});
            modeloTabla.addRow(new Object[]{10, "País J", 40});
            break;
        case 2013:
            modeloTabla.addRow(new Object[]{1, "País A", 230});
            modeloTabla.addRow(new Object[]{2, "País B", 210});
            modeloTabla.addRow(new Object[]{3, "País C", 190});
            modeloTabla.addRow(new Object[]{4, "País D", 170});
            modeloTabla.addRow(new Object[]{5, "País E", 150});
            modeloTabla.addRow(new Object[]{6, "País F", 25});
            modeloTabla.addRow(new Object[]{7, "País G", 35});
            modeloTabla.addRow(new Object[]{8, "País H", 75});
            modeloTabla.addRow(new Object[]{9, "País I", 80});
            modeloTabla.addRow(new Object[]{10, "País J", 90});
            break;
        case 2014:
            modeloTabla.addRow(new Object[]{1, "País A", 250});
            modeloTabla.addRow(new Object[]{2, "País B", 230});
            modeloTabla.addRow(new Object[]{3, "País C", 210});
            modeloTabla.addRow(new Object[]{4, "País D", 190});
            modeloTabla.addRow(new Object[]{5, "País E", 170});
            modeloTabla.addRow(new Object[]{6, "País F", 30});
            modeloTabla.addRow(new Object[]{7, "País G", 65});
            modeloTabla.addRow(new Object[]{8, "País H", 85});
            modeloTabla.addRow(new Object[]{9, "País I", 60});
            modeloTabla.addRow(new Object[]{10, "País J", 110});
            break;
        case 2015:
            modeloTabla.addRow(new Object[]{1, "País A", 270});
            modeloTabla.addRow(new Object[]{2, "País B", 250});
            modeloTabla.addRow(new Object[]{3, "País C", 230});
            modeloTabla.addRow(new Object[]{4, "País D", 210});
            modeloTabla.addRow(new Object[]{5, "País E", 190});
            modeloTabla.addRow(new Object[]{6, "País F", 35});
            modeloTabla.addRow(new Object[]{7, "País G", 70});
            modeloTabla.addRow(new Object[]{8, "País H", 90});
            modeloTabla.addRow(new Object[]{9, "País I", 120});
            modeloTabla.addRow(new Object[]{10, "País J", 130});
            break;
        case 2016:
            modeloTabla.addRow(new Object[]{1, "País A", 290});
            modeloTabla.addRow(new Object[]{2, "País B", 270});
            modeloTabla.addRow(new Object[]{3, "País C", 250});
            modeloTabla.addRow(new Object[]{4, "País D", 230});
            modeloTabla.addRow(new Object[]{5, "País E", 210});
            modeloTabla.addRow(new Object[]{6, "País F", 40});
            modeloTabla.addRow(new Object[]{7, "País G", 75});
            modeloTabla.addRow(new Object[]{8, "País H", 95});
            modeloTabla.addRow(new Object[]{9, "País I", 130});
            modeloTabla.addRow(new Object[]{10, "País J", 150});
            break;
        case 2017:
            modeloTabla.addRow(new Object[]{1, "País A", 310});
            modeloTabla.addRow(new Object[]{2, "País B", 290});
            modeloTabla.addRow(new Object[]{3, "País C", 270});
            modeloTabla.addRow(new Object[]{4, "País D", 250});
            modeloTabla.addRow(new Object[]{5, "País E", 230});
            modeloTabla.addRow(new Object[]{6, "País F", 45});
            modeloTabla.addRow(new Object[]{7, "País G", 80});
            modeloTabla.addRow(new Object[]{8, "País H", 100});
            modeloTabla.addRow(new Object[]{9, "País I", 140});
            modeloTabla.addRow(new Object[]{10, "País J", 160});
            break;
        case 2018:
            modeloTabla.addRow(new Object[]{1, "País A", 330});
            modeloTabla.addRow(new Object[]{2, "País B", 310});
            modeloTabla.addRow(new Object[]{3, "País C", 290});
            modeloTabla.addRow(new Object[]{4, "País D", 270});
            modeloTabla.addRow(new Object[]{5, "País E", 250});
            modeloTabla.addRow(new Object[]{6, "País F", 50});
            modeloTabla.addRow(new Object[]{7, "País G", 85});
            modeloTabla.addRow(new Object[]{8, "País H", 110});
            modeloTabla.addRow(new Object[]{9, "País I", 150});
            modeloTabla.addRow(new Object[]{10, "País J", 170});
            break;
        case 2019:
            modeloTabla.addRow(new Object[]{1, "País A", 350});
            modeloTabla.addRow(new Object[]{2, "País B", 330});
            modeloTabla.addRow(new Object[]{3, "País C", 310});
            modeloTabla.addRow(new Object[]{4, "País D", 290});
            modeloTabla.addRow(new Object[]{5, "País E", 270});
            modeloTabla.addRow(new Object[]{6, "País F", 55});
            modeloTabla.addRow(new Object[]{7, "País G", 90});
            modeloTabla.addRow(new Object[]{8, "País H", 120});
            modeloTabla.addRow(new Object[]{9, "País I", 160});
            modeloTabla.addRow(new Object[]{10, "País J", 180});
            break;
        case 2020:
            modeloTabla.addRow(new Object[]{1, "País A", 370});
            modeloTabla.addRow(new Object[]{2, "País B", 350});
            modeloTabla.addRow(new Object[]{3, "País C", 330});
            modeloTabla.addRow(new Object[]{4, "País D", 310});
            modeloTabla.addRow(new Object[]{5, "País E", 290});
            modeloTabla.addRow(new Object[]{6, "País F", 60});
            modeloTabla.addRow(new Object[]{7, "País G", 95});
            modeloTabla.addRow(new Object[]{8, "País H", 130});
            modeloTabla.addRow(new Object[]{9, "País I", 170});
            modeloTabla.addRow(new Object[]{10, "País J", 190});
            break;
        case 2021:
            modeloTabla.addRow(new Object[]{1, "País A", 390});
            modeloTabla.addRow(new Object[]{2, "País B", 370});
            modeloTabla.addRow(new Object[]{3, "País C", 350});
            modeloTabla.addRow(new Object[]{4, "País D", 330});
            modeloTabla.addRow(new Object[]{5, "País E", 310});
            modeloTabla.addRow(new Object[]{6, "País F", 65});
            modeloTabla.addRow(new Object[]{7, "País G", 100});
            modeloTabla.addRow(new Object[]{8, "País H", 140});
            modeloTabla.addRow(new Object[]{9, "País I", 180});
            modeloTabla.addRow(new Object[]{10, "País J", 200});
            break;
        case 2022:
            modeloTabla.addRow(new Object[]{1, "País A", 410});
            modeloTabla.addRow(new Object[]{2, "País B", 390});
            modeloTabla.addRow(new Object[]{3, "País C", 370});
            modeloTabla.addRow(new Object[]{4, "País D", 350});
            modeloTabla.addRow(new Object[]{5, "País E", 330});
            modeloTabla.addRow(new Object[]{6, "País F", 70});
            modeloTabla.addRow(new Object[]{7, "País G", 105});
            modeloTabla.addRow(new Object[]{8, "País H", 150});
            modeloTabla.addRow(new Object[]{9, "País I", 190});
            modeloTabla.addRow(new Object[]{10, "País J", 210});
            break;
        case 2023:
            modeloTabla.addRow(new Object[]{1, "País A", 430});
            modeloTabla.addRow(new Object[]{2, "País B", 410});
            modeloTabla.addRow(new Object[]{3, "País C", 390});
            modeloTabla.addRow(new Object[]{4, "País D", 370});
            modeloTabla.addRow(new Object[]{5, "País E", 350});
            modeloTabla.addRow(new Object[]{6, "País F", 75});
            modeloTabla.addRow(new Object[]{7, "País G", 110});
            modeloTabla.addRow(new Object[]{8, "País H", 160});
            modeloTabla.addRow(new Object[]{9, "País I", 200});
            modeloTabla.addRow(new Object[]{10, "País J", 220});
            break;
        default:
            JOptionPane.showMessageDialog(this, "Año no disponible.");
            return; // Salir si el año no está disponible
    }

    // Asignar el modelo de tabla actualizado a la tabla
    jTable1.setModel(modeloTabla);
}
   
        private void crearGrafico(int año) {
        CategoryDataset dataset = obtenerDatosProduccionPorAño(año);
        JFreeChart barChart = ChartFactory.createBarChart(
                "Producción de Energía Eólica en " + año,
                "País",
                "Producción (MW)",
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
                "Ranking", "País", "Producción (MWh)"
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
                                .addGap(85, 85, 85)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)))
                        .addGap(0, 40, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
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
            .addGap(0, 181, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
