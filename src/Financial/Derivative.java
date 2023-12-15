package Financial;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Derivative {
    private boolean sortObligationsByRiskCalled = false;
    private boolean showObligationsCalled = false;
    List<InsuranceObligation> obligations;
    double totalCost;

    public double getTotalCost() {
        return totalCost;
    }

    private void setTotalCost() {
        totalCost = 0;
        for (InsuranceObligation obligation : obligations) {
            totalCost += obligation.getCost();
        }
    }
    public Derivative(List<InsuranceObligation> obligations) {
        this.obligations = new ArrayList<>();
        createDerivative(obligations);
    }
    public void createDerivative(List<InsuranceObligation> obligations) {
        this.obligations.clear();
        this.obligations.addAll(obligations);
        setTotalCost();
        obligations.clear();
    }
    public void showObligations() {
        System.out.printf("|%-20s|%-20s |%-20s|\n", "Назва", "Рівень ризику", "Вартість");
        for (var obligation : obligations) {
            obligation.showInformation();
        }
    }
    public void sortObligationsByRisk() {
        obligations.sort(Comparator.comparingDouble(InsuranceObligation::getRiskLevel).reversed());
    }
    public List<InsuranceObligation> findObligationsByParameters(double min, double max, String parameter) {
        List<InsuranceObligation> obligationsByParameters = new ArrayList<>();

        for (var obligation : obligations) {
            double value = 0;

            switch (parameter.toLowerCase()) {
                case "cost":
                    value = obligation.getCost();
                    break;
                case "risk":
                    value = obligation.getRiskLevel();
                    break;
                default:
                    System.out.println("Невірний параметр.");
                    return obligationsByParameters;
            }
            if (value >= min && value <= max) {
                obligationsByParameters.add(obligation);
            }
        }
        return obligationsByParameters;
    }
    public List<InsuranceObligation> getObligations() {
        return obligations;
    }
    public void showDerivative() {
        System.out.println("Створений дериватив:");
        System.out.printf("|%-20s|%-20s |%-20s|\n", "Назва", "Рівень ризику", "Вартість");
        for (var obligation : obligations) {
            obligation.showInformation();
        }
    }
    public boolean isSortObligationsByRiskCalled() {
        return sortObligationsByRiskCalled;
    }

    public boolean isShowObligationsCalled() {
        return showObligationsCalled;
    }
}

