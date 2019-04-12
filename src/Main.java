import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static Graph g = new Graph();
    public static Player p = new Player("p1", g.getRoom("hall"));

    private static HashMap<String, Command> commands = new HashMap<>();

    public static void main(String[] args) {

        Main.setup();

        Scanner scanner = new Scanner(System.in);
        String response = "";

        while (!response.equals("quit")) {

            for (int i = 0; i < 1; i++) {
                System.out.println();
            }

            System.out.println("=======================");

            System.out.println("Current room: " + p.getCurrentRoom().getName());
            System.out.println("All neighbors: " + p.getCurrentRoom().getNeighbors(true));

            System.out.print("Your move: ");
            response = scanner.nextLine();

            try {

                Command command = getCommandFromInput(response);
                command.init(response);
                command.execute();

                if (command.isSafeToMoveCreatures()) g.moveCreatures();

            } catch (NullPointerException e) {
                System.out.println("Unknown command: " + response);
            }

            System.out.println("=======================");
        }
    }

    private static void setup() {

        //require input
        commands.put("go", new GoCommand());
        commands.put("add", new AddCommand());
        commands.put("lift", new LiftCommand());
        commands.put("place", new PlaceCommand());
        commands.put("describe", new DescribeCommand());

        //no input required
        commands.put("look", new LookCommand());
        commands.put("quit", new QuitCommand());
        commands.put("get description", new GetDescriptionCommand());

    }

    private static Command getCommandFromInput(String input) {
        for (String key : commands.keySet()) {
            if (input.contains(key)) return commands.get(key);
        }
        return null;
    }
}

