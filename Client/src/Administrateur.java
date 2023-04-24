import javax.swing.*;
import java.io.PrintWriter;

public class Administrateur {
    private JButton BANNIRButton;
    private JButton BANNIRButton1;
    private JButton BANNIRButton2;
    private JButton BANNIRButton3;
    private JButton BANNIRButton4;
    private JButton BANNIRButton5;
    private JButton BANNIRButton6;
    private JButton BANNIRButton7;
    private JButton BANNIRButton8;
    private JButton BANNIRButton9;
    private JButton BANNIRButton10;
    private JButton BANNIRButton11;
    private JButton BANNIRButton12;
    private JButton BANNIRButton13;
    private JButton PROMOTIONButton0;
    private JButton PROMOTIONButton1;
    private JButton PROMOTIONButton2;
    private JButton PROMOTIONButton3;
    private JButton PROMOTIONButton4;
    private JButton PROMOTIONButton5;
    private JButton PROMOTIONButton6;
    private JButton PROMOTIONButton7;
    private JButton PROMOTIONButton8;
    private JButton PROMOTIONButton9;
    private JButton PROMOTIONButton10;
    private JButton PROMOTIONButton11;
    private JButton PROMOTIONButton12;
    private JButton PROMOTIONButton13;
    private JButton STATISTIQUESButton;
    private JLabel PSEUDO0;
    private JLabel PSEUDO1;
    private JLabel PSEUDO2;
    private JLabel PSEUDO3;
    private JLabel PSEUDO4;
    private JLabel PSEUDO5;
    private JLabel PSEUDO6;
    private JLabel PSEUDO7;
    private JLabel PSEUDO8;
    private JLabel PSEUDO9;
    private JLabel PSEUDO10;
    private JLabel PSEUDO11;
    private JLabel PSEUDO12;
    private JLabel PSEUDO13;
    private JPanel Panel1;


    public Administrateur(PrintWriter out,String Username, String Password){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setContentPane(Panel1);

        BANNIRButton.addActionListener(e -> out.println("bannir "+"1 "+ Username+" "+Password));
        BANNIRButton1.addActionListener(e -> out.println("bannir "+"2 "+ Username+" "+Password));
        BANNIRButton2.addActionListener(e -> out.println("bannir "+"3 "+ Username+" "+Password));
        BANNIRButton3.addActionListener(e -> out.println("bannir "+"4 "+ Username+" "+Password));
        BANNIRButton4.addActionListener(e -> out.println("bannir "+"5 "+ Username+" "+Password));
        BANNIRButton5.addActionListener(e -> out.println("bannir "+"6 "+ Username+" "+Password));
        BANNIRButton6.addActionListener(e -> out.println("bannir "+"7 "+ Username+" "+Password));
        BANNIRButton7.addActionListener(e -> out.println("bannir "+"8 "+ Username+" "+Password));
        BANNIRButton8.addActionListener(e -> out.println("bannir "+"9 "+ Username+" "+Password));
        BANNIRButton9.addActionListener(e -> out.println("bannir "+"10 "+ Username+" "+Password));
        BANNIRButton10.addActionListener(e -> out.println("bannir "+"11 "+ Username+" "+Password));
        BANNIRButton11.addActionListener(e -> out.println("bannir "+"12 "+ Username+" "+Password));
        BANNIRButton12.addActionListener(e -> out.println("bannir "+"13 "+ Username+" "+Password));
        BANNIRButton13.addActionListener(e -> out.println("bannir "+"14 "+ Username+" "+Password));


        PROMOTIONButton0.addActionListener(e -> out.println("promouvoir "+"1"));
        PROMOTIONButton1.addActionListener(e -> out.println("promouvoir "+"2"));
        PROMOTIONButton2.addActionListener(e -> out.println("promouvoir "+"3"));
        PROMOTIONButton3.addActionListener(e -> out.println("promouvoir "+"4"));
        PROMOTIONButton4.addActionListener(e -> out.println("promouvoir "+"5"));
        PROMOTIONButton5.addActionListener(e -> out.println("promouvoir "+"6"));
        PROMOTIONButton6.addActionListener(e -> out.println("promouvoir "+"7"));
        PROMOTIONButton7.addActionListener(e -> out.println("promouvoir "+"8"));
        PROMOTIONButton8.addActionListener(e -> out.println("promouvoir "+"9"));
        PROMOTIONButton9.addActionListener(e -> out.println("promouvoir "+"10"));
        PROMOTIONButton10.addActionListener(e -> out.println("promouvoir "+"11"));
        PROMOTIONButton11.addActionListener(e -> out.println("promouvoir "+"12"));
        PROMOTIONButton12.addActionListener(e -> out.println("promouvoir "+"13"));
        PROMOTIONButton13.addActionListener(e -> out.println("promouvoir "+"14"));




    }
}
