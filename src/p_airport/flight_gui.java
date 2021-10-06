package p_airport;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class flight_gui {

    JFrame flight_f;
    JPanel flight_p;
    JLabel heading;
    JLabel NameL;
    JTextField NameTF;
    JLabel dateL;
    JTextField dateTF;
    JLabel timeL;
    JTextField timeTF;
    JLabel DistinationL;
    JTextField distinationTF;
    JLabel totalPassangerF;
    JTextField totalPassangerTF;
    JLabel totalEmployeeF;
    JTextField totalEmployeeTF;
    JLabel textL;
    JTextArea text;
    JButton addFdata;

    String nameD;
    int totalpassengers;
    int totalEmployees;

    public void f_gui() {
        heading = new JLabel("Update Flight details");
        NameL = new JLabel("Name");
        NameTF = new JTextField(20);
        dateL = new JLabel("Date");
        dateTF = new JTextField(20);
        timeL = new JLabel("Time");
        timeTF = new JTextField(20);
        DistinationL = new JLabel("Distination");
        distinationTF = new JTextField(20);
        totalPassangerF = new JLabel("Total Passanger");
        totalPassangerTF = new JTextField(20);
        totalEmployeeF = new JLabel("Total Employee");
        totalEmployeeTF = new JTextField(20);
        textL = new JLabel("Update / delay Details");
        text = new JTextArea(8, 45);
        //JScrollPane scrollpane = new JScrollPane(text);
        addFdata = new JButton("Update Data");

        flight_f = new JFrame();
        flight_f.setLayout(new FlowLayout()); //Layout
        flight_f.setVisible(true); // byDefault it is hidden
        flight_f.setSize(600, 600);
        flight_f.add(heading);
        heading.setFont(new Font("Verdana", Font.BOLD, 20));
        heading.setBorder(new EmptyBorder(20, 20, 20, 20));

        flight_p = new JPanel();
        flight_p.setLayout(new GridLayout(6, 2, 10, 20));
        flight_p.setVisible(true);
        flight_p.setSize(410, 410);

        flight_p.add(NameL);
        flight_p.add(NameTF);
        flight_p.add(dateL);
        flight_p.add(dateTF);
        flight_p.add(timeL);
        flight_p.add(timeTF);
        flight_p.add(DistinationL);
        flight_p.add(distinationTF);
        flight_p.add(totalPassangerF);
        flight_p.add(totalPassangerTF);
        flight_p.add(totalEmployeeF);
        flight_p.add(totalEmployeeTF);

        flight_f.add(flight_p);
        flight_f.add(textL);
        textL.setFont(new Font("Verdana", Font.BOLD, 20));
        textL.setBorder(new EmptyBorder(20, 20, 20, 20));
        flight_f.add(text);
        flight_f.add(addFdata);

        addFdata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    totalpassengers = Integer.parseInt(totalPassangerTF.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter numaric value in total Passanger");
                    return;
                }

                try {
                    totalEmployees = Integer.parseInt(totalEmployeeTF.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter numaric value in total Employees");
                    return;
                }

                try {

                    FileWriter fw = new FileWriter("Flight_Details.txt");
                    PrintWriter pw = new PrintWriter(fw);

                    String details = NameTF.getText() + "," + dateTF.getText() + "," + timeTF.getText() + "," + distinationTF.getText() + "," + totalpassengers + "," + totalEmployeeTF.getText() + "," + text.getText();

                    pw.println(details);

                    pw.flush();
                    pw.close();
                    fw.close();

                    NameTF.setText(null);
                    dateTF.setText(null);
                    timeTF.setText(null);
                    distinationTF.setText(null);
                    totalPassangerTF.setText(null);
                    totalEmployeeTF.setText(null);
                    text.setText(null);

                    JOptionPane.showMessageDialog(null, "Data updated");

                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        });
    }
    public flight_gui() {
        f_gui();
    }
}
    