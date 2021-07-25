package drawer;

import command.Command;
import java.awt.Color;

public class ColorCommand implements Command {
    protected Drawable drawable;    // 描画対象
    private Color color;            // 描画色
    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }
    public void execute() {
        drawable.setColor(color);
    }
}
