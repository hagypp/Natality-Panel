import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//a class represent a pie graph
public class Pie extends Chart
{
    //constructor
    public Pie(ArrayList<Double> data, ArrayList<String> labels)
    {
        super(data, labels);
    }

    @Override
    //function that draw pie graph
    public void draw(Graphics g, int x, int y, int width, int height)
    {
        double sum = 0;
        int startAngle = 0;
        int startX = width / 2 - width / 10;
        //find the sum of the data
        for (int i = 0; i < this.data.size(); i++)
            sum = sum + this.data.get(i);
        for (int i = 0; i < this.data.size(); i++)
        {
            //draw the relative size of the pie in one color
            startX = startX + 20;
            g.setColor(Color.BLACK);
            g.drawString(this.labels.get(i), startX, (int) (height / 1.2) + 10);
            startX = startX + 40;
            Color color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            g.setColor(color);
            g.fillRect(startX, (int) (height / 1.2), 10, 10);
            int angle = (int) ((this.data.get(i) / sum) * 360);
            g.fillArc(width / 2 - width / 10, height / 2 - height / 10, height / 3, height / 3, startAngle, angle);
            startAngle = startAngle + angle;
//            System.out.println(g.getColor());
        }
        if ((360-startAngle)!=360)
        g.fillArc(width / 2 - width / 10, height / 2 - height / 10, height / 3, height / 3, startAngle, 360 - startAngle);

    }
}
