/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaçãopes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gusta
 */
public class ctrlCadProd {
    public void save(){
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO Prod(	id, descri, NCM, ICMS, preco, empac, codBar, ativo)" 
                + " VALUES(2,2,2,2,2,2,2,false)";
        
        try {
            //Cria uma conexão com o banco
            conn = connectFactory.getConnection();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            
            //Adiciona o valor do primeiro parâmetro da sql
            //pstm.setString(1, produto.getNome());
            //Adicionar o valor do segundo parâmetro da sql
            //pstm.setInt(2, produto.getIdade());
            //Adiciona o valor do terceiro parâmetro da sql
            //pstm.setDate(3, new Date(produto.getDataCadastro().getTime()));
            
            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {

            e.printStackTrace();
            }finally{
        }
    }

    public ctrlCadProd() {
    }
    
}