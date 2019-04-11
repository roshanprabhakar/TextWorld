public class PlaceCommand extends Command {

    @Override
    void execute() {
        Main.p.placeItem(placeHolder);
    }
}
