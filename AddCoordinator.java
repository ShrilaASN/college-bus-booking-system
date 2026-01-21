package BusManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCoordinator extends JFrame implements ActionListener{
    
    JTextField tfname, tfphone, tfempid, tfdepartment, tfaddress;
    JRadioButton rbmale, rbfemale;

    public AddCoordinator() {

        getContentPane().setBackground(new Color(245, 247, 250));
        setLayout(null);

        JLabel heading = new JLabel("ADD COORDINATOR DETAILS");
        heading.setBounds(200, 20, 500, 35);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 30));
        heading.setForeground(new Color(52, 102, 164));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setForeground(new Color(60, 60, 60));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);

        JLabel lbldepartment = new JLabel("Department");
        lbldepartment.setBounds(60, 130, 150, 25);
        lbldepartment.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldepartment.setForeground(new Color(60, 60, 60));
        add(lbldepartment);

        tfdepartment = new JTextField();
        tfdepartment.setBounds(220, 130, 150, 25);
        add(tfdepartment);

        JLabel lblempid = new JLabel("Employee ID");
        lblempid.setBounds(60, 180, 150, 25);
        lblempid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblempid.setForeground(new Color(60, 60, 60));
        add(lblempid);

        tfempid = new JTextField();
        tfempid.setBounds(220, 180, 150, 25);
        add(tfempid);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbladdress.setForeground(new Color(60, 60, 60));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setForeground(new Color(60, 60, 60));
        add(lblgender);

        ButtonGroup gendergroup = new ButtonGroup();

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(new Color(245, 247, 250));
        rbmale.setForeground(new Color(80, 80, 80));
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 80, 25);
        rbfemale.setBackground(new Color(245, 247, 250));
        rbfemale.setForeground(new Color(80, 80, 80));
        add(rbfemale);

        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JButton save = new JButton("SAVE");
        save.setBackground(new Color(33, 64, 154));
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);

        ImageIcon image = new ImageIcon(
            ClassLoader.getSystemResource("busmanagementsystem/icons/emp.png")
        );
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);

        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        String name = tfname.getText();
        String department = tfdepartment.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String empid = tfempid.getText();
        String gender = rbmale.isSelected() ? "Male" : "Female";

        try {
            Conn conn = new Conn();

            String query ="insert into coordinator values('"+name+"','"+department+"','"+phone+"','"+address+"','"+empid+"','"+gender+"')";
                
            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Coordinator Details Added Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddCoordinator();
    }
}
