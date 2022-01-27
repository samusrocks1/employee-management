import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen {
    public static void main(){
        JFrame home = new JFrame("Employee Management");
        home.setBounds(25, 25, 500, 500);
        home.setLayout(new BorderLayout());

        // Menu bar components
        JMenuBar mainMenu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(e -> {
            MainScreen.main(new String[] {});
            home.setVisible(false);
        });
        file.add(logout);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        mainMenu.add(file);
        file.add(exit);
        home.add(mainMenu, BorderLayout.NORTH);


        // Employee Management System Operation Selection Screen
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,2,10,10));
        JButton viewEmployee = new JButton("Search for employee");
        viewEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewEmployee.main();
            }
        });

        mainPanel.add(viewEmployee);

        JButton addEmployee = new JButton("Add an employee");
        addEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployee.newEmployee();
                home.setVisible(false);
            }
        });
        mainPanel.add(addEmployee);

        JButton timeCard = new JButton("View Time Card");
        timeCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mainPanel.add(timeCard);

        JButton pto = new JButton("View Paid Time Off");
        pto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mainPanel.add(pto);

        JButton benefits = new JButton("View Benefits");
        benefits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mainPanel.add(benefits);

        home.add(mainPanel, BorderLayout.CENTER);
        home.setVisible(true);
        home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}