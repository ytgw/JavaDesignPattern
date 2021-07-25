package drawer;

import command.Command;
import java.awt.Point;

public class DrawCommand implements Command {
    protected Drawable drawable;    // 描画対象
    private Point position;         // 描画位置
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
