public class LiftCommand extends Command {

    @Override
    void execute() {
        Main.p.liftItem(placeHolder);
    }
}
