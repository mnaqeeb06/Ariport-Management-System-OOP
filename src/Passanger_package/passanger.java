package Passanger_package;

import Passanger_package.passanger_gui;
import java.io.*;
import javax.swing.table.DefaultTableModel;

public class passanger extends passanger_gui {

    FileReader fr;
    BufferedReader br;
    public String[] columnsName;
    String firstLine;
    String dataRead;
    DefaultTableModel model;

    FileWriter fw;
    PrintWriter pw;
    String[] dataRow;
    public String wholeData;
    public int count_DataRow;

    public void Passanger_() {

        //File handing (read and display on JTable)
        try {

            fr = new FileReader("Pfile.txt");
            br = new BufferedReader(fr);  //for filteration 

            firstLine = br.readLine().trim();
            columnsName = firstLine.split(",");

            dataRead = br.readLine();

            while (dataRead != null) {
                count_DataRow += 1;
                wholeData += dataRead + "\n";
                dataRead = br.readLine();

            }
            br.close();
            fr.close();
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
}