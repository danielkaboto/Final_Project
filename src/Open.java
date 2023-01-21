import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Open extends JFrame implements ActionListener 
{
    private JLabel Brand , Model, Year, Color, Max,Gear;
    private JTextField Bt,Mt,Yt,Ct,Mxt,Gt;
    private JButton Find , clear;

    public Open()
    {
        setTitle("Search");
        setSize(410,150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Brand = new JLabel("Brand    Model      Year      Color       Speed     Gear");

        Bt = new JTextField(5);
        Mt = new JTextField(5);
        Yt = new JTextField(5);
        Ct = new JTextField(5);
        Mxt = new JTextField(5);
        Gt = new JTextField(5);


        Find = new JButton("Find the faster Car  ");
        Find.setPreferredSize(new DimensionUIResource(300, 25));
        clear = new JButton("clear"); 

        add(Brand); 
        add(Bt); add(Mt); add(Yt); add(Ct); add(Mxt);add(Gt);
        add(Find); add(clear);

        Find.addActionListener(this);
        clear.addActionListener(this);

      //  setVisible(true);


    }

    public void actionPerformed( ActionEvent e)
    {
       
        if(e.getSource() == Find)
        {
            //String filePath = "/home/daniel/Desktop/Car_File.txt";
            int maxSpeed = 0;
            String Brand = "";
            String Model = "";
            String Gear= "";
            String Year = "";
            String color = "";
            try
           {
                File file = new File("/home/daniel/Desktop/Car_File.txt");
                
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) 
                {
                    String[] words = scanner.nextLine().split("\t");
                    if(words.length>=5)
                    {
                        try 
                        {
                            int speed = Integer.parseInt(words[8]);
                            if (speed > maxSpeed) 
                            {
                                maxSpeed = speed;
                                Brand = words[0];
                                Gear= words[2];
                                Model = words[4];
                                Year = words[6];
                                color = words[10];

                             } 

                        } 
                        catch (NumberFormatException f) 
                        {
                            JOptionPane.showMessageDialog(null,"The 4th column should contain integers, please check the file");
                            f.printStackTrace();
                        }
                    
                    } 
                
                }
                scanner.close();
                System.out.println("The fastest car is " + Brand+" "+ Gear+" "+Model+" "+maxSpeed+" "+Year+" "+color );
                Bt.setText(Brand); Gt.setText(Gear); Mt.setText(Model); Mxt.setText(Integer.toString(maxSpeed));
                Yt.setText(Year);Ct.setText(color);
            }
             catch (IOException x) 
            {
                System.out.println("An error occurred.");
                x.printStackTrace();
            }
        }

        else if(e.getSource() == clear)
        {
            Bt.setText(""); Mt.setText(""); Yt.setText(""); Mxt.setText("");
            Gt.setText(""); Ct.setText("");
        }


    }

    
}
