import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class ViewEmployee {
    private static ArrayList<employee> employees = new ArrayList<>();
    private static JPanel empDetail = new JPanel();
    public static void main() {
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
        searchEmployeeScreen();
    }

    private static void searchEmployeeScreen() {
        JFrame searchScreen = new JFrame("View employee");
        searchScreen.setLayout(new BorderLayout());
        searchScreen.setBounds(25, 25, 500, 700);

        JMenuBar mainMenu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem returnHome = new JMenuItem("Return to home screen");
        returnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeScreen.main();
                searchScreen.setVisible(false);
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
        searchScreen.add(mainMenu, BorderLayout.NORTH);
        JPanel centerContainer = new JPanel(new GridLayout(1, 2));
        searchScreen.add(centerContainer, BorderLayout.CENTER);

        JTabbedPane employeeSearch = new JTabbedPane();
        centerContainer.add(employeeSearch);
        JPanel searchPane = new JPanel(new GridLayout(employees.size(), 2));
        employeeSearch.addTab("Search", searchPane);
        JTextField searchField = new JTextField();
        searchPane.add(searchField);
        JButton submitSearch = new JButton("Search");
        submitSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<employee> searched = searchEmp(searchField.getText());
                searchPane.removeAll();
                searchPane.add(searchField);
                searchPane.add(submitSearch);
                for (int index = 0; index < searched.size(); index ++) {
                    JLabel empName = new JLabel(searched.get(index).getFirstName() + " " + searched.get(index).getLastName() + " ID #: " + searched.get(index).getEmployeeId());
                    JButton viewEmp = new JButton("More Details");
                    int finalIndex = index;
                    viewEmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            empInfoView(searched.get(finalIndex));
                        }
                    });
                    searchPane.add(empName);
                    searchPane.add(viewEmp);
                }
                searchPane.revalidate();
                searchPane.repaint();
            }
        });
        searchPane.add(submitSearch);

        JScrollPane allPane = new JScrollPane();
        JPanel employeesPane = new JPanel(new GridLayout(employees.size(), 2, 0, 5));
        for (int index = 0; index < employees.size(); index ++) {
            JLabel empName = new JLabel(employees.get(index).getFirstName() + " " + employees.get(index).getLastName() + " ID #: " + employees.get(index).getEmployeeId());
            JButton viewEmp = new JButton("More Details");
            int finalIndex = index;
            viewEmp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    empInfoView(employees.get(finalIndex));
                }
            });
            employeesPane.add(empName);
            employeesPane.add(viewEmp);
        }
        allPane.setViewportView(employeesPane);
        allPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        employeeSearch.addTab("View all", allPane);

        JPanel employeeInformation = new JPanel();
        employeeInformation.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        centerContainer.add(empDetail);
        empDetail.setVisible(true);

        searchScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        searchScreen.setVisible(true);
    }

    private static void empInfoView(employee emp){
        empDetail.removeAll();
        empDetail.setLayout(new GridLayout(20, 2));
        ArrayList<JLabel> labels = new ArrayList<>();
        labels.add(new JLabel("Name: " + emp.getFirstName() + " " + emp.getLastName()));
        labels.add(new JLabel("Date of birth: " + emp.getMonthOfBirth() + "\\" + emp.getDayOfBirth() + "\\" + emp.getYearOfBirth()));
        labels.add(new JLabel("Gender: " + emp.getSex()));
        labels.add(new JLabel(emp.getStreetAddress() + ", " + emp.getCity() + ", " + emp.getState() + " " + emp.getZipCode()));
        labels.add(new JLabel("Phone number: " + emp.getPhoneNumber()));
        //labels.add(new JLabel("Employee number: ", emp.getEmployeeId()));
        labels.add(new JLabel("Employee Title: " + emp.getTitle()));
        labels.add(new JLabel("Start date: " + emp.getMonthOfStart() + "\\" + emp.getDayOfStart() + "\\" + emp.getYearOfStart()));
        labels.add(new JLabel("Years of service: " + emp.getYearsService()));
        labels.add(new JLabel("Hourly pay: " + emp.getHourlyPay()));
        labels.add(new JLabel("Hours of sick time: " + emp.getSickTime()));
        labels.add(new JLabel("Hours of personal time: " + emp.getPersonalTime()));
        labels.add(new JLabel("Hours of vacation time: " + emp.getVacationTime()));
        labels.add(new JLabel("Receives health insurance: " + emp.isReceivesHealth()));
        labels.add(new JLabel("Receives retirement: " + emp.isReceivesRetirement()));
        labels.add(new JLabel("Overtime eligible: " + emp.isOverTimeEligible()));
        for (int index = 0; index < labels.size(); index++){
            empDetail.add(labels.get(index));
        }
        empDetail.revalidate();
        empDetail.repaint();
    }

    private static ArrayList<employee> searchEmp (String name) {
        ArrayList<employee> searched = new ArrayList<>();
        String[] searchItem = name.split(" ");
        searchItem[0].toLowerCase(Locale.ROOT);
        searchItem[1].toLowerCase(Locale.ROOT);
        for (int index = 0; index < employees.size(); index ++) {
            if (Objects.equals(employees.get(index).getFirstName().toLowerCase(Locale.ROOT), searchItem[0]) || Objects.equals(employees.get(index).getLastName().toLowerCase(Locale.ROOT), searchItem[1])) {
                searched.add(employees.get(index));
            }
        }
        return searched;
    }
}
