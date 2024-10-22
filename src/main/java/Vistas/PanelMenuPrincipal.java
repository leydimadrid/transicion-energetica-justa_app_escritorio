/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controllers.EnergiaRenovableController;
import Model.Usuario;
import Repository.EnergiaRenovableRepository;
import Services.EnergiaRenovableService;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MI PC
 */
public class PanelMenuPrincipal extends javax.swing.JFrame {

    private DefaultTableModel tableModel;

    /**
     * Creates new form PanelMenuPrincipal
     */
    public PanelMenuPrincipal() {
        initComponents();
        inicializarTabla();
         this.setVisible(true);
         setLocationRelativeTo(null);
          this.setResizable(false); 
     
     
            jTableUsuarios.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 16));

            jTableUsuarios.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));

          jLabelNombre.setFont(new Font(jLabelNombre.getFont().getName(), Font.PLAIN, 16));
          jLabelContrasenia.setFont(new Font(jLabelContrasenia.getFont().getName(), Font.PLAIN, 16));
          jLabelEmail.setFont(new Font(jLabelEmail.getFont().getName(), Font.PLAIN, 16));
          jLabelRol.setFont(new Font(jLabelRol.getFont().getName(), Font.PLAIN, 16));
          
          jTabbedEnergias.setFont(new Font(jTabbedEnergias.getFont().getName(), Font.PLAIN, 16));
          jTableUsuarios.setFont(new Font(jTableUsuarios.getFont().getName(), Font.PLAIN, 16));
          
          jButtonGuardar.setFont(new Font(jButtonGuardar.getFont().getName(), Font.PLAIN, 16));
          jButtonBuscar.setFont(new Font(jButtonBuscar.getFont().getName(), Font.PLAIN, 16));
          jButtonEliminar.setFont(new Font(jButtonEliminar.getFont().getName(), Font.PLAIN, 16));
          jButtonModificar.setFont(new Font(jButtonModificar.getFont().getName(), Font.PLAIN, 16));
          

    }
     private void inicializarTabla() {
        tableModel = (DefaultTableModel) jTableUsuarios.getModel(); 
        
    jTableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50); 
    jTableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(150); 
    jTableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(200); 
    jTableUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100); 

   /*
    tableModel.addRow(new Object[]{1, "Juan Pérez", "juan.perez@example.com", "Admin"});
    tableModel.addRow(new Object[]{2, "Ana Gómez", "ana.gomez@example.com", "Usuario"});
    tableModel.addRow(new Object[]{3, "Luis Martínez", "luis.martinez@example.com", "Moderador"});
    tableModel.addRow(new Object[]{4, "María López", "maria.lopez@example.com", "Usuario"});
    tableModel.addRow(new Object[]{5, "Carlos Fernández", "carlos.fernandez@example.com", "Admin"});
    tableModel.addRow(new Object[]{6, "Sofía Torres", "sofia.torres@example.com", "Moderador"});
    tableModel.addRow(new Object[]{7, "Javier Ruiz", "javier.ruiz@example.com", "Usuario"});
    tableModel.addRow(new Object[]{8, "Laura González", "laura.gonzalez@example.com", "Admin"});
    tableModel.addRow(new Object[]{9, "Pablo Ramírez", "pablo.ramirez@example.com", "Moderador"});
    tableModel.addRow(new Object[]{10, "Isabel Martínez", "isabel.martinez@example.com", "Usuario"});
    tableModel.addRow(new Object[]{11, "Diego Romero", "diego.romero@example.com", "Usuario"});
    tableModel.addRow(new Object[]{12, "Claudia Castro", "claudia.castro@example.com", "Admin"});
    tableModel.addRow(new Object[]{13, "Fernando Salazar", "fernando.salazar@example.com", "Moderador"});
    tableModel.addRow(new Object[]{14, "Elena Rojas", "elena.rojas@example.com", "Usuario"});
    tableModel.addRow(new Object[]{15, "Martín Aguirre", "martin.aguirre@example.com", "Admin"});
    tableModel.addRow(new Object[]{16, "Valeria Peña", "valeria.pena@example.com", "Moderador"});
    tableModel.addRow(new Object[]{17, "Rodrigo Silva", "rodrigo.silva@example.com", "Usuario"});
    tableModel.addRow(new Object[]{18, "Gabriela Vargas", "gabriela.vargas@example.com", "Admin"});
    tableModel.addRow(new Object[]{19, "Mateo Paredes", "mateo.paredes@example.com", "Moderador"});
    tableModel.addRow(new Object[]{20, "Natalia Cordero", "natalia.cordero@example.com", "Usuario"});
    
    */
    
        EnergiaRenovableRepository energiaRepository = new EnergiaRenovableRepository();

        EnergiaRenovableService energiaService = new EnergiaRenovableService(energiaRepository);

        EnergiaRenovableController controller = new EnergiaRenovableController(energiaService);

        List<Usuario> listUsuarios = controller.obtenerUsuarios();

        tableModel.setRowCount(0); 
        for (Usuario usuario : listUsuarios) {
            tableModel.addRow(new Object[]{
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRol()
            });
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

        jTabbedEnergias = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jLabelNombre = new javax.swing.JLabel();
        jTextNombreUsuario = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLabelContrasenia = new javax.swing.JLabel();
        jTextContrasenia = new javax.swing.JTextField();
        jLabelRol = new javax.swing.JLabel();
        jTextRol = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );

        jTabbedEnergias.addTab("Gestion de Energias renovables", jPanel1);

        jButtonGuardar.setText("Guardar");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");

        jLabelNombre.setText("Nombre");

        jLabelEmail.setText("E-mail");

        jTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEmailActionPerformed(evt);
            }
        });

        jLabelContrasenia.setText("Contraseña");

        jLabelRol.setText("Rol");

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Email", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);
        if (jTableUsuarios.getColumnModel().getColumnCount() > 0) {
            jTableUsuarios.getColumnModel().getColumn(0).setResizable(false);
            jTableUsuarios.getColumnModel().getColumn(1).setResizable(false);
            jTableUsuarios.getColumnModel().getColumn(2).setResizable(false);
            jTableUsuarios.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextNombreUsuario)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextEmail)
                    .addComponent(jLabelContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(jTextContrasenia)
                    .addComponent(jLabelRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextRol))
                .addGap(182, 182, 182))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelContrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextRol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jTabbedEnergias.addTab("Gestion de usuarios", jPanel2);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedEnergias, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedEnergias))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEmailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelMenuPrincipal().setVisible(true);
            }
        });
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabelContrasenia;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelRol;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedEnergias;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextContrasenia;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextNombreUsuario;
    private javax.swing.JTextField jTextRol;
    // End of variables declaration//GEN-END:variables
}
