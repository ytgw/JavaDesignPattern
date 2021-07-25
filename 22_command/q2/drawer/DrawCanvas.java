package drawer;

import command.MacroCommand;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


public class DrawCanvas extends Canvas implements Drawable {
    private Color color = Color.red;    // 描画色
    private int radius = 6;             // 描画する点の半径
    private MacroCommand history;       // 履歴
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }
    public void paint(Graphics g) {
        // 履歴全体を再描画
        history.execute();
    }
    public void draw(int x, int y) {
        // 描画
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
