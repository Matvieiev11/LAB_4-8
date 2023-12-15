package Commands;
import Financial.InsuranceObligation;

import java.util.List;
import java.util.Scanner;

public class AddObligationCommand implements Command {
    List<InsuranceObligation> obligations;
    public AddObligationCommand(List<InsuranceObligation> obligations){
        this.obligations= obligations;
    }
    @Override
    public void execute() {
        var scanner = new Scanner(System.in);
        String name;
        double cost;
        double riskLevel;
        System.out.print("Назва зобов'язання: ");
        name = scanner.nextLine();
        System.out.print("Вартість зобов'язання: ");
        cost = scanner.nextDouble();
        System.out.print("Рівень ризику: ");
        riskLevel = scanner.nextDouble();

        obligations.add(new InsuranceObligation(name,riskLevel,cost));
    }
}