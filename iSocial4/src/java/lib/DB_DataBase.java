/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import java.sql.*;

/**
 *
 * @author alex
 */
public class DB_DataBase {
    
    Connection connection=null;
	
    public DB_DataBase() {
        connection=null;
    }

    public boolean connect(){
	try {
            String urlBD = "jdbc:mysql://localhost:3306/isocial?user=root&zeroDateTimeBehavior=convertToNull"; 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(urlBD);
        } catch (Exception e) { 
	    System.out.println(e);
            return false;
	}
        return true;
    }
    
    public boolean close() {
        try {
            connection.close(); 
            return true;
        } catch (Exception e) { 
	    System.out.println(e);
            return false;
	}
    }
}
