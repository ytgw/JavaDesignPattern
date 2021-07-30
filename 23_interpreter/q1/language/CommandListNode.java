package language;

import java.util.ArrayList;
import java.util.Iterator;

// <command list> ::= <command>* end
public class CommandListNode extends Node {
    private ArrayList<Node> list = new ArrayList<Node>();
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end'");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }
    public void execute() throws ExecuteException {
        Iterator<Node> it = list.iterator();
        while (it.hasNext()) {
            it.next().execute();
        }
    }
    public String toString() {
        return list.toString();
    }
}
