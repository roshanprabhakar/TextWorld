public class Chicken extends Creature {

    public Chicken(String name, Node room) {
        super(name, room);
    }

    @Override
    public void act() {
    }

    @Override
    public void move() {
        moveToRoom(room.getRandomNeighbor());
    }
}
