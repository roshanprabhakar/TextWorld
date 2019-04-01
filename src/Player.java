import java.util.HashMap;

public class Player {

    HashMap<String, Item> items;
    String name;
    String description;
    Node currentRoom;


    public Player(String name, Node currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
        items = new HashMap<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item getItem(String item) {
        try {
            Item out = items.get(item);
            items.remove(item);
            return out;
        } catch (NullPointerException e) {
            System.out.println("no existing item");
        }
        return null;
    }

    public void addItem(String name) {
        items.put(name, new Item(name));
    }

    public Node getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Node newRoom) {
        currentRoom = newRoom;
    }

    public String getItems() {
        String out = "";
        for (String item : items.keySet()) {
            out += item + " ";
        }
        return out;
    }
}