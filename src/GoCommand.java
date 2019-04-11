public class GoCommand extends Command {

    @Override
    public void execute() {
        try {
            if (Main.p.getCurrentRoom().containsNeighbor(placeHolder)) {
                Main.p.moveToRoom(placeHolder);
            } else {
                System.out.println("Cannot move here: either non-existent or not a neighbor");
            }
        } catch (NullPointerException e) {
        }
    }
}
