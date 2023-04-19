import java.awt.*;
import java.util.ArrayList;

//a class represent a column graph
public class Column extends Chart
{
    //constructor
    public Column(ArrayList<Double> data, ArrayList<String> labels)
    {
        super(data, labels);
    }

    @Override
    //function that draw column graph
    public void draw(Graphics g, int x, int y, int width, int height)
    {
        double sum = 0;
        double max = 0;
        //find the max and the sum of the data
        for (int i = 0; i < this.data.size(); i++)
        {
            max = Math.max(max, this.data.get(i));
            sum = sum + this.data.get(i);
        }
        int startY = height / 10 + 2;
        int startX = width / 25;
        int label = (int) sum;
        int jump = label / 8;
        // draw the lines of the data
        for (int i = 0; i < 9; i++)
        {
            g.drawLine(startX, startY, width - 10, startY);
            if (i == 8)
                g.drawString("0", startX - 30, startY);
            else
                g.drawString(Integer.toString((int) ((label / sum) * max)), startX - 30, startY);
            startY = startY + height / 10;
            label = label - jump;
        }

        int start = width / (this.data.size() * 2);

        //draw a reverse rect in relative size
        for (int i = 0; i < this.data.size(); i++)
        {
            double value = (int) ((this.data.get(i) / sum) * max * 2);
            g.setColor(Color.BLUE);
            g.fillRect(start, (int) (height - value) - height / 10, width / (this.data.size() * 3), (int) (value));
            g.setColor(Color.BLACK);
            //draw the label
            g.drawString(this.labels.get(i), start + 10, height - 50);
            start = start + width / this.data.size();
        }
    }
}
