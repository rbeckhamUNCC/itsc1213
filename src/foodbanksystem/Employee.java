package foodbanksystem;

/**
 *
 * @author Robert Beckham
 */
public class Employee extends User {

    private double hoursWorked;
    private double payRate;
    private double weekPay; 

    /**
     *
     * @param name
     */
    public Employee(String name) {
        super(name);
    }

    /**
     *
     * @param name enter employee name
     * @param hoursWorked amount of hours worked
     * @param payRate rate per hour for employee
     *
     */
    public Employee(String name, double hoursWorked, double payRate) {
        super(name);
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
        this.weekPay = hoursWorked*payRate;
    }

    /**
     *
     * @param hoursWorked sets amount of hours worked a week
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     *
     * @param payRate gets hourly pay rate
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    /**
     *
     * @return gets hours worked for a week
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     *
     * @return gets employees pay rate per hour
     */
    public double getPayRate() {
        return payRate;
    }
    
    /**
     *
     * @return gets pay for a week
     */
    public double getweeklyPay() {
        return this.weekPay;
    }

    

    /**
     *
     * @param hoursWorked hours worked a week
     * @param payRate hourly pay rate
     * @return weekly pay with overtime calculated
     * 
     * calculate weeklyPay by passing in an integer for hours worked
     * pass in a double for the employees payRate
     * 
     * if hours worked are greater than 40 
     *  then weekly pay will equal the hoursWorked
     *  minus 40 then multiplied by the payRate multiplied by 1.5, this amount
     *  is then added to the product of 40 times payRate, 
     * return the calculated amount including overtime
     * 
     * else 
     *  the hoursWorked are less than 40
     *  multiply hoursWorked times payRate
     * return weeklyPay
     */
    public double calculateWeeklyPay(double hoursWorked, double payRate) {
        double weeklyPay;

        if (hoursWorked > 40) {
            weeklyPay = (hoursWorked - 40) * (payRate * 1.5) + (40 * payRate);

            return weeklyPay;
            
        } else {
            weeklyPay = hoursWorked * payRate;

            return weeklyPay;
        }
    }

    @Override
    public String toString() {
        return userName + "\nHours Worked: " + hoursWorked + "\nPay Rate: $" + 
                payRate + "\nEarned for the weeek: $" +
                calculateWeeklyPay(hoursWorked,payRate); 
    }
    
    
    
}
