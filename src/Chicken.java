public class Chicken extends Creature {

    public Chicken(Node room) {
        super("chicken", room);
    }

    @Override
    public void act() {
    }

    @Override
    public void move() {
        moveToRoom(room.getRandomNeighbor());
    }
}
