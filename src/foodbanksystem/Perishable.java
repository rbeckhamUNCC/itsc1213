package foodbanksystem;

/**
 *
 * @author Robert Beckham
 */
public class Perishable extends FoodItem {
    private int expDate;

    
    /**
     *
     * @param foodName name of item
     * @param quantity quantity of item
     * @param foodType perishable or non-perishable
     * @param expDate expiration date of item
     */
    public Perishable(String foodName, int quantity, int expDate) {
        super(foodName, quantity, expDate);
        this.expDate = expDate;

    }

    /**
     *
     * @param expDate sets expiration date of item
     */
    public void setExpDate(int expDate) {
        this.expDate = expDate;
    }

    /**
     *
     * @return gets expiration date of item
     */
    public int getExpDate() {
        return expDate;
    }

    @Override
    public String toString() {
        if(expDate > 1)
            return foodName + "\namount: " + quantity + "\nexpiration time left: " + expDate + " days";
        else
            return foodName + "\namount: " + quantity + "\nexpiration time left: " + expDate + " day";
    }
    

}
