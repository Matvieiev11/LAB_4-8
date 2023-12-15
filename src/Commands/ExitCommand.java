package Commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("До побачення!");
        System.exit(0);
    }
}