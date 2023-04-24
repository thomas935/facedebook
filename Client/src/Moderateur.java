import javax.swing.*;
import java.io.PrintWriter;

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

    public Moderateur(PrintWriter out, String Username, String Password){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setContentPane(Panel1);

        BOUTONBAN0.addActionListener(e -> out.println("bannir "+"1"+" "+Username+" "+Password));
        BOUTONBAN1.addActionListener(e -> out.println("bannir "+"2"+" "+Username+" "+Password));
        BOUTONBAN2.addActionListener(e -> out.println("bannir "+"3"+" "+Username+" "+Password));
        BOUTONBAN3.addActionListener(e -> out.println("bannir "+"4"+" "+Username+" "+Password));
        BOUTONBAN4.addActionListener(e -> out.println("bannir "+"5"+" "+Username+" "+Password));
        BOUTONBAN5.addActionListener(e -> out.println("bannir "+"6"+" "+Username+" "+Password));
        BOUTONBAN6.addActionListener(e -> out.println("bannir "+"7"+" "+Username+" "+Password));
        BOUTONBAN7.addActionListener(e -> out.println("bannir "+"8"+" "+Username+" "+Password));
        BOUTONBAN8.addActionListener(e -> out.println("bannir "+"9"+" "+Username+" "+Password));
        BOUTONBAN9.addActionListener(e -> out.println("bannir "+"10"+" "+Username+" "+Password));
        BOUTONBAN10.addActionListener(e -> out.println("bannir "+"11"+" "+Username+" "+Password));
        BOUTONBAN11.addActionListener(e -> out.println("bannir "+"12"+" "+Username+" "+Password));
        BOUTONBAN12.addActionListener(e -> out.println("bannir "+"13"+" "+Username+" "+Password));
        BOUTONBAN13.addActionListener(e -> out.println("bannir "+"14"+" "+Username+" "+Password));

    }

}
