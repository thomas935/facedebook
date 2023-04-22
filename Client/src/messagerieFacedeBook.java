import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

public class messagerieFacedeBook extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private  JLabel TextOut0;
    private  JLabel TextOut1;
    private  JLabel TextOut2;
    private  JLabel TextOut3;
    private  JLabel TextOut4;
    private JLabel Pseudo0;
    private JLabel Pseudo1;
    private JLabel Pseudo2;
    private JLabel Pseudo3;
    private JLabel Pseudo4;
    private JLabel Etat0;
    private JLabel STATUT3;
    private JLabel STATUT2;
    private JLabel STATUT1;
    private JLabel Etat4;
    private JButton OPTIONButton;
    private JPanel STATUT0;
    private JPanel STATUT4;
    private JPanel STATUT5;
    private JButton DECONNEXIONButton;
    private JLabel USERNAME4;
    private JLabel HEURE4;
    private JLabel HEURE3;
    private JLabel HEURE2;
    private JLabel HEURE1;
    private JLabel HEURE0;
    private JLabel USERNAME3;
    private JLabel USERNAME2;
    private JLabel USERNAME1;
    private JLabel USERNAME0;
    private PrintWriter out;

    public messagerieFacedeBook(PrintWriter out, String username,String password) throws IOException  {

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.setContentPane(panel1);


        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textField1.getText();
                out.println("message "+username+" "+password+" "+message) ;
                textField1.setText("");
            }
        });
    }

    public void displayMessage(StringBuilder message, String localDateTime, String Username){
        if (!TextOut3.getText().equals("")){
            TextOut4.setText(TextOut3.getText());
        }
        if (!TextOut2.getText().equals("")){
            TextOut3.setText(TextOut2.getText());
        }
        if (!TextOut1.getText().equals("")){
            TextOut2.setText(TextOut1.getText());
        }
        if (!TextOut0.getText().equals("")){
            TextOut1.setText(TextOut0.getText());
        }
        TextOut0.setText(String.valueOf(message));
        textField1.setText("");

        // HEURE
        if (!HEURE3.getText().equals("")){
            HEURE4.setText(HEURE3.getText());
        }
        if (!HEURE2.getText().equals("")){
            HEURE3.setText(HEURE2.getText());
        }
        if (!HEURE1.getText().equals("")){
            HEURE2.setText(HEURE1.getText());
        }
        if (!HEURE0.getText().equals("")){
            HEURE1.setText(HEURE0.getText());
        }
        HEURE0.setText(String.valueOf(localDateTime));


        // USERNAME
        if (!USERNAME3.getText().equals("")){
            USERNAME4.setText(USERNAME3.getText());
        }
        if (!USERNAME2.getText().equals("")){
            USERNAME3.setText(USERNAME2.getText());
        }
        if (!USERNAME1.getText().equals("")){
            USERNAME2.setText(USERNAME1.getText());
        }
        if (!USERNAME0.getText().equals("")){
            USERNAME1.setText(USERNAME0.getText());
        }
        USERNAME0.setText(String.valueOf(Username));




    }
}

