// Shayaan Doodekula

import javax.swing.*;
import java.awt.*;

public class PanelSampleYard {

    private final JPanel panel = new JPanel(new BorderLayout());

    private final DisplaySampleYard display;

    public PanelSampleYard() {

        Color gray = Color.lightGray;
        Font mainFont = new Font("Arial", Font.BOLD, 25);
        panel.setBackground(gray); // sets bg color
        panel.setLayout(new BorderLayout()); // sets layout of the panel

        //sets title
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(gray);
        panel.add(titlePanel, BorderLayout.NORTH);
        JLabel titleLabel = new JLabel("Green and Grow Mowing Company");
        titleLabel.setFont(mainFont);
        titleLabel.setBackground(gray);
        titlePanel.add(titleLabel);
        titleLabel.setOpaque(false);

        // main
        display = new DisplaySampleYard();
        panel.add(display.getPanel());


        // buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton nextButton = new JButton("Next");
        // when the next button is pressed, the ActionListener in Driver will run and receive "next"
        nextButton.setActionCommand("next");
        // sets the action listener
        nextButton.addActionListener(DriverSampleYard.getListener());
        nextButton.setSize(60, 40);
        JButton quitButton = new JButton("Quit");
        quitButton.setActionCommand("quit");
        quitButton.addActionListener(DriverSampleYard.getListener());
        quitButton.setSize(60, 40);
        buttonPanel.add(nextButton);
        buttonPanel.add(quitButton);
        buttonPanel.setBackground(gray);
        panel.add(buttonPanel, BorderLayout.SOUTH);

    }

    public JPanel getPanel() {
        return panel;
    }

    public DisplaySampleYard getDisplay() {
        return display;
    }
}
