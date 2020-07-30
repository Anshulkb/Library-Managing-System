import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IssueBook extends JFrame{
    public JPanel issue;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton exit;
    private JButton addButton;
    private JButton resetButton;
    private JButton backButton;
    private JButton searchButton;
    private JTextField textField5;

    public IssueBook(){
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setContentPane(issue);
          this.pack();
        textField2.setEnabled(false);
        textField2.setFocusable(false);
        textField3.setEnabled(false);
        textField3.setFocusable(false);
        textField4.setEnabled(false);
        textField4.setFocusable(false);
        textField5.setEnabled(false);
        textField5.setFocusable(false);

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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                welcome obj = new welcome();
                obj.setVisible(true);
                obj.setSize(800, 500);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField2.setEnabled(false);
                textField2.setFocusable(false);
                textField3.setText("");
                textField3.setEnabled(false);
                textField3.setFocusable(false);
                textField4.setText("");
                textField4.setEnabled(false);
                textField4.setFocusable(false);
                textField5.setText("");
                textField5.setEnabled(false);
                textField5.setFocusable(false);
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
                        String query = "SELECT FROM Library_Card WHERE Card_No='" +tf1+ "';";
                        ResultSet rs=stm.executeQuery(query);
                        if(rs.next()){
                            String Name=rs.getString("Name");
                            textField2.setText(Name);
                            textField3.setEnabled(true);
                            textField3.setFocusable(true);
                            textField4.setEnabled(true);
                            textField4.setFocusable(true);
                            textField5.setEnabled(true);
                            textField5.setFocusable(true);

                        }
                        else{JOptionPane.showMessageDialog(null,"Person not Registered");}
                    } catch (Exception cl) {
                        JOptionPane.showMessageDialog(null, cl.getMessage());
                    }

                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tf1 = textField1.getText();
                String tf2 = textField2.getText();
                String tf3 = textField3.getText();
                String tf4 = textField4.getText();
                String tf5 = textField5.getText();
                if((tf1.isEmpty())|| (tf2.isEmpty()) || (tf3.isEmpty()) || (tf4.isEmpty()) || (tf5.isEmpty()) ){
                    JOptionPane.showMessageDialog(null, "Please check the text fields.");
                }
                else{
                    try {
                        Class.forName("java.sql.DriverManager");
                        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Anshul", "root", "12345");
                        Statement stm = (Statement) con.createStatement();
                        String query = "INSERT INTO Issue_Book(Card_No,Name,Book_Name,ISBN,Issue_Date) VALUES ('"+tf1+"','"+tf2+"','"+tf3+"','"+tf5+"','"+tf4+"');";
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

