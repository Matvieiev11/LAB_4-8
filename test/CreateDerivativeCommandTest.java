

import Commands.*;
import Financial.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateDerivativeCommandTest {

    @Test
    public void testExecute() {
        List<InsuranceObligation> obligations = new ArrayList<>();
        obligations.add(new InsuranceObligation("Obligation1", 0.2, 100.0));
        Derivative derivative = new Derivative(obligations);
        CreateDerivativeCommand command = new CreateDerivativeCommand(obligations, derivative);

        command.execute();

        assertTrue(derivative.isShowObligationsCalled());
        assertEquals(obligations, derivative.getObligations());
        assertEquals(100.0, derivative.getTotalCost(), 0.001);

    }
}


