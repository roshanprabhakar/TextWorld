public class Popstar extends Creature {

    public Popstar(String name, Node node) {
        super(name, node);
    }

    @Override
    public void act() {
    }

    @Override
    public void move() {
        for (String neighbor : room.getNeighbors().keySet()) {
            Node first = room.getNeighbor(neighbor);

            System.out.println(room.getNeighbor(neighbor));
            System.out.println(room.getNeighbor(neighbor).getNeighbors().keySet());

            for (String neighbor2 : room.getNeighbor(neighbor).getNeighbors().keySet()) {
                Node second = first.getNeighbor(neighbor2);

                if (first.containsAPlayer()) {
                    moveToRoom(first);
                    return;
                } else {
                    if (second.containsAPlayer()) {
                        moveToRoom(first);
                    } else {
                        moveToRoom(room.getRandomNeighbor());
                    }
                }
            }
        }
    }
}
