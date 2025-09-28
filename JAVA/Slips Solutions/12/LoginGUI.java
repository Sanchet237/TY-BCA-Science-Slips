/*Q2. Write a program to design a following GUI. Use appropriate Layout and Components. On 
click of login check whether Username and Password is “admin” or not. [20 Marks] */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, resetButton;
    JLabel messageLabel;

    public LoginGUI() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        formPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        formPanel.add(usernameField);
        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        buttonPanel.add(loginButton);
        buttonPanel.add(resetButton);

        // Message Label
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            if (username.equals("admin") && password.equals("admin")) {
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Login Successful!");
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Invalid Username or Password!");
            }
        } else if (e.getSource() == resetButton) {
            usernameField.setText("");
            passwordField.setText("");
            messageLabel.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginGUI::new);
    }
}

