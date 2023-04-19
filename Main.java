import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JPanel
{
    public void paint(Graphics g)
    {
        ArrayList<Double> data = new ArrayList<Double>();
        ArrayList<String> labels = new ArrayList<String>();
        data.add(0.0);
        data.add(0.0);
        data.add(0.0);
        data.add(0.0);

//        data.add(10.0);
//        data.add(10.0);
//        data.add(15.2);
//        data.add(19.2);
//        data.add(38.4);
//        data.add(125.8);
//        data.add(385.6);
//        data.add(851.2);
//        data.add(1000.9);
//        data.add(1234.9);
//        data.add(2438.2);
//        data.add(8.2);
//        data.add(10.4);
//        data.add(15.2);
//        data.add(19.2);
//        data.add(38.4);
        labels.add("querter1");
        labels.add("querter2");
        labels.add("querter3");
        labels.add("querter4");

//        labels.add("1");
//        labels.add("2");
//        labels.add("3");
//        labels.add("4");
//        labels.add("5");
//        labels.add("6");
//        labels.add("7");
//        labels.add("8");
//        labels.add("9");
//        labels.add("10");
//        labels.add("11");
//        labels.add("12");
//        labels.add("13");
//        labels.add("14");
//        labels.add("15");
//        labels.add("16");
//        Pie pie = new Pie(data, labels);
//        pie.draw(g,0,0,getWidth(),getHeight());
        Column col=new Column(data,labels);
        col.draw(g,0,0,getWidth(),getHeight());
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
//        frame.add(new Main());
        frame.add(new NatalityPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0, 0, size.width, size.height);
        frame.setVisible(true);
    }
}
