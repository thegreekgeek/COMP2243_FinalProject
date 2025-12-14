import java.awt.*;
import javax.swing.*;

public class FauxCalculator extends JFrame {

    public FauxCalculator() {
        setTitle("Calcy");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel displayPanel = new JPanel();

        displayPanel.setLayout(new FlowLayout());
        displayPanel.add(new JTextField(20));

        JPanel numpadPanel = new JPanel();

        numpadPanel.setLayout(new GridLayout(4, 4));

        // Create buttons (for numbers and operators)
        String[] buttonLabels = {
            "7",
            "8",
            "9",
            "/",
            "4",
            "5",
            "6",
            "*",
            "1",
            "2",
            "3",
            "-",
            "0",
            ".",
            "=",
            "+",
        };

        for (String label : buttonLabels) {
            numpadPanel.add(new JButton(label));
        }
        add(displayPanel, BorderLayout.NORTH);
        add(numpadPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FauxCalculator calc = new FauxCalculator();
            calc.setVisible(true); // Make the frame visible
        });
    }
}
