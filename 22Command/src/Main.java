import command.Command;
import command.MacroCommand;
import drawer.DrawCanvas;
import drawer.DrawComand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

    //그림 그린 이력
    private MacroCommand history = new MacroCommand();

    //그림 그리는 영역
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    // 제거 버튼
    private JButton clearButton = new JButton("clear");

    public Main(String title) throws HeadlessException {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

    //ActionListener 용
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == clearButton){
            history.clear();
            canvas.repaint();
        }
    }

    //MouseMtionListener용
    public void mouseMoved(MouseEvent e){

    }

    public void mouseDragged(MouseEvent e){
        Command cmd = new DrawComand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    public void windowClosing(WindowEvent e){
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
