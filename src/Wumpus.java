public class Wumpus extends Creature {

    public Wumpus(Node node) {
        super("wumpus", node);
    }

    @Override
    public void act() {
        System.out.println("The wumpus killed you!");
        System.exit(0);
    }

    @Override
    public void move() {
        for (String neighbor : room.getNeighbors().keySet()) {
            for (String finder : room.getNeighbors().get(neighbor).getNeighbors().keySet()) {
                if (room.getNeighbors().get(neighbor).getNeighbors().get(finder).containsAPlayer()) {
                    moveToRoom(room.getNeighbors().get(neighbor));
                }
            }
        }
    }
}
