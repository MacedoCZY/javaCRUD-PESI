/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaçãopes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;

/**
 *
 * @author gusta
 */
public class ctrlListProd {
    public static listagemProduto list;
    public void listar(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null; 
        String[] cu = new String[2];
        cu[0] = "jaum";
        cu[1] = "firipi";
        list.jListListagem.setListData(cu);
        
        try{ 
            /*conn = connectFactory.getConnection();
            pstm = conn.prepareStatement("SELECT max(id) FROM Prod");
            rs = pstm.executeQuery();
            rs.previous();*/
            System.out.println("cu");
           
            /*while (rs.previous()) {
                String lastName = rs.getString("id");
                model.addElement(lastName);
                list.jListListagem.setModel(model);
                System.out.println(lastName + "\n");
            }*/
        }catch (Exception e){
            System.out.println("Erro 404 not a found");
        }
        
    }
    
    public ctrlListProd(listagemProduto list) {
        this.list = list;
    }
}
