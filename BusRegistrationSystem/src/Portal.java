//Main File which will start first



import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Portal extends JFrame{
    JLabel heading, background;
    JButton Book_Ticket, See_Details, Exit;
    ImageIcon Portal_Background;
    Font font;

    Portal()
    {
        setTitle("Ticket Reservation"); //frame title
        setLayout(null);
        setBounds(800,330,390,400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        font = new Font(null, Font.BOLD,18);
        Border border = BorderFactory.createLineBorder(Color.cyan,3);

        //Portal Heading Label
        heading = new JLabel("BUS TICKET RESERVATION PORTAL");
        add(heading);
        heading.setBounds(25,100,330,40);
        heading.setBorder(border);
        heading.setFont(font);
        heading.setForeground(Color.magenta);


        //Book_Ticket Button
        Book_Ticket = new JButton("BOOK TICKET");
        add(Book_Ticket);
        Book_Ticket.setBounds(60,190,120,30);

        //See_Details Button
        See_Details = new JButton("SEE DETAILS");
        add(See_Details);
        See_Details.setBounds(190,190,120,30);

        //Exit Button
        Exit= new JButton("CLOSE PORTAL");
        add(Exit);
        Exit.setBounds(60,230,250,30);

        //Portal Background
        Portal_Background = new ImageIcon(getClass().getResource("PortalBackground.png"));
        background = new JLabel();
        background.setBounds(0,0,390,400);
        add(background);
        background.setIcon(new ImageIcon(Portal_Background.getImage().getScaledInstance(390,400, Image.SCALE_AREA_AVERAGING)));


        //Action listener for BookTicket Button
        Book_Ticket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new  Travel_Information();
                dispose();
            }
        });


        //Acton listener for SeeDetails Button
        See_Details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new See_Details();
                dispose();
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    // main function
    public static void main(String[] args) {
        new Portal();
    }


}
