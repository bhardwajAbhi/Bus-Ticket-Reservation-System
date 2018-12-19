//second frame of the project.. here the details related to journey will be added


import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Travel_Information extends JFrame {

    JLabel Heading, Boarding_From, Boarding_To, Bus_Type, Date, Available_Buses, No_of_seats, background;
    JTextField From, To, SEATS;
    JComboBox Btype, day, month, buses;
    JButton Cancel, Next;
    ImageIcon Travel_Background;
    Font font;

    public String FROM, TO, SEAT, BUSTYPE, DAY, MONTH, BUSES;

    Travel_Information()
    {
        font = new Font(null, Font.BOLD,18);
        Border border1 = BorderFactory.createLineBorder(Color.cyan,3); // frame border
        Border border2 = BorderFactory.createLineBorder(Color.gray,2); // label border

        setTitle("Travel Information"); //frame title
        setLayout(null);
        setBounds(700,250,500,500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //Heading label
        Heading = new JLabel("......TRAVEL INFORMATION......");
        Heading.setBounds(100,40,280,40);
        Heading.setBorder(border1);
        Heading.setFont(font);
        Heading.setForeground(Color.magenta);
        add(Heading);



        //Booking From Label and Text Field
        Boarding_From = new JLabel("Boarding From : ");
        Boarding_From.setBounds(40,120,100,20);
        Boarding_From.setForeground(Color.white);
        Boarding_From.setBorder(border2);
        add(Boarding_From);
        From = new JTextField(15);
        From.setBounds(140,120,100,20);
        add(From);


        //Boarding To Label and Text Field
        Boarding_To = new JLabel("To : ");
        Boarding_To.setBounds(280,120,60,20);
        Boarding_To.setForeground(Color.white);
        Boarding_To.setBorder(border2);
        add(Boarding_To);
        To = new JTextField(15);
        To.setBounds(310,120,130,20);
        add(To);


        //BusType label and combo box
        Bus_Type= new JLabel("Bus Type : ");
        Bus_Type.setBounds(40,160,100,20);
        Bus_Type.setForeground(Color.white);
        Bus_Type.setBorder(border2);
        add(Bus_Type);
        //combo box for bus type
        String type [] = {"-Select-", "Ordinary", "AC Bus", "Non-AC Bus","Volvo"}; //list of buses
        Btype = new JComboBox();
        for(int i = 0; i<type.length; i ++)
        {
            Btype.addItem(type[i]);
        }
        Btype.setBounds(140,160,100,20);
        add(Btype);


        //Date label and combo box
        Date = new JLabel("Date : ");
        Date.setBorder(border2);
        Date.setForeground(Color.white);
        Date.setBounds(280,160,40,20);
        add(Date);
        String Day [] = {" - ","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String Month [] = {" -- ","January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        //day combo box
        day = new JComboBox();
        for(int d = 0; d<Day.length; d++)
        {
            day.addItem(Day[d]);
        }
        day.setBounds(330,160,40,20);
        add(day);
        //month combo box
        month = new JComboBox();
        for(int m = 0; m<Month.length; m++)
        {
            month.addItem(Month[m]);
        }
        month.setBounds(370,160,70,20);
        add(month);


        //Availabe buses label and combo box
        Available_Buses = new JLabel("...................................Available Buses for the Route are...................................");
        Available_Buses.setForeground(Color.white);
        Available_Buses.setBorder(border2);
        Available_Buses.setBounds(40,200,400,20);
        add(Available_Buses);
        //combo box for availabe buses
        String avail[] = {"----------------------------------------------Select--------------------------------------",
                "Hamirpur-Bilaspur-Shimla-Rohru",
                "Hamirpur-Bilaspur-Chandigarh",
                "Bilaspur-Mandi-Manali",
                "Shimla-Bilaspur-Hamirpur-Kangra",
                "Sarkaghat-Ghumarwin-Bilaspur-Shimla-Theyog-Hatkoti-Rohru",
                "Manali-Mandi-Bilaspur-Chandigarh-Delhi",
                "Mandi-Sundernagar-Shimla-Rohru",
                "Keylong-Kullu-Mandi-Bilaspur-Chandigarh-Delhi",
                "Palampur-Kangra-Shimla",
                "Mandi-Kullu-Manali-Rohtang-Keylong-Leh",
                "Shimla-Delhi-Jaipur"};

        buses = new JComboBox();
        for (int b = 0; b< avail.length; b++)
        {
            buses.addItem(avail[b]);
        }
        buses.setBounds(40,220,400,20);
        add(buses);

        //no. of  seats
        No_of_seats = new JLabel("Number of Seats : ");
        No_of_seats.setBorder(border2);
        No_of_seats.setForeground(Color.white);
        No_of_seats.setBounds(40,260,120,20);
        add(No_of_seats);
        SEATS = new JTextField(5);
        SEATS.setBounds(170,260,40,20);
        add(SEATS);


        //cancel button
        Cancel = new JButton("CANCEL");
        Cancel.setBounds(80,320,150,40);
        add(Cancel);

        //next button
        Next = new JButton("NEXT");
        Next.setBounds(240,320,150,40);
        add(Next);



        //action listeener for cancel button
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Portal();
                dispose();
            }
        });


        //action listeener for next button

        Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (From.equals("") || SEATS.equals("") || To.equals("") || Btype.getSelectedItem().equals("-Select-") || day.getSelectedItem().equals(" - ") || month.getSelectedItem().equals(" -- ") || buses.getSelectedItem().equals("-------------")) {

                    JOptionPane.showMessageDialog(null, "All fields are Mandatory!");
                } else {
                    // saving data from label in to variable

                    String from, to, Seats, Day, Month;


                    from = From.getText();
                    to = To.getText();
                    Seats = SEATS.getText();
                    Day = (String) day.getSelectedItem();
                    Month = (String) month.getSelectedItem();




                /*// to test if variable are working?
                System.out.println(from + " " + to + " " + Seats + " " + busType + " " + Day + " " + Month +" " + Buses );
                */

                    new Passenger_Details(from, to, Seats, Day, Month).setVisible(true);
                    dispose();
                }

            }
        });


        //Background
        Travel_Background = new ImageIcon(getClass().getResource("TravelBackground.jpg"));
        background = new JLabel();
        background.setBounds(0, 0, 600, 600);
        add(background);
        background.setIcon(new ImageIcon(Travel_Background.getImage().getScaledInstance(600, 600, Image.SCALE_AREA_AVERAGING)));




/*
        // this code is for "Availabe Buses" Combo box. it is placed here becoz at the end we will check whether the : From, To, Bustype, Day and Month are empty or not?
        // combo box will be enabled only when the above are not empty, else it will remain disabled.
        do {
            buses.setEnabled(false);
        }
        while ((From.getText().equals(""))|| (To.getText().equals(""))|| (Btype.getSelectedItem().equals("-Select-") ) || (day.getSelectedItem().equals(" - ")) || (month.getSelectedItem().equals(" -- ")));
        //while loop will keep on checking the condition. When it becomes false the the below conditon will be executed and combobox will be enabled.
        buses.setEnabled(true);
        SEATS.setEditable(true); // now we can enter the no. of seats that we want to book in bus

*/
    }




    //main function
    public static void main(String[] args) {
        new Travel_Information();
    }
}
