package com.shiftservices.cors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertData {
  static Connection conn;

  public static void main(String[] args) throws Exception {

   /* String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    String dbName = "shiftSchema";
    String connectionURL = "jdbc:derby:" + dbName + ";create=true";
    Class.forName(driver);*/
      
      String dbURL2 = "jdbc:derby://localhost/shiftSchema;create=true";
      String user = "APP";
      String password = "APP";
      Connection conn = DriverManager.getConnection(dbURL2, user, password);

   // conn = DriverManager.getConnection(connectionURL);

    Statement stmt = conn.createStatement();
    
    PreparedStatement psInsert = conn
            .prepareStatement("insert into SKILL values (?,?,?,?,?,?,?)");
    
    for (int i = 200000; i < 200002; i++) {
      

            psInsert.setInt(1, i);
            psInsert.setString(2, "Tin3000 :"+i);
            psInsert.setString(3, "REMYA:"+i);
            
           psInsert.setString(4, "L5");
        
           
           psInsert.setString(5, "QDB_B");
           psInsert.setInt(6, 2);
           psInsert.setString(7, "CORE_JAVA");
            psInsert.executeUpdate();
         
        
    }
    conn.close();

  

  }
}