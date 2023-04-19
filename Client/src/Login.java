import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login extends JFrame{
    JPanel panel1;
    private JTextField UsernameText;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JLabel UserName;
    private JLabel PassWord;
    String username;
    String password;


public Login(String windowLogin) {
    // create a frame and get username and password
    JFrame frame = new JFrame(windowLogin);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
    frame.setContentPane(panel1);


    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             username = UsernameText.getText();
             password = passwordField1.getText();
             getData();
        }
    });

}


    public HashMap<String, String> getData() {
        HashMap<String, String> loginInfo = new HashMap<String, String>();
        loginInfo.put("username", username);
        loginInfo.put("password", password);
        System.out.println(loginInfo);
        return loginInfo;
    }
}
