package dram_energy_sim.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Memoria {

    public String MODEL;
    public double VDD, tCK, tRC, pPerDQ, IDD2P, IDD2F, IDD3P, IDD3N, IDD0, IDD4W, IDD4R, IDD5A, BL, NUM_DQ, NUM_DQS;
    public int WORD_SIZE, PAGE_SIZE;

    public String toString() {
        String saida = "Model " + MODEL;
        return saida;
    }

    public String toStringI() {
        String saida = "Model\t" + MODEL + "\nVDD\t" + VDD + "\ntCK\t" + tCK + "\ntRC\t" + tRC + "\nP_DQ\t" + pPerDQ + "\nIDD2P\t"
                + IDD2F + "\nIDD3P\t" + IDD3P + "\nIDD3N\t" + IDD3N + "\nIDD0\t" + IDD0 + "\nIDD4W\t" + IDD4W + "\nIDD4R\t"
                + IDD4R + "\nIDD5A\t" + IDD5A + "\nBL\t" + BL + "\nNUM+DQ\t" + NUM_DQ + "\nNUM_DQS\t" + NUM_DQS
                + "\nWORD_SIZE\t" + WORD_SIZE + "\nPage_SIZE\t" + PAGE_SIZE;
        return saida;
    }

    public Memoria carregaEspecMem(String arquivo) {
        File a;
        FileReader x = null;
        try {
            a = new File(arquivo);
            x = new FileReader(a);
        } catch (FileNotFoundException e) {
            //
        }
        Scanner s = new Scanner(x);
        String linha;
        while (s.hasNext()) {
            linha = s.nextLine();
            if ("MODEL".equals(linha.split(" = ")[0])) {
                MODEL = linha.split(" = ")[1];
            } else if ("VDD".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                VDD = Double.parseDouble(p.split(" = ")[1]);

            } else if ("tCK".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                tCK = Double.parseDouble(p.split(" = ")[1]);

            } else if ("tRC".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                tRC = Double.parseDouble(p.split(" = ")[1]);

            } else if ("P_DQ".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                pPerDQ = Double.parseDouble(p.split(" = ")[1]);

            } else if ("WORD_SIZE".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                WORD_SIZE = Integer.parseInt(p.split(" = ")[1]);

            } else if ("PAGE_SIZE".equals(linha.split(" = ")[0])) {
                PAGE_SIZE = Integer.parseInt(linha.split(" ")[2]);

            } else if ("IDD2P".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                IDD2P = Double.parseDouble(p.split(" = ")[1]);

            } else if ("IDD2F".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                IDD2F = Double.parseDouble(p.split(" = ")[1]);

            } else if ("IDD3P".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                IDD3P = Double.parseDouble(p.split(" = ")[1]);

            } else if ("IDD3N".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                IDD3N = Double.parseDouble(p.split(" = ")[1]);

            } else if ("IDD0".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                IDD0 = Double.parseDouble(p.split(" = ")[1]);

            } else if ("IDD4W".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                IDD4W = Double.parseDouble(p.split(" = ")[1]);

            } else if ("IDD4R".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                IDD4R = Double.parseDouble(p.split(" = ")[1]);

            } else if ("IDD5A".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                IDD5A = Double.parseDouble(p.split(" = ")[1]);

            } else if ("BL".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                BL = Double.parseDouble(p.split(" = ")[1]);

            } else if ("NUM_DQ".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                NUM_DQ = Double.parseDouble(p.split(" = ")[1]);

            } else if ("NUM_DQS".equals(linha.split(" = ")[0])) {
                String p = linha.split("\t")[0];
                NUM_DQS = Double.parseDouble(p.split(" = ")[1]);
            }
        }
        return this;
    }
}
