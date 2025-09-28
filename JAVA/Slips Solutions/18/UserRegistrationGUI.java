/*Q2. Write a program to design following screen using swing components [20 Marks] */

import javax.swing.*;
import java.awt.event.*;

public class UserRegistrationGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("New User Register");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("New User Register");
        title.setBounds(180, 10, 200, 30);
        panel.add(title);

        JLabel lblFirst = new JLabel("First name");
        lblFirst.setBounds(50, 60, 100, 20);
        panel.add(lblFirst);
        JTextField txtFirst = new JTextField();
        txtFirst.setBounds(150, 60, 120, 20);
        panel.add(txtFirst);

        JLabel lblUser = new JLabel("Username");
        lblUser.setBounds(280, 60, 100, 20);
        panel.add(lblUser);
        JTextField txtUser = new JTextField();
        txtUser.setBounds(360, 60, 120, 20);
        panel.add(txtUser);

        JLabel lblLast = new JLabel("Last name");
        lblLast.setBounds(50, 100, 100, 20);
        panel.add(lblLast);
        JTextField txtLast = new JTextField();
        txtLast.setBounds(150, 100, 120, 20);
        panel.add(txtLast);

        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(280, 100, 100, 20);
        panel.add(lblPass);
        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(360, 100, 120, 20);
        panel.add(txtPass);

        JLabel lblEmail = new JLabel("Email address");
        lblEmail.setBounds(50, 140, 100, 20);
        panel.add(lblEmail);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(150, 140, 120, 20);
        panel.add(txtEmail);

        JLabel lblMobile = new JLabel("Mobile number");
        lblMobile.setBounds(280, 140, 100, 20);
        panel.add(lblMobile);
        JTextField txtMobile = new JTextField();
        txtMobile.setBounds(360, 140, 120, 20);
        panel.add(txtMobile);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(200, 190, 100, 30);
        panel.add(btnRegister);

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String first = txtFirst.getText();
                String last = txtLast.getText();
                String username = txtUser.getText();
                String email = txtEmail.getText();
                String mobile = txtMobile.getText();
                String password = new String(txtPass.getPassword());

                JOptionPane.showMessageDialog(frame,
                    "Registration Details:\n" +
                    "First Name: " + first + "\n" +
                    "Last Name: " + last + "\n" +
                    "Username: " + username + "\n" +
                    "Password: " + password + "\n" +
                    "Email: " + email + "\n" +
                    "Mobile: " + mobile,
                    "Registered Successfully",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
