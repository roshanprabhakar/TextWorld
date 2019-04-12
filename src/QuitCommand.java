public class QuitCommand extends Command {

    @Override
    void execute() {
        if (placeHolder.equals("quit")) {
            System.out.println("Exiting... ...Done");
            System.exit(0);
        }
    }
}
