import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainScreen {
    public static void main(String[] args){
        JFrame login = new JFrame("Login");
        login.setBounds(50, 50, 300, 150);
        login.setLayout(new GridLayout(3,2, 10, 10));
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel user = new JLabel("Username: ");
        login.add(user);
        JTextField userName = new JTextField();
        login.add(userName);

        JLabel password = new JLabel("Password: ");
        login.add(password);
        JPasswordField pass = new JPasswordField();
        login.add(pass);

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkUserName(userName.getText(), pass.getPassword()) == 0){
                       login.setVisible(false);
                }
            }
        });
        login.add(submit);
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        login.add(cancel);
        login.setVisible(true);
    }

    public static int checkUserName(String userName, char[] password) {
        char[] userPass = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        if (Objects.equals(userName, "admin")){
            boolean passMatch = false;
            for (int i = 0; i < password.length; i++){
                if (userPass[i] != password[i]){
                    break;
                }
                else if (i == password.length - 1){
                    passMatch = true;
                }
            }
            JFrame jFrame = new JFrame();
            if (passMatch) {
                HomeScreen.main();
                return 0;
            }
            else {
                JOptionPane.showMessageDialog(jFrame,"Incorrect Password.");
            }
        }
        else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame,"Incorrect Username");
        }
        return 1;
    }
}

