package foodbanksystem;

/**
 *
 * @author Robert Beckham
 */
public class Volunteer extends User {

    private double hoursWorked;

    /**
     *
     * @param name volunteers name
     * @param hoursWorked hours worked for the week
     */
    public Volunteer(String name, double hoursWorked) {
        super(name);
        this.hoursWorked = hoursWorked;
    }

    /**
     *
     * @param hoursWorked sets hours volunteered a week
     */
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     *
     * @return gets amount of hours volunteered weekly
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return userName + "\nHours Worked: " + hoursWorked; //To change body of generated methods, choose Tools | Templates.
    }
}

