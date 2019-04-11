public class DescribeCommand extends Command {

    @Override
    void execute() {
        Main.p.getCurrentRoom().setDescription(placeHolder);
    }
}
