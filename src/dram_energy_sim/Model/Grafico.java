package dram_energy_sim.Model;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Grafico{
    
    private JFreeChart grafico;
    
    public void geraGraficoPie(PowerEstimator estimate){
        DefaultPieDataset ds = new DefaultPieDataset();
        ds.insertValue(0, "ACT", estimate.ACT);
        ds.insertValue(0, "ACT_PDN", estimate.ACT_PDN);
        ds.insertValue(0, "ACT_STBY", estimate.ACT_STBY);
        ds.insertValue(0, "DQ", estimate.DQ);
        ds.insertValue(0, "PRE_PDN", estimate.PRE_PDN);
        ds.insertValue(0, "PRE_STBY", estimate.PRE_STBY);
        ds.insertValue(0, "RD", estimate.RD);
        ds.insertValue(0, "REF", estimate.REF);
        ds.insertValue(0, "WR", estimate.WR);
        grafico = ChartFactory.createPieChart3D(estimate.toString2(), ds, true, true, false);   
    }
    
    public void geraGraficoBar(ArrayList<PowerEstimator> relatorio){
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        int i;
        for(i=0;i<relatorio.size();i++){
            ds.addValue(relatorio.get(i).ACT, "ACT", relatorio.get(i).toString2());
            ds.addValue(relatorio.get(i).ACT_PDN, "ACT_PDN", relatorio.get(i).toString2());
            ds.addValue(relatorio.get(i).ACT_STBY, "ACT_STBY", relatorio.get(i).toString2());
            ds.addValue(relatorio.get(i).DQ, "DQ", relatorio.get(i).toString2());
            ds.addValue(relatorio.get(i).PRE_PDN, "PRE_PDN", relatorio.get(i).toString2());
            ds.addValue(relatorio.get(i).PRE_STBY, "PRE_STBY", relatorio.get(i).toString2());
            ds.addValue(relatorio.get(i).RD, "RD", relatorio.get(i).toString2());
            ds.addValue(relatorio.get(i).REF, "REF", relatorio.get(i).toString2());
            ds.addValue(relatorio.get(i).WR, "WR", relatorio.get(i).toString2());
            
            /*
            double total = relatorio.get(i).PRE_PDN + relatorio.get(i).PRE_STBY + relatorio.get(i).ACT_PDN + 
                relatorio.get(i).ACT_STBY + relatorio.get(i).ACT + relatorio.get(i).WR + relatorio.get(i).RD + 
                relatorio.get(i).DQ + relatorio.get(i).REF;
                ds.addValue(total, "ptotal",relatorio.get(i).toString2() );
            */
        }
        grafico = ChartFactory.createStackedBarChart3D("", "Application x Memory", "Power Consumption (mW)", ds, 
                PlotOrientation.VERTICAL, true, true, false);
    }
    
    public JPanel getPanel() {
        return new ChartPanel(grafico);
    }
}