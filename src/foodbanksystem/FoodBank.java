package foodbanksystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 *
 * @author Robert Beckham
 */
public class FoodBank {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        
//        ArrayList<User> userList = new ArrayList<>();
//        ArrayList<FoodItem> foodList = new ArrayList<>();
        boolean end = false;
        //create FoodBankSystem object
        FoodBankSystem foodBank = new FoodBankSystem();
        //scanner to read user input
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to the LifeHope Food Bank!\n");

        while (end != true) {
            System.out.println("********Main Menu********");
            System.out.println("Please select from the following by typing a number:");
            System.out.println("\t 1. User account information");
            System.out.println("\t 2. Food Item information");
            System.out.println("\t 3. Display User Information");
            System.out.println("\t 4. Simulate Time");
            System.out.println("\t 5. Check Expiration of items");
            System.out.println("\t 6. Remove Expired Items");
            System.out.println("\t 7. End program");
            try {
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("\nChoose one of the following:\n" + "1)Employee 2)Volunteer 3)Donor 4)Main Menu ");
                        int choice = sc.nextInt();
                        System.out.println("");
                        try {
                            switch (choice) {
                                case 1: {
                                    System.out.println("Welcome!");
                                    System.out.println("");

                                    System.out.println("Enter your name: ");
                                    String name = sc.next();
                                    System.out.println("");

                                    System.out.println("Enter your hourly pay rate: ");
                                    double payRate = sc.nextDouble();
                                    System.out.println("");

                                    System.out.println("Enter hours worked: ");
//                                    int hoursWorked = sc.nextInt();
                                    double hoursWorked = sc.nextDouble();
                                    System.out.println("");

                                    foodBank.addEmployee(name, hoursWorked, payRate);

                                    Employee emp = new Employee(name, hoursWorked, payRate);
                                    double weeklyPay = emp.calculateWeeklyPay(hoursWorked, payRate);
                                    System.out.println(name + " your pay for the week is $" + weeklyPay + ".");
                                    System.out.println("");
                                    break;
                                }
                                case 2: {
                                    System.out.println("Welcome volunteer!");

                                    System.out.println("Enter your name: ");
                                    String name = sc.next();
                                    System.out.println("");

                                    System.out.println("Enter hours worked ");
                                    double hoursWorked = sc.nextDouble();
                                    System.out.println("");

                                    foodBank.addVolunteer(name, hoursWorked);

                                    System.out.println("Thank you " + name + " for the " + hoursWorked + " hours volunteered this week!");
                                    System.out.println("");
                                    break;
                                }
                                case 3: {
                                    System.out.println("Welcome donor!");

                                    System.out.println("Enter your name: ");
                                    String name = sc.next();

                                    sc.nextLine();

                                    System.out.println("Enter name of item donated: ");
                                    String foodName = sc.nextLine();

                                    System.out.println("Enter amount of " + foodName + " donated: ");
                                    int itemsDonated = sc.nextInt();

                                    System.out.println("Is the item perishable? Enter Y or N");
                                    char letter = sc.next().charAt(0);

                                    if (letter == 'Y' || letter == 'y') {
                                        System.out.println("How many days before the item expires?");
                                        int expTime = sc.nextInt();
                                       
                                        foodBank.addPerishable(foodName, itemsDonated, expTime);
                                        foodBank.addDonor(name, itemsDonated, foodName, expTime);

                                    } else if (letter == 'N' || letter == 'n') {
                                        foodBank.addNonPerishable(foodName, itemsDonated);
                                    }
                                    
                                    foodBank.addDonorNP(name, itemsDonated, foodName);

                                    if (itemsDonated > 1) {
                                        System.out.println("Thank you " + name + " for the " + itemsDonated + " " 
                                                + foodName + "s donated this week!");
                                    } else if (itemsDonated == 1) {
                                        System.out.println("Thank you " + name + " for the " + itemsDonated + " " 
                                                + foodName + " donated this week!");
                                    }

                                    break;
                                } case 4:
                                    //Go back to main menu option
                                    break;

                                default:
                                    System.out.println("Sorry, but you need to enter a 1, 2, 3, or 4");

                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("Sorry, but that wasn't a number.");

                        }
                        break;
// end of case 1
                    case 2:
                        System.out.println("\nFood item information, choose from the following:");
                        System.out.println("1)Donate 2)Print Perishables 3)Print Non-Perishables 4)Print all food in stock 5)Main Menu");
                        int choice2 = sc.nextInt();
                        try {
                            switch (choice2) {
                                case 1: {
                                    System.out.println("Would you like to donate 1)Perishables or 2)Non-Perishables?");
                                    int num2 = sc.nextInt();
                                    try {
                                        switch (num2) {
                                            case 1: {
                                                System.out.println("\nAdd Perishable(s)");

                                                System.out.println("Enter food item: ");
                                                String name2 = sc.next();

                                                System.out.println("Enter amount of item: ");
                                                int amount = sc.nextInt();

                                                System.out.println("Enter amount of days before expiration: ");
                                                int expTime = sc.nextInt();
                                                System.out.println("");
                                                
                                                foodBank.addPerishable(name2, amount, expTime);

                                                break;
                                            }
                                            case 2: {
                                                System.out.println("\nAdd non-perishable(s)");

                                                System.out.println("Enter food item: ");
                                                String name9 = sc.next();

                                                System.out.println("Enter amount of item: ");
                                                int amount = sc.nextInt();
                                                foodBank.addNonPerishable(name9, amount);
                                                System.out.println("");
                                                
                                                break;
                                            }default:
                                                System.out.println("Sorry, but you need to enter a number 1 or 2");
                                        }
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Sorry, but that wasn't a number.");
                                    }
                                    break;
                                }

                                case 2: {
                                    System.out.println("");
                                    foodBank.getPerishables();
                                    

                                    break;
                                }
                                case 3: {
                                    System.out.println("");
                                    foodBank.getNonPerishables();
                                    System.out.println("");

                                    break;
                                }
                                case 4: {
                                    System.out.println("");
                                    foodBank.displayAllFood();
                                    System.out.println("");

                                    break;
                                }
                                case 5:
                                    //Go back to Main Menu
                                    System.out.println("");
                                    break;
                                default:
                                    System.out.println("Sorry, but you need to enter a number 1-5");;

                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("Sorry, but that wasn't a number.");

                        }

                        break;
//end of case 2
                    case 3:
                        System.out.println("\nDisplay User Information.");
                        System.out.println("Enter number 1)Print Employees 2)Print Donors 3)Print Volunteers 4)Print All Users 5)Main Menu");
                        int choice3 = sc.nextInt();
                        System.out.println("");
                        try {
                            switch (choice3) {
                                case 1:
                                    System.out.println("Employees:");
                                    foodBank.getEmployees();
                                    break;

                                case 2:
                                    System.out.println("Donors:");
                                    foodBank.getDonors();
                                    break;

                                case 3:
                                    System.out.print("Volunteers:");
                                    foodBank.getVolunteers();
                                    break;

                                case 4:
                                    System.out.println("****All Users****");
                                    foodBank.displayAllUsers();
                                    break;

                                case 5:
                                    //Go back to main menu option
                                    break;
                                    
                                default:
                                    System.out.println("Sorry, but you need to enter a number 1-5");

                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("Sorry, but that wasn't a number.");
                        }
                        break;

//end of case 3
                    case 4:
                        System.out.println("Time passes.......");
                        Thread.sleep(1500);
                        foodBank.simulateTime();
                        System.out.println("");
                        break;

                    case 5:
                        System.out.println("\nChecking expired Items...");
                        foodBank.isExpired();

                        break;

                    case 6:
                        System.out.println("Removing expired Items");
                        foodBank.removeExpired();
                        break;

                    case 7:
                        end = true;
                        System.out.println("Have a good day!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Sorry, but that wasn't a number.");
                end = true;
            }

        } // end while
        
    }// end main

} // end class
