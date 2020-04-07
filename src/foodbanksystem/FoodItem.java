package foodbanksystem;

import java.util.ArrayList;

/**
 *
 * @author Robert Beckham
 */
public class FoodItem {

    protected String foodName;
    protected int quantity;
    protected boolean foodType = false;
    protected Perishable perishable;
    protected int expDate;

    protected ArrayList<Perishable> perishableList = new ArrayList<>();
    protected ArrayList<NonPerishable> nonPerishableList = new ArrayList<>();

    public FoodItem(String foodName, int quantity) {
        this.foodName = foodName;
        this.quantity = quantity;

    }

    public FoodItem(String foodName, int quantity, int expDate) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.expDate = expDate;
    }

    /**
     *
     * @param foodName name of food item
     * @param quantity amount of food item
     * @param foodType
     */
    public FoodItem(String foodName, int quantity, int expDat, boolean foodType) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.foodType = foodType;
    }

    /**
     *
     * @return gets name of food item
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     *
     * @return gets amount of food item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param foodName sets name of food item
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     *
     * @param quantity sets quantity of food item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * sets food to perishable(true) or non-perishable(false)
     *
     * @param foodType true or false to set if perishable
     */
    public void setFoodType(boolean foodType) {
        this.foodType = foodType;
    }
  
    public String toString() {
        return "Food in stock: " + perishableList + nonPerishableList;
    }
}
