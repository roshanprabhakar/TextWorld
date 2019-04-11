public abstract class Command {

    protected String placeHolder;

    abstract void execute();

    protected void init(String in) {
        placeHolder = getObjectName(in);
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
