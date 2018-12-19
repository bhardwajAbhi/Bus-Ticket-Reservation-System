//3rd frame of the class where the data base will be connected and values will be inserted into the database

import javafx.scene.control.RadioButton;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

//for database
import com.mysql.jdbc.Connection;
import java.sql.*;



public class Passenger_Details extends JFrame
{
    JLabel Headings, Name, Age, Gender, Mobile, UID, Email, background;
    JTextField name, age, mob, uid, mail;
    JRadioButton Male, Female;
    JButton Cancel, Confirm;
    ImageIcon Passenger_Background;
    Font font;


    //For DataBase
    String url = "jdbc:mysql://localhost:3306/bus_system";
    String user = "root";
    String password = "";



    Passenger_Details(String FROM, String TO, String SEATS, String DAY, String MONTH){

        font = new Font(null, Font.BOLD,18);
        Border border1 = BorderFactory.createLineBorder(Color.cyan,3); // heading border
        Border border2 = BorderFactory.createLineBorder(Color.gray,2); // label border

        setTitle("Passenger Details"); //frame title
        setLayout(null);
        setBounds(700,250,500,500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        //heading
        Headings = new JLabel(".......PASSENGER DETAILS........");
        Headings.setBounds(100,40,280,40);
        Headings.setBorder(border1);
        Headings.setFont(font);
        Headings.setForeground(Color.magenta);
        add(Headings);

        //NAME LABEL TEXTFIELD
        Name= new JLabel("Name ");
        Name.setBounds(60,120,60,20);
        Name.setForeground(Color.white);
        Name.setBorder(border2);
        add(Name);
        name = new JTextField(15);
        name.setBounds(140,120,100,20);
        add(name);

        //age label textfield
        Age= new JLabel("Age ");
        Age.setBounds(270,120,60,20);
        Age.setForeground(Color.white);
        Age.setBorder(border2);
        add(Age);
        age = new JTextField(5);
        age.setBounds(340,120,60,20);
        add(age);

        //ButtonGroup for gender
        Gender = new JLabel("Gender");
        Gender.setBounds(60,160,60,20);
        Gender.setBorder(border2);
        Gender.setForeground(Color.white);
        add(Gender);

        ButtonGroup Gender = new ButtonGroup();
        Male = new JRadioButton("M");
        Male.setBounds(140,160,40,20);
        add(Male);
        Female= new JRadioButton("F");
        Female.setBounds(180,160,40,20);
        add(Female);
        Gender.add(Male);  // adding into group
        Gender.add(Female);


        //mob label and textbox
        Mobile = new JLabel("Mobile");
        Mobile.setBorder(border2);
        Mobile.setForeground(Color.white);
        Mobile.setBounds(270,160,60,20);
        add(Mobile);
        mob = new JTextField(10);
        mob.setBounds(340,160,90,20);
        add(mob);



        // Adhaar label and text box
        UID = new JLabel("UID");
        UID.setBorder(border2);
        UID.setForeground(Color.white);
        UID.setBounds(60,200,60,20);
        add(UID);
        uid = new JTextField(12);
        uid.setBounds(140,200,110,20);
        add(uid);


        //email label text box'
        Email = new JLabel("Email");
        Email.setBorder(border2);
        Email.setForeground(Color.white);
        Email.setBounds(270,200,60,20);
        add(Email);
        mail = new JTextField(20);
        mail.setBounds(340,200,120,20);
        add(mail);


        //cancel button
        Cancel = new JButton("BACK");
        Cancel.setBounds(80,320,150,40);
        add(Cancel);

        //next button
        Confirm= new JButton("CONFIRM");
        Confirm.setBounds(240,320,150,40);
        add(Confirm);


        //Background
        Passenger_Background= new ImageIcon(getClass().getResource("PassengerBackground.jpg"));
        background = new JLabel();
        background.setBounds(0,0,600,600);
        add(background);
        background.setIcon(new ImageIcon(Passenger_Background.getImage().getScaledInstance(600,600, Image.SCALE_AREA_AVERAGING)));



        //action listener for cancel button
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Travel_Information();
                dispose();
            }
        });

        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(name.equals("") || age.equals("") || mob.equals("") || uid.equals("") || mail.equals("") || Gender.isSelected(null))
                {

                    JOptionPane.showMessageDialog(null, "All fields are Mandatory!! Kindly fill them in order to continue!");
                }

                else
                {
                    String NAME, AGE, MOB, UID, MAIL;

                    NAME = name.getText();
                    AGE = age.getText();
                    MOB = mob.getText();
                    UID = uid.getText();
                    MAIL = mail.getText();





                    // now inserting the variables values into the data base
                    //we have to use try catch here as without it we will get SQL Exception, so write the code inside try catch

                    try {
                        //1. get a connection to database
                        Connection myconnection = (Connection) DriverManager.getConnection(url, user, password);

                        myconnection.setAutoCommit(true);


                        //2. create a Prepared Statement instead of Simple Statement  i.e SQL injection
                        PreparedStatement pState = (PreparedStatement) myconnection.prepareStatement("insert into ticket_details (Boarding_From, Boarding_To, Seats, Day, Month, Name, Age, Mobile, UID, Mail)" + " values (?, ?, ?, ? ,?, ?, ?, ?, ?, ?)");
                        pState.setString(1,FROM);
                        pState.setString(2,TO);
                        pState.setString(3,SEATS);
                        pState.setString(4,DAY);
                        pState.setString(5,MONTH);
                        pState.setString(6,NAME);
                        pState.setString(7,AGE);
                        pState.setString(8,MOB);
                        pState.setString(9,UID);
                        pState.setString(10,MAIL);

                        //3. execute query
                       int r =  pState.executeUpdate();

                       JOptionPane.showMessageDialog(null,"Booking Successfully Done!");
                       new  See_Details();


                    }

                    catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(null,"Details Already Exist! Enter New Details!");
                        ex.printStackTrace();
                    }

                }

            }
        });
    }

    public Passenger_Details() {

    }


    public static void main(String[] args) {
        new Passenger_Details();
    }
}
