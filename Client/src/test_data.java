import javax.swing.*;
import java.awt.*;

public class test_data {
    private JPanel panel1;
    private JTable table1;

    public static void main(String[] args) {
        final JFrame frame = new JFrame("JTable Demo");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setContentPane(new test_data().panel1);
    }
}
