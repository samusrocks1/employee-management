public class fullTime extends employee{
    private double hourlyPay;
    private double vacationTime;
    private double personalTime;
    private boolean receivesHealth;
    private boolean receivesRetirement;
    private boolean overTimeEligible;

    public fullTime(int employeeId, int dayOfBirth, int monthOfBirth, int yearOfBirth, int dayOfStart, int monthOfStart, int yearOfStart, String streetAddress, String city, String state, int zipCode, char sex, int phoneNumber, String title, String firstName, String lastName, double hourlyPay, double vacationTime, double personalTime, boolean receivesHealth, boolean receivesInsurance, boolean overTimeEligible) {
        super(employeeId, dayOfBirth, monthOfBirth, yearOfBirth, dayOfStart, monthOfStart, yearOfStart, streetAddress, city, state, zipCode, sex, phoneNumber, title, firstName, lastName);
        this.hourlyPay = hourlyPay;
        this.vacationTime = vacationTime;
        this.personalTime = personalTime;
        this.receivesHealth = receivesHealth;
        this.receivesRetirement = receivesInsurance;
        this.overTimeEligible = overTimeEligible;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public double getVacationTime() {
        return vacationTime;
    }

    public void setVacationTime(double vacationTime) {
        this.vacationTime = vacationTime;
    }

    public double getPersonalTime() {
        return personalTime;
    }

    public void setPersonalTime(double personalTime) {
        this.personalTime = personalTime;
    }

    public boolean isReceivesHealth() {
        return receivesHealth;
    }

    public void setReceivesHealth(boolean receivesHealth) {
        this.receivesHealth = receivesHealth;
    }

    public boolean isReceivesRetirement() {
        return receivesRetirement;
    }

    public void setReceivesRetirement(boolean receivesInsurance) {
        this.receivesRetirement = receivesInsurance;
    }

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
