import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome extends JFrame {
    private JPanel root;
    private JButton exit;
    private JButton issue;
    private JLabel Welcome;
    private JButton addBook;
    private JButton returnBook;
    private JButton viewIssuedBook;
    private JButton removeBook;



    public welcome() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(root);
        this.pack();

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This is exit button
                System.exit(0);
            }
        });
        issue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                IssueBook obj = new IssueBook();
                obj.setVisible(true);
                obj.setSize(800, 500);
            }
        });
        returnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ReturnBook obj = new ReturnBook();
                obj.setVisible(true);
                obj.setSize(800, 500);
            }
        });
        removeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                deleteBook obj = new deleteBook();
                obj.setVisible(true);
                obj.setSize(800, 500);
            }
        });
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddBook obj = new AddBook();
                obj.setVisible(true);
                obj.setSize(800, 500);
            }
        });
        viewIssuedBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddCard obj=new AddCard();
                obj.setVisible(true);
                obj.setSize(800,500);
            }
        });
    }
}

