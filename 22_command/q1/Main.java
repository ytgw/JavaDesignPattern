import command.Command;
import command.MacroCommand;
import drawer.ColorCommand;
import drawer.DrawCanvas;
import drawer.DrawCommand;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
    private MacroCommand history = new MacroCommand();              // 描画履歴
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);  // 描画領域
    private JButton clearButton = new JButton("clear");             // 消去ボタン
    private JButton redButton = new JButton("red");                 // 赤色変更ボタン
    private JButton greenButton = new JButton("green");             // 緑色変更ボタン
    private JButton blueButton = new JButton("blue");               // 青色変更ボタン

    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // ActionListener用
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.init();
            canvas.repaint();
        } else {
            Command cmd = null;
            if (e.getSource() == redButton) {
                cmd = new ColorCommand(canvas, Color.red);
            } else if (e.getSource() == greenButton) {
                cmd = new ColorCommand(canvas, Color.green);
            } else if (e.getSource() == blueButton) {
                cmd = new ColorCommand(canvas, Color.blue);
            }
            if (cmd != null) {
                history.append(cmd);
                cmd.execute();    
            }
        }
    }

    // MouseMotionListener用
    public void mouseMoved(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    // WindowListener用
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowActivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
