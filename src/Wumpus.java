
public class Wumpus extends Creature {

    public Wumpus(String name, Node node) {
        super(name, node);
    }

    @Override
    public void act() {
    }

    @Override
    public void move() {
        for (String neighbor : room.getNeighbors().keySet()) {
            System.out.println("################################");
            System.out.println(neighbor + ": " + room.getNeighbor(neighbor).containsAPlayer());

            if (room.getNeighbor(neighbor).containsAPlayer()) {
                continue;
            }

            boolean canMoveToNeighbor = true;
            for (String neighbor2 : room.getNeighbor(neighbor).getNeighbors().keySet()) {
                System.out.println("      " + neighbor2 + ": " + room.getNeighbor(neighbor).getNeighbor(neighbor2).containsAPlayer());
                if (room.getNeighbor(neighbor).getNeighbor(neighbor2).containsAPlayer()) {
                    canMoveToNeighbor = false;
                }
            }

            if (canMoveToNeighbor) {
                System.out.println("wumpus moving to " + neighbor);
                moveToRoom(room.getNeighbor(neighbor));
            }
        }
    }
}
