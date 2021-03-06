package dram_energy_sim.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Relatorio {

    public ArrayList<PowerEstimator> estimate = new ArrayList<>();

    public Relatorio(ArrayList<Memoria> memorias, ArrayList<Aplicacao> aplicacoes, File file) {
        this.addRelatorio(memorias, aplicacoes, file);
    }

    private void addRelatorio(ArrayList<Memoria> memorias, ArrayList<Aplicacao> aplicacoes, File file) {
        PowerEstimator estimator;
        for (int j = 0; j < memorias.size(); j++) {
            for (int k = 0; k < aplicacoes.size(); k++) {
                estimator = new PowerEstimator(memorias.get(j), aplicacoes.get(k));
                estimate.add(estimator);
            }
        }
        this.geraRelatorio(file);
    }

    private void geraRelatorio(File file) {
        FileWriter fw;
        BufferedWriter escreve;
        try {
            fw = new FileWriter(file.getPath() + ".csv");
            escreve = new BufferedWriter(fw);
            escreve.write("PRE_PDN;PRE_STBY;ACT_PDN;ACT_STBY;ACT;WR;RD;DQ;REF\n");
            for (int i = 0; i < estimate.size(); i++) {
                escreve.write(estimate.get(i).toString() + "\n");
            }
            escreve.close();
            fw.close();
        } catch (IOException e) {
            //
        }
    }
}
