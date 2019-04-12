import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, Node> rooms;
    private ArrayList<Creature> creatures;

    //for setup reference
    private Graph g = this;

    public Graph() {
        rooms = new HashMap<>();
        creatures = new ArrayList<>();
        setup();
    }

    public Node getRoom(String room) {
        return rooms.get(room);
    }

    //Both addRooms used to add rooms not connected to anything
    public void addRoom(String name) {
        addRoom(new Node(name));
    }

    public void addRoom(Node room) {
        rooms.put(room.getName(), room);
    }

    //Connect rooms together
    public void addDirectedEdge(Node room1, Node room2) {
        room1.addNeighbor(room2);
    }

    public void addDirectedEdge(String room1, String room2) {
        addDirectedEdge(rooms.get(room1), rooms.get(room2));
    }

    public void addUndirectedEdge(Node room1, Node room2) {
        addDirectedEdge(room1, room2);
        addDirectedEdge(room2, room1);
    }

    public void addUndirectedEdge(String room1, String room2) {
        addUndirectedEdge(rooms.get(room1), rooms.get(room2));
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public void setup() {

        g.addRoom("hall");
        g.addRoom("twin bedroom");
        g.addRoom("closet");
        g.addRoom("master bedroom");
        g.addRoom("living room");
        g.addRoom("family room");
        g.addRoom("tv room");
        g.addRoom("master bathroom");
        g.addRoom("guest bathroom");
        g.addRoom("bathroom");

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
        g.addUndirectedEdge("tv room", "bathroom");

        for (int i = 0; i < 4; i++) {
            g.addCreature(new Chicken("chicken" + i, getRoom("hall")));
        }

        for (int i = 0; i < 3; i++) {
            g.getRoom("hall").addItem(new Item("sword" + i));
        }

//        g.addCreature(new Popstar("popstar", getRoom("twin bedroom")));
        g.addCreature(new Wumpus("wumpus", getRoom("twin bedroom")));
    }

    public void moveCreatures() {
        for (Creature creature : creatures) {
            creature.act();
            creature.move();
        }
    }
}
