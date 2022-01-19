public class partTimeEmp extends employee{
    private double hourlyPay;

    public partTimeEmp(int employeeId, int dayOfBirth, int monthOfBirth, int yearOfBirth, int dayOfStart, int monthOfStart, int yearOfStart, String streetAddress, String city, String state, int zipCode, char sex, int phoneNumber, String title, String firstName, String lastName, double hourlyPay) {
        super(employeeId, dayOfBirth, monthOfBirth, yearOfBirth, dayOfStart, monthOfStart, yearOfStart, streetAddress, city, state, zipCode, sex, phoneNumber, title, firstName, lastName);
        this.hourlyPay = hourlyPay;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public void addSick(){
        double sickTime = this.getSickTime();
        this.setSickTime(sickTime + 2);
    }

    public double totalPay() {
        if (this.getNumberOfHours() <= 40) {
            return this.getNumberOfHours() * this.getHourlyPay();
        }
        else {
            double overTime = this.getNumberOfHours() - 40;
            double OTpay = this.getHourlyPay() * 1.5;
            return (overTime * OTpay) + (this.getNumberOfHours() * this.getHourlyPay());
        }
    }
}
