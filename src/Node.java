import java.util.ArrayList;
import java.util.HashMap;

public class Node {

    private String name;
    private String description;

    private HashMap<String, Player> players;
    private HashMap<String, Creature> creatures;
    private HashMap<String, Item> items;
    private HashMap<String, Node> neighbors;

    public Node(String name) {

        this.name = name;

        players = new HashMap<>();
        creatures = new HashMap<>();
        items = new HashMap<>();
        neighbors = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void addNeighbor(Node node) {
        neighbors.put(node.getName(), node);
    }

    public HashMap<String, Node> getNeighbors() {
        return neighbors;
    }

    public Node getNeighbor(String name) {
        return neighbors.get(name);
    }

    public String getNeighbors(boolean bool) {
        StringBuilder out = new StringBuilder();
        for (String neighbor : neighbors.keySet()) {
            out.append(neighbor + ", ");
        }
        return out.toString();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void addCreature(Creature creature) {
        creatures.put(creature.getName(), creature);
    }

    public void removeCreature(Creature creature) {
        creatures.remove(creature.getName());
    }

    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    public void removePlayer(Player player) {
        players.remove(player.getName());
    }

    public Item getItem(String item) {return items.get(item);}

    public boolean containsAPlayer() {
        if (players.size() != 0) return true;
        return false;
    }

    public boolean containsItem(String item) {
        if (items.containsKey(item)) return true;
        return false;
    }

    public String getCreatures() {
        StringBuilder out = new StringBuilder();
        for (String creature : creatures.keySet()) {
            out.append(creature + ", ");
        }
        return out.toString();
    }

    public String getItems() {
        StringBuilder out = new StringBuilder();
        for (String item : items.keySet()) {
            out.append(item + ", ");
        }
        return out.toString();
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public boolean containsNeighbor(Node neighbor) {
        if (neighbors.get(neighbor.getName()) == null) {
            return false;
        }
        return true;
    }

    public boolean containsNeighbor(String name) {
        for (String neighbor : neighbors.keySet()) {
            if (name.equals(neighbor)) return true;
        }
        return false;
    }

    public Node getRandomNeighbor() {
        ArrayList<Node> list = mapToArray(neighbors);
        return list.get((int)(Math.random() * list.size()));
    }

    private ArrayList<Node> mapToArray(HashMap<String, Node> map) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (String key : map.keySet()) {
            nodes.add(neighbors.get(key));
        }
        return nodes;

    }

}
