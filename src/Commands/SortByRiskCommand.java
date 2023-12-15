package Commands;

import Financial.Derivative;

public class SortByRiskCommand implements Command {
    Derivative derivative;

    public SortByRiskCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public void execute() {
        derivative.sortObligationsByRisk();
        System.out.println("Дериватив відсортовано за зменшенням рівня ризику");
        derivative.showObligations();
    }
}
