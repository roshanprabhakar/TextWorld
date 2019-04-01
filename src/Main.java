import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Graph g = new Graph("player", "hall");
        Player player = g.getPlayer();
        Node current;



        String response = "";
        Scanner scanner = new Scanner(System.in);

        while (!response.equals("quit")) {

            current = player.getCurrentRoom();

            System.out.println("You are currently in room " + current.getName());
            System.out.print("What do you want to do?: ");
            response = scanner.nextLine();

            if (response.equals("look")) {
                System.out.println("All neighbors: " + current.getNeighborNames());
                System.out.println(player.getItems());
            }


            else if (response.substring(0, 4).equals("go <") && response.substring(response.length() - 1).equals(">")) {
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


            else if (response.equals("get description")) {
                System.out.println(current.getDescription());
            }


            else if (response.substring(0, 16).equals("set description <") && response.substring(response.length() - 1).equals(">")) {
                g.getNode(current.getName()).addDescription(response.substring(16, response.length() - 1));
            }


            else if (response.equals("quit")) {
                response = "quit";
            }


            else {
                System.out.println("Here are your options: ");
                System.out.println("look - view neighboring rooms");
                System.out.println("add room <roomname> - add a new room called roomname");
                System.out.println("get description - display a user defined description of the current room");
                System.out.println("set description - define a description for the current room");
                System.out.println("lift item <item name> - removes item and places in slot");
                System.out.println("place item <item name> - places item and removes from slot");
                System.out.println("quit - quit the game");
            }
        }
    }
}
