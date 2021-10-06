package Passanger_package;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class passanger_gui {

    JFrame p_frame;
    JTable table;
    JLabel mainLabel;
    JLabel mainLabel2;
    JPanel data_entry_container;
    JLabel name_label;
    JLabel idLabel;
    JTextField nameT;
    JTextField idT;
    JRadioButton r1, r2;
    JButton add, delete;
    JRadioButton c1, c2;
    JComboBox FlightClass;
    JLabel e;
    JLabel e2;

    DefaultTableModel model;
    Object[] newRow;
    String name;
    int id;
    String gender = "";

    FileReader fr;
    BufferedReader br;

    JScrollPane scrollPane;

    public void Passanger_() { 

        passanger pObj = new passanger();
        String data = pObj.wholeData;
        String[] c = pObj.columnsName;
        int count_r = pObj.count_DataRow;

        p_frame = new JFrame();
        p_frame.setLayout(new FlowLayout());
        p_frame.setVisible(true); 
        p_frame.setSize(600, 600);

        //-----------Table--------//
        model = new DefaultTableModel();
        //model.setColumnIdentifiers(columnNames);
        //model.addRow(dataRow);

        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        scrollPane = new JScrollPane(table);

        //table first line
        String[] columnsName = c;
        model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(columnsName);
        //table rest of data

        String[] split1_data = data.split("\n");

        for (int i = 0; i < count_r - 1; i++) {

            String[] split2_data = split1_data[i].split("/");
            model.addRow(split2_data);

        }

        mainLabel = new JLabel("Current  Passenger  record");
        mainLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        mainLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
        p_frame.add(mainLabel);
        p_frame.add(scrollPane);
        mainLabel2 = new JLabel("Add / remove new data");

        mainLabel2.setFont(new Font("Verdana", Font.BOLD, 20));
        mainLabel2.setBorder(new EmptyBorder(20, 20, 20, 20));
        p_frame.add(mainLabel2);

        //-----panal for form------//
        data_entry_container = new JPanel();
        data_entry_container.setLayout(new GridLayout(5, 2, 10, 20));
        data_entry_container.setVisible(true);
        data_entry_container.setSize(400, 400);
        p_frame.add(data_entry_container);

        name_label = new JLabel("Name");
        idLabel = new JLabel("ID");
        nameT = new JTextField(20);
        idT = new JTextField(20);
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");

        add = new JButton("Add");
        delete = new JButton("Remove");
        String clas[] = {"bussiness", "Economy", "First Class"};
        FlightClass = new JComboBox(clas);
        e = new JLabel();
        e2 = new JLabel();

        data_entry_container.add(name_label);
        data_entry_container.add(nameT);
        data_entry_container.add(idLabel);
        data_entry_container.add(idT);

        //for making radio button one click at a time // toggel
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        data_entry_container.add(r1);
        data_entry_container.add(r2);
        data_entry_container.add(FlightClass);
        data_entry_container.add(e);
        data_entry_container.add(add);
        data_entry_container.add(delete);

        //-------------Delete event listener---------//
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (table.getSelectedRowCount() == 1) {
                    //if single row is selected
                    model.removeRow(table.getSelectedRow());

                } else {
                    //if table is empty
                    if (table.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Table is empty");

                    } else {
                        //if table is not empty but row is not selected
                        JOptionPane.showMessageDialog(null, "Select row for deletion");

                    }

                }

            }
        });

        //add
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                name = nameT.getText();

                if (r1.isSelected()) {
                    gender = "male";
                } else {
                    gender = "female";
                }

               //checking
                if (name.isEmpty() || idT.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Field is Empty"); 

                    //this will return the control and next part is not executed
                    return;
                }

                try {
                    id = Integer.parseInt(idT.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter an integer value in ID");
                    return;
                }

                Object[] newRow = {name, id, FlightClass.getSelectedItem(), gender};
                model.addRow(newRow);

                // File append
                try {
                    //if file does not exist, it automatically create for you
                    FileWriter fw = new FileWriter("Pfile.txt", true);
                    PrintWriter pw = new PrintWriter(fw);

                    String s1 = name + "/" + id + "/" + gender + "/" + FlightClass.getSelectedItem();

                    pw.println(s1);

                    pw.flush();
                    pw.close();
                    fw.close();

                } catch (IOException ex) {
                    System.out.println(ex);
                }

                nameT.setText(null);
                idT.setText(null);

            }
        });

    }//Passanger_Gui end

    public passanger_gui() {
        Passanger_();
    }
}
