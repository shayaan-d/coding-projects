// Shayaan Doodekula

import javax.swing.*;
import java.awt.*;

public class DisplaySampleYard {
    private final JPanel panel = new JPanel();
    private final Font mainFont = new Font("Arial", Font.BOLD, 20);
    private final JLabel lastNameArea;
    private final JLabel firstNameArea;
    private final JLabel lawnSizeArea;
    private final JLabel numberOfTreesArea;
    private final JLabel gardenSizeArea;
    private final JLabel doubleDrivewayArea;
    private final JLabel totalCostArea;
    private final JLabel runningCostArea;
    private double runningCost = 0.0;

    public DisplaySampleYard() {
        panel.setLayout(new GridLayout(8, 2));
        panel.setBackground(Color.lightGray);

        // createGridRow() basically creates each row for the value, and returns the display area for info.

        lastNameArea = createGridRow("Last Name");
        firstNameArea = createGridRow("First Name");
        lawnSizeArea = createGridRow("Lawn Size");
        numberOfTreesArea = createGridRow("Number Of Trees");
        gardenSizeArea = createGridRow("Garden Size");
        doubleDrivewayArea = createGridRow("Double Driveway");
        totalCostArea = createGridRow("Total Cost");
        runningCostArea = createGridRow("Running Cost");
    }

    private JLabel createGridRow(String text) {

        JLabel label = new JLabel(text + ":");
        label.setFont(mainFont);
        panel.add(label);

        JLabel area = new JLabel();
        area.setFont(mainFont);
        // next 3 lines make it look like a text box
        area.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        area.setOpaque(true);
        area.setBackground(Color.WHITE);

        panel.add(area);

        return area;
    }


    public void setText(String area, String text) {
        // sets the info display area to text
        switch (area) {
            case "Last Name":
                lastNameArea.setText(text);
                break;
            case "First Name":
                firstNameArea.setText(text);
                break;
            case "Lawn Size":
                lawnSizeArea.setText(text);
            case "Number Of Trees":
                numberOfTreesArea.setText(text);
                break;
            case "Garden Size":
                gardenSizeArea.setText(text);
                break;
            case "Double Driveway":
                doubleDrivewayArea.setText(text);
                break;
            case "Total Cost":
                totalCostArea.setText(text);
                break;
            case "Running Cost":
                runningCostArea.setText(text);
                break;
        }
    }

    public double getRunningCost() {
        return runningCost;
    }

    public void addToRunningCost(double addedCost) {
        this.runningCost += addedCost;
    }

    public JPanel getPanel() {
        return panel;
    }
}
