public abstract class Creature {

    protected String name;
    protected Node room;

    public Creature(String name, Node room) {
        this.room = room;
        this.name = name;
        room.addCreature(this);
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return "Creature <" + name + "> is in room: " + room.getName();
    }

    public abstract void act();
    public abstract void move();

    public void moveToRoom(Node room) {
        this.room.removeCreature(this);
        this.room = room;
        room.addCreature(this);
    }

    public Node getRoom() {return room;}
}
