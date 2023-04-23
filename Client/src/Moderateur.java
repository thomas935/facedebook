import javax.swing.*;

public class Moderateur extends JFrame{
    private JPanel Panel1;
    private JButton BOUTONBAN10;
    private JButton BOUTONBAN9;
    private JButton BOUTONBAN8;
    private JButton BOUTONBAN7;
    private JButton BOUTONBAN6;
    private JButton BOUTONBAN5;
    private JButton BOUTONBAN4;
    private JButton BOUTONBAN3;
    private JButton BOUTONBAN2;
    private JButton BOUTONBAN1;
    private JButton BOUTONBAN0;
    private JButton BOUTONBAN11;
    private JButton BOUTONBAN12;
    private JButton BOUTONBAN13;

    public Moderateur(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setContentPane(Panel1);
    }
}
