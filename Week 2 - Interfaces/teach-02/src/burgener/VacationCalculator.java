package burgener;
import java.util.List;
import java.util.ArrayList;

public class VacationCalculator {

    public static void main(String[] args) {

        VacationCalculator vc = new VacationCalculator();

        // Calculate some vacation costs...
        float mexicoCost = vc.calculateVacationCost(Destination.Mexico, 5);
        float europeCost = vc.calculateVacationCost(Destination.Europe, 5);
        float japanCost = vc.calculateVacationCost(Destination.Japan, 5);

        // Print the cost...
        System.out.println("The cost of the vacation is: " + mexicoCost + ".");
        System.out.println("The cost of the vacation is: " + europeCost + ".");
        System.out.println("The cost of the vacation is: " + japanCost + ".");
    }

    /**
     * Calculates the total cost for vacationing at a given location for
     * a specific number of nights.
     *
     * @param dest the destination of the vacation
     * @return the total cost of the vacation
     */
    public float calculateVacationCost(Destination dest, int nights) {
        List<Expense> items = new ArrayList<Expense>();
        items.add(new Cruise(dest));
        items.add(new Dining(dest, nights));
        items.add(new Lodging(dest, nights));
        float totalCost = tallyExpenses(items);
        return totalCost;
    }

    /**
     * An internal method used by VacationCalculator to loop through
     * a List of items that implement the Expense interface and
     * determine their cost
     *
     * @param expenses A list of items that implement the Expense interface
     * @return the total cost calculated by the items
     */
    float tallyExpenses(List<Expense> expenses) {
        float totalCost = 0;

        for (Expense e : expenses) {
            totalCost += e.getCost();
        }
        return totalCost;
    }
}