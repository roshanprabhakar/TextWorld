public class LookCommand extends Command {

    private Player p = Main.p;
    private Graph g = Main.g;

    @Override
    public void init(String in) {}

    @Override
    public void execute() {
        System.out.println("----- Current Room ----");
        System.out.println(p.getCurrentRoom().getName());
        System.out.println(p.getCurrentRoom().getDescription());

        System.out.println("-------- Items --------");
        System.out.println("carrying items: " + p.getItems());
        System.out.println("items in room: " + p.getCurrentRoom().getItems());

        System.out.println("------ Creatures ------");
        System.out.println("creatures in current room: " + p.getCurrentRoom().getCreatures());
        for (String room : p.getCurrentRoom().getNeighbors().keySet()) {
            System.out.println("Creatures in (neighbor) " + room + ": " + g.getRoom(room).getCreatures());
        }

        System.out.println("------ Neighbors ------");
        System.out.println(p.getCurrentRoom().getNeighbors(true));

    }
}
