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
    
//    PreparedStatement psInsert = conn
//            .prepareStatement("insert into SKILL values (?,?,?,?,?,?,?)");
//    
//    for (int i = 1; i < 200001; i++) {
//      
//
//            psInsert.setInt(1, i);
//            psInsert.setString(2, "Tin"+i);
//            psInsert.setString(3, "NAME"+i);
//            
//           psInsert.setString(4, "L2");
//        
//           
//           psInsert.setString(5, "QDB_B");
//           psInsert.setInt(6, 2);
//           psInsert.setString(7, "CORE_JAVA");
//            psInsert.executeUpdate();
//         
//        
//    }
    PreparedStatement psInsert = conn
            .prepareStatement("insert into SHIFTENTRY values (?,?,?,?,?,?,?,?,?)");
    
    for (int i = 1; i < 200001; i++) {
      

    psInsert.setInt(1, i);
    psInsert.setString(2, "Tin"+i);
    psInsert.setString(3, "NAME"+i);
    psInsert.setString(4, "L2");
    psInsert.setInt(5, 5);
    psInsert.setInt(6, 2);
    psInsert.setInt(7, 1);
           psInsert.setString(8, "SHIFT1");
        
           psInsert.setString(9, "Jan15_Feb14");
            psInsert.executeUpdate();
         
        
    }
    conn.close();

  

  }
}