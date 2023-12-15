import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CalculateValueCommandTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testExecute() {

        List<Financial.InsuranceObligation> obligations = new ArrayList<>();
        obligations.add(new Financial.InsuranceObligation("Test1", 0.1, 100.0));
        obligations.add(new Financial.InsuranceObligation("Test2", 0.2, 200.0));

        Financial.Derivative derivative = new Financial.Derivative(obligations);

        // Створення об'єкту CalculateValueCommand для тестування
        Commands.CalculateValueCommand calculateValueCommand = new Commands.CalculateValueCommand(derivative);

        calculateValueCommand.execute();
        String expectedOutput = "Загальна вартість деривативу: " + derivative.getTotalCost() + "\n";

        // Перевірка, чи вивід на консоль відповідає очікуваному значенню
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
