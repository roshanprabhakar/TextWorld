public class AddCommand extends Command {

    @Override
    public void execute() {
        Main.g.addRoom(placeHolder);
        Main.g.addUndirectedEdge(Main.p.getCurrentRoom().getName(), placeHolder);
    }
}
