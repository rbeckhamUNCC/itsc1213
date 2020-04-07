package foodbanksystem;

/**
 *
 * @author Robert Beckham
 */
public class NonPerishable extends FoodItem {

//    public NonPerishable() {
//    }

    /**
     *
     * @param foodName name of food item
     * @param quantity quantity of food item
     * @param foodType perishable or non-perishable
     */
    public NonPerishable(String foodName, int quantity) {
        super(foodName, quantity);
    }

    @Override
    public String toString() {
        return foodName + "\namount: " + quantity;
    }
}
