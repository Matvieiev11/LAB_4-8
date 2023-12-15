import Commands.SearchByParametersCommand;
import Financial.Derivative;
import Financial.InsuranceObligation;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchByParametersCommandTest {
    private Derivative derivative;

    @Before
    public void setUp() {
        List<InsuranceObligation> obligations = new ArrayList<>();
        obligations.add(new InsuranceObligation("Test1", 0.1, 100.0));
        obligations.add(new InsuranceObligation("Test2", 0.2, 200.0));
        derivative = new Derivative(obligations);
    }

    @Test
    public void testExecuteWithInvalidParameterChoice() {
        // Тестуємо випадок, коли користувач вводить невірний параметр
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);

        SearchByParametersCommand command = new SearchByParametersCommand(derivative);

        // Захоплюємо виведення консолі
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        command.execute();

        assertEquals("Невірний вибір параметру.\n", outContent.toString());
    }

    @Test
    public void testExecuteWithValidParameterChoice() {
        // Тестуємо випадок, коли користувач вводить правильний параметр
        ByteArrayInputStream in = new ByteArrayInputStream("1\n100\n200".getBytes());
        System.setIn(in);

        SearchByParametersCommand command = new SearchByParametersCommand(derivative);

        // Захоплюємо виведення консолі
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        command.execute();

        assertEquals("|Назва               |Рівень ризику       |Вартість            |\n" +
                "|--------------------|--------------------|--------------------|\n" +
                "|Test1               |0.1                 |100.0               |\n", outContent.toString());
    }
}
