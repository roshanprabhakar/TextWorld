import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Node startRoom;
    private static Graph g;

    public static void main(String[] args) {

        g = new Graph("player", "hall");
        g.setup();

        Player player = g.getPlayer();

        Node current;

        String response = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("TEXT WORLD LOBBY");
        while (!response.equals("quit")) {

            current = player.getCurrentRoom();
            System.out.println("---------------------------");
            System.out.println("You are currently in room " + current.getName());
            printCreatures(current);
            System.out.print("What do you want to do?: ");
            response = scanner.nextLine();

            if (response.equals("look")) {
                System.out.println("All neighbors: " + current.getNeighborNames());
                System.out.println("Current items: " + player.getItems());
                System.out.println("description of current room: " + current.getDescription());
                System.out.println("Creatures in map: ");
                for (Creature creature : g.getCreatures()) {
                    System.out.println(creature.getDescription());
                }
            }

            else if (response.equals("quit")) {
                response = "quit";
            }

            else if (response.equals("get room description")) {
                System.out.println(current.getDescription());
            }

            try {

                if (response.substring(0, 4).equals("go <") && response.substring(response.length() - 1).equals(">")) {
                    player.setCurrentRoom(g.getNode(response.substring(4, response.length() - 1)));
                }

                else if (response.substring(0, 10).equals("add room <") && response.substring(response.length() - 1).equals(">")) {
                    g.addNode(response.substring(10, response.length() - 1));
                    g.addUndirectedEdge(current.getName(), response.substring(10, response.length() - 1));
                }

                else if (response.substring(0, 11).equals("lift item <")) {
                    player.addItem(g.liftItem(current.getName(), response.substring(11, response.length() - 1)));
                }

                else if (response.substring(0, 12).equals("place item <")) {
                    g.placeItem(current.getName(), player.getItem(response.substring(12, response.length() - 1)));
                }

                else if (response.substring(0, 17).equals("set description <") && response.substring(response.length() - 1).equals(">")) {
                    g.getNode(current.getName()).setDescription(response.substring(17, response.length() - 1));
                }

                else if (response.substring(0, 17).equals("create creature <") && response.substring(response.length() - 1).equals(">")) {
                    if (response.substring(17, response.length() - 1).split(", ")[0].equals("chicken")) {

                    }
                }

            } catch (StringIndexOutOfBoundsException e) {
            }
        }

        moveCreatures();

        System.out.println("---------------------------");
        System.out.println();
        System.out.println();
    }

    private static void printCreatures(Node current) {
        System.out.println("Creatures in this room: " + current.getCreatures());
        System.out.println("Creatures in neighbors: ");
        for (String nodeName : current.getNeighbors().keySet()) {
            System.out.print("Creatures in room  <" + nodeName + ">: ");
            System.out.println(current.getNeighbors().get(nodeName).getCreatureNames());


        }
    }

    private static void moveCreatures() {
        for (Creature creature : g.getCreatures()) {
            creature.move();
        }
    }
}
