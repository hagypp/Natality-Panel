import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JPanel
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.add(new NatalityPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0, 0, size.width, size.height);
        frame.setVisible(true);
    }
}
