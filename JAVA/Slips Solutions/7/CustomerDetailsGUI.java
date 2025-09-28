/* 
Q2. Write a program to design the following GUI using Swing components. 
On click of submit button, check whether user has entered all the details or not. 
If any details are missing, then display appropriate message on screen using label. [20 Marks] 
*/

import javax.swing.*;
import java.awt.*;

public class CustomerDetailsGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Customer Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField nameField = new JTextField();
        JTextField bankField = new JTextField();
        JTextField accountField = new JTextField();
        JTextField panField = new JTextField();
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);

        formPanel.add(new JLabel("Name:")); formPanel.add(nameField);
        formPanel.add(new JLabel("Bank:")); formPanel.add(bankField);
        formPanel.add(new JLabel("Account No:")); formPanel.add(accountField);
        formPanel.add(new JLabel("PAN No:")); formPanel.add(panField);

    
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);

        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(messageLabel, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> {
            if (nameField.getText().isEmpty() || bankField.getText().isEmpty() ||
                accountField.getText().isEmpty() || panField.getText().isEmpty()) {
                messageLabel.setText("Please enter all details!");
                messageLabel.setForeground(Color.RED);
            } else {
                messageLabel.setText("Details submitted successfully!");
                messageLabel.setForeground(new Color(0, 128, 0));
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
