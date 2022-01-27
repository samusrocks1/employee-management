import java.io.Serializable;

public class fullTime extends employee implements Serializable {
    private double vacationTime;
    private double personalTime;
    private boolean receivesHealth;
    private boolean receivesRetirement;
    private boolean overTimeEligible;

    public fullTime(int employeeId, int dayOfBirth, int monthOfBirth, int yearOfBirth, int dayOfStart,
                    int monthOfStart, int yearOfStart, String streetAddress, String city, String state,
                    int zipCode, char sex, String phoneNumber, String title, String firstName, String lastName,
                    double hourlyPay, boolean receivesHealth,
                    boolean receivesRetirement, boolean overTimeEligible) {
        super(employeeId, dayOfBirth, monthOfBirth, yearOfBirth, dayOfStart, monthOfStart, yearOfStart, streetAddress, city, state, zipCode, sex, phoneNumber, title, firstName, lastName, hourlyPay);
        this.vacationTime = 0;
        this.personalTime = 0;
        this.receivesHealth = receivesHealth;
        this.receivesRetirement = receivesRetirement;
        this.overTimeEligible = overTimeEligible;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double getVacationTime() {
        return vacationTime;
    }

    public void setVacationTime(double vacationTime) {
        this.vacationTime = vacationTime;
    }

    @Override
    public double getPersonalTime() {
        return personalTime;
    }

    @Override
    public void setPersonalTime(double personalTime) {
        this.personalTime = personalTime;
    }

    @Override
    public boolean isReceivesHealth() {
        return receivesHealth;
    }

    @Override
    public void setReceivesHealth(boolean receivesHealth) {
        this.receivesHealth = receivesHealth;
    }

    @Override
    public boolean isReceivesRetirement() {
        return receivesRetirement;
    }

    public void setReceivesRetirement(boolean receivesInsurance) {
        this.receivesRetirement = receivesInsurance;
    }

    @Override
    public boolean isOverTimeEligible() {
        return overTimeEligible;
    }

    public void setOverTimeEligible(boolean overTimeEligible) {
        this.overTimeEligible = overTimeEligible;
    }

    public void addSick(){
        double sickTime = this.getSickTime();
        this.setSickTime(sickTime + 4);
    }

    public void addVacation() {
        setVacationTime(this.getVacationTime() + 4);
    }

    @Override
    public double totalPay() {
        if (this.isOverTimeEligible()) {
            if (this.getNumberOfHours() <= 40){
                return this.getNumberOfHours() * this.getHourlyPay();
            }
            else {
                double overtime = this.getNumberOfHours() - 40;
                return (this.getHourlyPay() * 40) + (overtime * (this.getHourlyPay() * 1.5));
            }
        }
        else {
            return this.getHourlyPay() * 40;
        }
    }
}
