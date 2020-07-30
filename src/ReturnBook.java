import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReturnBook extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel bookReturn;
    private JButton exit;
    private JButton resetButton;
    private JButton backButton;
    private JButton searchButton;
    private JButton saveButton;
    private JTextField textField6;

    public ReturnBook() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(bookReturn);
        this.pack();

        textField2.setEnabled(false);
        textField2.setFocusable(false);
        textField3.setEnabled(false);
        textField3.setFocusable(false);
        textField4.setEnabled(false);
        textField4.setFocusable(false);
        textField5.setEnabled(false);
        textField5.setFocusable(false);
        textField6.setEnabled(false);
        textField6.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                welcome obj=new welcome();
                obj.setVisible(true);
                obj.setSize(800,500);

            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");

                textField2.setEnabled(false);
                textField2.setFocusable(false);
                textField3.setEnabled(false);
                textField3.setFocusable(false);
                textField4.setEnabled(false);
                textField4.setFocusable(false);
                textField5.setEnabled(false);
                textField5.setFocusable(false);
                textField6.setEnabled(false);
                textField6.setFocusable(false);

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tf1 = textField1.getText();
                if((tf1.isEmpty()) ){
                    JOptionPane.showMessageDialog(null, "Please enter Library Card Number.");
                }
                else{
                    try {
                        Class.forName("java.sql.DriverManager");
                        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Anshul", "root", "12345");
                        Statement stm = (Statement) con.createStatement();
                        String query = "SELECT FROM Library_Card WHERE (Card_No='" +tf1+ "' AND Return_Date= IS NULL );";
                        ResultSet rs=stm.executeQuery(query);
                        if(rs.next()){
                            String Name=rs.getString("Name");
                            String Book=rs.getString("Book_Name");
                            String Issue_Date=rs.getString("Issue_Date");
                            String ISBN=rs.getString("ISBN");

                            textField2.setText(Name);
                            textField3.setText(Book);
                            textField4.setText(Issue_Date);
                            textField5.setEnabled(true);
                            textField5.setFocusable(true);
                            textField6.setText(ISBN);

                        }
                        else{JOptionPane.showMessageDialog(null,"Person not Registered");}
                    } catch (Exception cl) {
                        JOptionPane.showMessageDialog(null, cl.getMessage());
                    }

                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tf1=textField1.getText();
                String tf4 = textField5.getText();
                String tf5 = textField5.getText();
                String tf6 = textField5.getText();
                if(tf5.isEmpty() || tf6.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter Return Date.");
                }
                else{
                    try {
                        Class.forName("java.sql.DriverManager");
                        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Anshul", "root", "12345");
                        Statement stm = (Statement) con.createStatement();
                        String query = "INSERT INTO Issue_Book(Return_Date) VALUES ('"+tf5+"') WHERE (Card_No='"+tf1+"' AND Issue_Date='"+tf4+"'AND ISBN='"+tf6 +"' AND Return_Date=IS NULL);";
                        stm.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Data Saved.");
                    } catch (Exception cl) {
                        JOptionPane.showMessageDialog(null, cl.getMessage());
                    }

                }
            }
        });
    }
}
