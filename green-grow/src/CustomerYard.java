// Shayaan Doodekula

public class CustomerYard implements Yard {

    // declare variables
    private final String lastName;
    private final String firstName;
    private final int size;
    private final int numberTrees;
    private final int gardenSize;
    private final double cost;
    private final String doubleDriveway;

    public CustomerYard(String lastName,
                        String firstName,
                        int size,
                        int numberTrees,
                        int gardenSize,
                        double cost,
                        String doubleDriveway) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.size = size;
        this.numberTrees = numberTrees;
        this.gardenSize = gardenSize;
        this.cost = cost;
        this.doubleDriveway = doubleDriveway;
    }

    public static double determineCost(int size, int numberTrees, int gardenSize, String doubleDriveway) {
        double baseCost; // this is the cost of the yard based solely on size
        double cost; // this is the cost in total

        /*
         if it's a small yard, then charge $0.005 per sq. ft. (minus garden footage)
         if it's a large yard, then charge $0.003 per sq. ft.  (minus garden footage)
         if it's a medium yard, charge $0.004 per sq. ft  (minus garden footage)
         */

        if (size <= 10000) {baseCost = 0.005 * (size - gardenSize);}

        else if (size <= 20000) {baseCost = 0.004 * (size - gardenSize);}

        else {baseCost = 0.003 * (size - gardenSize);}

        cost = baseCost; // set cost to base cost

        if (numberTrees % 2 == 1) cost += 0.05 * baseCost; // if there's an odd number of trees, then increase the price by 5% of base cost
        if (doubleDriveway.equals("yes")) cost -= 0.03 * baseCost; // if there's a double driveway, we decrease the price by 3% of base cost
        if (gardenSize > 0) cost += 10; // if there's a garden we charge the garden fee

        return cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public int compareTo(Yard y) {
        return getLastName().compareTo(y.getLastName());
    } // compares by name
    @Override
    public int getNumberTrees() {
        return numberTrees;
    }
    @Override
    public int getGardenSize() {
        return gardenSize;
    }
    @Override
    public String getDoubleDriveway() {
        return doubleDriveway;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + DriverSampleYard.getFormatter().format(cost);
    } // format: Sam Smith 123.45
    @Override
    public int getSize() {
        return size;
    }
}
