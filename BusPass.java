package BusManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BusPass extends JFrame implements ActionListener {
    JTextField tfpnr;
    JLabel tfname, tfdept, lblsrc, lbldest, labelbusno, labelbusid, labeldate;
    JButton fetchButton;
    
    public BusPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ACS COLLEGE OF ENGINEERING");
        heading.setBounds(100, 10, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        JLabel subheading = new JLabel("Bus Pass");
        subheading.setBounds(250, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(new Color(33, 64, 154));
        add(subheading);
        
        JLabel lblempid = new JLabel("PNR DETAILS");
        lblempid.setBounds(60, 100, 150, 25);
        lblempid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblempid);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        
        JLabel lbldept = new JLabel("DEPARTMENT");
        lbldept.setBounds(60, 180, 150, 25);
        lbldept.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldept);
        
        tfdept = new JLabel();
        tfdept.setBounds(220, 180, 150, 25);
        add(tfdept);
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60, 220, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380, 220, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25);
        add(lbldest);
        
        JLabel lblfname = new JLabel("BUS No.");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelbusno = new JLabel();
        labelbusno.setBounds(220, 260, 150, 25);
        add(labelbusno);
        
        JLabel lblbusid = new JLabel("BUS ID");
        lblbusid.setBounds(380, 260, 150, 25);
        lblbusid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblbusid);
        
        labelbusid = new JLabel();
        labelbusid.setBounds(540, 260, 150, 25);
        add(labelbusid);
        
        JLabel lbldate = new JLabel("DATE");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BusManagementSystem/icons/acsce.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);
        
        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();

        try {
            Conn conn = new Conn();

            String query = "select * from booking where PNR = '"+pnr+"'";

            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                tfname.setText(rs.getString("name")); 
                tfdept.setText(rs.getString("dept")); 
                lblsrc.setText(rs.getString("src")); 
                lbldest.setText(rs.getString("des"));  
                labelbusno.setText(rs.getString("busnumber"));  
                labelbusid.setText(rs.getString("busid"));  
                labeldate.setText(rs.getString("ddate")); 
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BusPass();
    }
}
