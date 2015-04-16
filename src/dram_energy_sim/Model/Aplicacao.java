package dram_energy_sim.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Aplicacao {

    public double readPctg, writePctg, pageHitPctg, ckeLoPREPctg, ckeLoACTPctg, bnkPREPctg;
    public int id;

    public String toString() {
        String saida = "Aplicação " + id;
        return saida;
    }

    public String toStringI() {
        String saida = "readPctg\t" + readPctg + "\nwritePctg\t" + writePctg + "\npageHitPctg\t" + pageHitPctg
                + "\nckeLoPREPctg\t" + ckeLoPREPctg + "\nckeLoACTPctg\t" + ckeLoACTPctg + "\nbnkPREPctg\t" + bnkPREPctg;
        return saida;
    }

    public Aplicacao carregaEspecAplic(String arquivo) {
        File a;
        FileReader x = null;
        try {
            a = new File(arquivo);
            x = new FileReader(a);
        } catch (FileNotFoundException e) {
            //
        }
        Scanner s = new Scanner(x);
        String linha = s.nextLine();
        readPctg = Double.parseDouble(linha.split(" ")[0]);
        writePctg = Double.parseDouble(linha.split(" ")[1]);
        pageHitPctg = Double.parseDouble(linha.split(" ")[2]);
        ckeLoPREPctg = Double.parseDouble(linha.split(" ")[3]);
        ckeLoACTPctg = Double.parseDouble(linha.split(" ")[4]);
        bnkPREPctg = Double.parseDouble(linha.split(" ")[5]);
        return this;
    }
}
