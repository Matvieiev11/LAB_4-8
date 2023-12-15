import Financial.InsuranceObligation;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class InsuranceObligationTest {

    @Test
    public void testGetName() {
        InsuranceObligation obligation = new InsuranceObligation("Test Obligation", 0.1, 50.0);
        String name = obligation.getName();
        assertEquals("Test Obligation", name);
    }

    @Test
    public void testGetRiskLevel() {
        InsuranceObligation obligation = new InsuranceObligation("Test Obligation", 0.1, 50.0);
        double riskLevel = obligation.getRiskLevel();
        assertEquals(0.1, riskLevel, 0.001);
    }

    @Test
    public void testGetCost() {
        InsuranceObligation obligation = new InsuranceObligation("Test Obligation", 0.1, 50.0);
        double cost = obligation.getCost();
        assertEquals(50.0, cost, 0.001);
    }

    @Test
    public void testShowInformation() {
        InsuranceObligation obligation = new InsuranceObligation("Test Obligation", 0.1, 50.0);
        obligation.showInformation();

    }

}
