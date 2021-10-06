package p_airport;

import Employee_package.employee_gui;
import Employee_package.Employeee;
import Passanger_package.passanger;
import Passanger_package.passanger_gui;
import Change_PP.*;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

class Gui1 {
    JFrame myFrame;
    JPanel sideBar;
    JLabel sidelogo;
    JButton HomeBtn;
    JButton exitBtn;
    JButton Update;
    JButton passangerBtn;
    JButton EmployeeBtn;
    JButton FlightBtn;
    JButton changePassword;

    JPanel box1;
    JLabel box1Icon;
    JLabel box1Text;
    JButton box1B;
    JLabel hPassangerL;
    JPanel centerTables;
    JLabel hEmployeeL;

    JTable table;
    JScrollPane scrollpane;
    DefaultTableModel model;

    JTable table2;
    JScrollPane scrollpane2;
    DefaultTableModel model2;

    JLabel NameSet;
    String[] flight_Data;

    public void initGUI() {

        passanger pObj = new passanger();
        String data = pObj.wholeData;
        //System.out.println(data);
        String[] c = pObj.columnsName;
        int count_r = pObj.count_DataRow;

        Employeee eObj = new Employeee();
        String data2 = eObj.wholeData;

        String[] c2 = eObj.columnsName;
        int count_r2 = eObj.count_DataRow;

        //------- main frame which hold the panals-----------//
        myFrame = new JFrame("Airport Management");

        myFrame.setLayout(new BorderLayout());
        myFrame.setVisible(true); 
        myFrame.setSize(1000, 650);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //---- side Bar panal---//
        sideBar = new JPanel();
        myFrame.add(sideBar, BorderLayout.WEST);
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));

        //-----------Table--------//
        model = new DefaultTableModel();
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        scrollpane = new JScrollPane(table);

        //table first line
        String[] columnsName = c;
        model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(columnsName);
        //table rest of data
        String[] split1_data = data.split("\n");

        for (int i = 0; i < count_r-1; i++) {

            String[] split2_data = split1_data[i].split("/");
            model.addRow(split2_data);
        }

        //-----------Table--------//
        model2 = new DefaultTableModel();
        table2 = new JTable(model2);
        table2.setPreferredScrollableViewportSize(new Dimension(500, 50));
        scrollpane2 = new JScrollPane(table2);

        //table first line
        String[] columnsName2 = c2;
        model2 = (DefaultTableModel) table2.getModel();
        model2.setColumnIdentifiers(columnsName2);
        //table rest of data
        String[] split1_data2 = data2.split("\n");

        for (int i = 0; i < count_r2; i++) {

            String[] split2_data2 = split1_data2[i].split("/");
            model2.addRow(split2_data2);

        }

        hPassangerL = new JLabel("Passangers");
        hPassangerL.setFont(new Font("Arial", Font.BOLD, 20));
        hPassangerL.setBorder(new EmptyBorder(20, 20, 20, 20));
        hEmployeeL = new JLabel("Employees");
        hEmployeeL.setFont(new Font("Arial", Font.BOLD, 20));
        hEmployeeL.setBorder(new EmptyBorder(50, 20, 20, 20));

        centerTables = new JPanel();
        centerTables.setLayout(new FlowLayout());
        centerTables.setVisible(true);
        centerTables.setSize(400, 400);
        centerTables.add(hPassangerL);
        centerTables.add(scrollpane);
        centerTables.add(hEmployeeL);
        centerTables.add(scrollpane2);
        myFrame.add(centerTables, BorderLayout.CENTER);

        //----logo---//
        sidelogo = new JLabel();
        ImageIcon logo = new ImageIcon("logoo.png");
        sidelogo.setIcon(logo);
        
        //----home button---//
        HomeBtn = new JButton("HOME");
        passangerBtn = new JButton("Passanger");
        EmployeeBtn = new JButton("Employee");
        FlightBtn = new JButton("Flight");
        exitBtn = new JButton("Exit");
        Update = new JButton("Refresh");
        changePassword = new JButton("Change Password");

        exitBtn.setMargin(new Insets(10, 94, 10, 95));
        HomeBtn.setMargin(new Insets(10, 88, 10, 88));
        Update.setMargin(new Insets(10, 67, 10, 68));
        passangerBtn.setMargin(new Insets(10, 74, 10, 74));
        EmployeeBtn.setMargin(new Insets(10, 78, 10, 77));
        FlightBtn.setMargin(new Insets(10, 90, 10, 90));
        changePassword.setMargin(new Insets(10, 53, 10, 53));
        Update.setMargin(new Insets(10, 83, 10, 82));
        
        sideBar.add(sidelogo);
        sideBar.setBackground(Color.WHITE);
        HomeBtn.setBackground(Color.BLACK);
        HomeBtn.setForeground(Color.WHITE);
        passangerBtn.setBackground(Color.LIGHT_GRAY);
        EmployeeBtn.setBackground(Color.LIGHT_GRAY);
        FlightBtn.setBackground(Color.LIGHT_GRAY);
        exitBtn.setBackground(Color.LIGHT_GRAY);
        changePassword.setBackground(Color.LIGHT_GRAY);
        Update.setBackground(Color.LIGHT_GRAY);

        sideBar.add(HomeBtn);
        sideBar.add(passangerBtn);
        sideBar.add(EmployeeBtn);
        sideBar.add(FlightBtn);
        sideBar.add(Update);
        sideBar.add(changePassword);
        sideBar.add(exitBtn);

        //------ Right side----\\
        box1 = new JPanel();
        box1.setLayout(new BoxLayout(box1, BoxLayout.Y_AXIS));

        box1Text = new JLabel("    Flight Details    ");
        box1Text.setFont(new Font("Arial", Font.BOLD, 20));
        
        box1.add(box1Text);
        box1.setBackground(Color.white);
        myFrame.add(box1, BorderLayout.EAST);

        try {

            FileReader fr = new FileReader("Flight_Details.txt");
            BufferedReader br = new BufferedReader(fr);  //for filteration 

            String flightData = br.readLine();
            flight_Data = flightData.split(",");

            br.close();
            fr.close();

        } catch (IOException ex) {
            System.out.println("1" + ex.getMessage());

        }

        NameSet = new JLabel("   Name : " + flight_Data[0]);
        JLabel d = new JLabel("\n   Date : " + flight_Data[1]);
        JLabel t = new JLabel("\n   Time : " + flight_Data[2]);
        JLabel dis = new JLabel("\n   Distination : " + flight_Data[3]);
        JLabel tp = new JLabel("\n   Total Passanger : " + flight_Data[4]);
        JLabel te = new JLabel("\n   Total Employee : " + flight_Data[5]);
        JLabel are = new JLabel("\n   Note : " + flight_Data[6]);

        box1Text.setBorder(new EmptyBorder(20, 20, 20, 20));
        d.setBorder(new EmptyBorder(20, 0, 20, 20));
        dis.setBorder(new EmptyBorder(20, 0, 20, 20));
        te.setBorder(new EmptyBorder(20, 0, 20, 20));

        box1.add(NameSet);
        box1.add(d);
        box1.add(t);
        box1.add(dis);
        box1.add(tp);
        box1.add(te);
        box1.add(are);
        
        JLabel NextF = new JLabel();       
        NextF.setText("Next Flights");
        NextF.setFont(new Font("Arial", Font.BOLD, 20));
        NextF.setBorder(new EmptyBorder(20, 50, 20, 20));
        box1.add(NextF);
        
        day_time_flights DayFlight = new day_time_flights();
        JLabel next1 = new JLabel();
        next1.setText(DayFlight.Detail());
        next1.setBorder(new EmptyBorder(0, 10, 0, 0));
        box1.add(next1);
        
        evening_time_flights EveningFlight = new evening_time_flights();
        JLabel next2 = new JLabel();
        next2.setText(EveningFlight.Detail());
        next2.setBorder(new EmptyBorder(20, 10, 20, 20));
        box1.add(next2);
        
        night_time_flights nightFlight = new night_time_flights();
        JLabel next3 = new JLabel();
        next3.setText(nightFlight.Detail());
        next3.setBorder(new EmptyBorder(0, 10, 0, 0));
        box1.add(next3);
        
        //-----------------------Action Listener of SideBar Button-------------------//
        passangerBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                new passanger_gui();
                

            }
        });

        EmployeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                new employee_gui();
                
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int a = JOptionPane.showConfirmDialog(null, "Are you sure to exit?");
                if (a == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        FlightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new flight_gui();
            }
        });

        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                myFrame.setVisible(false);
                new Gui1();
            }
        });
        
        
        changePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
              change_password obj  =new change_password();
              obj.f.setVisible(true);
            }
        });
        

    } //end init method

    public Gui1() {
        initGUI();
    }
}//class gui1 end
public class P_Airport {

    public static void main(String[] args) {

     logInForm obj = new logInForm();
     
     obj.run();
     
     
    }
}
