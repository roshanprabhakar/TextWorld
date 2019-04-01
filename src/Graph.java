import java.util.HashMap;

public class Graph {

    HashMap<String, Node> nodes;
    Player player;

    public Graph(String player, String startRoom) {
        nodes = new HashMap<>();
        addNode(startRoom);
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
        try {
            return nodes.get(name);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void addDescription(String name, String description) {
        nodes.get(name).addDescription(description);
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

}
