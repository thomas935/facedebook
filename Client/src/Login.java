import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import java.util.HashMap;

public class Login extends JFrame {
    JPanel panel1;
    private JTextField UsernameText;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton databaseButton;
    private PrintWriter out;


    public Login(String windowLogin, PrintWriter out) {
        // create a frame and get username and password
        JFrame frame = new JFrame(windowLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
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

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                out.println("exit");
            }
        });


    }
}

