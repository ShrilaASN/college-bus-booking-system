package BusManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class BookBus extends JFrame implements ActionListener{
    JTextField tfempid;
    JLabel tfname, tfdept, tfaddress, labelgender, labelbno, labelbid;
    JButton bookbus, fetchButton, bus;
    Choice source, destination;
    JDateChooser dcdate;
    
    public BookBus() {
        getContentPane().setBackground(new Color(245, 247, 250));
        setLayout(null);
        
        JLabel heading = new JLabel("Book Bus");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        heading.setForeground(new Color(33, 37, 41));
        add(heading);
        
        JLabel lblempid = new JLabel("Employee ID");
        lblempid.setBounds(60, 80, 150, 25);
        lblempid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblempid);
        
        tfempid = new JTextField();
        tfempid.setBounds(220, 80, 150, 25);
        add(tfempid);
        
        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(new Color(33, 64, 154));
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel lbldept = new JLabel("Department");
        lbldept.setBounds(60, 180, 150, 25);
        lbldept.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldept);
        
        tfdept = new JLabel();
        tfdept.setBounds(220, 180, 150, 25);
        add(tfdept);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 330, 150, 25);       
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);       
        add(destination);
        
        try {
            Conn c = new Conn();
            String query = "select * from bus";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        bus = new JButton("Fetch Bus");
        bus.setBackground(new Color(33, 64, 154));
        bus.setForeground(Color.WHITE);
        bus.setBounds(380, 380, 120, 25);
        bus.addActionListener(this);
        add(bus);
        
        
        JLabel lblbno = new JLabel("Bus Number");
        lblbno.setBounds(60, 430, 150, 25);
        lblbno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblbno);
        
        labelbno = new JLabel();
        labelbno.setBounds(220, 430, 150, 25);
        add(labelbno);
        
        JLabel lblbid = new JLabel("Bus ID");
        lblbid.setBounds(60, 480, 150, 25);
        lblbid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblbid);
        
        labelbid = new JLabel();
        labelbid.setBounds(220, 480, 150, 25);
        add(labelbid);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BusManagementSystem/icons/details.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);
        
        bookbus = new JButton("Book Bus");
        bookbus.setBackground(new Color(33, 64, 154));
        bookbus.setForeground(Color.WHITE);
        bookbus.setBounds(220, 580, 150, 25);
        bookbus.addActionListener(this);
        add(bookbus);
        
        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String emp_id = tfempid.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select * from coordinator where emp_id = '"+emp_id+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tfname.setText(rs.getString("name")); 
                    tfdept.setText(rs.getString("department")); 
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct Employee ID");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bus) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            try {
                Conn conn = new Conn();

                String query = "select * from bus where source = '"+src+"' and destination = '"+dest+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    labelbno.setText(rs.getString("bus_no")); 
                    labelbid.setText(rs.getString("bus_id")); 
                } else {
                    JOptionPane.showMessageDialog(null, "No Buses Found");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            
            String empid = tfempid.getText();
            String name = tfname.getText(); 
            String dept = tfdept.getText();
            String busnumber = labelbno.getText(); 
            String busid = labelbid.getText();
            String src = source.getSelectedItem(); 
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
            try {
                Conn conn = new Conn();

                String query = "insert into booking values('PNR-"+random.nextInt(1000000)+"', 'REF_ID-"+random.nextInt(10000)+"', '"+empid+"', '"+name+"', '"+dept+"', '"+busnumber+"', '"+busid+"', '"+src+"', '"+des+"', '"+ddate+"')";

                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Bus Booked Successfully");
            } catch(SQLException e) {
                if (e.getErrorCode() == 1062) {
                    JOptionPane.showMessageDialog(null, "This bus is already booked for the selected date. \nPlease choose another date or bus.");
                } else {
                    JOptionPane.showMessageDialog(null,"Database Error");
                    e.printStackTrace();
                }

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BookBus();
    }
}