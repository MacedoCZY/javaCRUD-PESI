/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaçãopes;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
/**
 *
 * @author gusta
 */
public class ctrlCadProd {
    public void save(int id, int icms, int empacotament, String NCM, String decri, double preco, String codBar, boolean ative){
        
        ICMS icm = new ICMS(icms);
        Empacot empac = new Empacot(empacotament);
        
        
        Produto produto = new Produto(icm, empac, NCM, id, decri, preco, codBar, ative);
        
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO Prod(descri, NCM, ICMS, preco, empac, codBar, ativo, id)" 
                + " VALUES(?,?,?,?,?,?,?, ?)";
        
        try {
            //Cria uma conexão com o banco
            conn = connectFactory.getConnection();
            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(3, icm.getValor());
            
            pstm.setString(2, produto.getNCM());
 
            pstm.setInt(5, empac.getEmpac());
            
            pstm.setString(1, produto.getDecri());
            
            pstm.setDouble(4, produto.getPreco());
            
            pstm.setString(6, produto.getCodBar());
            
            pstm.setBoolean(7, produto.isAtive());
            
            pstm.setInt(8, produto.getID());
            
            pstm.execute();    
         
        } catch (Exception e) {

            e.printStackTrace();
            }finally{
        }
    }

    public ctrlCadProd() {
    }
}