import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel panel1;
    private JTextField UsernameText;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JLabel UserName;
    private JLabel PassWord;
public Login() {
    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = UsernameText.getText();
            String password = passwordField1.getText();
            if (username.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(null, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed");
            }
        }
    });
}
}
