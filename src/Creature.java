import java.util.ArrayList;

public abstract class Creature {

    String name;
    protected Node room;
    protected ArrayList<Node> options;

    public Creature(Node room, String name) {
        this.room = room;
        this.name = name;
    }

    abstract void act();
    abstract void move();
    public abstract String toString();

    public Node getRoom() {
        return room;
    }

    public void setRoom(Node room) {
        this.room = room;
    }

    public String getDescription() {
        return "<" + name + "> in room: " + room;
    }
}
