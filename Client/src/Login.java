import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.HashMap;

public class Login extends JFrame {
    JPanel panel1;
    private JTextField UsernameText;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JLabel UserName;
    private JLabel PassWord;
    private JButton databaseButton;
    private PrintWriter out;


    public Login(String windowLogin, PrintWriter out) {
        // create a frame and get username and password
        JFrame frame = new JFrame(windowLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setContentPane(panel1);
        this.out = out;

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.println("connexion "+UsernameText.getText()+" "+passwordField1.getText());
                UsernameText.setText("");
                passwordField1.setText("");
            }
        });

    }
}

