import javax.swing.*;

public class messagerieFacedeBook extends JFrame {
    private JPanel panel1;
    private JTextField textField1;

    public messagerieFacedeBook() {
        // create a frame and get username and password
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setContentPane(panel1);

    }
}

