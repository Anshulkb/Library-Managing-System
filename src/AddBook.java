import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddBook extends JFrame{
    private JPanel adding;
    private JButton backButton;
    private JButton resetButton;
    private JButton saveButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField3;
    private JTextField textField5;
    private JButton exitButton;


    public AddBook(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(adding);
        this.pack();
        exitButton.addActionListener(new ActionListener() {
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
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
            }
        });
        saveButton.addActionListener(new ActionListener() {
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
                        String query = "INSERT INTO Book VALUES ('"+tf1+"','"+tf2+"','"+tf4+"','"+tf3+"','"+tf5+"');";
                        stm.executeUpdate(query);
                    } catch (Exception cl) {
                        JOptionPane.showMessageDialog(null, cl.getMessage());
                    }

                }

            }
        });
    }
}
