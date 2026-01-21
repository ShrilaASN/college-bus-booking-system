package BusManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    public Home() {
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BusManagementSystem/icons/front.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1536, 800);
        add(image);
        
        JLabel heading = new JLabel("COLLEGE TRANSPORTATION FACILITY");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(new Color(245, 244, 240));
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem busDetails = new JMenuItem("Bus Details");
        busDetails.addActionListener(this);
        details.add(busDetails);
        
        JMenuItem coordinatorDetails = new JMenuItem("Add Coordinator Details");
        coordinatorDetails.addActionListener(this);
        details.add(coordinatorDetails);
        
        JMenuItem bookBus = new JMenuItem("Book Bus");
        bookBus.addActionListener(this);
        details.add(bookBus);
        
        JMenuItem tripDetails = new JMenuItem("Trip Details");
        tripDetails.addActionListener(this);
        details.add(tripDetails);
        
        JMenuItem bookingCancellation = new JMenuItem("Cancel Booking");
        bookingCancellation.addActionListener(this);
        details.add(bookingCancellation);
        
        JMenu booking = new JMenu("Booking");
        menubar.add(booking);
        
        JMenuItem busPass = new JMenuItem("Bus Pass");
        busPass.addActionListener(this);
        booking.add(busPass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if (text.equals("Add Coordinator Details")) {
            new AddCoordinator();
        } else if (text.equals("Bus Details")) {
            new BusInfo();
        } else if (text.equals("Book Bus")) {
            new BookBus();
        } else if (text.equals("Trip Details")) {
            new TripDetails();
        } else if (text.equals("Cancel Booking")) {
            new Cancel();
        } else if (text.equals("Bus Pass")) {
            new BusPass();  
        }
    }
    
    public static void main(String[] args) {
        new Home();
    }
}

    

