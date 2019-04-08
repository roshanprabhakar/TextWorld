import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private Graph g = this;
    private Node startNode;
    private HashMap<String, Node> nodes;
    private Player player;

    private ArrayList<Creature> creatures;

    public Graph(String player, String startRoom) {
        creatures = new ArrayList<>();
        nodes = new HashMap<>();
        addNode(startRoom);
        startNode = getNode(startRoom);
        this.player = new Player(player, getNode(startRoom));
    }

    public void addNode(String name) {
        nodes.put(name, new Node(name));
    }

    public void addDirectedEdge(String name1, String name2) {
        getNode(name1).addNeighbor(getNode(name2));
    }

    public void addUndirectedEdge(String name1, String name2) {
        addDirectedEdge(name1, name2);
        addDirectedEdge(name2, name1);
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public void addDescription(String name, String description) {
        nodes.get(name).setDescription(description);
    }

    public String getDescription(String name) {
        return nodes.get(name).getDescription();
    }

    public void placeItem(String node, String item) {
        try {
            getNode(node).addItem(item);
        } catch (NullPointerException e) {
            System.out.println("item: " + item + " non existent");
        }
    }

    public void placeItem(String node, Item item) {
        try {
            getNode(node).addItem(item);
        } catch (NullPointerException e) {
            System.out.println("item: " + item + " non existent");
        }
    }

    public String liftItem(String node, String item) {
        return nodes.get(node).removeItem(item);
    }

    public Player getPlayer() {
        return player;
    }


    public Node getStartRoom() {
        return startNode;
    }

    public void setup() {

        g.addNode("twin bedroom");
        g.addNode("closet");
        g.addNode("master bedroom");
        g.addNode("living room");
        g.addNode("family room");
        g.addNode("tv room");
        g.addNode("master bathroom");
        g.addNode("guest bathroom");
        g.addNode("bathroom");

        g.addUndirectedEdge("hall", "twin bedroom");
        g.addUndirectedEdge("twin bedroom", "closet");
        g.addUndirectedEdge("closet", "master bedroom");
        g.addUndirectedEdge("master bedroom", "hall");
        g.addUndirectedEdge("hall", "guest bathroom");
        g.addUndirectedEdge("master bedroom", "master bathroom");
        g.addUndirectedEdge("hall", "living room");
        g.addUndirectedEdge("living room", "family room");
        g.addUndirectedEdge("family room", "hall");
        g.addUndirectedEdge("tv room", "family room");
        g.addDirectedEdge("tv room", "bathroom");

        for (int i = 0; i < 3; i++) {
            Chicken chicken = new Chicken(g.getStartRoom(), "Chicken");
            creatures.add(chicken);
            getStartRoom().addCreature(chicken);
        }
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

}
