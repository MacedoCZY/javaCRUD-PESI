/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaçãopes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gusta
 */
public class ctrlListProd {
    public void listar(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{ 
            conn = connectFactory.getConnection();
            pstm = conn.prepareStatement("SELECT max(id) FROM Prod");
            rs = pstm.executeQuery();
            rs.next();
            while (rs.next()) {
                String lastName = rs.getString("Lname");
                System.out.println(lastName + "\n");
            }
        }catch (Exception e){
        }
        FieldID.setText(String.valueOf(lastId));
    }
}
