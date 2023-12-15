package Commands;

import Financial.Derivative;
import Financial.InsuranceObligation;

import java.util.Scanner;
import java.util.List;

public class SearchByParametersCommand implements Command {
    Derivative derivative;

    public SearchByParametersCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public void execute() {
        var scanner = new Scanner(System.in);
        double from, to;
        int parameterChoice;

        System.out.println("Оберіть параметр пошуку:");
        System.out.println("1) Вартість");
        System.out.println("2) Рівень ризику");

        parameterChoice = scanner.nextInt();

        switch (parameterChoice) {
            case 1:
                System.out.print("Знайти зобов'язання, вартість яких від ");
                from = scanner.nextDouble();
                System.out.print("До ");
                to = scanner.nextDouble();
                var listByCost = derivative.findObligationsByParameters(from, to, "cost");
                displayResults(listByCost);
                break;
            case 2:
                System.out.print("Знайти зобов'язання, рівень ризику яких від ");
                from = scanner.nextDouble();
                System.out.print("До ");
                to = scanner.nextDouble();
                var listByRisk = derivative.findObligationsByParameters(from, to, "risk");
                displayResults(listByRisk);
                break;
            default:
                System.out.println("Невірний вибір параметру.");
        }
    }

    public void displayResults(List<InsuranceObligation> list) {
        System.out.printf("|%-20s|%-20s|%-20s|\n", "Назва", "Рівень ризику", "Вартість");
        for (var obligation : list) {
            obligation.showInformation();
        }
    }
}