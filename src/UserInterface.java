import java.awt.*;
import javax.swing.*;

public class UserInterface extends JFrame {

    private JTextField display;
    private ToneSequence seq = new ToneSequence();

    public UserInterface() {
        setTitle("BlueBox");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout());

        display = new JTextField(20);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        displayPanel.add(display);

        JPanel numpadPanel = new JPanel();
        numpadPanel.setLayout(new GridLayout(4, 3));

        String[] buttonLabels = {
            "7",
            "8",
            "9",
            "4",
            "5",
            "6",
            "1",
            "2",
            "3",
            "*",
            "0",
            "#",
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(e -> onButtonPress(label));
            numpadPanel.add(button);
        }

        JPanel executionPanel = new JPanel();
        executionPanel.setLayout(new GridLayout(1, 2));

        String[] exebutton = { "EXECUTE", "Clear" };

        for (String label : exebutton) {
            JButton cmdbutton = new JButton(label);
            cmdbutton.addActionListener(e -> onButtonPress(label));
            executionPanel.add(cmdbutton);
        }

        add(displayPanel, BorderLayout.NORTH);
        add(numpadPanel, BorderLayout.CENTER);
        add(executionPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null); // Centers the window
    }

    private void onButtonPress(String label) {
        if (label.equals("EXECUTE")) {
            if (display.getText().isEmpty()) {
                System.out.println("No input to execute");
                return;
            }
            System.out.println("EXECUTING:" + display.getText());
            TonePlayer player = new TonePlayer();
            player.playSequence(seq);
        } else if (label.equals("Clear")) {
            display.setText("");
            seq = new ToneSequence();
            System.out.println("Display cleared");
        } else {
            display.setText(display.getText() + label);
            System.out.println(label + " was pressed");

            // Generate MF tone for the digit
            try {
                MFTone mfTone = MFTone.fromDigit(label.charAt(0), 100); // 100ms duration
                ToneSequence toneSeq = new ToneSequence();
                toneSeq.add(mfTone);

                // Add to sequence for later playback
                for (Tone t : toneSeq.getTones()) {
                    seq.add(t);
                }

                // Play the tone immediately
                TonePlayer player = new TonePlayer();
                player.playSequence(toneSeq);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid digit: " + label);
                // For non-MF characters like * and #, you might want to handle differently
                Whistle tone = new Whistle(2600.0);
                ToneSequence whistleSeq = tone.blow(100);
                for (Tone t : whistleSeq.getTones()) {
                    seq.add(t);
                }
                TonePlayer player = new TonePlayer();
                player.playSequence(whistleSeq);
            }
        }
    }
}
