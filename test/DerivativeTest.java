import Financial.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DerivativeTest {
    private Derivative derivative;


    @Before
    public void setUp() {
        List<InsuranceObligation> obligations = new ArrayList<>();
        obligations.add(new InsuranceObligation("Test1", 0.1, 100.0));
        obligations.add(new InsuranceObligation("Test2", 0.2, 200.0));
        derivative = new Derivative(obligations);
    }

    @Test
    public void testGetTotalCost() {
        assertEquals(300.0, derivative.getTotalCost(), 0.001);
    }

    @Test
    public void testCreateDerivative() {
        List<InsuranceObligation> newObligations = new ArrayList<>();
        newObligations.add(new InsuranceObligation("Test3", 0.3, 300.0));
        newObligations.add(new InsuranceObligation("Test4", 0.4, 400.0));
        derivative.createDerivative(newObligations);

        assertEquals(700.0, derivative.getTotalCost(), 0.001);
    }

    @Test
    public void testSortObligationsByRisk() {
        derivative.sortObligationsByRisk();
        List<InsuranceObligation> sortedObligations = derivative.getObligations();

        // Перевірте, чи обов'язки відсортовані у зворотньому порядку за ризиком
        for (int i = 0; i < sortedObligations.size() - 1; i++) {
            assertTrue(sortedObligations.get(i).getRiskLevel() >= sortedObligations.get(i + 1).getRiskLevel());
        }
    }

    @Test
    public void testFindObligationsByParameters() {
        List<InsuranceObligation> foundObligations = derivative.findObligationsByParameters(0.1, 0.3, "risk");

        // Перевірте, чи знайдені обов'язки задовольняють вказані параметри
        for (var obligation : foundObligations) {
            assertTrue(obligation.getRiskLevel() >= 0.1 && obligation.getRiskLevel() <= 0.3);
        }
    }
}
