import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Graph g = new Graph();
        g.setup();

        Player p = new Player("p1", g.getRoom("hall"));

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

            if (response.equals("look")) {
                System.out.println("----- Current Room ----");
                System.out.println(p.getCurrentRoom().getName());
                System.out.println(p.getCurrentRoom().getDescription());

                System.out.println("-------- Items --------");
                System.out.println("carrying items: " + p.getItems());
                System.out.println("items in room: " + p.getCurrentRoom().getItems());

                System.out.println("------ Creatures ------");
                System.out.println("creatures in current room: " + p.getCurrentRoom().getCreatures());
                for (String room : p.getCurrentRoom().getNeighbors().keySet()) {
                    System.out.println("Creatures in (neighbor) " + room + ": " + g.getRoom(room).getCreatures());
                }

                System.out.println("------ Neighbors ------");
                System.out.println(p.getCurrentRoom().getNeighbors(true));

            } else if (response.equals("get room description")) {
                System.out.println(p.getCurrentRoom().getDescription());
            }

            try {
                if (response.substring(0, 4).equals("go <") && response.substring(response.length() - 1).equals(">")) {
                    p.moveToRoom(response.substring(4, response.length() - 1));
                } else if (response.substring(0, 10).equals("add room <") && response.substring(response.length() - 1).equals(">")) {
                    g.addRoom(response.substring(10, response.length() - 1));
                    g.addUndirectedEdge(p.getCurrentRoom().getName(), response.substring(10, response.length() - 1));
                } else if (response.substring(0, 11).equals("lift item <")) {
                    p.liftItem(response.substring(11, response.length() - 1));
                } else if (response.substring(0, 12).equals("place item <")) {
                    p.placeItem(response.substring(12, response.length() - 1));
                } else if (response.substring(0, 17).equals("set description <") && response.substring(response.length() - 1).equals(">")) {
                    p.getCurrentRoom().setDescription(response.substring(17, response.length() - 1));
                }
            } catch (Exception e) {}
            System.out.println("=======================");

            g.moveCreatures();
        }
    }
}
