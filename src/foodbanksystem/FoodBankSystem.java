package foodbanksystem;

import java.util.ArrayList;

/**
 *
 *
 * @author Robert Beckham
 */
public class FoodBankSystem {

    private ArrayList<Donor> donorList = new ArrayList<>();
    private ArrayList<Volunteer> volunteerList = new ArrayList<>();
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private ArrayList<Perishable> perishList = new ArrayList<>();
    private ArrayList<NonPerishable> nonPerishList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<FoodItem> foodList = new ArrayList<>();

    public FoodBankSystem() {
        employeeList.add(new Employee("Delilah", 10, 10.00));
        employeeList.add(new Employee("Bob", 20, 20.00));

        donorList.add(new Donor("Cat", 1, "peach", true));
        donorList.add(new Donor("Rob", 1, "peanut butter", true));

        volunteerList.add(new Volunteer("Britt", 10));
        volunteerList.add(new Volunteer("Matt", 10));

        nonPerishList.add(new NonPerishable("chicken noodle soup", 4));
        nonPerishList.add(new NonPerishable("peanut butter", 4));

        perishList.add(new Perishable("apple", 1, 1));
        perishList.add(new Perishable("orange", 2, 3));

    }

    public void addEmployee(String name, double hoursWorked, double payRate) {
        employeeList.add(new Employee(name, hoursWorked, payRate));

    }

    public void addDonor(String name, int donationAmount, String foodItem, int expDate) {
        donorList.add(new Donor(name, donationAmount, foodItem));

    }

    public void addDonorNP(String name, int donationAmount, String foodItem) {
        donorList.add(new Donor(name, donationAmount, foodItem));

    }

    public void addVolunteer(String name, double hoursWorked) {
        volunteerList.add(new Volunteer(name, hoursWorked));
    }

    public void addPerishable(String foodName, int quantity, int expDate) {
        int temp = 0;
        perishList.add(new Perishable(foodName, quantity, expDate));
        for (int i = 0; i < perishList.size(); i++) {
            temp = perishList.get(i).getQuantity();
            perishList.get(i).setQuantity(temp);
        }

    }

    public void addNonPerishable(String foodName, int quantity) {

        int temp = 0;
        nonPerishList.add(new NonPerishable(foodName, quantity));
        for (int i = 0; i < nonPerishList.size(); i++) {
            temp = nonPerishList.get(i).getQuantity();
            nonPerishList.get(i).setQuantity(temp);
        }
    }

    public void getEmployees() {
        for (int x = 0; x < employeeList.size(); x++) {
            System.out.print("Name: ");
            System.out.println(employeeList.get(x));
            System.out.println("");
        }
    }

    public void getDonors() {

        for (int x = 0; x < donorList.size(); x++) {
            System.out.print("Name: ");
            System.out.println(donorList.get(x));
            System.out.println("");
        }
    }

    public void getVolunteers() {

        for (int x = 0; x < volunteerList.size(); x++) {
            System.out.print("Name: ");
            System.out.println(volunteerList.get(x));
            System.out.println("");
        }
    }

    public void getPerishables() {

        for (int x = 0; x < perishList.size(); x++) {
            System.out.println("Perishables: ");
            System.out.println(perishList.get(x));
            System.out.println("");
        }
    }

    public void getNonPerishables() {

        for (int x = 0; x < nonPerishList.size(); x++) {
            System.out.println("Non-Perishables: ");
            System.out.println(nonPerishList.get(x));
            System.out.println("");
        }
    }

    /**
     * Method that organizes and prints all users in food bank Print
     * "Volunteers" call method getVolunteers Print "Employees" call method
     * getEmployees Print "Donors" call method getDonors Print a space
     *
     */
    public void displayAllUsers() {
        System.out.println("Volunteers:");
        getVolunteers();
        System.out.println("Employees: ");
        getEmployees();
        System.out.println("Donors: ");
        getDonors();
    }

    public void displayAllFood() {
        getPerishables();
        getNonPerishables();
    }

    /**
     * set boolean temp to false 
     * for each item in perishList 
     *  if the item at the current index in perishList has an expDate of 0 
     *  print "Careful quantity + foodName is/are out of date 
     *  set temp equal to true 
     *      if temp is not equal to true 
     *      print 'No items have expired' return temp
     *
     * @return boolean true to indicated expired or false to indicate not
     * expired
     */

    public boolean isExpired() {
        boolean temp = false;

        for (int x = 0; x < perishList.size(); x++) {

            if (perishList.get(x).getQuantity() == 1 && perishList.get(x).getExpDate() <= 0) {
                System.out.println("Careful, " + perishList.get(x).getQuantity() + " " 
                        + perishList.get(x).getFoodName() + " is out of date!");
                temp = true;
            }
            else{
                System.out.println("Careful, " + perishList.get(x).getQuantity() + " " 
                        + perishList.get(x).getFoodName() + "s" + " are out of date!");
                temp = true;
            }
        }
        if (temp != true) {
            System.out.println("No items have Expired.");
        }
        System.out.println("");
        return temp;
    }

    /**
     * set boolean temp to false 
     * for each item in perishList 
     *  if the item at the current index in perishList has an expDate equal to zero 
     *  print "Item removed + foodName" 
     *  remove the item at the current index
     *
     *
     *
     */

    public void removeExpired() {

        for (int x = 0; x < perishList.size(); x++) {

            if (perishList.get(x).getExpDate() <= 0) {
                System.out.println("Item and amount removed: " + perishList.get(x).quantity + " " + perishList.get(x).getFoodName());
//                System.out.println("Amount removed: " + perishList.get(x).quantity);
                perishList.remove(x); 
            }
        }
    }

    /**
     * for each item in perishList 
     *  set temp to the expDate of current element in perishList 
     *  decrement the expDate by 1 
     *  set the new expDate of current element in perishList to the decremented temp variable
     */
    public void simulateTime() {

        for (int i = 0; i < perishList.size(); i++) {
            int expDate = perishList.get(i).getExpDate();
            expDate--;
            perishList.get(i).setExpDate(expDate);
        }
    }
    
} // end of class
