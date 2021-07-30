package language;

public class InterpreterFacade implements Executor {
    private ExecutorFactory factory;
    private Context context;
    private Node programNode;
    public InterpreterFacade(ExecutorFactory factory) {
        this.factory = factory;
    }
    public boolean parse(String text) {
        boolean ok = true;
        context = new Context(text);
        context.setExecutorFactory(factory);
        programNode = new ProgramNode();
        try {
            programNode.parse(context);
            System.out.println(programNode.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }
    public void execute() throws ExecuteException {
        programNode.execute();
    }
}
