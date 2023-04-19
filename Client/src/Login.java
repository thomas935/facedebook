import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.HashMap;

public class Login extends JFrame{
    JPanel panel1;
    private JTextField UsernameText;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JLabel UserName;
    private JLabel PassWord;
    private String username;
    private String password;
    private PrintWriter out;


public Login(String windowLogin, PrintWriter out) {
    // create a frame and get username and password
    JFrame frame = new JFrame(windowLogin);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
    frame.setContentPane(panel1);
    this.out = out;

    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            out.println("connexion"+ UsernameText.getText());
            out.println("connexion"+passwordField1.getText());
            UsernameText.setText("");
            passwordField1.setText("");
        }
    });

}


    public HashMap<String, String> getData() {
        HashMap<String, String> loginInfo = new HashMap<String, String>();
        loginInfo.put("username", username);
        loginInfo.put("password", password);

        return loginInfo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
