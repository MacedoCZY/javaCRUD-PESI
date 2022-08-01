/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicaçãopes;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

/**
 *
 * @author gusta
 */
public class connectFactory {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dnote?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "0000";
    
    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            return conn;
        } catch (Exception ex) {
            System.out.println("Erro ao conectar"+ ex.getMessage());
            return null;
        }
        
    }
}
