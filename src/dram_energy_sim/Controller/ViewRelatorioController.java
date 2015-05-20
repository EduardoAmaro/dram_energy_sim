package dram_energy_sim.Controller;

import dram_energy_sim.Model.Grafico;
import dram_energy_sim.Model.PowerEstimator;
import dram_energy_sim.View.VisualizacaoRelatorio;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ViewRelatorioController {

    public VisualizacaoRelatorio viewRelatorio;
    public ArrayList<PowerEstimator> relatorio;
    public ArrayList<PowerEstimator> relatorioGrafico;
    
    public ViewRelatorioController(ArrayList<PowerEstimator> relatorio) {
        this.relatorio = relatorio;
        this.relatorioGrafico = new ArrayList<>();
        viewRelatorio = new VisualizacaoRelatorio(this);
        viewRelatorio.setVisible(true);
        DefaultListModel modelLista1 = (DefaultListModel) viewRelatorio.jList1.getModel();
        int i;
        for (i = 0; i < this.relatorio.size(); i++) {
            modelLista1.addElement(relatorio.get(i).toString2());
        }
    }

    public void add(int i) {
        if (i != -1) {
            relatorioGrafico.add(relatorio.remove(i));
            this.atualizaLista();
        } else {
            //
        }
    }

    public void remove(int i) {
        if (i != -1) {
            relatorio.add(relatorioGrafico.remove(i));
            this.atualizaLista();
        } else {
            //
        }
    }
    
    private void atualizaLista(){
        DefaultListModel modelLista1 = (DefaultListModel) viewRelatorio.jList1.getModel();
        modelLista1.clear();
        DefaultListModel modelLista2 = (DefaultListModel) viewRelatorio.jList2.getModel();
        modelLista2.clear();
        int i;
        for (i = 0; i < this.relatorio.size(); i++) {
            modelLista1.addElement(relatorio.get(i).toString2());
        }
        for (i=0;i<relatorioGrafico.size();i++){
            modelLista2.addElement(relatorioGrafico.get(i).toString2());
        }
    }
    
    public void geraGrafico() {
        DefaultListModel modelLista2 = (DefaultListModel) viewRelatorio.jList2.getModel();
        int i;
        if (viewRelatorio.jList2.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "Primeiramente você deverá adicionar um relatório para gerar gráfico");
        } else {
            if(relatorioGrafico.size() <= 1){
                Grafico grafico = new Grafico();
                grafico.geraGraficoPie(relatorioGrafico.get(0));
                JFrame viewGrafico = new JFrame();
                viewGrafico.add(grafico.getPanel());
                viewGrafico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewGrafico.setLocationRelativeTo(null);
                viewGrafico.pack();
                viewGrafico.setVisible(true);
            }else{
                Grafico grafico = new Grafico();
                grafico.geraGraficoBar(relatorioGrafico);
                JFrame viewGrafico = new JFrame();
                viewGrafico.add(grafico.getPanel());
                viewGrafico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewGrafico.setLocationRelativeTo(null);
                viewGrafico.pack();
                viewGrafico.setVisible(true);
            }
        }
    }
}