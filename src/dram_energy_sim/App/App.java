package dram_energy_sim.App;

import dram_energy_sim.Controller.CmdController;
import dram_energy_sim.View.MainView;

public class App {

    public static void main(String[] args) {
        if(args.length == 0){
            new MainView().setVisible(true);
        }else{
            CmdController cmd = new CmdController(args);
        }
    }
}
