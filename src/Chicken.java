import java.util.ArrayList;

public class Chicken extends Creature {

    public Chicken(Node room, String name) {
        super(room, name);
    }

    @Override
    public void act() {
    }

    @Override
    public void move() {
        options = new ArrayList<>(this.room.getNeighbors().values());
        room.removeCreature(this);
        this.room = options.get((int)(Math.random() * options.size()));
        room.addCreature(this);
    }

    @Override
    public String toString() {
        return "chicken";
    }

    public void moveTo(Node node) {
        this.room.removeCreature(this);
        this.room = node;
        this.room.addCreature(this);
    }
}
