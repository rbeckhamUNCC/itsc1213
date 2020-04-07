package foodbanksystem;

/**
 *
 * @author Robert Beckham
 */
public class Donor extends User {

    private String foodItem;
    private int donationAmount;
    private boolean perish = false;

    /**
     *
     * @param name name of donor
     * @param donationAmount number of donations by donor
     * @param foodItem name of food
     */
    public Donor(String name, int donationAmount, String foodItem) {
        super(name);
        this.donationAmount = donationAmount;
        this.foodItem = foodItem;

    }

    /**
     *
     * @param name name of donor
     * @param donationAmount number of donations by donor
     * @param foodItem name of food
     * @param perish perishable(true), non-perishable(false)
     */
    public Donor(String name, int donationAmount, String foodItem, boolean perish) {
        super(name);
        this.donationAmount = donationAmount;
        this.foodItem = foodItem;
        this.perish = perish;

    }

    /**
     *
     * @param foodItem sets food item donated
     */
    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    /**
     *
     * @param donationAmount sets amount of donations
     */
    public void setDonations(int donationAmount) {
        this.donationAmount = donationAmount;
    }

    /**
     *
     * @return gets food item donated
     */
    public String getFoodItem() {
        return foodItem;
    }

    /**
     *
     * @return get amount of donations
     */
    public int getDonations() {
        return donationAmount;
    }

    public boolean isPerish() {
        return perish;
    }

    
    
    @Override
    public String toString() {
        return userName + ", donated " + donationAmount + " " + foodItem + "(s)."; //To change body of generated methods, choose Tools | Templates.
    }
}
