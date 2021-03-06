public class Popstar extends Creature {

    public Popstar(String name, Node node) {
        super(name, node);
    }

    @Override
    public void act() {
    }

    @Override
    @SuppressWarnings("Duplicates")
    public void move() {
        boolean canMoveToNeighbor = false;

        System.out.println("<What the popstar sees>");
        for (String neighbor : room.getNeighbors().keySet()) {

            System.out.println(neighbor + ": " + room.getNeighbor(neighbor).containsAPlayer());

            if (room.getNeighbor(neighbor).containsAPlayer()) {
                System.out.println("popstar moving to room: " + neighbor);
                moveToRoom(room.getNeighbor(neighbor));
                return;
            }

            for (String neighbor2 : room.getNeighbor(neighbor).getNeighbors().keySet()) {
                System.out.println("      " + neighbor2 + ": " + room.getNeighbor(neighbor).getNeighbor(neighbor2).containsAPlayer());
                if (room.getNeighbor(neighbor).getNeighbor(neighbor2).containsAPlayer()) {
                    canMoveToNeighbor = true;
                }
            }

            if (canMoveToNeighbor) {
                System.out.println("popstar moving to " + neighbor);
                moveToRoom(room.getNeighbor(neighbor));
                return;
            }
        }

        if (!canMoveToNeighbor) moveToRoom(room.getRandomNeighbor());
    }
}