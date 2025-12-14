import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserInterface blueBox = new UserInterface();
            blueBox.setVisible(true); // Make the frame visible
        });
    }
}
