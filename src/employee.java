import java.io.Serializable;

public class employee implements Serializable {
    private int employeeId;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private int dayOfStart;
    private int monthOfStart;
    private int yearOfStart;
    private double yearsService;
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private char sex;
    private String phoneNumber;
    private String title;
    private double numberOfHours;
    private double sickTime;
    private String firstName;
    private String lastName;
    private double hourlyPay;

    public employee(int employeeId, int dayOfBirth, int monthOfBirth, int yearOfBirth, int dayOfStart, int monthOfStart, int yearOfStart,
                    String streetAddress, String city, String state, int zipCode, char sex, String phoneNumber, String title, String firstName, String lastName, double hourlyPay) {
        this.employeeId = employeeId;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.dayOfStart = dayOfStart;
        this.monthOfStart = monthOfStart;
        this.yearOfStart = yearOfStart;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyPay = hourlyPay;
        this.numberOfHours = 0;
        this.sickTime = 0;
        this.yearsService = 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getDayOfStart() {
        return dayOfStart;
    }

    public void setDayOfStart(int dayOfStart) {
        this.dayOfStart = dayOfStart;
    }

    public int getMonthOfStart() {
        return monthOfStart;
    }

    public void setMonthOfStart(int monthOfStart) {
        this.monthOfStart = monthOfStart;
    }

    public int getYearOfStart() {
        return yearOfStart;
    }

    public void setYearOfStart(int yearOfStart) {
        this.yearOfStart = yearOfStart;
    }

    public double getYearsService() {
        return yearsService;
    }

    public void setYearsService(double yearsService) {
        this.yearsService = yearsService;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(double numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public double getSickTime() {
        return sickTime;
    }

    public void setSickTime(double sickTime) {
        this.sickTime = sickTime;
    }

    public employee() {
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public double getVacationTime() {return 0;}

    public void setVacationTime() {}

    public double getPersonalTime() {return 0;};

    public void setPersonalTime(double personalTime) {};

    public boolean isReceivesHealth() {return false;}

    public void setReceivesHealth(boolean receivesHealth) {};

    public boolean isReceivesRetirement() {return false;}

    public boolean isOverTimeEligible() {return true;}

    public void addSick() {}

    public void addVacation() {};

    public double totalPay() {return 0;};

}
