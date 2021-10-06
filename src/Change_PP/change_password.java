package Change_PP;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class change_password {

    JLabel heading;
    String s1, s2, s3;
    public JFrame f;
    JTextField tf1, tf2, tf3;
    JLabel l1, l2, l3;
    JPanel p;
    JButton jb;
    public String save_password = "1111111T";

    public change_password() {

        f = new JFrame();
        p = new JPanel();

        heading = new JLabel("Change your Password");
        heading.setFont(new Font("Verdana", Font.BOLD, 20));
        heading.setBorder(new EmptyBorder(20, 20, 20, 20));
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(10);

        l1 = new JLabel("Enter Old Password");
        l2 = new JLabel("Enter New Password");
        l3 = new JLabel("Confirm   Password");

        jb = new JButton("Change Password");

        // p.setBackground(Color.GRAY);
        f.add(heading);

        p.add(l1);
        p.add(tf1);

        p.add(l2);
        p.add(tf2);

        p.add(l3);
        p.add(tf3);

        p.add(jb);
        p.setLayout(new GridLayout(4, 1, 60, 20));
        p.setSize(490, 390);

        f.add(p);

        f.setVisible(false);
        f.setSize(500, 400);
        f.setLayout(new FlowLayout());

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {

                s1 = tf1.getText();
                s2 = tf2.getText();
                s3 = tf3.getText();

                if (!s1.equals(save_password)) {
                    JOptionPane.showMessageDialog(null, "Old Password did not match");
                    return;

                }
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    JOptionPane.showMessageDialog(null, "Field is empty Kindly enter new password & then conform it");
                    return;
                }
                if (s2.length() < 8 || s3.length() < 8) {
                    JOptionPane.showMessageDialog(null, "Kindly enter Atleast 8 character included one Alphabat or Special Character for strong Password ");
                    return;
                }
                if (!s2.equals(s3)) {
                    JOptionPane.showMessageDialog(null, "Kindly Enter same password ");
                    return;
                }
// there should be on Alphabat or digit+    

                try {
                    int n1 = Integer.parseInt(s2.trim());
                    int n3 = Integer.parseInt(s3.trim());

                    JOptionPane.showMessageDialog(null, "There should be one Alphabat or Special Character for strong Password ");
                } // if there is any alphabat or special character then there should be error in it so we use catch
                catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(null, "your password has been changed");

                }

            }
        });

    }

}
