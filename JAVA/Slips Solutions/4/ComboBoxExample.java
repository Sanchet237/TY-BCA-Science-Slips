/*Q2. Write a program to design following GUI using swing. On click of Show button display the 
selected Programming language on screen using label. [20 Marks] */

import javax.swing.*;
import java.awt.event.*;

public class ComboBoxExample extends JFrame implements ActionListener {
    JComboBox<String> combo;
    JButton btn;
    JLabel lbl;

    public ComboBoxExample() {
        setTitle("ComboBox Example");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lbl = new JLabel("Programming language Selected: Java");
        lbl.setBounds(90, 40, 300, 30);
        add(lbl);

        combo = new JComboBox<>(new String[]{"C", "C++", "C#", "Java", "PHP"});
        combo.setBounds(90, 100, 100, 25);
        add(combo);

        btn = new JButton("Show");
        btn.setBounds(210, 100, 80, 25);
        add(btn);

        btn.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        lbl.setText("Programming language Selected: " + combo.getSelectedItem());
    }

    public static void main(String[] args) {
        new ComboBoxExample();
    }
}
