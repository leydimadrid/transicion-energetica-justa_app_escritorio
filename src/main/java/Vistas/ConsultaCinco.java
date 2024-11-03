package Vistas;

import Controllers.EnergiaRenovableController;
import Repository.EnergiaRenovableRepository;
import Services.EnergiaRenovableService;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author thec1
 */
public class ConsultaCinco extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaCinco
     */
    public ConsultaCinco() {
        initComponents();
        iniciarGrafica();
    }
    
    private void iniciarGrafica() {
        
        EnergiaRenovableRepository energiaRenovableRepository = new EnergiaRenovableRepository();
        EnergiaRenovableService energiaRenovableService = new EnergiaRenovableService(energiaRenovableRepository);
        EnergiaRenovableController energiaController = new EnergiaRenovableController(energiaRenovableService);

        Map<String, Double> consumoEnergiaMapa = energiaController.obtenerParticipacionConsumo();
        
        
        DefaultPieDataset datos = new DefaultPieDataset();

        datos.setValue("Biomasa", consumoEnergiaMapa.get("Biomasa"));
        datos.setValue("Eolica", consumoEnergiaMapa.get("Eólica"));
        datos.setValue("Solar", consumoEnergiaMapa.get("Solar"));
        datos.setValue("Geotermica", consumoEnergiaMapa.get("Geotérmica"));
        datos.setValue("Hidraulica", consumoEnergiaMapa.get("Hidraúlica"));
        datos.setValue("Termica", consumoEnergiaMapa.get("Termal"));
        
        JFreeChart grafico_circular = ChartFactory.createPieChart("Consumo a nivel global",datos,true,true,false);

        ChartPanel panel = new ChartPanel(grafico_circular);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(750, 340));

        JPanelGrafica.setLayout(new BorderLayout());
        JPanelGrafica.add(panel,BorderLayout.NORTH);

        pack();
        repaint();
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        valorBiomasa = new javax.swing.JTextField();
        valorEolica = new javax.swing.JTextField();
        valorSolar = new javax.swing.JTextField();
        valorGeotermica = new javax.swing.JTextField();
        valorHidraulica = new javax.swing.JTextField();
        valorTermica = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        JPanelGrafica = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        valorBiomasa.setText("Ingrese consumo");
        valorBiomasa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorBiomasaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorBiomasaFocusLost(evt);
            }
        });
        valorBiomasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorBiomasaActionPerformed(evt);
            }
        });

        valorEolica.setText("Ingrese consumo");
        valorEolica.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorEolicaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorEolicaFocusLost(evt);
            }
        });
        valorEolica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorEolicaActionPerformed(evt);
            }
        });

        valorSolar.setText("Ingrese consumo");
        valorSolar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorSolarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorSolarFocusLost(evt);
            }
        });

        valorGeotermica.setText("Ingrese consumo");
        valorGeotermica.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorGeotermicaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorGeotermicaFocusLost(evt);
            }
        });

        valorHidraulica.setText("Ingrese consumo");
        valorHidraulica.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorHidraulicaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorHidraulicaFocusLost(evt);
            }
        });

        valorTermica.setText("Ingrese consumo");
        valorTermica.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorTermicaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorTermicaFocusLost(evt);
            }
        });
        valorTermica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTermicaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("Biomasa");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setText("Eolica");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setText("Solar");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setText("Geotermica");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setText("Hidraulica");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel6.setText("Termica");

        jButton1.setText("GRAFICAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JPanelGrafica.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout JPanelGraficaLayout = new javax.swing.GroupLayout(JPanelGrafica);
        JPanelGrafica.setLayout(JPanelGraficaLayout);
        JPanelGraficaLayout.setHorizontalGroup(
            JPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 745, Short.MAX_VALUE)
        );
        JPanelGraficaLayout.setVerticalGroup(
            JPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel7.setText("Consumo a nivel global");

        jButton3.setText("Atras");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(valorBiomasa)
                            .addComponent(valorEolica)
                            .addComponent(valorSolar))
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(valorGeotermica)
                            .addComponent(valorHidraulica)
                            .addComponent(valorTermica)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(jButton1)))
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JPanelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jButton3))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(valorBiomasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(valorEolica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(valorSolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(valorGeotermica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(valorHidraulica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(valorTermica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(69, 69, 69)
                .addComponent(JPanelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        VistaPrincipal vistaP = new VistaPrincipal();
        this.setVisible(false);
        PanelMenuPrincipal mi_PanelMenuPrincipal = new PanelMenuPrincipal();
        mi_PanelMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //tomar valores por teclado
        
        int Biomasa = Integer.parseInt(valorBiomasa.getText());
        int Eolica = Integer.parseInt(valorEolica.getText());
        int Solar = Integer.parseInt(valorSolar.getText());
        int Geotermica = Integer.parseInt(valorGeotermica.getText());
        int Hidraulica = Integer.parseInt(valorHidraulica.getText());
        int Termica = Integer.parseInt(valorTermica.getText());
        
        //valores ejemplo
        
        /*int Biomasa = 56;
        int Eolica = 56;
        int Solar = 56;
        int Geotermica = 56;
        int Hidraulica = 56;
        int Termica = 56;*/

        DefaultPieDataset datos = new DefaultPieDataset();

        datos.setValue("Biomasa",Biomasa);
        datos.setValue("Eolica",Eolica);
        datos.setValue("Solar",Solar);
        datos.setValue("Geotermica",Geotermica);
        datos.setValue("Hidraulica",Hidraulica);
        datos.setValue("Termica",Termica);
     

        JFreeChart grafico_circular = ChartFactory.createPieChart("Consumo a nivel global",datos,true,true,false);

        ChartPanel panel = new ChartPanel(grafico_circular);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(750, 340));

        JPanelGrafica.setLayout(new BorderLayout());
        JPanelGrafica.add(panel,BorderLayout.NORTH);

        pack();
        repaint();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void valorTermicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTermicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTermicaActionPerformed

    private void valorTermicaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTermicaFocusLost
        if (valorTermica.getText().isEmpty()) {
            valorTermica.setText("Ingrese consumo");
        }
    }//GEN-LAST:event_valorTermicaFocusLost

    private void valorTermicaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTermicaFocusGained
        if (valorTermica.getText().equals("Ingrese consumo")) {
            valorTermica.setText("");
        }
    }//GEN-LAST:event_valorTermicaFocusGained

    private void valorHidraulicaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorHidraulicaFocusLost
        if (valorHidraulica.getText().isEmpty()) {
            valorHidraulica.setText("Ingrese consumo");
        }
    }//GEN-LAST:event_valorHidraulicaFocusLost

    private void valorHidraulicaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorHidraulicaFocusGained
        if (valorHidraulica.getText().equals("Ingrese consumo")) {
            valorHidraulica.setText("");
        }
    }//GEN-LAST:event_valorHidraulicaFocusGained

    private void valorGeotermicaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorGeotermicaFocusLost
        if (valorGeotermica.getText().isEmpty()) {
            valorGeotermica.setText("Ingrese consumo");
        }
    }//GEN-LAST:event_valorGeotermicaFocusLost

    private void valorGeotermicaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorGeotermicaFocusGained
        if (valorGeotermica.getText().equals("Ingrese consumo")) {
            valorGeotermica.setText("");
        }
    }//GEN-LAST:event_valorGeotermicaFocusGained

    private void valorSolarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorSolarFocusLost
        if (valorSolar.getText().isEmpty()) {
            valorSolar.setText("Ingrese consumo");
        }
    }//GEN-LAST:event_valorSolarFocusLost

    private void valorSolarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorSolarFocusGained
        if (valorSolar.getText().equals("Ingrese consumo")) {
            valorSolar.setText("");
        }
    }//GEN-LAST:event_valorSolarFocusGained

    private void valorEolicaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorEolicaFocusLost
        if (valorEolica.getText().isEmpty()) {
            valorEolica.setText("Ingrese consumo");
        }
    }//GEN-LAST:event_valorEolicaFocusLost

    private void valorEolicaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorEolicaFocusGained
        if (valorEolica.getText().equals("Ingrese consumo")) {
            valorEolica.setText("");
        }
    }//GEN-LAST:event_valorEolicaFocusGained

    private void valorBiomasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorBiomasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorBiomasaActionPerformed

    private void valorBiomasaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorBiomasaFocusLost
        if (valorBiomasa.getText().isEmpty()) {
            valorBiomasa.setText("Ingrese consumo");
        }
    }//GEN-LAST:event_valorBiomasaFocusLost

    private void valorBiomasaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorBiomasaFocusGained

        if (valorBiomasa.getText().equals("Ingrese consumo")) {
            valorBiomasa.setText("");
        }
    }//GEN-LAST:event_valorBiomasaFocusGained

    private void valorEolicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorEolicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorEolicaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaCinco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaCinco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaCinco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaCinco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCinco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelGrafica;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField valorBiomasa;
    private javax.swing.JTextField valorEolica;
    private javax.swing.JTextField valorGeotermica;
    private javax.swing.JTextField valorHidraulica;
    private javax.swing.JTextField valorSolar;
    private javax.swing.JTextField valorTermica;
    // End of variables declaration//GEN-END:variables
}
