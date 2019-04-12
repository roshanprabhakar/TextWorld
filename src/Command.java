public abstract class Command {

    protected String placeHolder;
    public boolean isSafeToMoveCreatures = true;

    abstract void execute();
    protected void init(String in) {
        placeHolder = getObjectName(in);
    }

    protected boolean isSafeToMoveCreatures() {
        return isSafeToMoveCreatures;
    }

    private String getObjectName(String in) {

        int first = in.indexOf("<") + 1;
        StringBuilder body = new StringBuilder();
        char current = in.charAt(first);

        while (current != '>' || first < in.length() - 1) {
            body.append(current);
            first++;
            current = in.charAt(first);
        }
        return body.toString();
    }

}
