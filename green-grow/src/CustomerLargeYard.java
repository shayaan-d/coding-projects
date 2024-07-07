// Shayaan Doodekula
public class CustomerLargeYard extends CustomerYard {

    // declare variables
    private String lastName;
    private String firstName;
    private int size;
    private int numberTrees;
    private int gardenSize;
    private double cost;
    private String doubleDriveway;

    public CustomerLargeYard(String lastName,
                             String firstName,
                             int size,
                             int numberTrees,
                             int gardenSize,
                             String doubleDriveway) {
        super(lastName,
                firstName,
                size,
                numberTrees,
                gardenSize,
                determineCost(
                        size,
                        numberTrees,
                        gardenSize,
                        doubleDriveway),
                doubleDriveway);
    }
}
