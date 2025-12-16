import java.io.*;
import javax.swing.*;

public class TextAreaOutputStream extends OutputStream {

    private final JTextArea textArea;

    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        SwingUtilities.invokeLater(() ->
            textArea.append(String.valueOf((char) b))
        );
    }
}
