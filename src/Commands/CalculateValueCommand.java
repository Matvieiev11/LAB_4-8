package Commands;

import Financial.Derivative;

public class CalculateValueCommand implements Command {
    Derivative derivative;
    public  CalculateValueCommand(Derivative derivative){
        this.derivative=derivative;
    }
    @Override
    public void execute() {
        System.out.print("Загальна вартість деривативу: "+ derivative.getTotalCost()+"\n");
    }
}