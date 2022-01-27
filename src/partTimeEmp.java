public class partTimeEmp extends employee{

    public partTimeEmp(int employeeId, int dayOfBirth, int monthOfBirth, int yearOfBirth, int dayOfStart, int monthOfStart, int yearOfStart, String streetAddress, String city, String state, int zipCode, char sex, String phoneNumber, String title, String firstName, String lastName, double hourlyPay) {
        super(employeeId, dayOfBirth, monthOfBirth, yearOfBirth, dayOfStart, monthOfStart, yearOfStart, streetAddress, city, state, zipCode, sex, phoneNumber, title, firstName, lastName, hourlyPay);
    }

       public void addSick(){
        double sickTime = this.getSickTime();
        this.setSickTime(sickTime + 2);
    }

    @Override
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
