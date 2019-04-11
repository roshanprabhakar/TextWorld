
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
            Node first = room.getNeighbor(neighbor);
            for (String neighbor2 : room.getNeighbor(neighbor).getNeighbors().keySet()) {
                Node second = first.getNeighbor(neighbor2);

                if (!first.containsAPlayer()) {
                    if (!second.containsAPlayer()) {
                        moveToRoom(first);
                    } else {
                        moveToRoom(room);
                    }

                } else {
                    Node random = room.getRandomNeighbor();
                    while (random == first) {
                        random = room.getRandomNeighbor();
                    }
                    moveToRoom(random);
                }
            }
        }
    }
}
