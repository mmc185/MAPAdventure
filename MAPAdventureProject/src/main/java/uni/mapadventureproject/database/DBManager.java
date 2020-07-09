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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Classe che gestisce il jdbc per tenere traccia dei giocatori e i loro
 * punteggi
 */
public class DBManager {

    private Connection con;
    private final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS scores (name VARCHAR(25), time TIME)";

    /**
     * Si connette al db locale
     *
     * @throws SQLException
     */
    public void connect() throws SQLException {

        con = DriverManager.getConnection("jdbc:h2:./resources/db/scores");
        Statement stm = con.createStatement();
        stm.executeUpdate(CREATE_TABLE);
        stm.close();

    }

    /**
     * Si riconnette, se la connessione è caduta
     *
     * @throws SQLException
     */
    public void reconnect() throws SQLException {
        if (con != null && !con.isValid(0)) {
            con = DriverManager.getConnection("jdbc:h2:./resources/db/store");
        }
    }

    /**
     * Inserisce il punteggio di un nuovo giocatore
     *
     * @param s nome del giocatore
     * @param t punteggio del giocatore ( in questo caso il tempo )
     * @throws SQLException
     * @throws ParseException
     */
    public void insertScore(String s, String t) throws SQLException, ParseException {
        reconnect();
        PreparedStatement prstm = con.prepareStatement("INSERT INTO scores VALUES (?,?)");
        prstm.setString(1, s);

        // Converte la stringa in tempo
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Time time = new Time(dateFormat.parse(t.replaceAll("[hms]", ":")).getTime());
        prstm.setTime(2, time);

        prstm.executeUpdate();
        prstm.close();
    }

    /**
     * restituisce il risultato della query per i migliori 3 punteggi
     *
     * @return stringa
     * @throws SQLException
     */
    public String topScores() throws SQLException {
        reconnect();

        String results = "";
        Statement stm = con.createStatement();
        ResultSet resSet = stm.executeQuery("SELECT name, time FROM scores ORDER BY time LIMIT 3");

        while (resSet.next()) {

            results += resSet.getString(1) + "\t\t\t" + resSet.getTime(2) + "\n\n";
        }

        resSet.close();
        stm.close();

        return results;
    }

}
