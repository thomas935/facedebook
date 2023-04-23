import javax.swing.*;

public class Moderateur extends JFrame{
    private JButton BANNIRButton;
    private JLabel PSEUDO0;
    private JLabel PSEUDO1;
    private JLabel PSEUDO2;
    private JLabel PSEUDO3;
    private JLabel PSEUDO4;
    private JLabel PSEUDO5;
    private JLabel PSEUDO6;
    private JLabel PSEUDO7;
    private JPanel Panel1;

    public Moderateur(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setContentPane(Panel1);
    }
}
