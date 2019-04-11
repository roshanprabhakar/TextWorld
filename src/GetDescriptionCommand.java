public class GetDescriptionCommand extends Command {

    private Player p = Main.p;

    @Override
    public void init(String in) {}

    @Override
    public void execute() {
        System.out.println(p.getCurrentRoom().getDescription());
    }
}
