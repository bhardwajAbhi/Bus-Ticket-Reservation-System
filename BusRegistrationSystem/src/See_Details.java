//LAST frame where all the details will be concluded


import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

//for database
import com.mysql.jdbc.Connection;
import jdk.nashorn.internal.scripts.JO;

import java.sql.*;


public class See_Details extends JFrame {

    JLabel Heading, Name, Age, Mail, UID, Mobile, From, To, Seat, Date, background;
    JTextField name, age, mail, uid, mobile, from, to, seat, day, month;
    JButton Close, Ticket;
    ImageIcon Details_Background;
    Font font;

    //For DataBase
    String url = "jdbc:mysql://localhost:3306/bus_system";
    String user = "root";
    String password = "";

    See_Details()
    {
        font = new Font(null, Font.BOLD,18);
        Border border1 = BorderFactory.createLineBorder(Color.cyan,3); // heading border
        Border border2 = BorderFactory.createLineBorder(Color.gray,2); // label border


        setTitle("Final Details");  //frame details
        setLayout(null);
        setBounds(700,250,500,500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //heading
        Heading = new JLabel("FINAL RESERVATION DETAILS");
        Heading.setBounds(100,40,280,40);
        Heading.setFont(font);
        Heading.setBorder(border1);
        Heading.setForeground(Color.white);
        add(Heading);


        //Name Label and text field
        Name  = new JLabel("Name ");
        Name.setBounds(60,120,60,20);
        Name.setForeground(Color.white);
        Name.setBorder(border2);
        add(Name);
        name = new JTextField(15);
        name.setBounds(140,120,100,20);
        name.setEditable(false);
        add(name);

        //mobile label and text field
        Mobile= new JLabel("Mobile");
        Mobile.setBounds(270,120,60,20);
        Mobile.setForeground(Color.white);
        Mobile.setBorder(border2);
        add(Mobile);
        mobile= new JTextField(5);
        mobile.setBounds(340,120,100,20);
        mobile.setEditable(false);
        add(mobile);


        //mail label and text field
        Mail = new JLabel("E-mail ");
        Mail.setBorder(border2);
        Mail.setBounds(60,150,60,20);
        Mail.setForeground(Color.white);
        add(Mail);
        mail = new JTextField(20);
        mail.setEditable(false);
        mail.setBounds(140,150,100,20);
        add(mail);

        //uid label and text field
        UID = new JLabel("UID");
        UID.setBorder(border2);
        UID.setForeground(Color.white);
        UID.setBounds(270,150,60,20);
        add(UID);
        uid = new JTextField(12);
        uid.setBounds(340,150,100,20);
        uid.setEditable(false);
        add(uid);

        //From label and text field
        From= new JLabel("From ");
        From.setBounds(60,200,60,20);
        From.setForeground(Color.white);
        From.setBorder(border2);
        add(From);
        from = new JTextField(10);
        from.setBounds(140,200,100,20);
        from.setEditable(false);
        add(from);

        //to label and text field
        To= new JLabel("To ");
        To.setBounds(270,200,60,20);
        To.setForeground(Color.white);
        To.setBorder(border2);
        add(To);
        to = new JTextField(10);
        to.setBounds(340,200,100,20);
        to.setEditable(false);
        add(to);

        //age label and text field
        Age= new JLabel("Age ");
        Age.setBounds(70,250,40,20);
        Age.setForeground(Color.white);
        Age.setBorder(border2);
        add(Age);
        age = new JTextField(5);
        age.setBounds(120,250,40,20);
        age.setEditable(false);
        add(age);

        //seat label and text field
        Seat = new JLabel("Seats");
        Seat.setBounds(180,250,40,20);
        Seat.setForeground(Color.white);
        Seat.setBorder(border2);
        add(Seat);
        seat = new JTextField(5);
        seat.setEditable(false);
        seat.setBounds(230,250,40,20);
        add(seat);

        //day and month label and text field;
        Date = new JLabel("Date");
        Date.setBorder(border2);
        Date.setForeground(Color.white);
        Date.setBounds(290,250,40,20);
        add(Date);
        day = new JTextField(5);
        day.setEditable(false);
        day.setBounds(340,250,30,20);
        add(day);
        month = new JTextField(10);
        month.setEditable(false);
        month.setBounds(380,250,50,20);
        add(month);



        //close button
        Close= new JButton("CLOSE");
        Close.setBounds(250,330,170,40);
        add(Close);

        //Ticket Button
        Ticket = new JButton("CANCEL TICKET!");
        Ticket.setBounds(70,330,170,40);
        add(Ticket);



        //Background
        Details_Background= new ImageIcon(getClass().getResource("detailsBackground.jpg"));
        background = new JLabel();
        background.setBounds(0,0,500,500);
        add(background);
        background.setIcon(new ImageIcon(Details_Background.getImage().getScaledInstance(500,500, Image.SCALE_AREA_AVERAGING)));




        //JoptionPane for email address
        String Emailaddress = JOptionPane.showInputDialog(null,"Enter Your Registered Email Address : ");

        //rrSystem.out.println(Emailaddress);




        //database fetching
        try{
            Connection mycon = (Connection) DriverManager.getConnection(url,user,password);

            String sql = "SELECT Boarding_From, Boarding_To, Seats, Day, Month, Name, Age, Mobile, UID, Mail FROM ticket_details WHERE Mail = ?";


            PreparedStatement pst = mycon.prepareStatement(sql);

            pst.setString(1,Emailaddress);

            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {
                String From = rs.getString("Boarding_From");
                from.setText(From);

                String To = rs.getString("Boarding_To");
                to.setText(To);

                String Seats = rs.getString("Seats");
                seat.setText(Seats);

                String Day = rs.getString("Day");
                day.setText(Day);

                String Month = rs.getString("Month");
                month.setText(Month);

                String Name = rs.getString("Name");
                name.setText(Name);

                String Age = rs.getString("Age");
                age.setText(Age);

                String Mobile = rs.getString("Mobile");
                mobile.setText(Mobile);

                String UID = rs.getString("UID");
                uid.setText(UID);

                String Mail = rs.getString("Mail");
                mail.setText(Mail);
            }

            else
            {

                JOptionPane.showMessageDialog(null,"Details Not Found!");
                dispose();
                new Portal();

            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();

        }


        //action listener for Ticket Button
        Ticket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // first of all, asking for confirmation from user
                int YorN = JOptionPane.showConfirmDialog(null,"Do you really want to cancel ticket?", "Cancel Ticket!", JOptionPane.YES_NO_OPTION);

                if(YorN == 0) // if yes is pressed
                {
                    try {

                        Connection myconn = (Connection) DriverManager.getConnection(url, user, password);

                        Statement stat = myconn.createStatement();

                        PreparedStatement pst = myconn.prepareStatement("DELETE FROM ticket_details WHERE Mail = ?");       // delete statement

                        pst.setString(1, Emailaddress);         //passing primary key value

                        int rs = pst.executeUpdate();   //executing update instead of executeQuery()

                        JOptionPane.showMessageDialog(null,"Ticket Has Been Canceled Successfully");    //Showing msg to user after the deletion of ticket details

                        //now erasing the data from all of text fields

                        name.setText("");           uid.setText("");
                        age.setText("");            mobile.setText("");
                        mail.setText("");           from.setText("");
                        to.setText("");             seat.setText("");
                        day.setText("");            month.setText("");

                        dispose(); // now closing the See_Details Frame
                        new Portal(); //and opening the Portal again


                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                }


            }
        });


        //action listener for Close button
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                new Portal();
            }
        });


    }

    //main function
    public static void main(String[] args) {
        new See_Details();
    }

}
