import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

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
    private JLabel Etat1;
    private JLabel Etat2;
    private JLabel Etat3;
    private JLabel Etat4;
    private PrintWriter out;
    private String line;


    public messagerieFacedeBook(PrintWriter out) throws IOException  {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.setContentPane(panel1);
            this.out = out;

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textField1.getText();
                out.println("message "+message) ;
            }
        });
    }

    public void displayMessage(StringBuilder message){
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
    }


}

