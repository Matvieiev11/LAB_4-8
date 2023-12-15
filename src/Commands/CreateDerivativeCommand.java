package Commands;

import Financial.*;
import java.util.List;
public class CreateDerivativeCommand implements Command {
    List<InsuranceObligation> obligations;
    Derivative derivative;

    public CreateDerivativeCommand(List<InsuranceObligation> obligations, Derivative derivative) {
        this.obligations = obligations;
        this.derivative = derivative;
    }

    @Override
    public void execute() {
        derivative.createDerivative(obligations);
        System.out.println("Дериватив створено успішно");
        derivative.showDerivative();
    }
}

