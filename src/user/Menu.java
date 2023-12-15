package user;

import Commands.*;
import Financial.*;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Menu {
    private Map<Integer, Command> commands = new HashMap<Integer, Command>();
    List<InsuranceObligation> obligations = new ArrayList<>();
    Derivative derivative = new Derivative(obligations);

    public Menu() {
        commands.put(1, new AddObligationCommand(obligations));
        commands.put(2, new CreateDerivativeCommand(obligations, derivative));
        commands.put(3, new CalculateValueCommand(derivative));
        commands.put(4, new SortByRiskCommand(derivative));
        commands.put(5, new SearchByParametersCommand(derivative));
        commands.put(0, new ExitCommand());

        for (var item : commands.entrySet()){
            System.out.println(item.getKey() + ", " + item.getValue());
        }
    }

    public void displayMenu() {
        System.out.println("1) Додати зобов'язання");
        System.out.println("2) Створити дериватив");
        System.out.println("3) Підрахунок вартості");
        System.out.println("4) Сортування за ризиком ");
        System.out.println("5) Пошук за параметрами");
        System.out.println("0) Вихід");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            if (commands.containsKey(choice)) {
                commands.get(choice).execute();
            } else if (choice != 0) {
                System.out.println("Невідома команда.");
            }
        } while (choice != 0);
    }
}
