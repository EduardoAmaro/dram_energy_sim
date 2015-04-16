package dram_energy_sim.View;

import dram_energy_sim.Controller.MainViewController;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainView extends javax.swing.JFrame {

    public MainView() {
        initComponents();
    }
    MainViewController viewController = new MainViewController();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMem = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listApli = new javax.swing.JList();
        buttonVisuMem = new javax.swing.JButton();
        buttonVisuApli = new javax.swing.JButton();
        run = new javax.swing.JButton();
        carregMem = new javax.swing.JButton();
        carregApli = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        listMem.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(listMem);

        listApli.setModel(new DefaultListModel());
        jScrollPane2.setViewportView(listApli);

        buttonVisuMem.setText("Visualizar Memória");
        buttonVisuMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVisuMemActionPerformed(evt);
            }
        });

        buttonVisuApli.setText("Visualizar Aplicação");
        buttonVisuApli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVisuApliActionPerformed(evt);
            }
        });

        run.setText("Run");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        carregMem.setText("Carregar Memória");
        carregMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregMemActionPerformed(evt);
            }
        });

        carregApli.setText("Carregar Aplicação");
        carregApli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregApliActionPerformed(evt);
            }
        });

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(carregMem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(buttonVisuMem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(buttonExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(carregApli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(run, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonVisuApli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carregMem)
                    .addComponent(carregApli))
                .addGap(32, 32, 32)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVisuMem)
                    .addComponent(buttonVisuApli))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(run)
                    .addComponent(buttonExit))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void carregMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregMemActionPerformed
        JFileChooser j = new JFileChooser();
        int fileChooser = j.showOpenDialog(null);
        if (fileChooser == JFileChooser.APPROVE_OPTION) {
            DefaultListModel model = (DefaultListModel) this.listMem.getModel();
            model.addElement(viewController.carregaMemoria(j.getSelectedFile().getPath()));
        }
    }//GEN-LAST:event_carregMemActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
        if (i == 0) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_buttonExitActionPerformed

    private void carregApliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregApliActionPerformed
        JFileChooser j = new JFileChooser();
        int fileChooser = j.showOpenDialog(null);
        if (fileChooser == JFileChooser.APPROVE_OPTION) {
            DefaultListModel model = (DefaultListModel) this.listApli.getModel();
            model.addElement(viewController.carregaAplicacao(j.getSelectedFile().getPath()));
        }
    }//GEN-LAST:event_carregApliActionPerformed

    private void buttonVisuMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVisuMemActionPerformed
        int i = this.listMem.getSelectedIndex();
        viewController.visualizaMemoria(i);
    }//GEN-LAST:event_buttonVisuMemActionPerformed

    private void buttonVisuApliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVisuApliActionPerformed
        int i = this.listApli.getSelectedIndex();
        viewController.visualizaAplicacao(i);
    }//GEN-LAST:event_buttonVisuApliActionPerformed

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
        viewController.run();
    }//GEN-LAST:event_runActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonVisuApli;
    private javax.swing.JButton buttonVisuMem;
    private javax.swing.JButton carregApli;
    private javax.swing.JButton carregMem;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listApli;
    public javax.swing.JList listMem;
    private javax.swing.JButton run;
    // End of variables declaration//GEN-END:variables
}
