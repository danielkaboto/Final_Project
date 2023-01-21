import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.io.*;



public class Car extends JFrame implements ActionListener
{
    // -------------create GUI tools needed in the frame ---------------------//
    private JLabel title,Brand, Gear,Model_l, Year_l,Max_l, Color_l;
    private JTextField Model, Year, Max, Color;
    private JButton Add, Open;
    private JRadioButton Manual,Automatic;
    ButtonGroup myRadio = new ButtonGroup();
    private JComboBox Choose ;

    public Car(String Title)
    {
        setLayout(new FlowLayout ());
        setSize(430,300);
        setTitle(Title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //------- set the labels ---------
        title = new JLabel("             Enter the Car's Infromation           ");
        Brand = new JLabel("Choose the Brand :        ");
        Gear = new JLabel("Choose the GearBox :          ");
        Model_l = new JLabel("Enter the Model :                     ");
        Year_l = new JLabel("Enter the Year :                        ");
        Max_l = new JLabel("   Enter the Max Speed :          ");
        Color_l = new JLabel ("Enter the Color :                        ");

        //------------ set the TextFields --------
        Model = new JTextField(15);
        Year = new JTextField(15);
        Max = new JTextField(15);
        Color = new JTextField(15);

        //---------- set the RadioButton-----------------
        Manual = new JRadioButton("Manual");
        Automatic= new JRadioButton("Automatic");
        // put the radioButton into a group so we can select only one of them
        myRadio.add(Manual);
        myRadio.add(Automatic);

        //-----------set the Combox -----------------
        Choose = new JComboBox<>(new String [] {"------------- Choose ----------","Mercedes","BMW","HONDA",
        "Mazda","Suzuki","Hyundai"});

        //---------- set Buttton ----------------------
        Add = new JButton("Add the car to the File ");
        Open = new JButton("Open the Search Form ");

        Add.setPreferredSize(new DimensionUIResource(400, 30));
        Open.setPreferredSize(new DimensionUIResource(400, 30));
     

        //  add the element on the form
        add(title); 
        add(Brand); add(Choose); 
        add(Gear);add(Manual); add(Automatic); 
        add(Model_l);add(Model); 
        add(Year_l); add(Year);
        add(Max_l); add(Max); 
        add(Color_l); add(Color);
        add(Add);add(Open);


        
        Add.addActionListener(this);
        Open.addActionListener(this);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {


        if(e.getSource() == Add)
        {
            String file =""; // keep the sum of the all information 
            String Chooce = (String) Choose.getSelectedItem(); // keep the  brand value
            String G="";
            if(Manual.isSelected()) 
            {
                G = "Manual" ; // keep the GearBox value
            }
            else if(Automatic.isSelected())
            {
                G = "Automatic";  // keep the GearBox value
            }

            String M = Model.getText();  // keep the Model value
            String Y = Year.getText();  // keep the Year value
            String Speed = Max.getText(); // keep the Speed value
            String color = Color.getText();  // keep the Color value

            file = Chooce + "\t\t" + G +"\t\t"+M+"\t\t"+Y +"\t\t"+Speed +"\t\t"+color;

            try
            {

                File myFile = new File("/home/daniel/Desktop/Car_File.txt");
                FileWriter writer = new FileWriter(myFile,true);
                writer.write(file);
                writer.write(System.getProperty("line.separator"));
                writer.close();
                JOptionPane.showMessageDialog(null,"Successfully appended a new line to the File.");
                writer.write(System.getProperty("line.separator"));

            }
            catch(IOException x)
            {
                System.out.println("An error Occurred .");
                x.printStackTrace();
            }
        }
        else if (e.getSource()== Open)
        {
           Open p1 = new Open();
           p1.setVisible(true);
        }

    }
    
}
