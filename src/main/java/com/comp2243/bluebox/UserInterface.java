package com.comp2243.bluebox;

import com.comp2243.bluebox.tone.*;
import com.comp2243.bluebox.ui.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class UserInterface extends JFrame {

    private JTextField display;
    private ToneSequence seq = new ToneSequence();

    public UserInterface() {
        setTitle("BlueBox");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea logArea = new JTextArea();
        System.setOut(new PrintStream(new TextAreaOutputStream(logArea)));
        System.setErr(new PrintStream(new TextAreaOutputStream(logArea)));
        logArea.setEditable(false);
        logArea.setRows(4);

        JScrollPane logScrollPane = new JScrollPane(logArea);
        logScrollPane.setBorder(BorderFactory.createTitledBorder("Log"));
        logScrollPane.setPreferredSize(new Dimension(Integer.MAX_VALUE, 120));

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());

        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        displayPanel.add(display, BorderLayout.CENTER);

        JPanel numpadPanel = new JPanel();
        numpadPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
            "1",
            "2",
            "3",
            "A",
            "4",
            "5",
            "6",
            "B",
            "7",
            "8",
            "9",
            "C",
            "*",
            "0",
            "#",
            "D",
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(e -> onButtonPress(label));
            numpadPanel.add(button);
        }

        JPanel executionPanel = new JPanel();
        executionPanel.setLayout(new GridLayout(3, 1));

        String[] exebutton = { "2600Hz", "DIAL", "Clear" };

        for (String label : exebutton) {
            JButton cmdbutton = new JButton(label);
            cmdbutton.addActionListener(e -> onButtonPress(label));
            executionPanel.add(cmdbutton);
        }

        add(displayPanel, BorderLayout.NORTH);
        add(numpadPanel, BorderLayout.CENTER);
        add(executionPanel, BorderLayout.EAST);
        add(logScrollPane, BorderLayout.SOUTH);
        setLocationRelativeTo(null); // Centers the window
    }

    private void onButtonPress(String label) {
        if (label.equals("DIAL")) {
            if (display.getText().isEmpty()) {
                System.out.println("No input to execute");
                return;
            }
            System.out.println("DIALING:" + display.getText());
            TonePlayer player = new TonePlayer();
            player.playSequence(seq);
        } else if (label.equals("Clear")) {
            display.setText("");
            seq = new ToneSequence();
            System.out.println("Display cleared");
        } else if (label.equals("2600Hz")) {
            try {
                display.setText(display.getText() + ' ' + label + ' ');
                System.out.println("TIME 2 HACK");
                Whistle tone = new Whistle(2600.0);
                ToneSequence whistleSeq = tone.blow(2000);
                for (Tone t : whistleSeq.getTones()) {
                    seq.add(t);
                }
                TonePlayer player = new TonePlayer();
                player.playSequence(whistleSeq);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid digit: " + label);
            }
        } else {
            display.setText(display.getText() + label + ' ');
            System.out.println(label + " was pressed");

            // Generate MF tone for the digit
            try {
                MFTone MfTone = MFTone.fromDigit(label.charAt(0), 55);
                ToneSequence toneSeq = new ToneSequence();
                toneSeq.add(MfTone);

                // Add to sequence for later playback
                for (Tone t : toneSeq.getTones()) {
                    seq.add(t);
                }

                // Play the tone immediately
                TonePlayer player = new TonePlayer();
                player.playSequence(toneSeq);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid digit: " + label);
            }
        }
    }
}
