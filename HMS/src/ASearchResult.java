import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ASearchResult implements ActionListener{
JFrame frame, frame1;
JTextField textbox;
JLabel label;
JButton button;
JPanel panel;
static JTable table;

String driverName = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/hms2";
String userName = "root";
String password = "";
String[] columnNames = {"ROOM_NO", "NAME", "SEX", "AADHAR","MOB_NO","ADDRESS","ROOM_TYPE","BED_TYPE","PRICE"};

public void createUI()
{
   // showTableData();
    frame1 = new JFrame("Database Search Result");
frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
button = new JButton("Back");
frame1.setLayout(new BorderLayout()); 
//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
//String textvalue = textbox.getText();
String ROOM_NO= "";
String NAME= "";
String SEX= "";
String AADHAR = "";
String  MOB_NO= "";
String  ADDRESS="";
String  ROOM_TYPE="";
String  BED_TYPE="";
String  PRICE="";
try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection(url, userName, password);
String sql = "select * from customer";
Statement smt = con.createStatement();
ResultSet rs = smt.executeQuery(sql);
int i =0;
if(rs.next())
{
ROOM_NO = rs.getString("rnumber");
NAME= rs.getString("cname");
SEX = rs.getString("csex");
AADHAR = rs.getString("caadhar"); 
MOB_NO = rs.getString("cmob"); 
ADDRESS = rs.getString("caddress");
ROOM_TYPE= rs.getString("croom");
BED_TYPE = rs.getString("cbed");
PRICE = rs.getString("cprice"); 
model.addRow(new Object[]{ROOM_NO, NAME, SEX, AADHAR,MOB_NO,ADDRESS,ROOM_TYPE,BED_TYPE,PRICE});
i++; 
}
if(i <1)
{
JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
System.out.println(i+" Records Found");
}
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
frame1.add(scroll);
frame1.setVisible(true);
frame1.setSize(900,500);
frame1.setLocation(500, 300);
//frame = new JFrame("Database Search Result");
//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//frame.setLayout(null);
//textbox = new JTextField();
//textbox.setBounds(120,30,150,20); 
//label = new JLabel("Enter employee id");
//label.setBounds(10, 30, 100, 20);
//button = new JButton("Back");
//button.setBounds(120,130,150,20);
//button.addActionListener(this);
//
//frame.add(textbox);
//frame.add(label);
//frame.add(button);
//frame.setVisible(true);
//frame.setSize(500, 400); 
} 

public void actionPerformed(ActionEvent ae)
{
//button = (JButton)ae.getSource();
 //new Employee().setVisible(true);  
         //   setVisible(false);
} 

//public void showTableData()
//{
//
//frame1 = new JFrame("Database Search Result");
//frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//button = new JButton("Back");
//frame1.setLayout(new BorderLayout()); 
////TableModel tm = new TableModel();
//DefaultTableModel model = new DefaultTableModel();
//model.setColumnIdentifiers(columnNames);
////DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
////table = new JTable(model);
//table = new JTable();
//table.setModel(model); 
//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//table.setFillsViewportHeight(true);
//JScrollPane scroll = new JScrollPane(table);
//scroll.setHorizontalScrollBarPolicy(
//JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//scroll.setVerticalScrollBarPolicy(
//JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
////String textvalue = textbox.getText();
//String Employee_ID= "";
//String Emp_Name= "";
//String Emp_Designation= "";
//String Emp_Salary = "";
//String Emp_Address = "";
//try
//{ 
//Class.forName(driverName); 
//Connection con = DriverManager.getConnection(url, userName, password);
//String sql = "select * from employee";
//Statement smt = con.createStatement();
//ResultSet rs = smt.executeQuery(sql);
//int i =0;
//while(rs.next())
//{
//Employee_ID = rs.getString("eid");
//Emp_Name= rs.getString("ename");
//Emp_Designation = rs.getString("edesignation");
//Emp_Salary = rs.getString("esalary"); 
//Emp_Address = rs.getString("eaddress"); 
//model.addRow(new Object[]{Employee_ID, Emp_Name, Emp_Designation, Emp_Salary,Emp_Address});
//i++; 
//}
//if(i <1)
//{
//JOptionPane.showMessageDialog(null, "No Record Found","Error",
//JOptionPane.ERROR_MESSAGE);
//}
//if(i ==1)
//{
//System.out.println(i+" Record Found");
//}
//else
//{
//System.out.println(i+" Records Found");
//}
//}
//catch(Exception ex)
//{
//JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
//JOptionPane.ERROR_MESSAGE);
//}
//frame1.add(scroll);
//frame1.setVisible(true);
//frame1.setSize(900,500);
//frame1.setLocation(500, 300);
//}

public static void main(String args[])
{
ASearchResult sr = new ASearchResult();
sr.createUI(); 
}
}