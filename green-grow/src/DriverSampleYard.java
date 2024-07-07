/*
 AUTHOR: Shayaan Doodekula
 INSTRUCTIONS:
 Step 1. Run the code.
 Step 2. Enter the file name in the terminal.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DriverSampleYard {

    private static JFrame frame;
    private static PanelSampleYard panel;
    private static ArrayList<CustomerYard> customerArray;
    private static Scanner scanner;
    private static NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
    private static final ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { // basically when any button is pressed this will trigger, e.getActionCommand will tell us where it came from
            switch (e.getActionCommand()) {
                case "quit":
                    sort(); // bubble-sorts array
                    for (CustomerYard customerYard : customerArray) {
                        System.out.println(customerYard.toString());
                    }
                    System.exit(0);
                case "next":
                    CustomerYard yard = createCustomerYard();
                    customerArray.add(yard);

                    // setText will set the area(the box where info is shown)'s text

                    DisplaySampleYard display = panel.getDisplay();
                    display.setText("Last Name", yard.getLastName());
                    display.setText("First Name", yard.getFirstName());
                    display.setText("Lawn Size","" + yard.getSize());
                    display.setText("Number Of Trees","" + yard.getNumberTrees());
                    display.setText("Garden Size","" + yard.getGardenSize());
                    display.setText("Double Driveway", yard.getDoubleDriveway());
                    display.setText("Total Cost", formatter.format(yard.getCost()));

                    display.addToRunningCost(yard.getCost()); // updates running cost
                    display.setText("Running Cost", formatter.format(display.getRunningCost()));

                    //check if there are any more customers: if not, print array and disable button

                    if (!scanner.hasNextLine()) {
                        JButton next = (JButton) e.getSource();
                        next.setEnabled(false);
                    }

                    break;
                    
            }
        }
    };

    private static CustomerYard createCustomerYard() {
        // initialize variables
        String lastName = scanner.nextLine();
        String firstName = scanner.nextLine();
        int size = Integer.parseInt(scanner.nextLine());
        int numberOfTrees = Integer.parseInt(scanner.nextLine());
        int gardenSize = Integer.parseInt(scanner.nextLine());
        String doubleDriveway = scanner.nextLine();
        CustomerYard yard;

        // based on size initialize a new yard
        if (size <= 10000) {
            yard = new CustomerSmallYard(
                    lastName,
                    firstName,
                    size,
                    numberOfTrees,
                    gardenSize,
                    doubleDriveway
            );
        } else if (size <= 20000) {
            yard = new CustomerMediumYard(
                    lastName,
                    firstName,
                    size,
                    numberOfTrees,
                    gardenSize,
                    doubleDriveway
            );
        } else {
            yard = new CustomerLargeYard(
                    lastName,
                    firstName,
                    size,
                    numberOfTrees,
                    gardenSize,
                    doubleDriveway
            );
        }
        return yard;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // this creates a new, separate "thread" so things can run in parallel
            @Override
            public void run() {
                System.out.print("Please enter the file name. ");
                Scanner in = new Scanner(System.in); // creates access to input stream
                String path = in.nextLine();
                File file = new File(path);
                try {
                    scanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("File Not Found", e); // if the file isn't found then throw an exception
                }

                /* because we are using an ArrayList, we don't need to use the customer count at the beginning of the file.
                this will discard the line at the beginning of the file */
                scanner.nextLine();

                customerArray = new ArrayList<>();

                /* creates a new instance of PanelSampleYard which will run the GUI. It will handle the JFrame, title, and buttons
                DisplaySampleYard deals with the main "body" section */
                panel = new PanelSampleYard();

                frame = new JFrame("Sample CS Readiness Test");
                frame.setLayout(new BorderLayout());
                frame.setSize(455, 345);
                frame.setLocationRelativeTo(null); // moves to center
                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // when the red x is clicked, close
                frame.setResizable(false);

                frame.add(panel.getPanel());

                frame.setVisible(true);
            }
        });
    }

    // bubble sort works by checking a pair of items and comparing them, and swapping them if needed
    private static void sort() {
        for (int i = 0; i < customerArray.size() - 1; i++) {
            for (int j = 0; j < customerArray.size() - 1; j++) {
                if (customerArray.get(j).compareTo(customerArray.get(j+1)) > 0) {
                    CustomerYard temp = customerArray.get(j);
                    customerArray.set(j, customerArray.get(j+1));
                    customerArray.set(j + 1, temp);
                }
            }
        }
    }

    public static ActionListener getListener() {
        return listener;
    }

    public static NumberFormat getFormatter() {
        return formatter;
    }
}
