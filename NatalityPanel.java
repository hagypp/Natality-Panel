import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

// a class the represent panel that use for listener too
public class NatalityPanel extends JPanel implements ActionListener
{
    //buttons for the panel
    private JButton clear;
    private JButton showData;
    private JComboBox box;
    //private graph for pie and column
    private Pie pie;
    private Column column;
    //private boolean value that represent the start of the show and if the pie is show
    private boolean start;
    private boolean p;

    public NatalityPanel()
    {
        this.start = false;
        this.p = false;
        //open new buttons set them and add them to the panel
        this.clear = new JButton("Clear");
        this.showData = new JButton("Show data");
        this.box = new JComboBox();
        this.box.addItem("by gender");
        this.box.addItem("by month");
        add(showData);
        add(box);
        add(clear);
        //add listener for the buttons
        this.clear.addActionListener(this);
        this.box.addActionListener(this);
        this.showData.addActionListener(this);

        //open array lists for the gender and for the months
        ArrayList<String> dataGender = new ArrayList<>();
        ArrayList<String> dataMonth = new ArrayList<>();
        try
        {
            //read the file by spilt them with ","
            BufferedReader inputStream = new BufferedReader(new FileReader("NatalityMini.csv"));
            String line = "";
            String splitBy = ",";
            while ((line = inputStream.readLine()) != null)
            {
                String[] res = line.split(splitBy);
                dataGender.add(res[2]);
                dataMonth.add(res[1]);
            }
        } catch (IOException x)
        {
            System.err.println("eror");
        }

        //insert the months into sorted sum list
        ArrayList<Double> sumMonths = new ArrayList<Double>();
        for (int i = 0; i < 12; i++)
            sumMonths.add(0.0);
        for (int i = 0; i < dataMonth.size(); i++)
        {
            if (dataMonth.get(i).equals("01"))
                sumMonths.set(0, sumMonths.get(0) + 1);
            if (dataMonth.get(i).equals("02"))
                sumMonths.set(1, sumMonths.get(1) + 1);
            if (dataMonth.get(i).equals("03"))
                sumMonths.set(2, sumMonths.get(2) + 1);
            if (dataMonth.get(i).equals("04"))
                sumMonths.set(3, sumMonths.get(3) + 1);
            if (dataMonth.get(i).equals("05"))
                sumMonths.set(4, sumMonths.get(4) + 1);
            if (dataMonth.get(i).equals("06"))
                sumMonths.set(5, sumMonths.get(5) + 1);
            if (dataMonth.get(i).equals("07"))
                sumMonths.set(6, sumMonths.get(6) + 1);
            if (dataMonth.get(i).equals("08"))
                sumMonths.set(7, sumMonths.get(7) + 1);
            if (dataMonth.get(i).equals("09"))
                sumMonths.set(8, sumMonths.get(8) + 1);
            if (dataMonth.get(i).equals("10"))
                sumMonths.set(9, sumMonths.get(9) + 1);
            if (dataMonth.get(i).equals("11"))
                sumMonths.set(10, sumMonths.get(10) + 1);
            if (dataMonth.get(i).equals("12"))
                sumMonths.set(11, sumMonths.get(11) + 1);
        }
        //make a array list for labels month
        ArrayList<String> monthsLabels = new ArrayList<String>();
        monthsLabels.add("01");
        monthsLabels.add("02");
        monthsLabels.add("03");
        monthsLabels.add("04");
        monthsLabels.add("05");
        monthsLabels.add("06");
        monthsLabels.add("07");
        monthsLabels.add("08");
        monthsLabels.add("09");
        monthsLabels.add("10");
        monthsLabels.add("11");
        monthsLabels.add("12");
        this.column = new Column(sumMonths, monthsLabels);

        double male = 0.0;
        double female = 0.0;
        //make array list of sum by gender and labels
        if (dataGender.size() > 0)
        {
            for (int i = 0; i < dataGender.size(); i++)
            {
                if (dataGender.get(i).equals("M"))
                    male++;
                if (dataGender.get(i).equals("F"))
                    female++;
            }
            ArrayList<Double> data = new ArrayList<Double>();
            data.add(0, female);
            data.add(1, male);
            ArrayList<String> genderLabels = new ArrayList<String>();
            genderLabels.add(0, "female");
            genderLabels.add(1, "male");
            this.pie = new Pie(data, genderLabels);
        }
    }

    //function that in every change in the screen is active
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (start==false)
            return;
        if (start == true)
        {
            if (p == true)
                this.pie.draw(g, 0, 0, getWidth(), getHeight());
            if (p == false)
                this.column.draw(g, 0, 0, getWidth(), getHeight());
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        //if clear is push start false and repaint the panel
        if (e.getSource() == clear)
        {
            start = false;
            repaint();
        }
        //if we want to show data we start the show
        if (e.getSource() == this.showData)
        {
            //if the box is on month=column draw column and pie is not present
            if (Objects.equals(this.box.getSelectedItem(), "by month"))
            {
                start = true;
                p = false;
                repaint();
//                this.column.draw(getGraphics(), 0, 0, getWidth(), getHeight());
            }
            //if the box is on gender=pie draw pie and pie is present
            if (Objects.equals(this.box.getSelectedItem(), "by gender"))
            {
                start = true;
                p = true;
                repaint();
//                this.pie.draw(getGraphics(), 0, 0, getWidth(), getHeight());
            }
        }
    }
}