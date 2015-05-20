package dram_energy_sim.Controller;

import dram_energy_sim.Model.Aplicacao;
import dram_energy_sim.Model.Memoria;
import dram_energy_sim.Model.Relatorio;
import dram_energy_sim.View.VisualizacaoAplicacao;
import dram_energy_sim.View.VisualizacaoMemoria;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MainViewController {

    public ArrayList< Memoria> memorias = new ArrayList<>();
    public ArrayList< Aplicacao> aplicacoes = new ArrayList<>();
    public int num;

    public Memoria carregaMemoria(String arquivo) {
        Memoria memoria = new Memoria();
        memoria = memoria.carregaEspecMem(arquivo);
        memorias.add(memoria);
        return memoria;
    }

    public Aplicacao carregaAplicacao(String arquivo) {
        Aplicacao aplicacao = new Aplicacao();
        aplicacao = aplicacao.carregaEspecAplic(arquivo);
        aplicacoes.add(aplicacao);
        num++;
        aplicacao.id = num;
        return aplicacao;
    }

    public void visualizaMemoria(int i) {
        if (i != -1) {
            new VisualizacaoMemoria(memorias.get(i)).setVisible(true);
        } else {
            //
        }
    }

    public void visualizaAplicacao(int i) {
        if (i != -1) {
            new VisualizacaoAplicacao(aplicacoes.get(i)).setVisible(true);
        } else {
            //
        }
    }

    public void run(File file) {
        if (memorias.isEmpty() || aplicacoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Para rodar é necessário que haja pelo menos uma aplicação e uma "
                    + "memória inseridas");
        } else {
            Relatorio relatorio = new Relatorio(memorias, aplicacoes,file);
            ViewRelatorioController viewRelatorio = new ViewRelatorioController(relatorio.estimate);
        }
    }
}
