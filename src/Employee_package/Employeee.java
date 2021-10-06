package Employee_package;

import java.io.*;
import javax.swing.table.DefaultTableModel;

public class Employeee extends employee_gui {

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

    public void employee_() {

        //File handing (read and display on JTable)
        try {

            fr = new FileReader("Efile.txt");
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
