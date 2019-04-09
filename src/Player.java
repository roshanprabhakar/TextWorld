import java.util.HashMap;

public class Player {

    private HashMap<String, Item> items;
    private Node currentRoom;
    private String name;

    public Player(String name, Node currentRoom) {
        this.currentRoom = currentRoom;
        this.name = name;
        items = new HashMap<>();
    }

    public void moveToRoom(Node room) {
        if (currentRoom.containsNeighbor(room)) {
            currentRoom.removePlayer(this);
            currentRoom = room;
            currentRoom.addPlayer(this);
        } else {
            System.out.println("WARNING! cannot move to this room, it is not a neighbor");
        }
    }

    public void moveToRoom(String node) {
        if (currentRoom.getNeighbors().get(node) != null) {
            moveToRoom(currentRoom.getNeighbors().get(node));
        } else {
            System.out.println("WARNING! cannot move to this room, it is not a neighbor");
        }
    }

    public void liftItem(String item) {
        if (currentRoom.containsItem(item)) {
            items.put(item, currentRoom.getItem(item));
            currentRoom.removeItem(item);
        } else {
            System.out.println("Cannot lift this item! it doesn't exist in this room");
        }
    }

    public void placeItem(String item) {
        currentRoom.addItem(items.get(item));
        items.remove(item);
    }

    public String getName() {
        return name;
    }

    public String getItems() {
        StringBuilder out = new StringBuilder();
        for (String item : items.keySet()) {
            out.append(item + ", ");
        }
        return out.toString();
    }

    public Node getCurrentRoom() {return currentRoom;}
}
