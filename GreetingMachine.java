import javax.swing.*;
import java.awt.*;

public class GreetingMachine extends JFrame {
    public GreetingMachine() {
        setTitle("Greeting Machine");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel prompt = new JLabel("WHAT IS YOUR NAME");
        JTextField nameField = new JTextField(15);
        JLabel prompt2 = new JLabel("WHAT IS YOUR QUEST");
        JTextField questField = new JTextField(15);
        JButton greetButton = new JButton("ATTEMPT TO CROSS BRIDGE");

        add(prompt);
        add(nameField);
        add(prompt2);
        add(questField);
        add(greetButton);

        setVisible(true);

        greetButton.addActionListener( e-> {
            String name = nameField.getText();
            String quest = questField.getText();
            JOptionPane.showMessageDialog(this, "HELLO, " + name + "! \n" + "Your quest to " + quest + " has been derailed!");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GreetingMachine());
    }
}