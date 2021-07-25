package command;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command {
    private Stack<Command> commands = new Stack<Command>();
    public void execute() {
        Iterator<Command> it = commands.iterator();
        while (it.hasNext()) {
            it.next().execute();
        }
    }
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    public void undo() {
        // 最後の命令を削除
        if (!commands.empty()) {
            commands.pop();
        }
    }
    public void clear() {
        // 全削除
        commands.clear();
    }
}
