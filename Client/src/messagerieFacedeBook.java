import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;

public class messagerieFacedeBook extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JLabel TextOut0;
    private JLabel TextOut1;
    private JLabel TextOut2;
    private JLabel TextOut3;
    private JLabel TextOut4;


    private JButton OPTIONButton;
    private JPanel STATUT0;
    private JPanel STATUT4;
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

    private JLabel Pseudo0;
    private JLabel Pseudo1;
    private JLabel Pseudo2;
    private JLabel Pseudo3;
    private JLabel Pseudo4;
    private JLabel Pseudo5;
    private JLabel Pseudo6;
    private JLabel Pseudo7;
    private JLabel Pseudo8;
    private JLabel Pseudo9;
    private JLabel Pseudo10;
    private JLabel Pseudo11;
    private JLabel Pseudo12;
    private JLabel Pseudo13;
    private JLabel Pseudo14;

    private JLabel Statut0;
    private JLabel Statut1;
    private JLabel Statut2;
    private JLabel Statut3;
    private JLabel Statut4;
    private JLabel Statut5;
    private JLabel Statut6;
    private JLabel Statut7;
    private JLabel Statut8;
    private JLabel Statut9;
    private JLabel Statut10;
    private JLabel Statut11;
    private JLabel Statut12;
    private JLabel Statut13;



    public messagerieFacedeBook(PrintWriter out, String username, String password) throws IOException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setContentPane(panel1);


        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textField1.getText();
                out.println("message " + username + " " + password + " " + message);
                textField1.setText("");
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                out.println("deconnexion " + username + " " + password);
            }
        });

        DECONNEXIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                out.println("deconnexion " + username + " " + password);
            }
        });

    }

    public void displayMessage(StringBuilder message, String localDateTime, String Username) {
        if (!TextOut3.getText().equals("")) {
            TextOut4.setText(TextOut3.getText());
        }
        if (!TextOut2.getText().equals("")) {
            TextOut3.setText(TextOut2.getText());
        }
        if (!TextOut1.getText().equals("")) {
            TextOut2.setText(TextOut1.getText());
        }
        if (!TextOut0.getText().equals("")) {
            TextOut1.setText(TextOut0.getText());
        }
        TextOut0.setText(String.valueOf(message));
        textField1.setText("");

        // HEURE
        if (!HEURE3.getText().equals("")) {
            HEURE4.setText(HEURE3.getText());
        }
        if (!HEURE2.getText().equals("")) {
            HEURE3.setText(HEURE2.getText());
        }
        if (!HEURE1.getText().equals("")) {
            HEURE2.setText(HEURE1.getText());
        }
        if (!HEURE0.getText().equals("")) {
            HEURE1.setText(HEURE0.getText());
        }
        HEURE0.setText(String.valueOf(localDateTime));


        // USERNAME
        if (!USERNAME3.getText().equals("")) {
            USERNAME4 .setText(USERNAME3.getText());
        }
        if (!USERNAME2.getText().equals("")) {
            USERNAME3.setText(USERNAME2.getText());
        }
        if (!USERNAME1.getText().equals("")) {
            USERNAME2.setText(USERNAME1.getText());
        }
        if (!USERNAME0.getText().equals("")) {
            USERNAME1.setText(USERNAME0.getText());
        }
        USERNAME0.setText(String.valueOf(Username));


    }

    public void Statut(String statut) {
        for (int i = 0; i < statut.length(); i++) {
            if (statut.charAt(i) == '1') {
                switch (i) {
                    case 0:
                        Statut0.setText("En ligne");
                        break;
                    case 1:
                        Statut1.setText("En ligne");
                        break;
                    case 2:
                        Statut2.setText("En ligne");
                        break;
                    case 3:
                        Statut3.setText("En ligne");
                        break;
                    case 4:
                        Statut4.setText("En ligne");
                        break;
                    case 5:
                        Statut5.setText("En ligne");
                        break;
                    case 6:
                        Statut6.setText("En ligne");
                        break;
                    case 7:
                        Statut7.setText("En ligne");
                        break;
                    case 8:
                        Statut8.setText("En ligne");
                        break;
                    case 9:
                        Statut9.setText("En ligne");
                        break;
                    case 10:
                        Statut10.setText("En ligne");
                        break;
                    case 11:
                        Statut11.setText("En ligne");
                        break;
                    case 12:
                        Statut12.setText("En ligne");
                        break;
                    case 13:
                        Statut13.setText("En ligne");
                        break;

                }
            } else {
                switch (i) {
                    case 0:
                        Statut0.setText("Hors ligne");
                        break;
                    case 1:
                        Statut1.setText("Hors ligne");
                        break;
                    case 2:
                        Statut2.setText("Hors ligne");
                        break;
                    case 3:
                        Statut3.setText("Hors ligne");
                        break;
                    case 4:
                        Statut4.setText("Hors ligne");
                        break;
                    case 5:
                        Statut5.setText("Hors ligne");
                        break;
                    case 6:
                        Statut6.setText("Hors ligne");
                        break;
                    case 7:
                        Statut7.setText("Hors ligne");
                        break;
                    case 8:
                        Statut8.setText("Hors ligne");
                        break;
                    case 9:
                        Statut9.setText("Hors ligne");
                        break;
                    case 10:
                        Statut10.setText("Hors ligne");
                        break;
                    case 11:
                        Statut11.setText("Hors ligne");
                        break;
                    case 12:
                        Statut12.setText("Hors ligne");
                        break;
                    case 13:
                        Statut13.setText("Hors ligne");
                        break;

                }
            }
        }
    }
}
