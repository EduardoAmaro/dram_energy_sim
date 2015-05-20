package dram_energy_sim.Model;

public final class PowerEstimator{

    public double PRE_PDN, PRE_STBY, ACT_PDN, ACT_STBY, ACT, WR, RD, DQ, REF;
    public String memoria;
    public String aplicacao;

    public PowerEstimator(Memoria memoria, Aplicacao aplicacao) {
        this.estimate(memoria, aplicacao);
    }

    private void estimate(Memoria mem, Aplicacao apli) {
        double tACT = this._calcTACT(mem.BL, mem.tCK, apli.readPctg, apli.writePctg, apli.pageHitPctg);
        this.memoria = mem.MODEL;
        this.aplicacao = "Aplicação " + apli.id;
        this.PRE_PDN = this._calcPRE_PDN(mem.IDD2P, mem.VDD, apli.bnkPREPctg, apli.ckeLoPREPctg);
        this.PRE_STBY = this._calcPRE_STBY(mem.IDD2F, mem.VDD, apli.bnkPREPctg, apli.ckeLoPREPctg);
        this.ACT_PDN = this._calcACT_PDN(mem.IDD3P, mem.VDD, apli.bnkPREPctg, apli.ckeLoACTPctg);
        this.ACT_STBY = this._calcACT_STBY(mem.IDD3N, mem.VDD, apli.bnkPREPctg, apli.ckeLoACTPctg);
        this.ACT = this._calcACT(mem.IDD0, mem.IDD3N, mem.tRC, tACT, mem.VDD);
        this.WR = this._calcWR(mem.IDD4W, mem.IDD3N, apli.writePctg, mem.VDD);
        this.RD = this._calcRD(mem.IDD4R, mem.IDD3N, apli.readPctg, mem.VDD);
        this.DQ = this._calcDQ(mem.pPerDQ, mem.NUM_DQ, mem.NUM_DQS, apli.readPctg);
        this.REF = this._calcREF(mem.IDD5A, mem.IDD2P, mem.VDD);
    }

    private double _calcTACT(PowerEstimator this, double BL, double tCK, double readPctg, double writePctg, double pageHitPctg) {
        double colToCol = ((BL / 2.0) * tCK) / (readPctg + writePctg);
        double tACT = colToCol / (1 - pageHitPctg);
        return tACT;
    }

    private double _calcPRE_PDN(PowerEstimator this, double IDD2P, double VDD, double bnkPREPctg, double ckeLoPREPctg) {
        double PRE_PDN = IDD2P * VDD * bnkPREPctg * ckeLoPREPctg;
        return PRE_PDN;
    }

    private double _calcPRE_STBY(PowerEstimator this, double IDD2F, double VDD, double bnkPREPctg, double ckeLoPREPctg) {
        double PRE_STBY = IDD2F * VDD * bnkPREPctg * (1 - ckeLoPREPctg);
        return PRE_STBY;
    }

    private double _calcACT_PDN(PowerEstimator this, double IDD3P, double VDD, double bnkPREPctg, double ckeLoACTPctg) {
        double ACT_PDN = IDD3P * VDD * (1 - bnkPREPctg) * ckeLoACTPctg;
        return ACT_PDN;
    }

    private double _calcACT_STBY(PowerEstimator this, double IDD3N, double VDD, double bnkPREPctg, double ckeLoACTPctg) {
        double ACT_STBY = IDD3N * VDD * (1 - bnkPREPctg) * (1 - ckeLoACTPctg);
        return ACT_STBY;
    }

    private double _calcACT(PowerEstimator this, double IDD0, double IDD3N, double tRC, double tACT, double VDD) {
        double P_ACT = (IDD0 - IDD3N) * (tRC / tACT) * VDD;
        return P_ACT;
    }

    private double _calcWR(PowerEstimator this, double IDD4W, double IDD3N, double writePctg, double VDD) {
        double P_WR = (IDD4W - IDD3N) * writePctg * VDD;
        return P_WR;
    }

    private double _calcRD(PowerEstimator this, double IDD4R, double IDD3N, double readPctg, double VDD) {
        double P_RD = (IDD4R - IDD3N) * readPctg * VDD;
        return P_RD;
    }

    private double _calcDQ(PowerEstimator this, double pPerDQ, double NUM_DQ, double NUM_DQS, double readPctg) {
        double P_DQ = pPerDQ * (NUM_DQ + NUM_DQS) * readPctg;
        return P_DQ;
    }

    private double _calcREF(PowerEstimator this, double IDD5A, double IDD2P, double VDD) {
        double P_REF = (IDD5A - IDD2P) * VDD;
        return P_REF;
    }

    public String toString2(){
        String saida = this.memoria + " X " + aplicacao;
        return saida;
    }
    public String toString() {
        String saida = PRE_PDN + ";" + PRE_STBY + ";" + ACT_PDN + ";" + ACT_STBY + ";" + ACT + ";" + WR + ";"
                + RD + ";" + DQ + ";" + REF;
        return saida;
    }
}
