import java.util.ArrayList;
import java.util.HashMap;

public class Node {
    private String name;
    private String description;
    private HashMap<String, Node> neighbors;
    private ArrayList<Item> items;

    public Node(String name) {
        this.name = name;
        neighbors = new HashMap<>();
        items = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.put(neighbor.getName(), neighbor);
    }

    public String getNeighborNames() {
        String out = "";
        for (String name : neighbors.keySet()) {
            out += name + " ";
        }
        return out;
    }

    public void addDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        if (description == null) return "no description";
        return description;
    }

    public Node getNeighbor(String name) {
        try {
            return neighbors.get(name);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public String getItems() {
        String out = "";
        for (Item item : items) {
            out += item.getName();
        }
        return out;
    }

    public void addItem(String item) {
        items.add(new Item(item));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) return item;
        }
        return null;
    }

    public String removeItem(String item) {
        items.remove(item);
        return item;
    }
}
