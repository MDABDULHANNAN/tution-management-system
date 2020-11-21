

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBConnector {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    //constructors
    public DBConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Step-1: get a connection to the db
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tutionmedia", 
                    "root", "");
            System.out.println("DB Connect Successful");
            //Step-2: create a statement
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    //parameterized constructor
    public DBConnector(String url, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Step-1: get a connection to the db
            con = DriverManager.getConnection(url, user, password);
            //Step-2: create a statement
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
  
    public ResultSet getResultSet() {
        try {
            String query = "select name,email,iname ,gender ,background from tinformation;";
            //Step-3: Execute SQL query
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }

    public void printDataInConole(ResultSet rs) {
        try {
            while (rs.next()) {
             
                String name = rs.getString("name");
                String email = rs.getString("email");
                String iname = rs.getString("iname");
                String gender = rs.getString("gender");
                String background = rs.getString("background");
                System.out.println("\nStudent name: " +name + "\n"
                        + "email: " + email+ "\n"
                        + "iname: " + iname+"\n"
                        + "gender: " + gender+"\n"
                        + "background: " + background);
                        
                        
                
            }//end of while
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
    public ResultSet getResultSet1() {
        try {
            String query = "select name,email,address ,medium ,Class,subj from information;";
            //Step-3: Execute SQL query
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }

    public void printDataInConole1(ResultSet rs) {
        try {
            while (rs.next()) {
             
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String medium = rs.getString("medium");
                String Class = rs.getString("Class");
                String subj = rs.getString("subj");
                System.out.println("\nStudent name: " +name + "\n"
                        + "email: " + email+ "\n"
                        + "address: " + address+"\n"
                        + "medium: " + medium+"\n"
                        + "Class: " + Class+"\n"
                        + "background: " + subj);
                        
                        
                
            }//end of while
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
    
    public void insertIntoDB(ArrayList row) {
        try {
            
            String query = "insert into information( name ,email ,mob_no ,id ,password ,address ,institution ,iname ,gender ,medium ,Class ,subj ) values('" +row.get(0) + "','" + row.get(1) + "','" + row.get(2) +"','"+ row.get(3)+"','"+ row.get(4)+"','"+ row.get(5)+"','"+ row.get(6)+"','"+ row.get(7)+"','"+ row.get(8)+"','"+ row.get(9)+"','"+ row.get(10)+"','"+ row.get(11)+"');";
                System.out.println(query);
                //Step-3: Execute SQL query
                st.executeUpdate(query);
                con.close();
            st.close();
                JOptionPane.showMessageDialog(null, "Student Info Added Successfully.");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Insert into Database Exception: " + e);
            System.out.println(e);
        }
         
    }
    
    public void insertIntoDB1(ArrayList row) {
        try {
            
            String query1 = "insert into tinformation( name ,email ,mob_no ,id ,password ,address ,institution ,iname ,gender ,medium,background ) values('" +row.get(0) + "','" + row.get(1) + "','" + row.get(2) +"','"+ row.get(3)+"','"+ row.get(4)+"','"+ row.get(5)+"','"+ row.get(6)+"','"+ row.get(7)+"','"+ row.get(8)+"','"+ row.get(9)+"','"+ row.get(10)+"');";
                System.out.println(query1);
                //Step-3: Execute SQL query
                st.executeUpdate(query1);
                con.close();
            st.close();
                JOptionPane.showMessageDialog(null, "Teacher Info Added Successfully.");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Insert into Database Exception: " + e);
            System.out.println(e);
        }
         
    }
    
}
