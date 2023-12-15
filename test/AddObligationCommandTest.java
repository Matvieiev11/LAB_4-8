
import Commands.*;
import Financial.InsuranceObligation;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddObligationCommandTest {

    private List<InsuranceObligation> obligations;
    private AddObligationCommand addObligationCommand;

    @Before
    public void setUp() {
        obligations = new ArrayList<>();
        addObligationCommand = new AddObligationCommand(obligations);
    }

    @Test
    public void execute_AddsObligationToList() {
        String input = "Test Obligation\n100.0\n0.5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        addObligationCommand.execute();

        assertEquals(1, obligations.size());
        InsuranceObligation addedObligation = obligations.get(0);
        assertEquals("Test Obligation", addedObligation.getName());
        assertEquals(100.0, addedObligation.getCost(), 0.001);
        assertEquals(0.5, addedObligation.getRiskLevel(), 0.001);
    }
}