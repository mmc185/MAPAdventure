/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author marta
 */
public class DBManager {
    
    Connection con;
    private final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS scores (name VARCHAR(25), time TIMESTAMP)";
    
    public void connect() throws SQLException {
        
        con = DriverManager.getConnection("jdbc:h2:./resources/db/scores");
        Statement stm = con.createStatement();
        stm.executeUpdate(CREATE_TABLE);
        stm.close();
        
    }
    
    public void insertScore(String s, String t) throws SQLException, ParseException {
        PreparedStatement prstm = con.prepareStatement("INSERT INTO scores VALUES (?,?)");
        prstm.setString(1, s);
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = dateFormat.parse(t);
        Timestamp time = new Timestamp(date.getTime());
        prstm.setTimestamp(2, time);
        
        prstm.executeUpdate();
        prstm.close();
    }
    
    public String topScores () throws SQLException {
        String results = "";
        Statement stm = con.createStatement();
        ResultSet resSet = stm.executeQuery("SELECT name, time FROM scores ORDER BY time LIMIT 3");
        
        while (resSet.next() ) {
            
            results = resSet.getString(1) + "\t" + resSet.getTimestamp(2) + "\n";
            
        }
        
        resSet.close();
        stm.close();
        
        return results;
    }
    
}
