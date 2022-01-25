import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class AddEmployee {
    public static void newEmployee(){
        ArrayList<employee> employees = new ArrayList<>();

        // Reads the file where the employee data is stored.
        try{
            FileInputStream readData = new FileInputStream("employeedata.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            ArrayList<employee> employees2 = (ArrayList<employee>) readStream.readObject();
            readStream.close();
            employees.addAll(employees2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Creates the frame for the page to add employees.
        JFrame addEmployee = new JFrame("Add Employee, ID #: " + (employees.size() + 1));
        addEmployee.setBounds(25, 25, 900, 450);
        addEmployee.setLayout(new BorderLayout());

        // Menu bar including return to home screen, log out, and exit.
        JMenuBar mainMenu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem returnHome = new JMenuItem("Return to home screen");
        returnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeScreen.main();
                addEmployee.setVisible(false);
            }
        });
        file.add(returnHome);
        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen.main(new String[] {});
            }
        });
        file.add(logout);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainMenu.add(file);
        file.add(exit);
        addEmployee.add(mainMenu, BorderLayout.NORTH);

        // Panel for the form to add employee information.
        JPanel empForm = new JPanel();
        empForm.setLayout(new GridLayout(10,2));

        // Employee name
        JLabel firstName = new JLabel(" First Name: ");
        empForm.add(firstName);
        JTextField primaryName = new JTextField();
        empForm.add(primaryName);
        JLabel lastName = new JLabel(" Last Name: ");
        empForm.add(lastName);
        JTextField surName = new JTextField();
        empForm.add(surName);

        // Employee Date of Birth
        JPanel dob = new JPanel();
        dob.setLayout(new FlowLayout());
        empForm.add(dob);
        JLabel birthday = new JLabel("Date of birth (MM/DD/YY): ");
        JLabel format = new JLabel("/");
        JLabel format1 = new JLabel("/");
        JTextField day = new JTextField(2);
        JTextField month = new JTextField(2);
        JTextField year = new JTextField(2);
        dob.add(birthday);
        dob.add(month);
        dob.add(format);
        dob.add(day);
        dob.add(format1);
        dob.add(year);

        // Employee Gender
        JPanel sex = new JPanel();
        JLabel gender = new JLabel("Gender: ");
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other/Decline", true);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        sex.add(gender);
        sex.add(male);
        sex.add(female);
        sex.add(other);
        empForm.add(sex);

        // Employee Address
        JLabel address = new JLabel(" Street Address: ");
        empForm.add(address);
        JTextField streetAddress = new JTextField(60);
        empForm.add(streetAddress);
        JLabel city = new JLabel(" City:");
        empForm.add(city);
        JTextField theCity = new JTextField(60);
        empForm.add(theCity);
        JPanel stateZip = new JPanel(new FlowLayout());
        JLabel state = new JLabel("State: ");
        stateZip.add(state);
        JTextField theState = new JTextField(2);
        stateZip.add(theState);
        JLabel zip = new JLabel("Zip Code: ");
        stateZip.add(zip);
        JTextField zipCode = new JTextField(5);
        stateZip.add(zipCode);
        empForm.add(stateZip);

        // Employee Phone Number
        JPanel phone = new JPanel();
        JLabel phoneNum = new JLabel("Phone number: ");
        phone.add(phoneNum);
        JTextField phoneNumber = new JTextField(10);
        phone.add(phoneNumber);
        empForm.add(phone);

        // Employee status and job title
        JPanel ft = new JPanel();
        JLabel status = new JLabel("Employment Status ");
        ft.add(status);
        JRadioButton partTime = new JRadioButton("Part Time", true);
        JRadioButton fullTime = new JRadioButton("Full Time");
        ButtonGroup ptft = new ButtonGroup();
        ft.add(partTime);
        ft.add(fullTime);
        ptft.add(partTime);
        ptft.add(fullTime);
        empForm.add(ft);
        JPanel titleJob = new JPanel();
        JLabel title = new JLabel(" Job Title: ");
        titleJob.add(title);
        JTextField jobTitle = new JTextField(30);
        titleJob.add(jobTitle);
        empForm.add(titleJob);

        // Employee Start Date
        JPanel startDate = new JPanel();
        dob.setLayout(new FlowLayout());
        empForm.add(startDate);
        JLabel starting = new JLabel("Start Date (MM/DD/YY): ");
        JLabel format2 = new JLabel("/");
        JLabel format3 = new JLabel("/");
        JTextField dayStart = new JTextField(2);
        JTextField monthStart = new JTextField(2);
        JTextField yearStart = new JTextField(2);
        startDate.add(starting);
        startDate.add(monthStart);
        startDate.add(format2);
        startDate.add(dayStart);
        startDate.add(format3);
        startDate.add(yearStart);

        // Employee pay
        JPanel pay = new JPanel();
        JLabel payLabel = new JLabel("Pay rate: ");
        pay.add(payLabel);
        JTextField payRate = new JTextField(8);
        pay.add(payRate);
        empForm.add(pay);

        //Employee health
        JPanel receivesHealth = new JPanel();
        JLabel health = new JLabel("Receives health insurance: ");
        JRadioButton healthNo = new JRadioButton("No", true);
        JRadioButton healthYes = new JRadioButton("Yes");
        ButtonGroup healthYesNo = new ButtonGroup();
        healthYesNo.add(healthNo);
        healthYesNo.add(healthYes);
        receivesHealth.add(health);
        receivesHealth.add(healthNo);
        receivesHealth.add(healthYes);
        empForm.add(receivesHealth);

        //Employee retirement
        JPanel receivesRetirement = new JPanel();
        JLabel Retirement = new JLabel("Receives retirement: ");
        JRadioButton RetirementNo = new JRadioButton("No", true);
        JRadioButton RetirementYes = new JRadioButton("Yes");
        ButtonGroup RetirementYesNo = new ButtonGroup();
        RetirementYesNo.add(RetirementNo);
        RetirementYesNo.add(RetirementYes);
        receivesRetirement.add(Retirement);
        receivesRetirement.add(RetirementNo);
        receivesRetirement.add(RetirementYes);
        empForm.add(receivesRetirement);

        // Employee over time.
        JPanel ot = new JPanel();
        JLabel otLabel = new JLabel("Overtime eligible: ");
        JRadioButton otNo = new JRadioButton("No", true);
        JRadioButton otYes = new JRadioButton("Yes");
        ButtonGroup otYesNo = new ButtonGroup();
        otYesNo.add(otNo);
        otYesNo.add(otYes);
        ot.add(otLabel);
        ot.add(otNo);
        ot.add(otYes);
        empForm.add(ot);

        // Submit button
        JButton submit = new JButton("Submit new employee");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char gender;
                if (Objects.equals(genderGroup.getSelection().getActionCommand(), "Male")){
                    gender = 'M';
                }
                else if (Objects.equals(genderGroup.getSelection().getActionCommand(), "Female")) {
                    gender = 'F';
                }
                else {
                    gender = 'X';
                }
                if (ptft.getSelection().getActionCommand().equals("Full Time")){
                    boolean health;
                    boolean retirement;
                    boolean ot;
                    if (Objects.equals(healthYesNo.getSelection().getActionCommand(), "Yes")){
                        health = true;
                    }
                    else{
                        health = false;
                    }
                    if (Objects.equals(RetirementYesNo.getSelection().getActionCommand(), "Yes")) {
                        retirement = true;
                    }
                    else {
                        retirement = false;
                    }
                    if (Objects.equals(otYesNo.getSelection().getActionCommand(), "Yes")){
                        ot = true;
                    }
                    else {
                        ot = false;
                    }
                    employees.add(new fullTime(employees.size() + 1,
                            Integer.parseInt(day.getText()),
                            Integer.parseInt(month.getText()),
                            Integer.parseInt(year.getText()),
                            Integer.parseInt(dayStart.getText()),
                            Integer.parseInt(monthStart.getText()),
                            Integer.parseInt(yearStart.getText()),
                            streetAddress.getText(),
                            theCity.getText(),
                            theState.getText(),
                            Integer.parseInt(zipCode.getText()),
                            gender,
                            phoneNumber.getText(),
                            jobTitle.getText(),
                            primaryName.getText(),
                            surName.getText(),
                            Double.parseDouble(payRate.getText()),
                            health,
                            retirement,
                            ot
                    ));
                }
                else {
                    employees.add(new partTimeEmp(employees.size() + 1,
                            Integer.parseInt(day.getText()),
                            Integer.parseInt(month.getText()),
                            Integer.parseInt(year.getText()),
                            Integer.parseInt(dayStart.getText()),
                            Integer.parseInt(monthStart.getText()),
                            Integer.parseInt(yearStart.getText()),
                            streetAddress.getText(),
                            theCity.getText(),
                            theState.getText(),
                            Integer.parseInt(zipCode.getText()),
                            gender,
                            phoneNumber.getText(),
                            jobTitle.getText(),
                            primaryName.getText(),
                            surName.getText(),
                            Double.parseDouble(payRate.getText())));
                }
                try{
                    FileOutputStream writeData = new FileOutputStream("employeedata.ser");
                    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

                    writeStream.writeObject(employees);
                    writeStream.flush();
                    writeStream.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                HomeScreen.main();
                addEmployee.setVisible(false);
            }
        });
        addEmployee.add(submit, BorderLayout.SOUTH);

        addEmployee.add(empForm, BorderLayout.CENTER);
        addEmployee.setVisible(true);
        addEmployee.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
