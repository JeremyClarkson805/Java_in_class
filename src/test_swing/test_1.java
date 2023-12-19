package test_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;

public class test_1 {
    public static void main(String[] args) {
        test_awt.test_1();
    }
}

class test_awt{
    static void test_1()
    {
        Frame frame = new Frame("聊天窗口");
        frame.setBackground(Color.PINK);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(800,600);

        int x = (int)screenSize.getWidth()/2 - frame.getWidth()/2;
        int y = (int)screenSize.getHeight() / 2 - frame.getHeight() / 2;

        frame.setLocation(x,y);
        frame.setResizable(false);
//        System.out.println(Arrays.toString(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()));
        frame.setFont(new Font("Weibei TC",Font.BOLD,15));
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
